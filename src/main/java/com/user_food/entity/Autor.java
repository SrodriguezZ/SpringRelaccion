package com.user_food.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long autoId;
    @Column(name = "nombreAutor", nullable = true)
    public String nombre;
    @NotEmpty
    public String apellido;

    @OneToMany(mappedBy = "autor" , cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonIgnore
    public Set<LibroAutor> libroAutors = new HashSet<>();

}
