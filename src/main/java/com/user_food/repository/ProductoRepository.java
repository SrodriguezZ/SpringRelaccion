package com.user_food.repository;

import com.user_food.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    @Query(value = "SELECT * FROM Producto p WHERE p.nombre_producto = :username" , nativeQuery = true)
    List<Producto> finByUsernameNative(@Param("username") String username);

    @Query(value = "SELECT * FROM Producto p WHERE p.nombre_producto  LIKE CONCAT(:username, '%')" , nativeQuery = true)
    List<Producto> finByUsername(@Param("username") String username);

}
