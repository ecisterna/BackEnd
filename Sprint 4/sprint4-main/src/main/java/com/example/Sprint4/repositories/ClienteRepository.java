package com.example.Sprint4.repositories;

import com.example.Sprint4.DTO.RankingClientesImporteDTO;
import com.example.Sprint4.DTO.RankingClientesPedidosDTO;
import com.example.Sprint4.entities.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente, Long>{

    @Query(
            value = "SELECT c.apellido, c.nombre, COUNT(p.id) AS cantPedidos " +
                    "FROM cliente c " +
                    "LEFT JOIN pedido p ON c.id = p.idCliente " +
                    "GROUP BY c.id " +
                    "ORDER BY cantPedidos DESC",
            nativeQuery = true
    )
    List<RankingClientesPedidosDTO> filtroPorPedidos();

    @Query(
            value = "SELECT c.nombre, C.apellido, SUM(p.total) AS importe_total " +
                    "FROM cliente c " +
                    "LEFT JOIN pedido p ON c.id = p.idCliente " +
                    "GROUP BY c.id " +
                    "ORDER BY importe_total DESC",
            nativeQuery = true
    )
    List<RankingClientesImporteDTO> filtroPorImporte();

    @Query(
            value = "SELECT c.apellido, c.nombre, COUNT(p.id) AS cantPedidos " +
                    "FROM cliente c " +
                    "LEFT JOIN pedido p ON c.id = p.id_cliente " +
                    "WHERE :filtro1 < p.FECHA_PEDIDO AND p.FECHA_PEDIDO < :filtro2 " +
                    "GROUP BY c.id " +
                    "ORDER BY cantPedidos DESC",
            nativeQuery = true
    )
        List<RankingClientesPedidosDTO> filtroPorPedidosFecha(@Param("filtro1") Date filtro1, @Param("filtro2") Date filtro2);

    @Query(
            value = "SELECT c.nombre, C.apellido, SUM(p.total) AS importe_total " +
                    "FROM cliente c " +
                    "LEFT JOIN pedido p ON c.id = p.id_cliente " +
                    "WHERE :filtro1 < p.FECHA_PEDIDO AND p.FECHA_PEDIDO < :filtro2 " +
                    "GROUP BY c.id " +
                    "ORDER BY importe_total DESC",
            nativeQuery = true
    )
    List<RankingClientesImporteDTO> filtroPorImporteFechas(@Param("filtro1") Date filtro1, @Param("filtro2") Date filtro2);

}
