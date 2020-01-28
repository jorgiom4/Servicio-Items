package com.instancia2.servicio.items.service;

import com.instancia2.servicio.items.model.Item;

import java.util.List;

public interface IItemService {

    public List<Item> findAll();
    public Item findById(Long id, Integer cantidad);
}
