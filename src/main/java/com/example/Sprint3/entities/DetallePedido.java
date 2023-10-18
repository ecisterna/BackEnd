package com.example.Sprint3.entities;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "detalle_pedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DetallePedido extends Base {

    @NotNull
    private Integer cantidad;

    @NotNull
    @Column(name = "subtotal", precision = 10, scale = 2)
    private int subtotal;

    @NotNull
    @Column(name = "subtotal_costo", precision = 10, scale = 2)
    private int subtotalCosto;


}
