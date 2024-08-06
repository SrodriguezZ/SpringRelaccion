package com.user_food.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AutorLibroDto {
    @NotNull
    public Long idAutor;
    @NotNull
    public Long idLibro;
    @NotNull
    public String comentario;
}
