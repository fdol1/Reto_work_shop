package com.co.certificacion.sofka.interactions;

import com.co.certificacion.sofka.utils.AccionesObjetos;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static com.co.certificacion.sofka.userinterface.UiDetalleCompra.*;
import static com.co.certificacion.sofka.utils.Constantes.LLAVE_PRECIOS_COMPRA;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import static net.serenitybdd.screenplay.questions.Text.of;


public class ObtenerPrecioTotal implements Interaction {


    public ObtenerPrecioTotal() {
    }

    public static ObtenerPrecioTotal deLaCompra() {
        return Tasks.instrumented(ObtenerPrecioTotal.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<WebElementFacade> listaPreciosCompra = LBL_PRECIOS_COMPRAS.resolveAllFor(actor);
        double tax = AccionesObjetos.convertirNumero(theActorInTheSpotlight().asksFor(of(LBL_IMPUESTO_TAX)));
        double subTotal = 0;

        for (WebElementFacade webElementFacade : listaPreciosCompra) {
            subTotal = subTotal + AccionesObjetos.convertirNumero(webElementFacade.getText());
        }
        BigDecimal total = new BigDecimal(subTotal + tax);
        total = total.setScale(2, RoundingMode.HALF_UP);
        List<Double> preciosCompra = new ArrayList<>();
        preciosCompra.add(0,Double.parseDouble(String.valueOf(total)));
        preciosCompra.add(1,subTotal);

        actor.remember(LLAVE_PRECIOS_COMPRA, preciosCompra);
    }
}