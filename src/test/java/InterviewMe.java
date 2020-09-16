import helpers.CommonUtils;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.PersonalDataPage;
import pages.PreviewPage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class InterviewMe {
    private WebDriver driver;
    MainPage mainPage;
    PersonalDataPage personalDataPage;
    PreviewPage previewPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://app.interviewme.pl/template/concept");
        mainPage = new MainPage(driver);
        personalDataPage = new PersonalDataPage(driver);
        previewPage = new PreviewPage(driver);
    }

    @Test
    public void FillDataTest() throws InterruptedException {
        mainPage.createCV();
        personalDataPage.setName("Piotr");
        personalDataPage.setSurname("Wisniewski");
        personalDataPage.uploadPhoto("src\\main\\resources\\elmo.png");
        Thread.sleep(1000);
        CommonUtils.scrollWindow(driver);
        personalDataPage.setEmail("email@email.com");
        personalDataPage.setPhoneNumber("+48 555 555 555");
        Assert.assertTrue(previewPage.isNameVisible());
        Assert.assertTrue(previewPage.isNameVisible2("Piotr"));
        Assert.assertTrue(personalDataPage.isNameSet("Piotr"));
        Assert.assertTrue(personalDataPage.isSureNameSet("Wisniewski"));
        Assert.assertTrue(personalDataPage.isEmailSet("email@email.com"));
        Assert.assertTrue(personalDataPage.doesEmailContains("email@email.com"));
        Assert.assertTrue(previewPage.isEmailVisible2("email@email.com"));

        personalDataPage.savePersonalData();

    }

    @After
    public void tearDown() {
      //  driver.close();
    }
}


