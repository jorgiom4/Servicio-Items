package com.instancia2.servicio.items.controller;

import com.instancia2.servicio.items.model.Item;
import com.instancia2.servicio.items.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    // @Qualifier("serviceRestTemplate") // Para usar el servicio RestTemplate
    @Qualifier("serviceFeing") // Para usar el servicio Feing
    private IItemService itemService;

    @GetMapping("/listar")
    public List<Item> listar(){
        return itemService.findAll();
    }

    @GetMapping("/listar/{id}/cantidad/{cantidad}")
    public Item findItem(@PathVariable Long id, @PathVariable Integer cantidad) {
        return itemService.findById(id, cantidad);
    }
}
