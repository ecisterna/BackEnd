package com.example.Sprint4.repositories;

import com.example.Sprint4.DTO.MovimientosMonetariosDTO;
import com.example.Sprint4.entities.Pedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface PedidoRepository extends BaseRepository<Pedido, Long>{
    @Query(
            value = "SELECT "+
            "SUM(total) AS total_ingresos, "+
            "SUM(totalCosto) AS total_costos, "+
            "SUM(total - totalCosto) AS diferencia "+
            "FROM pedido",
            nativeQuery = true
    )
    MovimientosMonetariosDTO MovimientoMonetario();

    @Query(
            value = "SELECT " +
                    "SUM(TOTAL) AS total_ingresos, " +
                    "SUM(TOTAL_COSTO) AS total_costos, " +
                    "SUM(TOTAL - TOTAL_COSTO) AS diferencia " +
                    "FROM pedido p " +
                    "WHERE :filtro1 < p.FECHA_PEDIDO AND p.FECHA_PEDIDO < :filtro2",
            nativeQuery = true
    )
    MovimientosMonetariosDTO MovimientoMonetarioFecha(@Param("filtro1") Date filtro1, @Param("filtro2") Date filtro2);

}
