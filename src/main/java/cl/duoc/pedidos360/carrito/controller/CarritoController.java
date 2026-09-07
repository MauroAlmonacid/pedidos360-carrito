package cl.duoc.pedidos360.carrito.controller;

import cl.duoc.pedidos360.carrito.model.Pedido;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/carrito")
// Permite la comunicación directa con tu frontend en Angular:
@CrossOrigin(origins = "http://localhost:4200")
public class CarritoController {

    // Lista temporal en memoria para almacenar los pedidos del carrito
    private final List<Pedido> itemsCarrito = new ArrayList<>();

    // Endpoint GET: http://localhost:8082/carrito
    @GetMapping
    public List<Pedido> obtenerCarrito() {
        return itemsCarrito;
    }

    // Endpoint POST: http://localhost:8082/carrito
    @PostMapping
    public Pedido agregarAlCarrito(@RequestBody Pedido pedido) {
        itemsCarrito.add(pedido);
        return pedido;
    }

    // Endpoint DELETE: http://localhost:8082/carrito
    @DeleteMapping
    public void vaciarCarrito() {
        itemsCarrito.clear();
    }
}