package org.example.decorator;

public class DescargasOffline extends DecoradorSuscripcion {
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