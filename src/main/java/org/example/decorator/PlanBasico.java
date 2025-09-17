package org.example.decorator;

// Implementación concreta básica
public class PlanBasico implements Suscripcion {
    @Override
    public double getCosto() {
        return 1000.0;
    }

    @Override
    public String getDescripcion() {
        return "Plan Básico";
    }
}
