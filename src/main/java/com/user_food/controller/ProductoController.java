package com.user_food.controller;

import com.user_food.dto.ProductoDTO;
import com.user_food.entity.Producto;
import com.user_food.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/producto")
public class ProductoController {
    @Autowired
    private ProductoService _productoService;

    @GetMapping("/")
    private ResponseEntity<List<Producto>> getAll(){
        return  ResponseEntity.ok(_productoService.getAllProducto());
    }

    @GetMapping("/{id}")
    private  ResponseEntity<Producto> getByIdProducto(@PathVariable long id){
        return ResponseEntity.ok(_productoService.getById(id));
    }

    @GetMapping("/username")
    private ResponseEntity<List<Producto>> getByUsername(@RequestParam("username") String username){
        return ResponseEntity.ok(_productoService.getByIdUsername(username));
    }

    @GetMapping("/list")
    private List<ProductoDTO> getListAll(){
        return _productoService.getDto();
    }

}
