package com.example.Sprint4.controlers;

import com.example.Sprint4.entities.Pedido;
import com.example.Sprint4.services.PedidoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/Pedidos")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl> {
    @GetMapping("/MovimientosMonetarios")
    public ResponseEntity<?> MovimientoMonetarios(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.MovimientoMonetario());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping({"/MovimientosMonetariosFecha"})
    public ResponseEntity<?> MovimientoMonetariosFecha(@RequestParam Date filtro1, @RequestParam Date filtro2) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((PedidoServiceImpl)this.servicio).MovimientoMonetarioFecha(filtro1, filtro2));
        } catch (Exception var4) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + var4.getMessage() + "\"}");
        }
    }
}
