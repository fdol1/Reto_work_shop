package com.co.certificacion.sofka.stepdefinitions;

import com.co.certificacion.sofka.questions.VerificarCompraExitosa;
import com.co.certificacion.sofka.questions.VerificarPrecios;
import com.co.certificacion.sofka.tasks.FinalizarCompra;
import com.co.certificacion.sofka.tasks.IngresarInformacion;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.Before;

import static com.co.certificacion.sofka.utils.Utils.setInfoPersonalModel;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RealizarCompraStepDefinition {

    @Cuando("^ingresa los datos para la compra$")
    public void ingresaLosDatosParaLaCompra(DataTable infoPersonalList) {
        theActorInTheSpotlight().attemptsTo(IngresarInformacion.paraLaCompra(setInfoPersonalModel(infoPersonalList)));
    }

    @Entonces("^verifica los precios y finaliza la compra$")
    public void verificaLosPreciosYFinalizaLaCompra() {
        theActorInTheSpotlight().should(seeThat(VerificarPrecios.paraFinalizarCompra()));
        theActorInTheSpotlight().attemptsTo(FinalizarCompra.deProductos());
    }

    @Entonces("^verifica el mensaje de compra exitosa: (.*)$")
    public void verificaElMensajeDeCompraExitosaThankYouForYourOrder(String mensaje) {
        theActorInTheSpotlight().should(seeThat(VerificarCompraExitosa.enElPortalSwagLabs(mensaje)));
    }
}
