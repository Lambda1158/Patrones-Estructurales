package org.example.bridge;

// ===== EJERCICIO 2 - BRIDGE =====
// Patrón Bridge: Separa la abstracción de la implementación
// para que ambas puedan variar independientemente.

// Implementación: Canales de envío
interface CanalEnvio {
    void enviar(String mensaje, String destinatario);
}

class Email implements CanalEnvio {
    @Override
    public void enviar(String mensaje, String destinatario) {
        System.out.println("📧 Email enviado a " + destinatario + ": " + mensaje);
    }
}

class SMS implements CanalEnvio {
    @Override
    public void enviar(String mensaje, String destinatario) {
        System.out.println("📱 SMS enviado a " + destinatario + ": " + mensaje);
    }
}

// Abstracción: Tipos de notificación
abstract class Notificacion {
    protected CanalEnvio canal; // Bridge - conexión con la implementación

    public Notificacion(CanalEnvio canal) {
        this.canal = canal;
    }

    public abstract void notificar(String destinatario);
}

class Alerta extends Notificacion {
    public Alerta(CanalEnvio canal) {
        super(canal);
    }

    @Override
    public void notificar(String destinatario) {
        canal.enviar("⚠️ ALERTA: Situación que requiere atención inmediata", destinatario);
    }
}

class Recordatorio extends Notificacion {
    public Recordatorio(CanalEnvio canal) {
        super(canal);
    }

    @Override
    public void notificar(String destinatario) {
        canal.enviar("⏰ RECORDATORIO: No olvides tu cita pendiente", destinatario);
    }
}

class Promocion extends Notificacion {
    public Promocion(CanalEnvio canal) {
        super(canal);
    }

    @Override
    public void notificar(String destinatario) {
        canal.enviar("🎉 PROMOCIÓN: ¡Ofertas especiales disponibles!", destinatario);
    }
}