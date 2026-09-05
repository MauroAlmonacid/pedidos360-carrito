package cl.duoc.pedidos360.carrito.model;

/**
 * Modelo de dominio que representa una línea de pedido del carrito de compras.
 *
 * Se implementa como un {@code record} por su inmutabilidad y su serialización
 * JSON directa por Jackson. Al concentrar la seguridad en el borde (API Gateway +
 * Azure Entra ID), este microservicio se limita a recibir, almacenar y devolver
 * datos sin lógica de autenticación local.
 *
 * @param id        Identificador de la línea de pedido.
 * @param producto  Nombre del producto solicitado.
 * @param cantidad  Cantidad de unidades solicitadas.
 * @param total     Importe total de la línea (precio * cantidad).
 * @param estado    Estado de la línea (ej: "PENDIENTE", "CONFIRMADO").
 */
public record Pedido(
        Long id,
        String producto,
        int cantidad,
        double total,
        String estado
) {
}