package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    By buttonCreateCVNow = By.xpath("//a[@title='Stwórz CV Teraz']");
    By templateConcept = By.xpath("//img[@alt='Szablon CV Concept']");
    By buttonStart = By.xpath("//a[@data-cy='how-it-works-cta']");

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void createCV() {
//        driver.findElement(buttonCreateCVNow).click();
//        driver.findElement(templateConcept).click();
        driver.findElement(buttonStart).click();
    }
}
