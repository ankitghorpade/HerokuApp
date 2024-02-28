package org.test;

import org.base.Base;
import org.base.Scenario;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class Ass_test extends Base {

    @Test
    public void add_data() throws InterruptedException, IOException, ParseException {
        Scenario scenario = new Scenario(driver);
        scenario.scenario_to_add();

        String actualJsonData = (String) ((JavascriptExecutor) driver).executeScript("return window.jsonData;");


        // Expected JSON data
        String expectedJsonData = "[{\"name\" : \"Bob\", \"age\" : 20, \"gender\": \"male\"}, " +
                "{\"name\": \"George\", \"age\" : 42, \"gender\": \"male\"}, " +
                "{\"name\": \"Sara\", \"age\" : 42, \"gender\": \"female\"}, " +
                "{\"name\": \"Conor\", \"age\" : 40, \"gender\": \"male\"}, " +
                "{\"name\": \"Jennifer\", \"age\" : 42, \"gender\": \"female\"}]";


        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(actualJsonData, expectedJsonData, "JSON data assertion failed");
        System.out.println("JSON data assertion using Soft Assert passed successfully");





    }
}
