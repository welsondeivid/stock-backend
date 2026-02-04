package com.stock.production;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProductionDTO {

    @NotNull
    public String rawMaterialCode;

    @Positive
    public int required;
}