package org.example.bridge;

public class Recordatorio extends Notificacion {
    public Recordatorio(CanalEnvio canal) {
        super(canal);
    }

    @Override
    public void notificar(String destinatario) {
        canal.enviar("⏰ RECORDATORIO: No olvides tu cita pendiente", destinatario);
    }
}
