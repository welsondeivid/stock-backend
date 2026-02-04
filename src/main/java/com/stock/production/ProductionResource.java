package com.stock.production;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/product/{productCode}/raw-material")
public class ProductionResource {

    @Inject
    ProductionService productionService;
    @GET
    public List<Production> listRawMaterialsOfProduct(@PathParam("productCode") String productCode){
        return productionService.listByProduct(productCode);
    }

    @POST
    public Response defineComposition(@PathParam("productCode") String productCode, @Valid List<ProductionDTO> materials) {

        List<Production> productions =
                productionService.defineComposition(productCode, materials);

        return Response.status(Response.Status.CREATED)
                .entity(productions)
                .build();
    }

    @DELETE
    @Path("/{rawMaterialCode}")
    public Response delete(
            @PathParam("productCode") String productCode,
            @PathParam("rawMaterialCode") String rawMaterialCode
    ) {
        productionService.delete(productCode, rawMaterialCode);
        return Response.noContent().build();
    }
}
