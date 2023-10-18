package com.example.Sprint3.entities;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "domicilio")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Domicilio extends Base {

    @NotNull
    @Column(length = 500)
    private String calle;

    @NotNull
    @Column(precision = 5)
    private Integer numero;

    @NotNull
    @Column(precision = 4)
    private Integer codigoPostal;

    @NotNull
    private String localidad;

    @Column(name = "numero_vivienda")
    private Integer numeroDpto;

    @Column(name = "piso_vivienda")
    private Integer pisoDpto;

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

}
