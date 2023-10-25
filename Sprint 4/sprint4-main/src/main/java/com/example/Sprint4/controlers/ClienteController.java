package com.example.Sprint4.controlers;

import com.example.Sprint4.entities.Cliente;
import com.example.Sprint4.services.ClienteServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/Clientes")
public class ClienteController extends BaseControllerImpl<Cliente, ClienteServiceImpl> {

    public ClienteController(){}

    @GetMapping({"/filtradoPorPedidos"})
    public ResponseEntity<?> filtradoPorPedidos() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((ClienteServiceImpl)this.servicio).filtradoPorPedidos());
        } catch (Exception var2) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + var2.getMessage() + "\"}");
        }
    }

    @GetMapping({"/filtradoPorImporte"})
    public ResponseEntity<?> filtradoPorImporte() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((ClienteServiceImpl)this.servicio).filtradoPorImporte());
        } catch (Exception var2) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + var2.getMessage() + "\"}");
        }
    }

    @GetMapping({"/filtradoPorPedidosFecha"})
    public ResponseEntity<?> filtroPorPedidosFecha(@RequestParam Date filtro1, @RequestParam Date filtro2) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((ClienteServiceImpl)this.servicio).filtroPorPedidosFecha(filtro1, filtro2));
        } catch (Exception var4) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + var4.getMessage() + "\"}");
        }
    }

    @GetMapping({"/filtradoPorImporteFecha"})
    public ResponseEntity<?> filtroPorImporteFechas(@RequestParam Date filtro1, @RequestParam Date filtro2) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((ClienteServiceImpl)this.servicio).filtradoPorImporteFechas(filtro1, filtro2));
        } catch (Exception var4) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + var4.getMessage() + "\"}");
        }
    }
}
