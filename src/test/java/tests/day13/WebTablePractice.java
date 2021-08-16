package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;


    // if we don`t specify td index, it will take all td elements
    // in css we use space " ", in xpath // to getDriver to any child
    // or in css we use ">", in xpath /, to getDriver to direct child
    // css selector alternative: table[id='table1'] tbody tr:nth-of-type(2) td
    // if index will exceed table size, you will not getDriver any errors, list will be just empty
    // findElements() doesn`t give NoSuchElementException, in any case.



public class WebTablePractice {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup(){

        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("table1")));

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    @Test (description = "Print table 1 data")
    public void Test1(){

        WebElement table = driver.findElement(By.id("table1"));
        System.out.println(table.getText());
    }
    @Test (description = "Verify that number of columns in the first table is equal to 6")
    public void Test2(){

        int actualColumnNumber = driver.findElements(By.xpath("//table[@id='table1']//th")).size();
        int expectedColumnNum = 6;
        Assert.assertEquals(actualColumnNumber, expectedColumnNum);
    }
    @Test (description = "Verify that number of rows is equal to 5")
    public void Test3 (){
        int expectedRows = 5;
        int actualRows = driver.findElements(By.xpath("//table[@id='table1']//tr")).size();
        Assert.assertEquals(actualRows, expectedRows);
    }
    @Test (description = "Print all values from the 2nd row (excl table header)")
    public void test4(){
        List<WebElement> row = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[2]//td"));
        for (WebElement cell : row) {
            System.out.println(cell.getText());
        }
    }
    @Test (description = "Print all values from the n-th row (excl table header)")
    public void test5() {
        int index = 1;
        List<WebElement> row = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[" + index + "]//td"));
        for (WebElement cell : row) {
            System.out.println(cell.getText());
        }
    }
    @Test (description = "Verify that email in the third row is equal to jdoe@hotmail.com")
    public void test6(){
        int row = 3;
        int column = 3;
        WebElement cell = driver.findElement(By.xpath("//table[@id='table1']//tbody//tr["+row+"]//td["+column+"]"));
        String expEmail = "jdoe@hotmail.com";
        String actEmail = cell.getText();
        Assert.assertEquals(actEmail, expEmail);
    }

    /*
    To getDriver all values from email column and verify that every value contains "@"
    If no - fail test.

     */
    @Test (description = "Verify that every email contains '@'")
    public void Test7(){
        //getDriver all emails
        List<WebElement> emails = driver.findElements(By.xpath("//table[@id='table1']//tbody//td[3]"));
        //loop through collection of emails
        for (WebElement email:emails){
            System.out.println(email.getText());
            Assert.assertTrue(email.getText().contains("@"));
        }
    }

    /*
    Step 1. Click on "Last Name"
    Step 2. Get all values from "last name" column
    Step 3. Verify that column is sorted in alphabetical order
     */

    @Test (description = "Verify that after click on last name, values will be sorted in alphabetical order")
    public void test8(){
       /* String word = "a";
        String word2 = "b";
        System.out.println(word.compareTo(word2));
        System.out.println(word.compareTo(word2)<0);
        */
        WebElement lastNameElement = driver.findElement(By.xpath("//table[@id='table1']//*[text()='Last Name']"));
        lastNameElement.click();
        List<WebElement> lastNames = driver.findElements(By.xpath("//table[@id='table1']//tbody//td[1]"));
       // for (WebElement lastName:lastNames){
       //     System.out.println(lastName.getText());
        for (int index = 0; index <lastNames.size()-1; index++){

            String lastName = lastNames.get(index).getText();
            String followingLastName = lastNames.get(index+1).getText();

            System.out.println("======== Iteration: :: "+index);
            System.out.println("Current Last Name: "+lastName);
            System.out.println("Following Last Name "+followingLastName);
            System.out.println("=================================");

            Assert.assertTrue(lastName.compareTo(followingLastName)<0);

    }

    }


}
