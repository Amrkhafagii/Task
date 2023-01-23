package scenarios;

import org.testng.annotations.Test;
import screens.*;

import java.io.IOException;

public class signup extends testbase.testannotations {


    @Test(priority = 1)

    public void Signup() throws IOException {
        landingScreen land = new landingScreen(driver);
        land.Register();


    }


}
