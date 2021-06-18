package StepDefinitions;

import Functions.CreateDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriverException;

import java.io.IOException;

public class Hooks {
    public static WebDriver driver;
    Logger log = Logger.getLogger(Hooks.class);
    Scenario scenario = null;
    private static CreateDriver instance = null;

    @Before
    public void initDriver(Scenario scenario) throws IOException {
        log.info("***********************************************************************************************************");
        log.info("[ Configuration ] - Initializing driver configuration");
        log.info("***********************************************************************************************************");
        driver = CreateDriver.initConfig();
        this.scenario = scenario;
        log.info("***********************************************************************************************************");
        log.info("[ Scenario ] - "+ scenario.getName());
        log.info("***********************************************************************************************************");
    }

    @After
    /**
     * Embed a screenshot in test report if test is marked as failed
     */
    public void tearDown(Scenario scenario) throws IOException {

        log.info("***********************************************************************************************************");
        log.info("[ Driver Status ] - Clean and close the intance of the driver");
        log.info("***********************************************************************************************************");
        driver.quit();

    }

}
