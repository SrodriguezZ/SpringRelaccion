package com.user_food.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.user_food.dto.UsuarioDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private  Long IdUsuario;
    @Column(name = "Nombres")
    private String Nombres;
    @Column(name = "Apellido")
    private String Apellidos;
    @Column(name = "Edad")
    private int Edad;
    @Column(name = "Correo")
    private String Correo;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Producto> productos;


    @ManyToMany
    @JoinTable(
            name ="usuario_roles",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    @JsonIgnore
    public Set<Rol> roles = new HashSet<>();

    public Usuario(UsuarioDTO usuarioDTO) {
        this.Nombres = usuarioDTO.getNombres();
        this.Apellidos = usuarioDTO.getApellidos();
        this.Edad = usuarioDTO.getEdad();
        this.Correo = usuarioDTO.getCorreo();
    }
}
