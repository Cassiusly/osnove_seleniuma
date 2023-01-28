package d26_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://geodata.solutions/");

        driver.findElement(By.id("countryId")).click();
        driver.findElement(By.xpath("//select/option[@countryid='RS']")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("stateId")).click();
        driver.findElement(By.xpath("//select/option[@value='Central Serbia']")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("cityId")).click();
        driver.findElement(By.xpath("//select/option[@value='Belgrade']")).click();
        Thread.sleep(5000);

    }
}
