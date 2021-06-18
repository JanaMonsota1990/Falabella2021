package Functions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class WebDriverFactory {
    private static Properties properties = new Properties();
    private static InputStream inReader = CreateDriver.class.getResourceAsStream("../test.properties");
    private static String resourceFolder;

    private static Logger log = Logger.getLogger(WebDriverFactory.class);

    private static WebDriverFactory instance = null;

    private WebDriverFactory() {    }

    public static WebDriverFactory getInstance() {
        if (instance == null) {
            instance = new WebDriverFactory();
        }
        return instance;
    }

    public static WebDriver createNewWebDriver(String browser, String os) throws IOException {
        WebDriver driver;
        properties.load(inReader);
        resourceFolder = properties.getProperty("resourceFolder");

        //firefox
        if ("FIREFOX".equalsIgnoreCase(browser)) {
            if("WINDOWS".equalsIgnoreCase(os)){
                System.setProperty("webdriver.gecko.driver", resourceFolder + os + "/geckodriver.exe");
            }
            else{
                System.setProperty("webdriver.gecko.driver", resourceFolder + os + "/geckodriver");
            }
            driver = new FirefoxDriver();
        }

        //chrome
        else if ("CHROME".equalsIgnoreCase(browser)) {
            if("WINDOWS".equalsIgnoreCase(os)){
                System.setProperty("webdriver.chrome.driver", resourceFolder+os+"/chromedriver.exe");
            }
            else{
                System.setProperty("webdriver.chrome.driver", resourceFolder+os+"/chromedriver");
            }
            driver = new ChromeDriver();

        }

        //internet explorer
        else if ("INTERNET EXPLORER".equalsIgnoreCase(browser)) {
            System.setProperty("webdriver.ie.driver", resourceFolder+os+"/IEDriverServer.exe");
            driver = new InternetExplorerDriver();

        }

        //the proerty dosent exist on test.properties
        else {
            log.error("The Driver is not selected properly, invalid name: " + browser + ", " + os);
            return null;
        }
        driver.manage().window().maximize();
        return driver;

    }
}
