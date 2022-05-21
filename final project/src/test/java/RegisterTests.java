import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegisterPage;

import java.util.Random;

public class RegisterTests extends BaseTest {

    @Test
    public void registerUserAccountTest() {
        RegisterPage registerPage = mainPage.openSignUpPage();
        int i = new Random().nextInt(100);
        registerPage.register("username" + i, "testPasswordd", true);
    }

    @Test
    public void registerOrganizationTest() {
        RegisterPage registerPage = mainPage.openSignUpPage();
        registerPage.register("organization", "testPasswordd", false);

        Assert.assertTrue(registerPage.isError());
    }
}
