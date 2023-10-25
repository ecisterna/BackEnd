package com.example.Sprint4.entities;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "detalle_articulo_manufacturado")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DetalleArticuloManufacturado extends Base {

    @NotNull
    @Column(name = "cantidad", precision = 10, scale = 2)
    private int cantidad;

}
