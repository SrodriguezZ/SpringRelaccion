package com.user_food.entity;

import jakarta.persistence.*;
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

public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public Long idROl;
    @Enumerated(EnumType.STRING)
    public EnumRol nombre;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<Usuario> usuarios = new HashSet<>();
}
