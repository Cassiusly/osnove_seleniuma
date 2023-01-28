package d26_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://s.bootsnipp.com/iframe/Dq2X");

        List<WebElement> niz = driver.findElements(By.xpath("//div/div/div/div"));

        int nizSize = niz.size();
        for (int i = 0; i < niz.size(); i++) {
            driver.findElement(By.xpath("//div/div/div/div/button")).click();
            Thread.sleep(2000);
            nizSize = nizSize-1;
        }

        System.out.println(nizSize);
        driver.quit();
    }
}