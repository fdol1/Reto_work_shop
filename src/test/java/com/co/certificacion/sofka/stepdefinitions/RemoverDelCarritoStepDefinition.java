package com.co.certificacion.sofka.stepdefinitions;

import com.co.certificacion.sofka.tasks.Remover;
import io.cucumber.java.es.Cuando;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.Before;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RemoverDelCarritoStepDefinition {

    @Cuando("^se dirige al carrito a remover su producto$")
    public void seDirigeAlCarritoARemoverSuProducto() {
        theActorInTheSpotlight().attemptsTo(Remover.delCarrito());
    }

}
