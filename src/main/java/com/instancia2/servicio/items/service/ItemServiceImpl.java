package com.instancia2.servicio.items.service;

import com.instancia2.servicio.commons.model.Producto;
import com.instancia2.servicio.items.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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

    @Override
    public Producto save(Producto producto) {
        HttpEntity<Producto> body = new HttpEntity<>(producto);
        ResponseEntity<Producto> respuesta =  clienteRest.exchange("http://servicio-productos/crear", HttpMethod.POST, body, Producto.class);
        Producto productoRespuesta = respuesta.getBody();

        return productoRespuesta;
    }

    @Override
    public Producto update(Producto producto, Long id) {
        HttpEntity<Producto> body = new HttpEntity<>(producto);
        HashMap<String, String> pathVariables = new HashMap<>();
        pathVariables.put("id", id.toString());
        ResponseEntity<Producto> respesta = clienteRest.exchange("http://servicio-productos/editar/{id}", HttpMethod.PUT, body, Producto.class, pathVariables);

        return respesta.getBody();
    }

    @Override
    public void delete(Long id) {
        HashMap<String, String> pathVariables = new HashMap<>();
        pathVariables.put("id", id.toString());
        clienteRest.delete("http://servicio-productos/eliminar/{id}", pathVariables);

    }
}
