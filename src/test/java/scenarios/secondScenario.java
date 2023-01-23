package scenarios;

import org.testng.annotations.Test;
import screens.landingScreen;
import screens.userScreen;

import java.io.IOException;

public class secondScenario extends testbase.testannotations {


    @Test(priority = 1)

    public void Signin() throws IOException {
        landingScreen land = new landingScreen(driver);

        land.Login();


    }

    @Test(priority = 2)

    public void ItemChecker() throws IOException {
        userScreen user = new userScreen(driver);

        user.ItemCheck();


    }

    @Test(priority = 3)

    public void AddItem() throws IOException {
        userScreen user = new userScreen(driver);


        user.AddItem();


    }

    @Test(priority = 3)

    public void PlaceOrder() throws IOException {
        userScreen user = new userScreen(driver);
        user.PlaceOrder();


    }


}
