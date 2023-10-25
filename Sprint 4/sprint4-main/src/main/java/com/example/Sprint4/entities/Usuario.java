package com.example.Sprint4.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "usuario")
@Builder
public class Usuario extends Base {

    @Column(name = "auth0_id", nullable = false, unique = true)
    private int auth0Id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "fecha_alta")
    private LocalDateTime fechaAlta;

    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    @Column(name = "fecha_baja")
    private Date fechaBaja;

}
