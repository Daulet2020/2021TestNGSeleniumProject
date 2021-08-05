package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class JSExecutorPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");


    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    @Test (description = "Scrolling with JavaScriptExecutor")
    public void test1(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 10; i++) {
            js.executeScript("window.scrollBy(0,500);");
            BrowserUtils.wait(2);
        }
        BrowserUtils.wait(2);
    }

    @Test (description = "Scrolling with JSexecutor to specific element")
    public void Test2(){
        driver.get("http://practice.cybertekschool.com/large");
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        BrowserUtils.wait(2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //this script must scroll, untill element is not visible
        //once link element will be visible, it will stop scrolling
        //argument[0] = means first webelement after comma (link)
        js.executeScript("arguments[0].scrollIntoView(true)", link);
        BrowserUtils.wait(2);

    }
    @Test (description = "Click with JC executor")
    // var btn1 = document.getElementsByTagName('a')[1]
    // btn1.click()
    public void test3(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        WebElement link1 = driver.findElement(By.partialLinkText("Example 1"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //argument [0] = link1 web element
        //whenever regular selenium methods are not working, I use JC executor
        //or for scrolling
        //argument[0].click() is an alternative for link1.click()
        js.executeScript("arguments[0].click()", link1);
        BrowserUtils.wait(2);


    }

    //document.getElementByName('full_name')[0].setAttribute('value', 'My name')
    @Test (description = "Send keys by JS executor")
    public void test4() {
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement name = driver.findElement(By.name("full_name"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement submitButton = driver.findElement(By.name("wooden_spoon"));

        //te create jc executor object we need to cast webdriver object
        //.setAttribute it`s same as .sendKeys
        JavascriptExecutor js = (JavascriptExecutor) driver;
        BrowserUtils.wait(2);
        js.executeScript("arguments[0].setAttribute('value', 'John Smith')", name);
        js.executeScript("arguments[0].setAttribute('value', 'someemail@gmail.com')", email);
        js.executeScript("arguments[0].click()", submitButton);


    }
}
