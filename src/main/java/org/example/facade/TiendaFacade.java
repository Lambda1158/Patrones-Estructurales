package org.example.facade;

// ===== EJERCICIO 4 - FACADE =====
// Patrón Facade: Proporciona una interfaz simplificada
// para un conjunto de clases complejas del subsistema.



// FACADE: Simplifica la interacción con los subsistemas
public class TiendaFacade {
    private Carrito carrito;
    private Pago pago;
    private Envio envio;

    public TiendaFacade() {
        this.carrito = new Carrito();
        this.pago = new Pago();
        this.envio = new Envio();
    }

    public void comprar(String producto, double monto, String direccion) {
        System.out.println("🎯 Iniciando proceso de compra...");

        // Coordina todos los subsistemas
        carrito.agregarProducto(producto);
        carrito.calcularTotal();

        if (pago.procesarPago(monto)) {
            envio.coordinarEntrega(direccion);
            System.out.println("✅ ¡Compra completada exitosamente!");
        } else {
            System.out.println("❌ Error en el pago");
        }
    }
}