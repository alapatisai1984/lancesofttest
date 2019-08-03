package StepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class CE
{
    WebDriver driver;
    Actions action;

    @Given("^Open browser and enter URL for CE Operation$")
    public void open_browser_and_enter_URL_for_CE_Operation()
    {
        try
        {
            System.setProperty("webdriver.chrome.driver", "/Users/gouthami/Desktop/AutomationProjects/LearningCucumber/src/main/resources/chromedriver");
            driver = new ChromeDriver();

            driver.get("https://www.online-calculator.com/full-screen-calculator/");
            Thread.sleep(3000);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @When("^I have entered first number for ce operation$")
    public void i_have_entered_first_number_for_ce_operation()
    {
        try {
            driver.switchTo().frame("fullframe");

            WebElement canvasElement = driver.findElement(By.id("canvas"));

            action = new Actions(driver);

            System.out.println("Going to click on 99");
            action.moveByOffset(580, 230).click().build().perform();
            action.moveByOffset(0, 0).click().build().perform();
            Thread.sleep(1000);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    @When("^I press ce button$")
    public void i_press_ce_button()
    {
        try
        {
            System.out.println("Going to click on CE");
            action.moveByOffset(150, -50).click().build().perform();
            action.moveByOffset(0, 0).click().build().perform();
            Thread.sleep(1000);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    @Then("^should display stop operation and should display zero$")
    public void should_display_stop_operation_and_should_display_zero()
    {
        try
        {
            String text = ScreenRead.getText(Screenshot.createScreenShot(driver).toString(), 0);
            Assert.assertTrue(text.contains("0"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }
}
