package utils;

public class BrowserUtils {

    //it will used to pause our test execution

    public static void wait (int seconds) {
        try {
            Thread.sleep(1000*seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
