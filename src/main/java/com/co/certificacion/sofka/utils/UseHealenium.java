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

public class UseHealenium implements Ability {

    public static BrowseTheWeb withSelfHealingDriver() {

        WebDriverManager.chromedriver().setup();
        WebDriver delegate = new ChromeDriver(); // WebDriver base

        Config config = ConfigFactory.parseFile(new File("src\\test\\resources\\healenium.properties"));

        //WebDriver driverAutoCorrector = SelfHealingDriver.create(delegate, config);
        //WebDriver driverAutoCorrector = SelfHealingDriver.create(delegate); // WebDriver con Healenium
        SelfHealingDriver driverAutoCorrector = SelfHealingDriver.create(delegate, config);


        return BrowseTheWeb.with(driverAutoCorrector);


      /* De esta manera se debe retornar un WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver baseDriver = new ChromeDriver();
        WebDriver selfHealingDriver = SelfHealingDriver.create(baseDriver);
        return selfHealingDriver;
       */
    }
}