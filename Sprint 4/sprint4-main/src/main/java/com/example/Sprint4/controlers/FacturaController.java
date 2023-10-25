package com.example.Sprint4.controlers;

import com.example.Sprint4.entities.Factura;
import com.example.Sprint4.services.FacturaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/Facturas")
public class FacturaController extends BaseControllerImpl<Factura, FacturaServiceImpl> {
}
