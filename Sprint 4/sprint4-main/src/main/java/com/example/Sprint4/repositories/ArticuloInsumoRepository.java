package com.example.Sprint4.repositories;

import com.example.Sprint4.DTO.InsumoDTO;
import com.example.Sprint4.entities.ArticuloInsumo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticuloInsumoRepository extends BaseRepository<ArticuloInsumo, Long>{
    @Query(
            value = "SELECT * FROM articulo_insumo " +
                    "WHERE articulo_insumo.denominacionInsumo LIKE %:filtro%",
            nativeQuery = true
    )
    List<ArticuloInsumo> busquedaPorDenominacionIns(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM articulo_insumo " +
                    "WHERE articulo_insumo.fecha_baja IS null",
            nativeQuery = true
    )
    List<ArticuloInsumo> verificarFechaBajaIngrediente();

    @Query(
            value = "SELECT * FROM articulo_insumo " +
                    "WHERE (stock_actual <= stock_minimo) OR (stock_actual <= (stock_minimo + 0.2*stock_minimo)) ",
            nativeQuery = true
    )
    List<InsumoDTO> bajoStock();
}
