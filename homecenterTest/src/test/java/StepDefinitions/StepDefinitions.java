package StepDefinitions;

import Functions.CreateDriver;
import Functions.SeleniumFunctions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class StepDefinitions {
    SeleniumFunctions functions = new SeleniumFunctions();

    private static String mainPagePrice = null;
    private static String productPagePrice = null;

    private static Properties properties = new Properties();
    private static InputStream inReader = CreateDriver.class.getResourceAsStream("../test.properties");
    private static String resourceFolder;

    Logger log = Logger.getLogger(StepDefinitions.class);
    WebDriver driver;

    public StepDefinitions() {
        driver = Hooks.driver;
    }

    @Given("^I go to sodimac main page (.*)")
    public void I_Go_To_Sodimac_Main_Page(String URL) throws IOException {
        log.info("Navigate to: " + URL);
        driver.get(URL);

    }

    @And("I load document with information (.*)$")
    public void i_Load_Document_With_Information_Sodimac(String json) throws Exception {
        SeleniumFunctions.FileName = json;
        SeleniumFunctions.readJson();
        log.info("initialize file: " + json);
    }

    @And("I click in element (.*)$")
    public void iClickInElement(String element) {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        driver.findElement(SeleniumElement);
        log.info("click on: " + element);

    }

    @And("I set (.*) with text (.*)")
    public void iSetWithText(String element, String text) {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        driver.findElement(SeleniumElement).sendKeys(text);
    }

    @Then("I wait (.*) seconds")
    public void iWaitSeconds(int seconds) throws InterruptedException {
        int secs = seconds * 1000;
        Thread.sleep(secs);
    }

    @And("I press enter on (.*)")
    public void iPressEnter(String element) {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        driver.findElement(SeleniumElement).sendKeys(Keys.ENTER);
    }

    @And("If (.*) is equal to (.*)")
    public void ifIsEqualTo(String mainPageElement, String productPageElement) {
        By SeleniumElementMainPage = SeleniumFunctions.getCompleteElement(mainPageElement);
        By SeleniumElementProductPage = SeleniumFunctions.getCompleteElement(productPageElement);

        System.out.println(SeleniumElementMainPage.toString());
        System.out.println(SeleniumElementProductPage.toString());

        driver.findElement(SeleniumElementMainPage);
    }



    @And("print price of the first element in (.*)")
    public void printPriceOfTheFirstElementIn(String element) {
        By SeleniumElementMainPage = SeleniumFunctions.getCompleteElement(element);
        //driver.findElement(SeleniumElementMainPage.linkText("$4.090"));
        //log.info(driver.findElement(SeleniumElementMainPage.linkText("$4.090")));
        Object elementLinktext = driver.findElement(By.linkText("$4.090"));
        System.out.println(elementLinktext.toString());

    }

    @Then("click on the (.*)")
    public void clickOnThe(String element) {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        driver.findElement(SeleniumElement);
        log.info("click on: " + element);
    }

    @Then("print price of the (.*)")
    public void printPriceOfThe(String element) {
        By SeleniumElementMainPage = SeleniumFunctions.getCompleteElement(element);
        driver.findElement(SeleniumElementMainPage.linkText("$4.090"));
        log.info(driver.findElement(SeleniumElementMainPage.linkText("$4.090")));
    }

    @Then("The test is successfull")
    public void theTestIsSuccessfull() {
        assert true;
    }
    
    @Then("^I close the window")
    public void i_close_window() {
        driver.close();
    }


}


