package com.example.Sprint4.DTO;

import com.example.Sprint4.entities.ArticuloManufacturado;
import jakarta.persistence.EntityResult;
import jakarta.persistence.FieldResult;
import jakarta.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
        name = "filtroPorProductos",
        entities = {
                @EntityResult(
                        entityClass = RankingProductosDTO.class,
                        fields = {
                                @FieldResult(name="denominacion", column = "denominacion"),
                                @FieldResult(name ="cantProdVend", column = "cantProdVend")
                        }
                )
        }
)

public interface RankingProductosDTO {
    String getdenominacion();
    Integer getcantProdVend();
}
