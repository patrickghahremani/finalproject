import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.JobSearchPage;

import java.util.List;
import java.util.Random;

public class JobSearchTests extends BaseTest {

    @Test
    public void gotoSearchPageTest() {
        JobSearchPage jobSearchPage = mainPage.search("java");
        Assert.assertEquals("Welcome to Announcements Page!", jobSearchPage.getCenterText());
    }

    @Test
    public void openJobTest() {
        JobSearchPage jobSearchPage = mainPage.search("");
        Assert.assertEquals("Welcome to Announcements Page!", jobSearchPage.getCenterText());
        List<WebElement> jobs = jobSearchPage.getJobs();
        Assert.assertTrue(jobs.size() > 0);
    }

    @Test
    public void searchJobsFilteres() {
        JobSearchPage jobSearchPage = mainPage.search("");
        Assert.assertEquals("Welcome to Announcements Page!", jobSearchPage.getCenterText());
        List<WebElement> jobs = jobSearchPage.getJobs();
        Assert.assertTrue(jobs.size() > 0);

        List<WebElement> webElements = jobSearchPage.fieldClickWithResults();
        int size = webElements.size();
        int i = new Random().nextInt(size);
        webElements.get(i).click();
    }
}