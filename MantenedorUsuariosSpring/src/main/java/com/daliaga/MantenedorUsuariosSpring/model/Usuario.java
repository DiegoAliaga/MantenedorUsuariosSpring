package com.daliaga.MantenedorUsuariosSpring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", length = 50)
    private Long id;
    @Column(name = "nombre_usuario", length = 50)
    private String name;
    @Column(name = "email",unique = true, length = 50)
    private String email;
    @Column(name = "password", length = 50)
    private String password;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Telefono> phones;
    @Column(name = "created", length = 50)
    private String created;
    @Column(name = "modified", length = 50)
    private String modified;
    @Column(name = "last_login", length = 50)
    private String lastLogin;
    @Column(name = "token", length = 200)
    private String token;
    @Column(name = "vigente")
    private Boolean isActive;
}
