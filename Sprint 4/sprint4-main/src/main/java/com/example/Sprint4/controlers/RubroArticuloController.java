package com.example.Sprint4.controlers;

import com.example.Sprint4.entities.RubroArticulo;
import com.example.Sprint4.services.BaseServiceImpl;
import com.example.Sprint4.services.RubroArticuloService;
import com.example.Sprint4.services.RubroArticuloServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/RubrosArticulo")
public class RubroArticuloController extends BaseControllerImpl<RubroArticulo, RubroArticuloServiceImpl> {
}
