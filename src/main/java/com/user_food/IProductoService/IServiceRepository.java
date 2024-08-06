package com.user_food.IProductoService;

import com.user_food.entity.Producto;

import java.util.List;

public interface IServiceRepository {

    public List<Producto> getAllProducto();

    public Producto getById(long id);

    public List<Producto> getByIdUsername(String username);
    public List<Producto> finByUsername(String username);
}
