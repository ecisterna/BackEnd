package com.example.Sprint4.DTO;


import jakarta.persistence.EntityResult;
import jakarta.persistence.FieldResult;
import jakarta.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
        name = "filtroPorPedidos",
        entities = {
                @EntityResult(
                        entityClass = RankingClientesPedidosDTO.class,
                        fields = {
                                @FieldResult(name = "nombre", column = "nombre"),
                                @FieldResult(name = "apellido", column = "apellido"),
                                @FieldResult(name = "cantPedidos", column = "cantPedidos")
                        }
                )
        }
)
public interface RankingClientesPedidosDTO {
    String getnombre();
    String getapellido();
    Integer getcantPedidos();
}
