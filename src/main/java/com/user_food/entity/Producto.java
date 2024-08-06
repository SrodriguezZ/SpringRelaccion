package com.user_food.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productoId;

    @Column(name = "NombreProducto")
    private String nombreProducto;
    @Column(name = "Precio")
    private int precio ;
    @Column(name = "Modelo")
    private String model;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "Id",nullable = true)
    @JsonIgnore
    private Usuario usuario;

}
