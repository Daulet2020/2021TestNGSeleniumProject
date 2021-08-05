package tests.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class DropDowns {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Dropdown")).click();

    }

    @Test(description = "Select option 2 from the dropdown")
    public void Test1() {
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Option 2");
        BrowserUtils.wait(2);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 2");

    }

    @Test(description = "List of states")
    public void Test2() {
        WebElement state = driver.findElement(By.id("state"));
        Select select = new Select(state);
        List<WebElement> states = select.getOptions();
        for (WebElement option : states) {
            System.out.println(option.getText());
        }
    }

    @Test
    public void Test3() {
        WebElement state = driver.findElement(By.id("state"));
        Select select = new Select(state);
        select.selectByValue("TX");
        BrowserUtils.wait(1);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Texas");


    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
