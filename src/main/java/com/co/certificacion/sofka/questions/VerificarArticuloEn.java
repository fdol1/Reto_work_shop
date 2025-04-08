package com.co.certificacion.sofka.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.co.certificacion.sofka.userinterface.UiCarritoCompras.LBL_PRECIO_PRODUCTO_AGREGADO;
import static com.co.certificacion.sofka.userinterface.UiCarritoCompras.LBL_TITULO_PRODUCTO_AGREGADO;
import static com.co.certificacion.sofka.utils.Constantes.LLAVE_PRECIO_PRODUCTO;
import static com.co.certificacion.sofka.utils.Constantes.LLAVE_TITULO_PRODUCTO;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import static net.serenitybdd.screenplay.questions.Text.of;

public class VerificarArticuloEn implements Question<Boolean> {

    public VerificarArticuloEn() {

    }
    public static VerificarArticuloEn elCarritoDeCompras(){
        return new VerificarArticuloEn();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(LBL_TITULO_PRODUCTO_AGREGADO,isVisible()).forNoMoreThan(10).seconds()
        );
        return ((actor.recall(LLAVE_TITULO_PRODUCTO).equals(theActorInTheSpotlight().asksFor(of(LBL_TITULO_PRODUCTO_AGREGADO))) &&
                (actor.recall(LLAVE_PRECIO_PRODUCTO).equals(theActorInTheSpotlight().asksFor(of(LBL_PRECIO_PRODUCTO_AGREGADO))))));
    }
}