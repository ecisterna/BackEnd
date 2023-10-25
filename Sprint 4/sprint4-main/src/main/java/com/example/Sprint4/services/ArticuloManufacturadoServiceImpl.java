package com.example.Sprint4.services;

import com.example.Sprint4.DTO.RankingProductosDTO;
import com.example.Sprint4.entities.ArticuloManufacturado;
import com.example.Sprint4.entities.Base;
import com.example.Sprint4.repositories.ArticuloManufacturadoRepository;
import com.example.Sprint4.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticuloManufacturadoServiceImpl extends BaseServiceImpl<ArticuloManufacturado,Long> implements ArticuloManufacturadoService {
    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;

    public ArticuloManufacturadoServiceImpl(BaseRepository<ArticuloManufacturado, Long> baseRepository, ArticuloManufacturadoRepository articuloManufacturadoRepository) {
        super(baseRepository);
    }

    public List<ArticuloManufacturado> busquedaPorDenominacion(String filtro) throws Exception {
        try {
            List<ArticuloManufacturado> articuloManufacturados = this.articuloManufacturadoRepository.busquedaPorDenominacion(filtro);
            return articuloManufacturados;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<ArticuloManufacturado> filtradoPorPrecioDesc() throws Exception {
        try {
            List<ArticuloManufacturado> articuloManufacturados = this.articuloManufacturadoRepository.filtradoPorPrecioDesc();
            return articuloManufacturados;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<ArticuloManufacturado> filtradoPorPrecioAsc() throws Exception {
        try {
            List<ArticuloManufacturado> articuloManufacturados = this.articuloManufacturadoRepository.filtradoPorPrecioAsc();
            return articuloManufacturados;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<RankingProductosDTO> filtradoPorProductoVendido() throws Exception {
        try {
            List<RankingProductosDTO> productos = articuloManufacturadoRepository.filtroPorProductoVendido();
            return productos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<RankingProductosDTO> filtradoPorProductoVendidoPorFecha(Date filtro1, Date filtro2) throws Exception {
        try {
            List<RankingProductosDTO> productos = articuloManufacturadoRepository.filtradoPorProductoVendidoPorFecha(filtro1,filtro2);
            return productos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
