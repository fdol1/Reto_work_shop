package com.co.certificacion.sofka.questions;

import com.co.certificacion.sofka.utils.AccionesObjetos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

import static com.co.certificacion.sofka.userinterface.UiDetalleCompra.LBL_PRECIO_SUB_TOTAL;
import static com.co.certificacion.sofka.userinterface.UiDetalleCompra.LBL_PRECIO_TOTAL;
import static com.co.certificacion.sofka.utils.Constantes.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import static net.serenitybdd.screenplay.questions.Text.of;


public class VerificarPrecios implements Question<Boolean> {

    public VerificarPrecios() {

    }
    public static VerificarPrecios paraFinalizarCompra(){
        return new VerificarPrecios();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        double totalWeb = AccionesObjetos.convertirNumero(theActorInTheSpotlight().asksFor(of(LBL_PRECIO_TOTAL)));
        double subTotalWb = AccionesObjetos.convertirNumero(theActorInTheSpotlight().asksFor(of(LBL_PRECIO_SUB_TOTAL)));
        List<Double> listaPrecios = actor.recall(LLAVE_PRECIOS_COMPRA);
        return (totalWeb == listaPrecios.get(0) && subTotalWb == listaPrecios.get(1));
    }
}