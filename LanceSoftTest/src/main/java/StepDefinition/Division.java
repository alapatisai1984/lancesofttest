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

import java.util.concurrent.TimeUnit;

public class Division
{
    WebDriver driver;
    Actions action;

    @Given("^Open browser and enter URL for division$")
    public void open_browser_and_enter_URL_for_division() throws Throwable
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

    @When("^I have entered first number for division$")
    public void i_have_entered_first_number_for_division() throws Throwable
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

    @When("^I press division$")
    public void i_press_division()
    {
        try
        {
            System.out.println("Going to click on division");
            action.moveByOffset(100, 0).click().build().perform();
            Thread.sleep(1000);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @When("^I have entered second number for division$")
    public void i_have_entered_second_number_for_division()
    {
        try
        {
            System.out.println("Going to click on 9");
            action.moveByOffset(-100, 0).click().build().perform();
            Thread.sleep(1000);

            System.out.println("Going to click on =");
            action.moveByOffset(150, 200).click().build().perform();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Then("^should display correct result of division$")
    public void should_display_correct_result_of_division()
    {
        try
        {
            String text = ScreenRead.getText(Screenshot.createScreenShot(driver).toString(), 0);
            Assert.assertTrue(text.contains("11"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @When("^I have entered zero as second number for division$")
    public void i_have_entered_zero_as_second_number_for_division()
    {
       try
       {
           System.out.println("Going to click on 0");
           action.moveByOffset(-200, 200).click().build().perform();
           Thread.sleep(1000);

           System.out.println("Going to click on =");
           action.moveByOffset(250, 0).click().build().perform();
           driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
    }

    @Then("^should display correct result of divide zero$")
    public void should_display_correct_result_of_divide_zero()
    {
        try
        {
            String text = ScreenRead.getText(Screenshot.createScreenShot(driver).toString(), 0);
            Assert.assertTrue(text.contains("Error"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @When("^I have entered first number as zero for division$")
    public void i_have_entered_first_number_as_zero_for_division()
    {
        try
        {
            driver.switchTo().frame("fullframe");

            WebElement canvasElement = driver.findElement(By.id("canvas"));

            action = new Actions(driver);

            System.out.println("Going to click on 0");
            action.moveByOffset(480,430).click().build().perform();
            Thread.sleep(1000);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @When("^I press division for division of zero by any number$")
    public void i_press_division_for_division_of_zero_by_any_number()
    {
        try
        {
            System.out.println("Going to click on division symbol");
            action.moveByOffset(200,-200).click().build().perform();
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @When("^I have entered second number for division of zero by any number$")
    public void i_have_entered_second_number_for_division_of_zero_by_any_number()
    {
        try
        {
            System.out.println("Going to click on 9");
            action.moveByOffset(-50,0).click().build().perform();
            Thread.sleep(1000);

            System.out.println("Going to click on =");
            action.moveByOffset(100,200).click().build().perform();
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }



    @Then("^should display correct result of Division of zero by any number$")
    public void should_display_correct_result_of_Division_of_zero_by_any_number()
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
