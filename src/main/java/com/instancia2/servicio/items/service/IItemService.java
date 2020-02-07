package com.instancia2.servicio.items.service;

import com.instancia2.servicio.commons.model.Producto; // Usamos la entindad productos del servicio commons
import com.instancia2.servicio.items.model.Item;

import java.util.List;

public interface IItemService {

    public List<Item> findAll();
    public Item findById(Long id, Integer cantidad);
    public Producto save(Producto producto);
    public Producto update(Producto producto, Long id);
    public void delete(Long id);
}
