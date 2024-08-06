package com.user_food.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LibroAutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long libroAutoId;

    @ManyToOne
    @JoinColumn(name = "libro_id",referencedColumnName = "libroId")
    @JsonBackReference
    private Libro libro;

    @ManyToOne
    @JoinColumn(name = "autor_id", referencedColumnName = "autoId"  )
    @JsonIgnore
    private Autor autor;

    @JoinColumn(name = "comentario", nullable = false)
    private String comentario;

}
