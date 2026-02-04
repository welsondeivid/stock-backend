package com.stock.production;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "product_raw_material")
public class Production extends PanacheEntityBase{

    @EmbeddedId
    @NotNull
    public ProductionId id;

    @NotNull
    @Positive
    public int required;
}
