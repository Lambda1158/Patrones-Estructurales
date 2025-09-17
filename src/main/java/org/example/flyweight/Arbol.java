package org.example.flyweight;

// Context: Contiene datos extrínsecos
public class Arbol {
    private int x, y; // Datos extrínsecos (posición específica)
    private TipoArbol tipo; // Referencia al Flyweight

    public Arbol(int x, int y, TipoArbol tipo) {
        this.x = x;
        this.y = y;
        this.tipo = tipo;
    }

    public void renderizar() {
        tipo.renderizar(x, y);
    }
}
