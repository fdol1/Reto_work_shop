package com.co.certificacion.sofka.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static com.co.certificacion.sofka.utils.Constantes.*;

public class GuardarProductosOrdenados implements Interaction {

    private final List<Double> listaPrecios;
    private final List<String> listaTitulos;
    private final boolean titulo;


    public GuardarProductosOrdenados(List<Double> listaPrecios, List<String> listaTitulos, boolean titulo) {
        this.listaPrecios = listaPrecios;
        this.listaTitulos = listaTitulos;
        this.titulo = titulo;
    }

    public static GuardarProductosOrdenados deSwagLabs(List<Double> listaPrecios,List<String> listaTitulos, boolean titulo) {
        return Tasks.instrumented(GuardarProductosOrdenados.class, listaPrecios, listaTitulos, titulo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        FileWriter documentoOrdenado;
        String tituloAccion = titulo ? OPCION_TITULO_ORDEN_MAYOR : OPCION_TITULO_ORDEN_MENOR;

        try {
            documentoOrdenado = new FileWriter(OPCION_RUTA_DOC, true); // El 'true' indica que se debe habilitar el modo de anexar
            PrintWriter dato = new PrintWriter(documentoOrdenado);
            StringBuilder productosOrdenados = new StringBuilder();
            for (int i = 0; i < listaTitulos.size(); i++) {
                productosOrdenados
                        .append(OPCION_PRODUCTO)
                        .append(listaTitulos.get(i)).append(OPCION_PRECIO)
                        .append(listaPrecios.get(i))
                        .append("\n\n");
            }
            dato.print(tituloAccion + productosOrdenados);
            documentoOrdenado.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}