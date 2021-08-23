package tests.Discover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.ArrayList;
import java.util.List;

public class HelpCenter {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() throws Exception {

        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.discover.com/");
        Thread.sleep(5000);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("(//*[@class=\"dropdown-toggle mobile-accessibility preventDefaultBehaviour\"])[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//*[@href=\"/credit-cards/help-center/?ICMPGN=PUB_HDR_HELP_CC\"])[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//*[@class=\"icon-nav__item-link\"])[1]")).click();

    }
   // @Test
  //  public void Test1() {
 //      String expected = "Cash Back Credit Card";
   //     String actual = driver.findElement(By.xpath("//*[@href=\"https://www.discover.com/credit-cards/cash-back/it-card.html\"]")).getText();
   //     Assert.assertEquals(expected, actual);
 //   }
    @Test
    public void Test2() {
        List<WebElement> cardBanners = driver.findElements(By.xpath("//div[@class='cards-offer-wrapper cards-offer-comp']"));
        int cardBannersCount = cardBanners.size();
        Assert.assertEquals(8, cardBannersCount);

        ArrayList<String> cards = new ArrayList<>();
        cards.add("Cash Back Credit Card");
        cards.add("Student Cash Back ");
        cards.add("Secured Credit Card");
        cards.add("Student Chrome ");
        cards.add("Travel Credit Card");
        cards.add("Gas & Restaurants ");
        cards.add("NHL");
        cards.add("Business Credit Card");



        for(String each:cards){

        }

        System.out.println(cards);
        System.out.println(cardBanners);
        System.out.println(cardBannersCount);

    }

}
