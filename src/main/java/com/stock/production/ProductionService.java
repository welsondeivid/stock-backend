package com.stock.production;

import com.stock.product.ProductService;
import com.stock.raw.RawMaterialService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.WebApplicationException;
import org.jspecify.annotations.NonNull;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProductionService {

    @Inject
    ProductionRepository productionRepository;
    @Inject
    ProductService productService;
    @Inject
    RawMaterialService rawMaterialService;

    public List<Production> listByProduct(String productCode) {
        return productionRepository.findByProduct(productCode);
    }

    @Transactional
    public List<Production> defineComposition(String productCode, List<ProductionDTO> materials) {
        if (materials.isEmpty()) throw new WebApplicationException("Materials list cannot be empty", 400);

        productService.findByCode(productCode);
        List<Production> result = new ArrayList<>();

        productionRepository.deleteByProduct(productCode);

        for (ProductionDTO dto : materials) {

            rawMaterialService.findByCode(dto.rawMaterialCode);

            Production production = productionRepository.findByCodes(productCode, dto.rawMaterialCode);
            if (production != null) {
                production.required = dto.required;
                result.add(production);
                continue;
            }

            ProductionId id = new ProductionId();
            id.productCode = productCode;
            id.rawMaterialCode = dto.rawMaterialCode;

            Production newProduction = new Production();
            newProduction.id = id;
            newProduction.required = dto.required;

            productionRepository.persist(newProduction);
            result.add(newProduction);
        }

        return result;
    }

    @Transactional
    public void delete(String productCode, String rawMaterialCode) {

        Production production = productionRepository.findByCodes(productCode, rawMaterialCode);

        if (production == null) throw new NotFoundException("Association not found");

        productionRepository.delete(production);
    }
}
