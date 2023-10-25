package com.example.Sprint4.services;

import com.example.Sprint4.DTO.MovimientosMonetariosDTO;
import com.example.Sprint4.entities.Pedido;

import java.util.Date;

public interface PedidoService extends BaseService<Pedido, Long>{

    MovimientosMonetariosDTO MovimientoMonetario() throws Exception;

    MovimientosMonetariosDTO MovimientoMonetarioFecha(Date filtro1, Date filtro2) throws Exception;
}
