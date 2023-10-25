package com.example.Sprint4.services;

import com.example.Sprint4.DTO.InsumoDTO;
import com.example.Sprint4.entities.ArticuloInsumo;

import java.util.List;

public interface ArticuloInsumoService extends BaseService<ArticuloInsumo, Long>{
    List<ArticuloInsumo> busquedaPorDenominacionIns(String filtro) throws Exception;
    List<ArticuloInsumo> nuevoInsumo(ArticuloInsumo articuloInsumo) throws Exception;
    List<InsumoDTO> bajoStock() throws Exception;
    List<ArticuloInsumo> verificarFechaBajaIngrediente() throws Exception;
}
