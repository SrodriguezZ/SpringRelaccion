package com.user_food.service;

import com.user_food.dto.RolDTO;
import com.user_food.entity.EnumRol;
import com.user_food.entity.Rol;
import com.user_food.entity.Usuario;
import com.user_food.exception.ResourceNotFoundException;
import com.user_food.repository.IRolesRepositpry;
import com.user_food.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {
    @Autowired
    private IRolesRepositpry _irolRepository;
    @Autowired
    private UsuarioRepository _usuarioRepository;

    public void postRol(Rol rol){
        _irolRepository.save((rol));
    }

    public List<Rol> getAll(){
        return _irolRepository.findAll();
    }
    @Transactional
    public void postRolUsuario(RolDTO roldto){
        Optional<Usuario> usuario = _usuarioRepository.findById(roldto.getUsuarioId());
        if(usuario.isPresent()){
            Usuario user = usuario.get();

            EnumRol enumRol = EnumRol.valueOf(roldto.getNombre().toUpperCase());
            Rol rol = _irolRepository.finByUsername(roldto.getNombre())
                    .orElseGet(()-> {
                        Rol newRol = new Rol();
                        newRol.setNombre(enumRol);
                        return _irolRepository.save(newRol);
                    });

            user.getRoles().add(rol);
            _usuarioRepository.save(user);
        }else{
            throw  new ResourceNotFoundException("Ocurrio un error");
        }
    }
}
