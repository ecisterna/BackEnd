package com.example.Sprint4.services;

import com.example.Sprint4.entities.DetalleArticuloManufacturado;
import com.example.Sprint4.repositories.BaseRepository;
import com.example.Sprint4.repositories.DetalleArtManufacturadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleArtManufacturadoServiceImpl extends BaseServiceImpl<DetalleArticuloManufacturado, Long> implements DetalleArtManufacturadoService {
    @Autowired
    private DetalleArtManufacturadoRepository detalleArtManufacturadoRepository;

    public DetalleArtManufacturadoServiceImpl(BaseRepository<DetalleArticuloManufacturado, Long> baseRepository) {
        super(baseRepository);
    }
}
