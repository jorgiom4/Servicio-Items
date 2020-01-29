package com.instancia2.servicio.items.service;

import com.instancia2.servicio.items.model.Item;
import com.instancia2.servicio.items.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("serviceRestTemplate")
public class ItemServiceImpl implements IItemService {

    @Autowired
    private RestTemplate clienteRest;

    @Override
    public List<Item> findAll() {

        System.out.println("\nUsando el cliente HTTP por RestTemplate");

        // Obtenemos el listado de los productos a través del servicio de productos usando RestTemplate
        List<Producto> productos= Arrays.asList(clienteRest.getForObject("http://servicio-productos/listar", Producto[].class));

        return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {

        System.out.println("\nUsando el cliente HTTP por RestTemplate");

        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("id", id.toString());
        Producto producto = clienteRest.getForObject("http://servicio-productos/listar/{id}", Producto.class, pathVariables);

        return new Item(producto, cantidad);
    }
}
