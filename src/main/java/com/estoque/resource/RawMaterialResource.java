package com.estoque.resource;

import com.estoque.entity.RawMaterial;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/raw-material")
@Produces(MediaType.APPLICATION_JSON)
public class RawMaterialResource {

    @GET
    public List<RawMaterial> listAll(){
        return RawMaterial.listAll();
    }
}
