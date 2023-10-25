package com.example.Sprint4.DTO;

import jakarta.persistence.EntityResult;
import jakarta.persistence.FieldResult;
import jakarta.persistence.SqlResultSetMapping;

import java.math.BigDecimal;

@SqlResultSetMapping(
        name = "insumosConBajoStock",
        entities = {
                @EntityResult(
                        entityClass = InsumoDTO.class,
                        fields = {
                                @FieldResult(name="denomInsumo", column = "denomInsumo"),
                                @FieldResult(name="unidadDenom", column = "unidadDenom"),
                                @FieldResult(name="stock_minimo",column = "stock_minimo"),
                                @FieldResult(name="stock_actual",column = "stock_actual"),
                                @FieldResult(name = "diferencia", column = "diferencia")
                        }
                )
        }
)

public interface InsumoDTO {
    String getarticuloDenominacion();
    String getunidadDenominacion();
    BigDecimal getstock_actual();
    BigDecimal getstock_minimo();
    BigDecimal getdiferencia();
}
