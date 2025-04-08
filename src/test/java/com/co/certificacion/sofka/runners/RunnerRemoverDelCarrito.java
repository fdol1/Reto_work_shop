package com.co.certificacion.sofka.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/removerProducto.feature",
        tags = "@RemoverDelCarrito",
        glue = {"com.co.certificacion.sofka.stepdefinitions"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class RunnerRemoverDelCarrito {
}
