package com.co.certificacion.sofka.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.co.certificacion.sofka.userinterface.UiIniciarSesion.LBL_MENSAJE_ERROR;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import static net.serenitybdd.screenplay.questions.Text.of;

public class VerificarInicioDeSesionErrado implements Question<Boolean> {

    private final String mensaje;
    public VerificarInicioDeSesionErrado(String mensaje) {
        this.mensaje = mensaje;
    }

    public static VerificarInicioDeSesionErrado alIngresarLasCredenciales(String mensaje){
        return new VerificarInicioDeSesionErrado(mensaje);
    }


    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(LBL_MENSAJE_ERROR,isVisible()).forNoMoreThan(10).seconds()
        );
        return mensaje.equals(theActorInTheSpotlight().asksFor(of(LBL_MENSAJE_ERROR)));
    }
}