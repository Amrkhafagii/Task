package screens;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class userScreen {


    WebDriver driver;

    By FProduct = By.xpath("//a[@href='prod.html?idp_=1']");
    By AddToCard_btn = By.xpath("//a[contains(@onclick, 'addToCart')]");
    By Card_btn = By.id("cartur");
    By Delete_btn = By.xpath("//a[contains(@onclick, 'deleteItem')]");
    By modal_dialog_Order = By.id("orderModal");
    By modal_dialog_Success = By.xpath("//div[@class='sweet-alert  showSweetAlert visible']");


    By Purchase_btn = By.xpath("//button[@onclick='purchaseOrder()']");
    By Country_lbl = By.id("country");
    By City_lbl = By.id("city");
    By Name_lbl = By.id("name");
    By CCard_lbl = By.id("card");
    By Month_lbl = By.id("month");
    By Year_lbl = By.id("year");

    String Country = "Egypt";
    String City = "Cairo";
    String Name = "Amr";
    String CCard = "5264123412341234";
    String Month = "06";
    String Year = "26";

    By NameOfUser_btn = By.id("nameofuser");

    By PlaceOrder_btn = By.xpath("//button[@class='btn btn-success']");

    By SuccessText = By.xpath("//h2[text()='Thank you for your purchase!']");


    public void PlaceOrder() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Card_btn));
        driver.findElement(Card_btn).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(PlaceOrder_btn));
        driver.findElement(PlaceOrder_btn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(modal_dialog_Order));
        driver.findElement(Name_lbl).sendKeys(Name);
        driver.findElement(Country_lbl).sendKeys(Country);
        driver.findElement(City_lbl).sendKeys(City);
        driver.findElement(CCard_lbl).sendKeys(CCard);
        driver.findElement(Month_lbl).sendKeys(Month);
        driver.findElement(Year_lbl).sendKeys(Year);
        driver.findElement(Purchase_btn).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(modal_dialog_Success));
        System.out.println("text= " + SuccessText());
        assertEquals(SuccessText().contains("Thank you for your purchase!"), true);


    }

    public String SuccessText() {
        String Text = driver.findElement(SuccessText).getText();
        return Text;
    }


    public void RemoveItem() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, 30);


        wait.until(ExpectedConditions.visibilityOfElementLocated(Card_btn));
        driver.findElement(Card_btn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Delete_btn));
        driver.findElement(Delete_btn).click();

    }

    public void Order() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, 30);


        wait.until(ExpectedConditions.visibilityOfElementLocated(Card_btn));
        driver.findElement(Card_btn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Delete_btn));
        driver.findElement(Delete_btn).click();

    }


    public void AddItem() throws IOException {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.findElement(FProduct).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AddToCard_btn));
        driver.findElement(AddToCard_btn).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();

        alert.dismiss();


    }

    public userScreen(WebDriver driver) {

        this.driver = driver;

    }

    public void ItemCheck() throws IOException {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(NameOfUser_btn));
        List<WebElement> products = driver.findElements(By.id("tbodyid"));

        if (products.isEmpty()) {
            System.out.println("No products found on the page");
        } else {
            System.out.println("products found on the page");
        }
    }

}
