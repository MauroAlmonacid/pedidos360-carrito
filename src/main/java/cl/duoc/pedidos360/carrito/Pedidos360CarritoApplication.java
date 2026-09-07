package cl.duoc.pedidos360.carrito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// scanBasePackages le ordena a Spring escanear todos los controladores bajo 'cl.duoc.pedidos360'
@SpringBootApplication(scanBasePackages = "cl.duoc.pedidos360")
public class Pedidos360CarritoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Pedidos360CarritoApplication.class, args);
    }

}