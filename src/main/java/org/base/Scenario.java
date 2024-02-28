package org.base;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;


public class Scenario extends Base{

    @FindBy(xpath = "//summary[normalize-space()='Table Data']")
    WebElement tabledata;

    @FindBy(xpath = "//textarea[@id='jsondata']")
    WebElement jsondata;

    @FindBy(xpath = "//button[@id='refreshtable']")
    WebElement refreshTable;

    @FindBy(xpath = "//table[@id='dynamictable']")
    WebElement result_data;

    public Scenario(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    public void scenario_to_add() throws InterruptedException, IOException, ParseException {
        tabledata.click();
        Thread.sleep(2000);

        jsondata.clear();
        Thread.sleep(2000);

        String jsonData = "[{\"name\" : \"Bob\", \"age\" : 20, \"gender\": \"male\"}, " +
                "{\"name\": \"George\", \"age\" : 42, \"gender\": \"male\"}, " +
                "{\"name\": \"Sara\", \"age\" : 42, \"gender\": \"female\"}, " +
                "{\"name\": \"Conor\", \"age\" : 40, \"gender\": \"male\"}, " +
                "{\"name\": \"Jennifer\", \"age\" : 42, \"gender\": \"female\"}]";

        jsondata.sendKeys(jsonData);


        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", refreshTable);
        Thread.sleep(5000);
        refreshTable.click();
        Thread.sleep(4000);



        System.out.println("Test passed successfully");
    }
}
