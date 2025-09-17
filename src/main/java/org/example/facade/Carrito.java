package org.example.facade;

// Subsistemas complejos
public class Carrito {
    public void agregarProducto(String producto) {
        System.out.println("🛒 Producto agregado al carrito: " + producto);
    }

    public void calcularTotal() {
        System.out.println("💰 Calculando total del carrito...");
    }
}