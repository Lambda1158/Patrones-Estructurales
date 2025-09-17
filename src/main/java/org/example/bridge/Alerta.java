package org.example.bridge;

public class Alerta extends Notificacion {
    public Alerta(CanalEnvio canal) {
        super(canal);
    }

    @Override
    public void notificar(String destinatario) {
        canal.enviar("⚠️ ALERTA: Situación que requiere atención inmediata", destinatario);
    }
}
