package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class LoginPage {

    @FindBy(id = "prependedInput") //this line will initialize web element
    public WebElement usernameInput;

    @FindBy(id = "prependedInput2")//without findby, web element will be null
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement loginButton;

    @FindBy(css = "[class = 'alert alert-error']")
    public WebElement warningMessage;

    public LoginPage() {
        //It`s mandatory if you want to use @FindBy annotation
        //this means LoginPage class
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void login(String userName, String password){
        usernameInput.sendKeys(userName);
        passwordInput.sendKeys(password, Keys.ENTER);

    }

 }
