package testbase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import screens.*;

public class testannotations {


    public WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");

        driver = new ChromeDriver();
        landingScreen land = new landingScreen(driver);
        land.openURL();
    }

    @AfterClass
    public void afterClass() {
     //   driver.quit();
    }


}
