package pages;

//everything that is in among pages
//can go here
//for example top menu elements don`t belong tp specific page
//top menu apeears on every single page
//so we can keep them here

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

public class BasePage {
    @FindBy(css = "div[class='loader-mask shown']")
    public WebElement loaderMask;

    public BasePage(){

        //this method requires to provide webdriver object for @FindBy
        //and page class
        //this means this page class
        PageFactory.initElements(Driver.getDriver(), this);

    }

    public void navigateTo(String moduleName, String subModuleName){
        String moduleLocator = "//*[normalize-space()='"+moduleName+"' and @class='title title-level-1]";
        String subModuleLocator = "//*[normalize-space()='"+subModuleName+"' and @class='title title-level-2]";
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(moduleLocator)));

        WebElement module = Driver.getDriver().findElement(By.xpath(moduleLocator));

        wait.until(ExpectedConditions.visibilityOf(module));
        wait.until(ExpectedConditions.elementToBeClickable(module));

        module.click();

        WebElement subModule = Driver.getDriver().findElement(By.xpath(subModuleLocator));
        wait.until(ExpectedConditions.visibilityOf(subModule));
        subModule.click();

        //wait till loader mask disappeared
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));


    }

}
