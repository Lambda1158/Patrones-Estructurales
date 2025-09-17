package org.example.decorator;

// Decoradores concretos
public class HD extends DecoradorSuscripcion {
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
