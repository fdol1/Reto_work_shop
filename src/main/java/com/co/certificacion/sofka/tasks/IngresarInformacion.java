package com.co.certificacion.sofka.tasks;

import com.co.certificacion.sofka.interactions.ObtenerPrecioTotal;
import com.co.certificacion.sofka.model.InfoPersonalModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.co.certificacion.sofka.userinterface.UiProductos.BTN_CHECKOUT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IngresarInformacion implements Task {

    private final InfoPersonalModel infoPersonal;

    public IngresarInformacion(InfoPersonalModel infoPersonal) {
        this.infoPersonal = infoPersonal;
    }

    public static IngresarInformacion paraLaCompra(InfoPersonalModel infoPersonal) {
        return Tasks.instrumented(IngresarInformacion.class, infoPersonal);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(BTN_CHECKOUT, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(BTN_CHECKOUT),
                com.co.certificacion.sofka.interactions.IngresarInformacion.paraCompra(infoPersonal),
                ObtenerPrecioTotal.deLaCompra()
        );
    }
}