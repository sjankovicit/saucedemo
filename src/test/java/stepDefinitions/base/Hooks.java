package stepDefinitions.base;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pageObject.Base_PO;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static driver.DriverFactory.cleanupDriver;

public class Hooks extends Base_PO {

    @Before
    public void setup(){
        getDriver();
    }

    @AfterStep
    public void captureExceptionImage(Scenario scenario){
        if (scenario.isFailed()){
            long currentDateTime = System.currentTimeMillis();
            Date currentDate = new Date(currentDateTime);
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy-HH:mm:ss");
            String time = df.format(currentDate);

            byte[] screenshot = ((TakesScreenshot) getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed image " + time);
        }
    }

    @After
    public void tearDown(){
        cleanupDriver();
    }

}
