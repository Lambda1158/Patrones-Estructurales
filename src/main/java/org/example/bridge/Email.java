package org.example.bridge;

public class Email implements CanalEnvio {
    @Override
    public void enviar(String mensaje, String destinatario) {
        System.out.println("📧 Email enviado a " + destinatario + ": " + mensaje);
    }
}
