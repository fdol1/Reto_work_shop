package com.co.certificacion.sofka.utils;

import com.epam.healenium.SelfHealingDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UseHealenium implements Ability {

    public static BrowseTheWeb withSelfHealingDriver() {

        WebDriverManager.chromedriver().setup();
        WebDriver delegate = new ChromeDriver(); // WebDriver base
        WebDriver driverAutoCorrector = SelfHealingDriver.create(delegate); // WebDriver con Healenium
        return BrowseTheWeb.with(driverAutoCorrector);


      /* De esta manera se debe retornar un WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver baseDriver = new ChromeDriver();
        WebDriver selfHealingDriver = SelfHealingDriver.create(baseDriver);
        return selfHealingDriver;
       */
    }
}