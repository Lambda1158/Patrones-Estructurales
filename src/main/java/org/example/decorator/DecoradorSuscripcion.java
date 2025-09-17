package org.example.decorator;

// Decorator base
public abstract class DecoradorSuscripcion implements Suscripcion {
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
