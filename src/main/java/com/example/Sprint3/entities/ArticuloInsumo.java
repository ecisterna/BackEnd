package com.example.Sprint3.entities;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "articulo_insumo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ArticuloInsumo extends Base {

    @NotNull
    private String denominacion;

    @Column(name = "url_imagen")
    private String urlImagen;

    @NotNull
    @Column(name = "precio_compra", precision = 10, scale = 2)
    private int precioCompra;

    @NotNull
    @Column(name = "stock_actual", precision = 10, scale = 2)
    private int stockActual;

    @NotNull
    @Column(name = "stock_minimo", precision = 10, scale = 2)
    private int stockMinimo;

    @NotNull
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;

    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @Column(name = "fecha_baja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBaja;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @NotNull
    @Builder.Default
    @JoinColumn(name = "id_detalleFactura")
    private List<DetalleFactura> detallesFactura = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Rubro_Articulo")
    private RubroArticulo rubroArticulo;

    public void AgregarDetallesFactura(DetalleFactura df){
        detallesFactura.add(df);
    }

}
