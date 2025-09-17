package org.example.decorator;

// ===== EJERCICIO 3 - DECORATOR =====
// Patrón Decorator: Permite agregar comportamientos a objetos
// dinámicamente sin alterar su estructura.

// Componente base
interface Suscripcion {
    double getCosto();
    String getDescripcion();
}

// Implementación concreta básica
class PlanBasico implements Suscripcion {
    @Override
    public double getCosto() {
        return 1000.0;
    }

    @Override
    public String getDescripcion() {
        return "Plan Básico";
    }
}

// Decorator base
abstract class DecoradorSuscripcion implements Suscripcion {
    protected Suscripcion suscripcion;

    public DecoradorSuscripcion(Suscripcion suscripcion) {
        this.suscripcion = suscripcion;
    }

    @Override
    public double getCosto() {
        return suscripcion.getCosto();
    }

    @Override
    public String getDescripcion() {
        return suscripcion.getDescripcion();
    }
}

// Decoradores concretos
class HD extends DecoradorSuscripcion {
    public HD(Suscripcion suscripcion) {
        super(suscripcion);
    }

    @Override
    public double getCosto() {
        return super.getCosto() + 500.0;
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + HD";
    }
}

class UltraHD extends DecoradorSuscripcion {
    public UltraHD(Suscripcion suscripcion) {
        super(suscripcion);
    }

    @Override
    public double getCosto() {
        return super.getCosto() + 1000.0;
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + UltraHD";
    }
}

class DescargasOffline extends DecoradorSuscripcion {
    public DescargasOffline(Suscripcion suscripcion) {
        super(suscripcion);
    }

    @Override
    public double getCosto() {
        return super.getCosto() + 700.0;
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Descargas Offline";
    }
}