package com.co.certificacion.sofka.tasks.byLogic;

import com.co.certificacion.sofka.interactions.bylogic.OrdenarLista;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static com.co.certificacion.sofka.userinterface.UiProductos.LBL_PRECIO_PRODUCTO;
import static com.co.certificacion.sofka.userinterface.UiProductos.LBL_TITULO_PRODUCTO;
import static com.co.certificacion.sofka.utils.Constantes.OPCION_MAYOR_MENOR;

public class Ordenar implements Task {

    private final String opcionOrden;

    public Ordenar(String opcionOrden) {
        this.opcionOrden = opcionOrden;
    }

    public static Ordenar productos(String opcionOrden) {
        return Tasks.instrumented(Ordenar.class, opcionOrden);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        boolean mayorOMenor = OPCION_MAYOR_MENOR.equals(opcionOrden);
        actor.attemptsTo(
                OrdenarLista.deProductosListados(LBL_TITULO_PRODUCTO,LBL_PRECIO_PRODUCTO,mayorOMenor)
        );
    }
}