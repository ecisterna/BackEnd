package com.example.Sprint4.repositories;

import com.example.Sprint4.DTO.RankingProductosDTO;
import com.example.Sprint4.entities.ArticuloManufacturado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturado, Long>{
    @Query(
            value = "SELECT * FROM articulo_manufacturado WHERE articulo_manufacturado.denominacion LIKE %:filtro%",
            nativeQuery = true
    )
    List<ArticuloManufacturado> busquedaPorDenominacion(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM articulo_manufacturado ORDER BY articulo_manufacturado.precio_venta DESC",
            nativeQuery = true
    )
    List<ArticuloManufacturado> filtradoPorPrecioDesc();

    @Query(
            value = "SELECT * FROM articulo_manufacturado ORDER BY articulo_manufacturado.precio_venta",
            nativeQuery = true
    )
    List<ArticuloManufacturado> filtradoPorPrecioAsc();

    @Query(
            value = "SELECT a.denominacion, SUM(d.cantidad) AS cantidad_productos_vendidos " +
                    "FROM articulo_manufacturado a " +
                    "INNER JOIN detalle_factura d ON a.id = d.id_articulo_manufacturado " +
                    "GROUP BY a.denominacion " +
                    "ORDER BY cantidad_productos_vendidos DESC",
            nativeQuery = true
    )
    List<RankingProductosDTO> filtroPorProductoVendido();

    @Query(
            value = "SELECT a.denominacion, SUM(d.cantidad) AS cantidad_productos_vendidos " +
                    "FROM articulo_manufacturado a " +
                    "INNER JOIN detalle_factura d ON a.id = d.id_articulo_manufacturado " +
                    "INNER JOIN factura f ON d.id_factura = f.id "+
                    "WHERE f.fecha_facturacion BETWEEN :filtro1 AND :filtro2 " +
                    "GROUP BY a.denominacion " +
                    "ORDER BY cantidad_productos_vendidos DESC",
            nativeQuery = true
    )
    List<RankingProductosDTO> filtradoPorProductoVendidoPorFecha(@Param("filtro1") Date filtro1, @Param("filtro2") Date filtro2);
}
