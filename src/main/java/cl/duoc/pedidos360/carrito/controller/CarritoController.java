package cl.duoc.pedidos360.carrito.controller;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.pedidos360.carrito.model.Pedido;

/**
 * Controlador REST del carrito de compras.
 *
 * Sin seguridad local a propósito: la validación de identidad ocurre en el borde
 * (AWS API Gateway + Azure Entra ID), por lo que los endpoints solo intercambian
 * JSON. Usa memoria volátil como almacenamiento de demostración.
 */
@RestController
@RequestMapping("/carrito")
@CrossOrigin(origins = "*") // Permite consumo directo desde el frontend (SPA) en desarrollo.
public class CarritoController {

    /**
     * Almacenamiento en memoria de las líneas de pedido.
     * Se usa CopyOnWriteArrayList (thread-safe) porque el controlador es un
     * singleton de Spring compartido entre todas las peticiones concurrentes;
     * así evitamos condiciones de carrera al hacer GET/POST simultáneos.
     */
    private final List<Pedido> pedidos = new CopyOnWriteArrayList<>(List.of(
            new Pedido(1L, "Notebook Lenovo Legion", 1, 549990.0, "PENDIENTE")
    ));

    /**
     * GET /carrito
     *
     * Retorna la lista completa de líneas de pedido en JSON.
     *
     * @return lista de pedidos actual del carrito.
     */
    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidos;
    }

    /**
     * POST /carrito
     *
     * Recibe una línea de pedido en el cuerpo de la petición, la agrega al
     * carrito y devuelve el pedido creado con HTTP 201 (Created), que es el
     * código correcto para una operación de creación exitosa.
     *
     * @param pedido línea de pedido enviada por el cliente en JSON.
     * @return la línea de pedido persistida en memoria.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido crearPedido(@RequestBody Pedido pedido) {
        pedidos.add(pedido);
        return pedido;
    }
}