package org.example.flyweight;

// ===== EJERCICIO 5 - FLYWEIGHT =====
// Patrón Flyweight: Minimiza el uso de memoria compartiendo
// eficientemente datos comunes entre múltiples objetos similares.

import java.util.HashMap;
import java.util.Map;

// Flyweight: Datos intrínsecos (compartidos)
class TipoArbol {
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

// Factory para manejar los Flyweights
class FabricaDeArboles {
    private static final Map<String, TipoArbol> tiposArboles = new HashMap<>();

    public static TipoArbol getTipoArbol(String nombre, String textura, String color) {
        String clave = nombre + textura + color;

        TipoArbol tipo = tiposArboles.get(clave);
        if (tipo == null) {
            tipo = new TipoArbol(nombre, textura, color);
            tiposArboles.put(clave, tipo);
            System.out.println("➕ Creando nuevo tipo de árbol: " + nombre);
        }

        return tipo;
    }

    public static int getCantidadTiposCreados() {
        return tiposArboles.size();
    }
}

// Context: Contiene datos extrínsecos
class Arbol {
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
