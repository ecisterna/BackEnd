package com.example.Sprint4.services;

import com.example.Sprint4.DTO.RankingClientesImporteDTO;
import com.example.Sprint4.DTO.RankingClientesPedidosDTO;
import com.example.Sprint4.entities.Cliente;

import java.util.Date;
import java.util.List;

public interface ClienteService extends BaseService<Cliente, Long>{
    List<RankingClientesPedidosDTO> filtradoPorPedidos() throws Exception;

    List<RankingClientesImporteDTO> filtradoPorImporte() throws Exception;

    List<RankingClientesPedidosDTO> filtroPorPedidosFecha(Date filtro1, Date filtro2) throws Exception;

    List<RankingClientesImporteDTO> filtradoPorImporteFechas(Date filtro1, Date filtro2) throws Exception;
}
