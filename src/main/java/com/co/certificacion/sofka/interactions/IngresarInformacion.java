package com.co.certificacion.sofka.interactions;

import com.co.certificacion.sofka.model.InfoPersonalModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.co.certificacion.sofka.userinterface.UiInformacionPersonal.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IngresarInformacion implements Task {

    private final InfoPersonalModel infoPersonal;

    public IngresarInformacion(InfoPersonalModel infoPersonal) {
        this.infoPersonal = infoPersonal;
    }

    public static IngresarInformacion paraCompra(InfoPersonalModel infoPersonal) {
        return Tasks.instrumented(IngresarInformacion.class, infoPersonal);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(TXT_PRIMER_NOMBRE,isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(infoPersonal.getNombre1()).into(TXT_PRIMER_NOMBRE),
                Enter.theValue(infoPersonal.getNombre2()).into(TXT_SEGUNDO_NOMBRE),
                Enter.theValue(infoPersonal.getCodigoPostal()).into(TXT_CODIGO_POSTAL),
                Click.on(BTN_CONTINUAR)
        );
    }
}
