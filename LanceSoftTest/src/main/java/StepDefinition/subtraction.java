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


public class subtraction
{
    WebDriver driver;
    Actions action;

    @Given("^Open browser and enter URL$")
    public void open_browser_and_enter_URL()
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

    @When("^I have entered first number into the calculator$")
    public void i_have_entered_first_number_into_the_calculator()
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

    @When("^I press subtract$")
    public void i_press_subtract()
    {
        try
        {
            System.out.println("Inside subtract");
            System.out.println("Going to click on -");
            action.moveByOffset(120, 170).click().build().perform();
            Thread.sleep(1000);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @When("^I have entered second number into the calculator$")
    public void i_have_entered_second_number_into_the_calculator()
    {
        try
        {
            System.out.println("Going to click on 3");
            action.moveByOffset(-100, 0).click().build().perform();
            Thread.sleep(1000);

            System.out.println("Going to click on =");
            action.moveByOffset(150, 50).click().build().perform();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    @Then("^should display correct result on the screen$")
    public void should_display_correct_result_on_the_screen()
    {
        try
        {
            String text = ScreenRead.getText(Screenshot.createScreenShot(driver).toString(), 0);
            Assert.assertTrue(text.contains("96"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    @When("^I have entered first negative number into the calculator$")
    public void i_have_entered_first_negative_number_into_the_calculator()
    {
       try
       {
           driver.switchTo().frame("fullframe");

           WebElement canvasElement = driver.findElement(By.id("canvas"));

           action = new Actions(driver);

           System.out.println("Going to click on 3");
           action.moveByOffset(580, 380).click().build().perform();
           Thread.sleep(2000);

           System.out.println("Going to click on +/-");
           action.moveByOffset(0, 50).click().build().perform();
           Thread.sleep(1000);
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
    }

    @When("^I press subtract for two negative numbers case$")
    public void i_press_subtract_for_two_negative_numbers_case()
    {
        try
        {
            System.out.println("Going to click on -");
            action.moveByOffset(70, -50).click().build().perform();
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @When("^I have entered second negative number into the calculator$")
    public void i_have_entered_second_negative_number_into_the_calculator()
    {
        try
        {
            System.out.println("Going to click on 2");
            action.moveByOffset(-100, 0).click().build().perform();
            Thread.sleep(1000);

            System.out.println("Going to click on =");
            action.moveByOffset(200, 50).click().build().perform();
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Then("^should display correct result on the screen for two negative numbers$")
    public void should_display_correct_result_on_the_screen_for_two_negative_numbers()
    {
        try
        {
            String text = ScreenRead.getText(Screenshot.createScreenShot(driver).toString(), 0);
            Assert.assertTrue(text.contains("-5"));
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
