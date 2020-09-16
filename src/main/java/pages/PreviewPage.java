package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PreviewPage {

    By nameInPreview = By.xpath("//*[@data-cy='builder-preview']//*[contains(text(),'Piotr')]");
    String locatorToName = "//*[@data-cy='builder-preview']//*[contains(text(),'%s')]";
    String locatorToEmail = "//*[@data-cy='builder-preview']//*[contains(text(),'%s')]";

    private WebDriver driver;

    public PreviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isNameVisible() {
        boolean namevisible;
        namevisible = driver.findElement(nameInPreview).isDisplayed();
        return namevisible;
    }

    public boolean isNameVisible2(String name) { //z dynamicznym xpathem
        boolean namevisible;
        locatorToName = locatorToName.replace("%s", name);
        namevisible = driver.findElement(By.xpath(locatorToName)).isDisplayed();
        return namevisible;
    }

    public boolean isEmailVisible2(String email) { //z dynamicznym xpathem
        boolean emailvisible;
        locatorToEmail = locatorToEmail.replace("%s", email);
        emailvisible = driver.findElement(By.xpath(locatorToEmail)).isDisplayed();
        return emailvisible;
    }
}

