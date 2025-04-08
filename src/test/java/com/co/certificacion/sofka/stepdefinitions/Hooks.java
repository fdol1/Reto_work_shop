package com.co.certificacion.sofka.stepdefinitions;

import com.co.certificacion.sofka.questions.VerificarInstancia;
import com.co.certificacion.sofka.utils.UseHealenium;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static com.co.certificacion.sofka.utils.Constantes.PERMITIR_IA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Hooks {

    @Before
    public void configuracionInicial() {
        OnStage.setTheStage(new OnlineCast());

        if (PERMITIR_IA) {
            theActorCalled("Luis").can(UseHealenium.withSelfHealingDriver());
            //theActorCalled("Luis").whoCan(BrowseTheWeb.with(UseHealenium.withSelfHealingDriver()));
            theActorInTheSpotlight().should(seeThat(VerificarInstancia.PorSelfHealingDriver()));
        }
    }
}