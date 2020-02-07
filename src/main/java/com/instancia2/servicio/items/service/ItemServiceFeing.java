package com.instancia2.servicio.items.service;

import com.instancia2.servicio.commons.model.Producto;
import com.instancia2.servicio.items.clienteRest.ProductoClienteRest;
import com.instancia2.servicio.items.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("serviceFeing")
public class ItemServiceFeing implements IItemService {

    //Inyectamos el cliente HTTP usando Feing
    @Autowired
    private ProductoClienteRest clienteFeing;

    @Override
    public List<Item> findAll() {

        System.out.println("\nUsando el cliente HTTP por Feing");

        // Obtenemos el listado de los productos a través del servicio de productos usando Feing
        return clienteFeing.findAll().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {

        System.out.println("\nUsando el cliente HTTP por Feing");

        return new Item(clienteFeing.findProducto(id),cantidad);
    }

    @Override
    public Producto save(Producto producto) {
        return clienteFeing.crear(producto);
    }

    @Override
    public Producto update(Producto producto, Long id) {
        return clienteFeing.update(producto,id);
    }

    @Override
    public void delete(Long id) {
        clienteFeing.eliminar(id);
    }
}
