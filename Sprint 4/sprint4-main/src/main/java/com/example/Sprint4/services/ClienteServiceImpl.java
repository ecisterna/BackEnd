package com.example.Sprint4.services;

import com.example.Sprint4.DTO.RankingClientesImporteDTO;
import com.example.Sprint4.DTO.RankingClientesPedidosDTO;
import com.example.Sprint4.entities.Cliente;
import com.example.Sprint4.repositories.BaseRepository;
import com.example.Sprint4.repositories.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente,Long> implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(BaseRepository<Cliente, Long> baseRepository, ClienteRepository clienteRepository) {
        super(baseRepository);
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<RankingClientesPedidosDTO> filtradoPorPedidos() throws Exception {
        try {
            List<RankingClientesPedidosDTO> clientes = this.clienteRepository.filtroPorPedidos();
            return clientes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<RankingClientesImporteDTO> filtradoPorImporte() throws Exception {
        try {
            List<RankingClientesImporteDTO> clientes = this.clienteRepository.filtroPorImporte();
            return clientes;
        } catch (Exception var2) {
            throw new Exception(var2.getMessage());
        }
    }

    @Transactional
    public List<RankingClientesPedidosDTO> filtroPorPedidosFecha(Date filtro1, Date filtro2) throws Exception {
        try {
            try {
                List<RankingClientesPedidosDTO> clientes = this.clienteRepository.filtroPorPedidosFecha(filtro1, filtro2);
                return clientes;
            } catch (Exception var4) {
                throw new Exception(var4.getMessage());
            }
        } catch (Throwable var5) {
            throw var5;
        }
    }

    @Transactional
    public List<RankingClientesImporteDTO> filtradoPorImporteFechas(Date filtro1, Date filtro2) throws Exception {
        try {
            List<RankingClientesImporteDTO> clientes = this.clienteRepository.filtroPorImporteFechas(filtro1, filtro2);
            return clientes;
        } catch (Exception var4) {
            throw new Exception(var4.getMessage());
        }
    }
}
