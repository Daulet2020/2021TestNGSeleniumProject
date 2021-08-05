package tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://google.com");

        driver.navigate().to("http://amazon.com");
        driver.manage().window().fullscreen();
        Thread.sleep (5000);
        driver.navigate().back();
        String url = driver.getCurrentUrl();
        System.out.println(url);
        driver.navigate().refresh();
        driver.navigate().forward();


        driver.close();

    }
}
