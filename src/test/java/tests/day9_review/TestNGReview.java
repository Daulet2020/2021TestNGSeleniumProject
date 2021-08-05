package tests.day9_review;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class TestNGReview {
        private WebDriver driver;

        @BeforeMethod
        public void setup(){
            System.out.println("Before method!");
            driver= BrowserFactory.getDriver("chrome");

        }
        @AfterMethod
        public void teardown(){
            System.out.println("After method!");
            driver.quit();
        }

        @Test (description = "Verify title of google.com", priority = 2)
        public void VerifyGooglePageTitle(){
            System.out.println("Test 1");
            driver.get("http://google.com");
            String expectedTitle = "Google";
            String actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle, expectedTitle, "Title is not correct!");

        }
        @Test(description = "Verify title of apple.com", priority = 1)
        public void VerifyApplePageTitle(){
            System.out.println("Test 2");
            driver.get("http://apple.com");
            String expectedTitle = "Apple";
            String actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle, expectedTitle, "Title is not correct!");
            System.out.println("Test passed!");

        }
        @DataProvider(name = "TestData")
        public static Object [][] testData(){
            return new Object[][]{  {"http://apple.com", "Apple"},      //1st set of data
                                    {"http://google.com", "Google"}};   //2nd set of data
        }

        @Test(dataProvider = "TestData")                                // this test will run twice, coz we have 2 sets of data
        public void TestWithDataProvider(String url, String title){
            driver.get(url);
            Assert.assertEquals(driver.getTitle(), title);

        }

        }


