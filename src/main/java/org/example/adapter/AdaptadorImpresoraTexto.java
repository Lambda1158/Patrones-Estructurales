package org.example.adapter;



// ADAPTER: Hace compatible ImpresoraTexto con la interfaz Impresora
public class AdaptadorImpresoraTexto implements Impresora {
    private ImpresoraTexto impresoraTexto;

    public AdaptadorImpresoraTexto(ImpresoraTexto impresoraTexto) {
        this.impresoraTexto = impresoraTexto;
    }

    @Override
    public void imprimir(String documento) {
        // Adaptamos la interfaz: llamamos al método específico de ImpresoraTexto
        impresoraTexto.imprimirTextoPlano(documento);
    }
}