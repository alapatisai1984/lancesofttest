package StepDefinition;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.UUID;

public class Screenshot
{
    private static String imageLocation = System.getProperty("user.dir")+"/screenshots/";

    public static File createScreenShot(WebDriver driver)
    {

        UUID uuid = UUID.randomUUID();

        File src = driver.findElement(By.id("canvas")).getScreenshotAs(OutputType.FILE);

        try
        {
            FileUtils.copyFile(src, new File(imageLocation + uuid + ".png"));
            Thread.sleep(3000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        File filepath = new File(imageLocation + uuid + ".png");
        System.out.println(filepath);

        return filepath;
    }
}
