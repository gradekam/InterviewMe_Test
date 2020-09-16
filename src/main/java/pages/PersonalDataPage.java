package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class PersonalDataPage {

    By inputFirstName = By.cssSelector("[name='firstName']");
    By inputSureName = By.xpath("//input[@name='lastName']");
    By inputUploadPhoto = By.cssSelector("input[type='file']");
    By buttonZapisz = By.xpath("//*[text()='Zapisz']");
    By inputEmail = By.xpath("//*[@placeholder='twoj.email@przyklad.pl']");
    By inputPhoneNumber = By.xpath("//*[@placeholder='+48 770 001 015']");
    By buttonNext = By.xpath("//*[text()='Dalej']");

    private WebDriver driver;

    public PersonalDataPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String name) {
        driver.findElement(inputFirstName).sendKeys(name);
    }

    public void setSurname(String surname) {
        driver.findElement(inputSureName).sendKeys(surname);
    }

    public void uploadPhoto(String path) {
        File file = new File(path);
        driver.findElement(inputUploadPhoto).sendKeys(file.getAbsolutePath());
        driver.findElement(buttonZapisz).click();
        //JavascriptExecutor js = (JavascriptExecutor) driver; js.executeScript("window.scrollBy(0,250)", "");
    }

    public void setEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    } //waita tutuaj?

    public void setPhoneNumber(String number) {
        driver.findElement(inputPhoneNumber).sendKeys(number);
    }

    public void savePersonalData() {
        driver.findElement(buttonNext).click();
    }

    public boolean isNameSet(String name) {
        String valueSet = driver.findElement(inputFirstName).getAttribute("value");
        if (valueSet.equals(name)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isSureNameSet(String surename) {
        String valueSet = driver.findElement(inputSureName).getAttribute("value");
        if (valueSet.equals(surename)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmailSet(String email) {
        String valueSet = driver.findElement(inputEmail).getAttribute("value");
        if (valueSet.equals(email)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean doesEmailContains (String email){
        String valuseSet = driver.findElement(inputEmail).getAttribute("value");
        if (valuseSet.equals(email) && valuseSet.contains("@")){
            return true;
        }
        return false;
    }
}