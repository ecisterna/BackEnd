package com.example.Sprint3.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Cliente extends Base {

    private String nombre;

    private String apellido;

    private String telefono;

    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @NotNull
    @Builder.Default
    @JoinColumn(name = "id_domicilio")
    private List<Domicilio> domicilios = new ArrayList<>();

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
    @JoinColumn(name = "id_pedido")
    private List<Pedido> pedidos = new ArrayList<>();

    public void AgregarPedidos(Pedido p){
        pedidos.add(p);
    }

    public void AgregarDomicilios(Domicilio d){
        domicilios.add(d);
    }
}
