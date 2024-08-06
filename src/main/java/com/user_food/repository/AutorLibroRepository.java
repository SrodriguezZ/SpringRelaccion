package com.user_food.repository;

import com.user_food.entity.LibroAutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorLibroRepository extends JpaRepository<LibroAutor, Long> {
}
