package org.example.composite;

// Hoja: Elemento individual
public class Plato implements ElementoMenu {
    private String nombre;
    private double precio;

    public Plato(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public void mostrar() {
        System.out.println("🍽️ Plato: " + nombre + " - $" + precio);
    }

    @Override
    public double getPrecio() {
        return precio;
    }
}
