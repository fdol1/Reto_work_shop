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

import static com.co.certificacion.sofka.utils.Constantes.*;
import static com.co.certificacion.sofka.utils.Utils.ejecucionEnPipeline;

public class UseHealenium implements Ability {

    public static BrowseTheWeb withSelfHealingDriver() {

        Config config;
        WebDriver delegate = new ChromeDriver();

        if(ejecucionEnPipeline()){
            String configString =  SERVER_URL +" \"" + System.getProperty(URL_REMOTA_HEALENIUM_BACKEND) + "\"";
            config = ConfigFactory.parseString(configString);
        }else {
            config = ConfigFactory.parseFile(new File(URL_LOCAL_HEALENIUM_BACKEND));
        }
        //WebDriver driverAutoCorrector = SelfHealingDriver.create(delegate); // Ejecución local
        SelfHealingDriver driverAutoCorrector = SelfHealingDriver.create(delegate, config);
        return BrowseTheWeb.with(driverAutoCorrector);

    }
}