package com.example.Sprint4.controlers;

import com.example.Sprint4.entities.DetalleArticuloManufacturado;
import com.example.Sprint4.services.DetalleArtManufacturadoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/DetallesArtManufacturado")
public class DetalleArtManufacturadoController extends BaseControllerImpl<DetalleArticuloManufacturado, DetalleArtManufacturadoServiceImpl>{
}
