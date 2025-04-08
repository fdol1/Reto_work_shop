package com.co.certificacion.sofka.stepdefinitions;

import com.co.certificacion.sofka.questions.VerificarArticuloEn;
import com.co.certificacion.sofka.tasks.AgregarAlCarrito;
import com.co.certificacion.sofka.tasks.AgregarPrimerEnLista;
import com.co.certificacion.sofka.tasks.IrAlCarrito;
import com.co.certificacion.sofka.tasks.OrdenarProductosDesde;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.Before;

import java.util.List;

import static com.co.certificacion.sofka.utils.Utils.setDatosProductoModel;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AgregarAlCarritoStepDefinition {

    @Dado("^que fer selecciona el producto a comprar$")
    public void queFerSeleccionaElProductoAComprar(DataTable datosProductoModels) {
        theActorInTheSpotlight().attemptsTo(AgregarAlCarrito.elProducto(setDatosProductoModel(datosProductoModels)));
    }

    @Cuando("^se dirige al carrito y comprueba su producto$")
    public void seDirigeAlCarritoYCompruebaSuProducto() {
        theActorInTheSpotlight().attemptsTo(IrAlCarrito.paraVerProductos());
    }

    @Entonces("^verifica el titulo y precio del producto agregado al carrito$")
    public void verificaElTituloYPrecioDelProductoAgregadoAlCarrito() {
        theActorInTheSpotlight().should(seeThat(VerificarArticuloEn.elCarritoDeCompras()));
    }

    ///******************************************************************

    @Dado("^que fer ordena la lista$")
    public void queFerOrdenaLaLista(List<String> opcion) {
        theActorInTheSpotlight().attemptsTo(OrdenarProductosDesde.OpcionesDesplegables(opcion.get(1)));
    }


    @Cuando("^agrega agrega al carrito el producto$")
    public void agregaAgregaAlCarritoElProducto() {
        theActorInTheSpotlight().attemptsTo(AgregarPrimerEnLista.despuesDeFiltrar());
    }


}