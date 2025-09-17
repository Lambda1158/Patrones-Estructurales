package org.example;

import org.example.adapter.*;
import org.example.bridge.*;
import org.example.composite.*;
import org.example.decorator.*;
import org.example.facade.*;
import org.example.flyweight.*;
import org.example.proxy.*;

// ===== MAIN CLASS PARA PROBAR TODO =====
public class Main {
    public static void main(String[] args) {
        System.out.println("🏗️ TRABAJO PRÁCTICO - PATRONES ESTRUCTURALES\n");

        probarAdapter();
        probarBridge();
        probarDecorator();
        probarFacade();
        probarFlyweight();
        probarProxy();
        probarComposite();
    }

    private static void probarAdapter() {
        System.out.println("===== 1. ADAPTER =====");

        // Sistema existente
        Impresora impresoraPDF = new ImpresoraPDF();

        // Nueva impresora incompatible
        ImpresoraTexto impresoraTexto = new ImpresoraTexto();

        // Adapter para hacerla compatible
        Impresora adaptador = new AdaptadorImpresoraTexto(impresoraTexto);

        // El cliente usa la misma interfaz para ambas
        impresoraPDF.imprimir("Documento Contractual");
        adaptador.imprimir("Informe Simple");

        System.out.println();
    }

    private static void probarBridge() {
        System.out.println("===== 2. BRIDGE =====");

        // Diferentes canales
        CanalEnvio email = new Email();
        CanalEnvio sms = new SMS();

        // Diferentes tipos de notificación pueden usar cualquier canal
        Notificacion alerta = new Alerta(email);
        Notificacion recordatorio = new Recordatorio(sms);
        Notificacion promocion = new Promocion(email);

        alerta.notificar("usuario@email.com");
        recordatorio.notificar("555-1234");
        promocion.notificar("cliente@email.com");

        System.out.println();
    }

    private static void probarDecorator() {
        System.out.println("===== 3. DECORATOR =====");

        // Plan básico
        Suscripcion plan = new PlanBasico();
        System.out.println(plan.getDescripcion() + " - $" + plan.getCosto());

        // Agregamos HD
        plan = new HD(plan);
        System.out.println(plan.getDescripcion() + " - $" + plan.getCosto());

        // Agregamos descargas
        plan = new DescargasOffline(plan);
        System.out.println(plan.getDescripcion() + " - $" + plan.getCosto());

        // Plan premium completo
        Suscripcion planPremium = new DescargasOffline(new UltraHD(new HD(new PlanBasico())));
        System.out.println(planPremium.getDescripcion() + " - $" + planPremium.getCosto());

        System.out.println();
    }

    private static void probarFacade() {
        System.out.println("===== 4. FACADE =====");

        TiendaFacade tienda = new TiendaFacade();

        // Una sola llamada maneja todo el proceso complejo
        tienda.comprar("Laptop Gaming", 150000, "Av. Corrientes 1234");

        System.out.println();
    }

    private static void probarFlyweight() {
        System.out.println("===== 5. FLYWEIGHT =====");

        List<Arbol> bosque = new ArrayList<>();

        // Simulamos la creación de muchos árboles
        String[] tipos = {"Roble", "Pino", "Sauce"};
        String[] texturas = {"Lisa", "Rugosa"};
        String[] colores = {"Verde", "Marrón"};

        // Creamos 100 árboles (en lugar de 1 millón para no saturar la consola)
        for (int i = 0; i < 100; i++) {
            TipoArbol tipo = FabricaDeArboles.getTipoArbol(
                    tipos[i % tipos.length],
                    texturas[i % texturas.length],
                    colores[i % colores.length]
            );

            Arbol arbol = new Arbol((int)(Math.random() * 1000), (int)(Math.random() * 1000), tipo);
            bosque.add(arbol);
        }

        System.out.println("🌲 Árboles creados: " + bosque.size());
        System.out.println("🎯 Tipos de árbol únicos: " + FabricaDeArboles.getCantidadTiposCreados());
        System.out.println("💾 Memoria ahorrada: " + (bosque.size() - FabricaDeArboles.getCantidadTiposCreados()) + " objetos");

        // Renderizamos algunos árboles
        System.out.println("Renderizando primeros 3 árboles:");
        for (int i = 0; i < 3; i++) {
            bosque.get(i).renderizar();
        }

        System.out.println();
    }

    private static void probarProxy() {
        System.out.println("===== 6. PROXY =====");

        // Usuario con permisos
        Archivo archivoAdmin = new ArchivoProxy("documento_confidencial.txt", "admin");
        archivoAdmin.abrir();
        System.out.println(archivoAdmin.leer());

        System.out.println();

        // Usuario sin permisos
        Archivo archivoGuest = new ArchivoProxy("documento_confidencial.txt", "guest");
        archivoGuest.abrir();
        System.out.println(archivoGuest.leer());

        System.out.println();
    }

    private static void probarComposite() {
        System.out.println("===== 7. COMPOSITE =====");

        // Platos individuales
        Plato plato1 = new Plato("Milanesa con papas", 2500);
        Plato plato2 = new Plato("Ensalada César", 1800);
        Plato plato3 = new Plato("Flan casero", 900);

        // Menú principal
        Menu menuPrincipal = new Menu("Menú Ejecutivo");
        menuPrincipal.agregar(plato1);
        menuPrincipal.agregar(plato2);

        // Submenú de postres
        Menu menuPostres = new Menu("Postres Especiales");
        menuPostres.agregar(plato3);
        menuPostres.agregar(new Plato("Tiramisu", 1200));

        // Agregamos el submenú al menú principal
        menuPrincipal.agregar(menuPostres);

        // Mostramos todo el menú (trata igual a platos individuales y submenús)
        menuPrincipal.mostrar();

        System.out.println();
    }
}