package com.user_food.repository;

import com.user_food.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRolesRepositpry extends JpaRepository<Rol, Long> {
    @Query(value = "SELECT * FROM Rol r WHERE r.nombre = :username", nativeQuery = true)
    Optional<Rol> finByUsername(@Param("username")String name);
}
