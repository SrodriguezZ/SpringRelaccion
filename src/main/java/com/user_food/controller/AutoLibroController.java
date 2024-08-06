package com.user_food.controller;

import com.user_food.dto.AutorLibroDto;
import com.user_food.service.AutorLibroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/autorlibro")
public class AutoLibroController {

    @Autowired
    private AutorLibroService _autorLibroService;
    @PostMapping
    public ResponseEntity<Void> post(@Valid @RequestBody AutorLibroDto autorLibroDto){
        _autorLibroService.postAutoLibro(autorLibroDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}
