package com.example.Sprint3.entities;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "detalle_factura")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DetalleFactura extends Base {

    @NotNull
    private Integer cantidad;

    @NotNull
    @Column(name = "subtotal", precision = 10, scale = 2)
    private int subtotal;

    @ManyToOne()
    @JoinColumn(name = "id_articulo_manufacturado")
    private ArticuloManufacturado articuloManufacturado;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Factura")
    private Factura facturas;

}
