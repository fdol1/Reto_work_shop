package com.co.certificacion.sofka.utils;

import com.epam.healenium.SelfHealingDriver;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import static com.co.certificacion.sofka.utils.Constantes.URL_BACKEND_HEALENIUM;

public class UseHealenium implements Ability {

    public static BrowseTheWeb withSelfHealingDriver() {

        WebDriverManager.chromedriver().setup();
        WebDriver delegate = new ChromeDriver(); // WebDriver base
        System.out.println("Healenium URL: " + System.getProperty("url_healenium_backend"));

        //Config config = ConfigFactory.parseFile(new File(URL_BACKEND_HEALENIUM));

        String configString = "hlm.server.url = \"" + System.getProperty("url_healenium_backend") + "\"";
        Config config = ConfigFactory.parseString(configString);

        //WebDriver driverAutoCorrector = SelfHealingDriver.create(delegate); // Ejecución local
        SelfHealingDriver driverAutoCorrector = SelfHealingDriver.create(delegate, config);
        return BrowseTheWeb.with(driverAutoCorrector);

    }
}