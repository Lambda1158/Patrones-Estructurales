package org.example.decorator;

public class UltraHD extends DecoradorSuscripcion {
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