package com.example.Sprint4.DTO;


import jakarta.persistence.EntityResult;
import jakarta.persistence.FieldResult;
import jakarta.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
        name = "filtroPorImporte",
        entities = {
                @EntityResult(
                        entityClass = RankingClientesImporteDTO.class,
                        fields = {
                                @FieldResult(name = "apellido", column = "apellido"),
                                @FieldResult(name = "nombre", column = "nombre"),
                                @FieldResult(name = "importe_total", column = "importe_total")
                        }
                )
        }
)
public interface RankingClientesImporteDTO {
    String getnombre();
    String getapellido();
    Integer getimporte_total();

}
