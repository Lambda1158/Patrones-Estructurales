package org.example.bridge;

public class SMS implements CanalEnvio {
    @Override
    public void enviar(String mensaje, String destinatario) {
        System.out.println("📱 SMS enviado a " + destinatario + ": " + mensaje);
    }
}
