package com.instancia2.servicio.items.clienteRest;

import com.instancia2.servicio.items.model.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Interface para definir el cliente HTTP Rest de para el servicio-productos usando Feing
 */
@FeignClient(name = "servicio-productos")
public interface ProductoClienteRest {

    @GetMapping("/listar")
    public List<Producto> findAll();

    @GetMapping("/listar/{id}")
    public Producto findProducto(@PathVariable Long id);
}
