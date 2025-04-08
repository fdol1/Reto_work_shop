package com.co.certificacion.sofka.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.co.certificacion.sofka.userinterface.UiProductos.LBL_TITULO;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import static net.serenitybdd.screenplay.questions.Text.of;

public class VerificarInicioDeSesion implements Question<Boolean> {

    private final String mensaje;
    public VerificarInicioDeSesion(String mensaje) {
        this.mensaje = mensaje;
    }

    public static VerificarInicioDeSesion alIngresarLasCredenciales(String mensaje){
        return new VerificarInicioDeSesion(mensaje);
    }


    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(LBL_TITULO,isVisible()).forNoMoreThan(10).seconds()
        );
        return mensaje.equals(theActorInTheSpotlight().asksFor(of(LBL_TITULO)));
    }
}