package com.instancia2.servicio.items.controller;

import com.instancia2.servicio.items.model.Item;
import com.instancia2.servicio.items.model.Producto;
import com.instancia2.servicio.items.service.IItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
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

    @HystrixCommand(fallbackMethod = "metodoAlternativo") // --> Metodo alternativo en caso de error al recuperar producto del servicio-productos
    @GetMapping("/listar/{id}/cantidad/{cantidad}")
    public Item findItem(@PathVariable Long id, @PathVariable Integer cantidad) {
        return itemService.findById(id, cantidad);
    }

    // Método alternativo que se ejecutará en caso de error, devolvemos un producto alternativo
    public Item metodoAlternativo(Long id, Integer cantidad){
        Item item = new Item();
        Producto producto = new Producto();

        producto.setId(id);
        producto.setNombre("Producto Alternativo");
        producto.setPrecio(500.00);
        producto.setCreateAt(new Date());

        item.setCantidad(5);
        item.setProducto(producto);

        return item;
    }
}
