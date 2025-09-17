package org.example.composite;

// ===== EJERCICIO 7 - COMPOSITE =====
// Patrón Composite: Permite tratar objetos individuales y
// composiciones de objetos de manera uniforme.

import java.util.ArrayList;
import java.util.List;

// Componente: Interfaz común
interface ElementoMenu {
    void mostrar();
    double getPrecio();
}

// Hoja: Elemento individual
class Plato implements ElementoMenu {
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

// Composite: Contenedor de elementos
class Menu implements ElementoMenu {
    private String nombre;
    private List<ElementoMenu> elementos;

    public Menu(String nombre) {
        this.nombre = nombre;
        this.elementos = new ArrayList<>();
    }

    public void agregar(ElementoMenu elemento) {
        elementos.add(elemento);
    }

    public void remover(ElementoMenu elemento) {
        elementos.remove(elemento);
    }

    @Override
    public void mostrar() {
        System.out.println("📋 Menú: " + nombre);
        for (ElementoMenu elemento : elementos) {
            System.out.print("  ");
            elemento.mostrar();
        }
        System.out.println("💰 Precio total del menú: $" + getPrecio());
    }

    @Override
    public double getPrecio() {
        return elementos.stream()
                .mapToDouble(ElementoMenu::getPrecio)
                .sum();
    }
}