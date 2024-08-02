package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class landingScreen {

    WebDriver driver;

    By Signup_btn = By.id("signin2");
    By Login_btn = By.id("login2");
    By modal_dialog = By.id("signInModal");
    By modal_dialog_login = By.id("logInModal");
    By Username_lbl = By.id("sign-username");
    By Password_lbl = By.id("sign-password");
    By Username_lbl_login = By.id("loginusername");
    By Password_lbl_login = By.id("loginpassword");
    By LoginConfirm_btn = By.xpath("//button[@class='btn btn-primary'][@onclick='logIn()']");

    By SignupConfirm_btn = By.xpath("//button[@class='btn btn-primary'][@onclick='register()']");
    String URL = "https://www.demoblaze.com/";
    String username = "Holla11";
    String password = "Holla1Pass";


    public landingScreen(WebDriver driver) {

        this.driver = driver;

    }


    public void openURL() {
        driver.navigate().to(URL);

    }

    public void Register() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.findElement(Signup_btn).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(modal_dialog));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Username_lbl));

        driver.findElement(Username_lbl).sendKeys(username);
        driver.findElement(Password_lbl).sendKeys(password);
        driver.findElement(SignupConfirm_btn).click();


    }

    public void Login() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.findElement(Login_btn).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(modal_dialog_login));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Username_lbl_login));

        driver.findElement(Username_lbl_login).sendKeys(username);
        driver.findElement(Password_lbl_login).sendKeys(password);
        driver.findElement(LoginConfirm_btn).click();


    }
}
