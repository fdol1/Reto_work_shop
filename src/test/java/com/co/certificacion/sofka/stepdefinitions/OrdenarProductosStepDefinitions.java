package com.co.certificacion.sofka.stepdefinitions;

import com.co.certificacion.sofka.tasks.byLogic.Ordenar;
import com.co.certificacion.sofka.tasks.byLogic.Seleccionar;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.Before;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class OrdenarProductosStepDefinitions {

    @Dado("^que fer ordena los productos de menor a mayor$")
    public void queFerOrdenaLosProductosDeMenorAMayor(List<String> opcionOrden) {
        theActorInTheSpotlight().attemptsTo(Ordenar.productos(opcionOrden.get(1)));

    }

    @Cuando("^selecciona el producto indicado por el precio$")
    public void seleccionaElProductoIndicadoPorElPrecio() {
        theActorInTheSpotlight().attemptsTo(Seleccionar.ProductoOrdenado());
    }

}
