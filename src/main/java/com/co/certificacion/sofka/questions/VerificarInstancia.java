package com.co.certificacion.sofka.questions;

import com.epam.healenium.SelfHealingDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

/**
 * Esta clase verifica si la instancia del driver esta siendo utilizada por SelfHealingDriver
 */

public class VerificarInstancia implements Question<Boolean> {

    public VerificarInstancia() {
    }

    public static VerificarInstancia PorSelfHealingDriver() {
        return new VerificarInstancia();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).getDriver() instanceof SelfHealingDriver;
    }
}