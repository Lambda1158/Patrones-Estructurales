package org.example.proxy;

// ===== EJERCICIO 6 - PROXY =====
// Patrón Proxy: Proporciona un sustituto para controlar
// el acceso a otro objeto.

// Interfaz común
interface Archivo {
    void abrir();
    String leer();
}

// Objeto real que queremos proteger
class ArchivoReal implements Archivo {
    private String nombreArchivo;

    public ArchivoReal(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        cargarArchivo();
    }

    private void cargarArchivo() {
        System.out.println("📁 Cargando archivo: " + nombreArchivo);
    }

    @Override
    public void abrir() {
        System.out.println("📖 Abriendo archivo: " + nombreArchivo);
    }

    @Override
    public String leer() {
        return "Contenido del archivo " + nombreArchivo;
    }
}

// PROXY: Controla el acceso al objeto real
class ArchivoProxy implements Archivo {
    private ArchivoReal archivoReal;
    private String nombreArchivo;
    private String usuario;

    public ArchivoProxy(String nombreArchivo, String usuario) {
        this.nombreArchivo = nombreArchivo;
        this.usuario = usuario;
    }

    private boolean tienePermiso() {
        // Simulamos verificación de permisos
        return "admin".equals(usuario) || "editor".equals(usuario);
    }

    @Override
    public void abrir() {
        if (tienePermiso()) {
            if (archivoReal == null) {
                archivoReal = new ArchivoReal(nombreArchivo);
            }
            archivoReal.abrir();
        } else {
            System.out.println("🚫 Acceso denegado para usuario: " + usuario);
        }
    }

    @Override
    public String leer() {
        if (tienePermiso()) {
            if (archivoReal == null) {
                archivoReal = new ArchivoReal(nombreArchivo);
            }
            return archivoReal.leer();
        } else {
            return "🚫 Acceso denegado para usuario: " + usuario;
        }
    }
}