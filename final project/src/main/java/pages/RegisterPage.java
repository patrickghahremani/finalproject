package pages;

import constants.locators.RegisterPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private final WebDriver driver;

    private final By username = By.id(RegisterPageConstants.USERNAME);
    private final By password = By.id(RegisterPageConstants.PASSWORD);
    private final By confirmPassword = By.id(RegisterPageConstants.CONFIRM_PASSWORD);
    private final By userCategory = By.id(RegisterPageConstants.CATEGORY);
    private final By userCategoryIndividual = By.xpath(RegisterPageConstants.CATEGORY_INDIVIDUAL);
    private final By userCategoryOrganization = By.xpath(RegisterPageConstants.CATEGORY_ORGANIZATION);
    private final By terms = By.xpath(RegisterPageConstants.TERMS);
    private final By next = By.xpath(RegisterPageConstants.NEXT);
    private final By error = By.xpath(RegisterPageConstants.ERROR);

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }


    public void register(String usernameStr, String passwordStr, boolean individual) {
        driver.findElement(username).sendKeys(usernameStr);
        driver.findElement(password).sendKeys(passwordStr);
        driver.findElement(confirmPassword).sendKeys(passwordStr);
        driver.findElement(userCategory).click();
        if (individual)
            driver.findElement(userCategoryIndividual).click();
        else
            driver.findElement(userCategoryOrganization).click();
        driver.findElement(terms).click();


        //uncomment this part,to create a new account
        driver.findElement(next).click();
    }

    public boolean isError() {
        return driver.getPageSource().contains("The username has already been taken.");
    }
}
