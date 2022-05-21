package pages;

import constants.locators.BasePageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    private final WebDriver driver;

    private final By saerchField = By.id(BasePageConstants.SEARCH);
    private final By button = By.xpath(BasePageConstants.BUTTON_PATH);
    private final By registerButton = By.xpath(BasePageConstants.REGISTER_BUTTON_PATH);


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public JobSearchPage search(String keyword) {
        driver.findElement(saerchField).sendKeys(keyword);
        driver.findElement(button).click();
        return new JobSearchPage(driver);
    }

    public RegisterPage openSignUpPage() {
        driver.findElement(registerButton).click();
        return new RegisterPage(driver);
    }
}
