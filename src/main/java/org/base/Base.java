package org.base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {

    public static WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}