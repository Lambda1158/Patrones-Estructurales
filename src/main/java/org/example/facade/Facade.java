package org.example.facade;

// ===== EJERCICIO 4 - FACADE =====
// Patrón Facade: Proporciona una interfaz simplificada
// para un conjunto de clases complejas del subsistema.

// Subsistemas complejos
class Carrito {
    public void agregarProducto(String producto) {
        System.out.println("🛒 Producto agregado al carrito: " + producto);
    }

    public void calcularTotal() {
        System.out.println("💰 Calculando total del carrito...");
    }
}

class Pago {
    public boolean procesarPago(double monto) {
        System.out.println("💳 Procesando pago de $" + monto);
        return true; // Simulamos pago exitoso
    }
}

class Envio {
    public void coordinarEntrega(String direccion) {
        System.out.println("🚚 Coordinando envío a: " + direccion);
    }
}

// FACADE: Simplifica la interacción con los subsistemas
class TiendaFacade {
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