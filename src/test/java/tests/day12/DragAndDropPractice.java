package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class DragAndDropPractice {

    @Test (description = "Drag and Drop example")
    public void test(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();

        //click to accept cookies
        driver.findElement(By.xpath("//div[@class='qual_x_close']")).click();
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();

        Actions actions = new Actions(driver);

        WebElement moon = driver.findElement(By.id("draggable"));
        WebElement earth = driver.findElement(By.id("droptarget"));

        BrowserUtils.wait(3);
        //* @param source element to emulate button down at.
        //* @param target element to move to and release the mouse at.
        actions.dragAndDrop(moon, earth).pause(800).build().perform();
        BrowserUtils.wait(3);

        driver.quit();




    }

}
