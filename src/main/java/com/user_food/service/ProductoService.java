package com.user_food.service;

import com.user_food.IProductoService.IServiceRepository;
import com.user_food.dto.ProductoDTO;
import com.user_food.dto.UsuarioDTO;
import com.user_food.entity.Producto;
import com.user_food.exception.ResourceNotFoundException;
import com.user_food.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService implements IServiceRepository {
    @Autowired
    private ProductoRepository _productoRepository;


    @Override
    public List<Producto> getAllProducto() {
        return _productoRepository.findAll();
    }

    @Override
    public Producto getById(long id) {
        return _productoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No existe id" + id));
    }

    @Override
    public List<Producto> getByIdUsername(String username) {
        return _productoRepository.finByUsernameNative(username);
    }

    @Override
    public List<Producto> finByUsername(String username) {
        return _productoRepository.finByUsername(username);
    }

    public List<ProductoDTO> getDto(){
        return _productoRepository.findAll().stream()
                .map( producto ->  new ProductoDTO(producto.getNombreProducto(), producto.getPrecio()))
                .collect(Collectors.toList());
    }
}
