package p27_1_2023;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("file:///C:/Users/cassiusly/Downloads/Zadatak4.html");

        for (int i = 0; i < 5; i++) {
            driver.findElement(By.id("showInBtn")).click();
            driver.findElement(By.id("id-" + i));
//            driver.findElement(By.xpath("//body/div["+(i + 1)+"]"));
//            driver.findElement(By.xpath("//body/div[last() + 1]"));

        }

        Thread.sleep(5000);
        driver.quit();
    }
}