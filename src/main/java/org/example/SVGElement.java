package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SVGElement {
    static WebDriver driver;

    public static void main(String[] args) {

        driver = new FirefoxDriver();
        driver.get("https://petdiseasealerts.org/forecast-map#/");
        driver.manage().window().fullscreen();

        WebElement frame = driver.findElement(By.xpath("//iframe[contains(@id, 'map-instance')]"));
        driver.switchTo().frame(frame);
        clickRegion("wyoming");

        driver.quit();
    }

    public static void clickRegion(String region) {
        List<WebElement> regions = driver.findElements(By.xpath("//*[local-name()='g' and @class='region']"));
        System.out.println("Total states: " + regions.size());
        for (WebElement e : regions) {
            System.out.println(e.getAttribute("id"));
        }

        WebElement m = driver.findElement(By.xpath("//*[local-name()='g' and @id=\"" + region + "\"]"));
        Actions a = new Actions(driver);
        a.moveToElement(m).click().build().perform();
        System.out.println("Clicked on: " + region);
    }

}