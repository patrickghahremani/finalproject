package pages;

import constants.locators.JobSearchPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class JobSearchPage {
    private final WebDriver driver;

    private final By centerText = By.tagName(JobSearchPageConstants.CENTER_TEXT);
    private final By jobItems = By.id(JobSearchPageConstants.JOB_ITEMS);
    private final By jobLinks = By.tagName(JobSearchPageConstants.JOB_LINKS);

    private final By fields = By.id(JobSearchPageConstants.FIELDS);
    private final By options = By.xpath(JobSearchPageConstants.OPTIONS);

    public JobSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getJobs() {
        return driver.findElement(jobItems).findElements(jobLinks);
    }

    public String getCenterText() {
        return driver.findElement(centerText).getText();
    }

    public List<WebElement> fieldClickWithResults() {
        driver.findElement(fields).click();
        List<WebElement> elements = driver.findElements(options);
        return elements;
    }
}
