package com.user_food.controller;

import com.user_food.dto.RolDTO;
import com.user_food.entity.Rol;
import com.user_food.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/rol")
public class RolController {
    @Autowired
    private RolService _rolService;

    @PostMapping
    public ResponseEntity<Void> post(Rol rol){
        _rolService.postRol(rol);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Rol>> getAll(){
        List<Rol> rol = _rolService.getAll();
        return ResponseEntity.ok(rol);
    }

    @PostMapping("/usario_rol")
    public ResponseEntity<Void> post(RolDTO rol){
        _rolService.postRolUsuario(rol);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
