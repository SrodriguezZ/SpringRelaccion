package com.user_food.service;

import com.user_food.dto.UsuarioDTO;
import com.user_food.dto.UsuarioProductoDTO;
import com.user_food.entity.Usuario;
import com.user_food.exception.ResourceNotFoundException;
import com.user_food.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository _usuarioRepository;

    public List<UsuarioDTO> getALL(){
        return _usuarioRepository.findAll()
                .stream()
                .map(usuario -> new UsuarioDTO(usuario.getNombres(), usuario.getApellidos(), usuario.getEdad(), usuario.getCorreo())).collect(Collectors.toList());
    }

    public void post(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario(usuarioDTO);
        _usuarioRepository.save(usuario);
    }

    public UsuarioDTO getById(long id){
        Usuario user = _usuarioRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No se encontro " + id));

        return new UsuarioDTO(user.getNombres(),user.getApellidos(),user.getEdad(),user.getCorreo());
    }

    public UsuarioDTO getByUsername(String name){
        Usuario user = _usuarioRepository.finByUsernameNative(name);
        if(user == null){
            throw new ResourceNotFoundException("No se encontro el usarneme " + name);
        }
        return new UsuarioDTO(user.getNombres(), user.getCorreo(), user.getEdad(), user.getApellidos());
    }

    public List<UsuarioDTO> getListByUsername(String name){
        List<UsuarioDTO> user =  _usuarioRepository.listByUsername(name)
                .stream().filter(usuario -> usuario.getEdad() > 18)
                .sorted(Comparator.comparing(Usuario::getEdad))
                .map(usuario -> new UsuarioDTO(
                        usuario.getNombres(), usuario.getApellidos(), usuario.getEdad(), usuario.getCorreo()
                )).collect(Collectors.toList());
        if(user.isEmpty()){
            throw  new ResourceNotFoundException("Lista vacia");
        }
        return user;
    }

    public List<Usuario >getWithUsuarioAndProducto(){
        return _usuarioRepository.findAll();
    }

    public Usuario getByIdProducto(long id ){
        Usuario user = _usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID NO ENCONTRADO" + id));
        return user;
    }

    public List<UsuarioProductoDTO> getListQueryNative(){
        System.out.println("Consulta : " + _usuarioRepository.finAllWitchProductoAndUsuario());
        return _usuarioRepository.finAllWitchProductoAndUsuario();
    }

}
