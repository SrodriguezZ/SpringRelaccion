package com.user_food.repository;

import com.user_food.dto.UsuarioDTO;
import com.user_food.dto.UsuarioProductoDTO;
import com.user_food.entity.Local;
import com.user_food.entity.Manager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class LocalRepositoryTest {

    @Autowired
    private LocalRepository localRepository;
    @Autowired
    private UsuarioRepository _usuarioRepository;

    @Test
    public void saveLocal(){
        Manager manager = Manager.builder()
                .name("Pedro")
                .build();

        Local local = Local.builder()
                .name("Casa blanca")
                .floor("Bastion")
                .manager(manager)
                .build();

        localRepository.save(local);
    }
    
    @Test
    public void getLocalALL(){
        List<Local> local = localRepository.findAll();
        System.out.println("local = " + local);
    }

    @Test
    public void getNativeAll(){
        List<UsuarioProductoDTO> user = _usuarioRepository.finAllWitchProductoAndUsuario();
user.stream().forEach(dto -> System.out.println( dto.getnombres() +
        dto.getapellido() +
        dto.getnombreProducto() +
        dto.getprecio()+
        dto.getmodelo()));
    }


}