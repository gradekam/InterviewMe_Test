package helpers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class CommonUtils {
    public static void makeScreenshot(WebDriver driver) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("screenshot.png"));
    }

    public static void scrollWindow(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver; js.executeScript("window.scrollBy(0,250)", "");
    }
}