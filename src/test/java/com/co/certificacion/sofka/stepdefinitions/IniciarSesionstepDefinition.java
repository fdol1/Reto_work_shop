package com.co.certificacion.sofka.stepdefinitions;

import com.co.certificacion.sofka.questions.VerificarInicioDeSesion;
import com.co.certificacion.sofka.questions.VerificarInicioDeSesionErrado;
import com.co.certificacion.sofka.tasks.AbrirNavegador;
import com.co.certificacion.sofka.tasks.IniciarSesion;
import com.co.certificacion.sofka.utils.UseHealenium;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import static com.co.certificacion.sofka.utils.Constantes.PERMITIR_IA;
import static com.co.certificacion.sofka.utils.Utils.setDatosInicioSesionModel;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class IniciarSesionstepDefinition {

    @Dado("^que (.*) ingresa a la pagina de Swaglabas$")
    public void queFerIngresaALaPaginaDeSwaglabas(String actor) {
        if (PERMITIR_IA) {
            theActorCalled("Luis").can(UseHealenium.withSelfHealingDriver());
            theActorInTheSpotlight().attemptsTo(AbrirNavegador.enSwagLabs());
        } else {
            theActorCalled(actor).wasAbleTo(AbrirNavegador.enSwagLabs());
        }
    }

    @Dado("^que fer ingresa sus credenciales$")
    public void queFerIngresaSusCredenciales(DataTable datosInicioSesion) {
        theActorInTheSpotlight().attemptsTo(IniciarSesion.enSwagLabs(setDatosInicioSesionModel(datosInicioSesion)));
    }

    @Entonces("^Entonces verifica el titulo (.*)$")
    public void entoncesVerificaElTituloSwagLabs(String mensaje) {
        theActorInTheSpotlight().should(seeThat(VerificarInicioDeSesion.alIngresarLasCredenciales(mensaje)));
    }

    @Entonces("^Entonces verifica mensaje error (.*)$")
    public void entoncesVerificaElMensajeDeError(String mensaje) {
        theActorInTheSpotlight().should(seeThat(VerificarInicioDeSesionErrado.alIngresarLasCredenciales(mensaje)));
    }
}