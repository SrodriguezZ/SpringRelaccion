package com.user_food.repository;

import com.user_food.dto.UsuarioProductoDTO;
import com.user_food.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query(value = "SELECT * FROM Usuario u WHERE u.nombres = :username", nativeQuery = true)
    Usuario finByUsernameNative(@Param("username") String username);

    @Query(value = "SELECT * FROM Usuario u WHERE u.nombres  LIKE CONCAT(:username, '%')", nativeQuery = true)
    List<Usuario> listByUsername(@Param("username") String username);

    @Query(value = "SELECT p.nombre_producto as nombreProducto, p.precio as precio, u.nombres as nombres, u.apellido as apellido, COALESCE(p.modelo, 'hOLA') as modelo " +
            "FROM  Producto p " +
            "INNER JOIN Usuario u ON u.id = p.usuario_id " +
            "WHERE p.precio > 500", nativeQuery = true)
    List<UsuarioProductoDTO> finAllWitchProductoAndUsuario();
}
