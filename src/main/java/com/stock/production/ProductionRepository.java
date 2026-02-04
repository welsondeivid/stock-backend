package com.stock.production;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ProductionRepository
        implements PanacheRepository<Production> {

    public Production findByCodes(String productCode, String rawMaterialCode) {
        return find(
                "id.productCode = ?1 and id.rawMaterialCode = ?2",
                productCode,
                rawMaterialCode
        ).firstResult();
    }

    public List<Production> findByProduct(String productCode) {
        return list("id.productCode", productCode);
    }

    public List<Production> findByRawMaterial(String rawMaterialCode) {
        return list("id.rawMaterialCode", rawMaterialCode);
    }

    public boolean exists(String productCode, String rawMaterialCode) {
        return count(
                "id.productCode = ?1 and id.rawMaterialCode = ?2",
                productCode,
                rawMaterialCode
        ) > 0;
    }

    public void deleteByProduct(String productCode) {
        delete("id.productCode", productCode);
    }

    public void deleteByRawMaterial(String rawMaterialCode) {
        delete("id.rawMaterialCode", rawMaterialCode);
    }
}