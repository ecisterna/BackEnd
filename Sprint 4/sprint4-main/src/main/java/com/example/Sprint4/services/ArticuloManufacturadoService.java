package com.example.Sprint4.services;

import com.example.Sprint4.DTO.RankingProductosDTO;
import com.example.Sprint4.entities.ArticuloManufacturado;

import java.util.Date;
import java.util.List;

public interface ArticuloManufacturadoService extends BaseService<ArticuloManufacturado, Long>{
    List<ArticuloManufacturado> busquedaPorDenominacion(String filtro) throws Exception;

    List<ArticuloManufacturado> filtradoPorPrecioDesc() throws Exception;

    List<ArticuloManufacturado> filtradoPorPrecioAsc() throws Exception;

    List<RankingProductosDTO> filtradoPorProductoVendido() throws Exception;

    List<RankingProductosDTO> filtradoPorProductoVendidoPorFecha(Date filtro1, Date filtro2) throws Exception;
}
