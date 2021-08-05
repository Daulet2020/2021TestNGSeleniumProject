package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class WaitsPractice {
    private WebDriver driver;

    /*
    Implicit wait resolves only one problem------> presence of element
    Explicit wait resolves more problems --------> presence of element, visibility, clickability, staleness of element, etc

    Every 500 milisecs selenium will check if the condition is met. If no, it will keep checking within given time frame
     */


    @BeforeMethod
    public void setup (){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    @Test
    public void Test1(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@href=\"/dynamic_loading\"]")).click();
        driver.findElement(By.partialLinkText("Example 2")).click();
        driver.findElement(By.tagName("button")).click();

        WebElement finishElement = driver.findElement(By.id("finish"));

        System.out.println(finishElement.getText());



        driver.findElement(By.id("finish"));

    }
    @Test
    public void Test2(){
        driver.findElement(By.xpath("//*[@href=\"/dynamic_loading\"]")).click();
        driver.findElement(By.partialLinkText("Example 1")).click();
        driver.findElement(By.tagName("button")).click();

        //we find element first, but the problem is element can be present but not visible
        WebElement userNameInputBox = driver.findElement(By.id("username"));
        //how to apply condition: ExpectedConditions.condition
        //explicit wait we must provide webdriver object and period of time
        //if wait timeout will expire, your test will fail (due to exception)
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(userNameInputBox));

        userNameInputBox.sendKeys("tomsmith");

        WebElement passwordInputBox = driver.findElement(By.name("password"));
        wait.until(ExpectedConditions.visibilityOf(passwordInputBox));

        passwordInputBox.sendKeys("SuperSecretPassword");
        BrowserUtils.wait(2);

       /* driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
        BrowserUtils.wait(2);
        */

        WebElement submit = driver.findElement(By.cssSelector("button[type='submit'"));
        wait.until(ExpectedConditions.elementToBeClickable(submit));

        submit.click();

        WebElement message = driver.findElement(By.tagName("h4"));

        wait.until(ExpectedConditions.visibilityOf(message));

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = message.getText();
        Assert.assertEquals(actual, expected);

    }

    @Test (description = "Find locator for overlayScreen")
    public void Test3(){
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 5")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement overlayScreen = driver.findElement(By.cssSelector("[class='fa fa-cog fa-spin]"));
        wait.until(ExpectedConditions.invisibilityOf(overlayScreen));

        // Fluent wait - it work like explicit wait, but except one difference - you can change polling time. Explicit wait
        // checks condition every 500 milliseconds. With a fluent wait, you can change this polling time. I would say that Fluent wait it`s
        // like custom explicit wait.


    }

    @Test (description = "Fluent time example")
    public void Test4(){
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 2")).click();
        driver.findElement(By.tagName("button")).click();

        Wait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(ElementNotVisibleException.class);

        WebElement message = (WebElement) wait.until(new Function<WebDriver, WebElement> () {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("finish"));
            }
        }
        );


    }




}
