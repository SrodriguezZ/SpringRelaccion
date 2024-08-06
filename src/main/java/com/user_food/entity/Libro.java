package com.user_food.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "libroId")
    private Long idLibro;
    @Column(name = "libroNombre")
    @NotNull
    private String nombreLibro;
    @Column(name = "precio", nullable = true)
    private Long precio;

    @OneToMany(mappedBy = "libro", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonIgnore
    public Set<LibroAutor> libroAutors = new HashSet<>();

}
