package com.example.Sprint4.DTO;


import jakarta.persistence.EntityResult;
import jakarta.persistence.FieldResult;
import jakarta.persistence.SqlResultSetMapping;

import java.math.BigDecimal;

@SqlResultSetMapping(
        name = "MovimientoMonetario",
        entities = {
                @EntityResult(
                        entityClass = MovimientosMonetariosDTO.class,
                        fields = {
                                @FieldResult(name = "total_ingresos", column = "total_ingresos"),
                                @FieldResult(name = "total_costos", column = "total_costos"),
                                @FieldResult(name = "diferencia", column = "diferencia")
                        }
                )
        }
)

public interface MovimientosMonetariosDTO {
    BigDecimal gettotal_ingresos();
    BigDecimal gettotal_costos();
    BigDecimal getdiferencia();
}
