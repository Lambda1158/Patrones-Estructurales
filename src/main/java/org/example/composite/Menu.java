package org.example.composite;

import java.util.ArrayList;
import java.util.List;

// Composite: Contenedor de elementos
public class Menu implements ElementoMenu {
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