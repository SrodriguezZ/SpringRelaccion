package com.user_food.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor@Data
public class UsuarioDTO {
    //Nulos controalar
    @NotNull//no puede ser nulo
    private String Nombres;
    @NotEmpty//puede ser vacio con espacio

    private String Apellidos;

    @Positive //   Que sea positiva -> podemos usar zero PositveOrZero
    private int Edad;
    //@NotBlank//No puede ser vacio ni con un espacio
    @Email
    private String Correo;
}
//@Negative puede ser valores negativo @NegativeOrZero