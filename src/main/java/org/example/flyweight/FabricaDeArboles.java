package org.example.flyweight;

// ===== EJERCICIO 5 - FLYWEIGHT =====
// Patrón Flyweight: Minimiza el uso de memoria compartiendo
// eficientemente datos comunes entre múltiples objetos similares.

import java.util.HashMap;
import java.util.Map;

// Factory para manejar los Flyweights
public class FabricaDeArboles {
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

