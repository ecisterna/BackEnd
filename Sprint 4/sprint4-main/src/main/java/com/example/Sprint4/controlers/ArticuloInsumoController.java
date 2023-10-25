package com.example.Sprint4.controlers;

import com.example.Sprint4.entities.ArticuloInsumo;
import com.example.Sprint4.services.ArticuloInsumoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/ArticulosInsumo")
public class ArticuloInsumoController extends BaseControllerImpl<ArticuloInsumo, ArticuloInsumoServiceImpl> {
    public ArticuloInsumoController() {
    }

    @GetMapping({"/busquedaPorDenominacion"})
    public ResponseEntity<?> busquedaPorDenominacionIns(@RequestParam String filtro) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(((ArticuloInsumoServiceImpl)this.servicio).busquedaPorDenominacionIns(filtro));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    @PostMapping("/nuevoInsumo")
    public ResponseEntity<?> nuevoInsumo(@RequestBody ArticuloInsumo articuloInsumo) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.nuevoInsumo(articuloInsumo));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/stockBajo")
    public ResponseEntity<?> stockBajo() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.bajoStock());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/verificarFechaBajaIngrediente")
    public ResponseEntity<?> verificarFechaBajaIngrediente(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.verificarFechaBajaIngrediente());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}

