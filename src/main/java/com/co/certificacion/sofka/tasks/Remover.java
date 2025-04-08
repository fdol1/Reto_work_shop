package com.co.certificacion.sofka.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.co.certificacion.sofka.userinterface.UiIniciarSesion.BTN_CARRITO_COMPRAS;
import static com.co.certificacion.sofka.userinterface.UiProductos.BTN_REMOVER;

public class Remover implements Task {

    public Remover() {
    }

    public static Remover delCarrito() {
        return Tasks.instrumented(Remover.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(BTN_CARRITO_COMPRAS),
                Click.on(BTN_REMOVER)
        );
    }
}