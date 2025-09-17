package org.example.flyweight;

// Flyweight: Datos intrínsecos (compartidos)
public class TipoArbol {
    private final String nombre;
    private final String textura;
    private final String color;

    public TipoArbol(String nombre, String textura, String color) {
        this.nombre = nombre;
        this.textura = textura;
        this.color = color;
    }

    // Operación que usa datos extrínsecos
    public void renderizar(int x, int y) {
        System.out.println("🌳 Renderizando " + nombre + " (" + color + ", " + textura +
                ") en posición (" + x + ", " + y + ")");
    }
}