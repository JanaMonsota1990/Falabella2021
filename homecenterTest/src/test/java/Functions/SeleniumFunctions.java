package Functions;

import StepDefinitions.Hooks;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class SeleniumFunctions {
    public static String GetFieldBy = "";
    public static String ValueToFind = "";
    private static Logger log = Logger.getLogger(SeleniumFunctions.class);
    public static String FileName = "";
    public static String PagesFilePath = "src/test/resources/Pages/";
    WebDriver driver;

    public SeleniumFunctions() {

        driver = Hooks.driver;
    }

    public static Object readJson() throws Exception {
        FileReader reader = new FileReader(PagesFilePath + FileName);
        try {

            if (reader != null) {
                JSONParser jsonParser = new JSONParser();
                return jsonParser.parse(reader);
            } else {
                return null;
            }
        } catch (FileNotFoundException | NullPointerException e) {
            log.error("ReadEntity: No existe el archivo " + FileName);
            throw new IllegalStateException("ReadEntity: No existe el archivo " + FileName, e);
        }

    }

    public static JSONObject readEntity(String element) throws Exception { //search element on json
        JSONObject Entity;

        JSONObject jsonObject = (JSONObject) readJson();
        Entity = (JSONObject) jsonObject.get(element);
        log.info(Entity.toJSONString());
        return Entity;

    }

    public static By getCompleteElement(String element) {
        try {
            By result = null;
            JSONObject Entity = readEntity(element);

            GetFieldBy = (String) Entity.get("GetFieldBy");
            ValueToFind = (String) Entity.get("ValueToFind");

            if ("className".equalsIgnoreCase(GetFieldBy)) {
                result = By.className(ValueToFind);
            } else if ("cssSelector".equalsIgnoreCase(GetFieldBy)) {
                result = By.cssSelector(ValueToFind);
            } else if ("id".equalsIgnoreCase(GetFieldBy)) {
                result = By.id(ValueToFind);
            } else if ("linkText".equalsIgnoreCase(GetFieldBy)) {
                result = By.linkText(ValueToFind);
            } else if ("name".equalsIgnoreCase(GetFieldBy)) {
                result = By.name(ValueToFind);
            } else if ("link".equalsIgnoreCase(GetFieldBy)) {
                result = By.partialLinkText(ValueToFind);
            } else if ("tagName".equalsIgnoreCase(GetFieldBy)) {
                result = By.tagName(ValueToFind);
            } else if ("xpath".equalsIgnoreCase(GetFieldBy)) {
                result = By.xpath(ValueToFind);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getPrices(){

        return 0;
    }

    public static boolean comparePrices(Object mainPagePrice, Object productPagePrice){

        if(mainPagePrice == productPagePrice){
            return true;
        }
        return false;
    }


}
