package com.user_food.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


public interface UsuarioProductoDTO {
    String getnombreProducto();

    int getprecio();

    String getnombres();

    String getapellido();
    String getmodelo();

}
