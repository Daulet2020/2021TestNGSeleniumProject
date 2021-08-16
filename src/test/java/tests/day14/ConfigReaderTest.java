package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigurationReader;

public class ConfigReaderTest {

    /*
            #Browser type | it`s comment
            #key=value, it`s like a Map in Java
            browser=chrome

            #URL of our web application
            url=https://qa1.vytrack.com/

            #Credentials
            user_name=storemanager85
            password=UserUser123
     */
    @Test
    public void test1(){
        String expBrowser = "chrome";
        //we write keys in "key" as a String
        String actBrowser = ConfigurationReader.getProperty("browser");
        Assert.assertEquals(actBrowser, expBrowser);
        //read value of url property
        System.out.println("URL: "+ConfigurationReader.getProperty("url"));
        //read value of user_name property
        System.out.println("Username "+ConfigurationReader.getProperty("user_name"));
        //read value of password property
        String password = ConfigurationReader.getProperty("password");
        System.out.println("Password: "+password);


    }
}
