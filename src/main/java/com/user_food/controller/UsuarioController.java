package com.user_food.controller;

import com.user_food.dto.UsuarioDTO;
import com.user_food.dto.UsuarioProductoDTO;
import com.user_food.entity.Usuario;
import com.user_food.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class UsuarioController {
    @Autowired
    private UsuarioService _usuarioService;

    @GetMapping("/")
    public List<UsuarioDTO> getAll(){
        return _usuarioService.getALL();
    }

    @PostMapping
    public ResponseEntity<Void> post(@Valid @RequestBody UsuarioDTO usuarioDTO){
        _usuarioService.post(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getById(@PathVariable long id){
            UsuarioDTO user = _usuarioService.getById(id);
            return ResponseEntity.ok(user);
    }

    @GetMapping("/username")
    public ResponseEntity<UsuarioDTO> getByUsername(@RequestParam("name") String name){
        UsuarioDTO user = _usuarioService.getByUsername(name);
        return ResponseEntity.ok(user);
    }
    @GetMapping("/list")
    public ResponseEntity<List<UsuarioDTO>> getList(@RequestParam("username")String name){
        List<UsuarioDTO> use =_usuarioService.getListByUsername(name);
        return  ResponseEntity.ok(use);
    }

    @GetMapping("/WithProrducto")
    public ResponseEntity<List<Usuario>> getWitchUsuarioAndProducto(){
        List<Usuario> list = _usuarioService.getWithUsuarioAndProducto();
        return ResponseEntity.ok(list);
    }

    @GetMapping("producto/id")
    public Usuario getWithByIdProducto(@RequestParam("id") long id){
        return _usuarioService.getByIdProducto(id);
    }

    @GetMapping("/native")
    public ResponseEntity<List<UsuarioProductoDTO>> getALLNative(){
        List<UsuarioProductoDTO> list = _usuarioService.getListQueryNative();
       return  ResponseEntity.ok(list);
    }
 }
