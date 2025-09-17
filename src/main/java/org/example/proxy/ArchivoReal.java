package org.example.proxy;

// Objeto real que queremos proteger
public class ArchivoReal implements Archivo {
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
