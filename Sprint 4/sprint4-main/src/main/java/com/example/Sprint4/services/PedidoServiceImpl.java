package com.example.Sprint4.services;

import com.example.Sprint4.DTO.MovimientosMonetariosDTO;
import com.example.Sprint4.controlers.BaseControllerImpl;
import com.example.Sprint4.entities.Pedido;
import com.example.Sprint4.repositories.BaseRepository;
import com.example.Sprint4.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido,Long> implements PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoServiceImpl(BaseRepository<Pedido, Long> baseRepository, PedidoRepository pedidoServiceRepository) {
        super(baseRepository);
    }

    @Override
    public MovimientosMonetariosDTO MovimientoMonetario() throws Exception {
        try {
            MovimientosMonetariosDTO movimientos = pedidoRepository.MovimientoMonetario();
            return movimientos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public MovimientosMonetariosDTO MovimientoMonetarioFecha(Date filtro1, Date filtro2) throws Exception {
        try {
            try {
                MovimientosMonetariosDTO movimientos = this.pedidoRepository.MovimientoMonetarioFecha(filtro1, filtro2);
                return movimientos;
            } catch (Exception var4) {
                throw new Exception(var4.getMessage());
            }
        } catch (Throwable var5) {
            throw var5;
        }
    }
}
