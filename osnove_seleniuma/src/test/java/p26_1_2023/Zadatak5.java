package p26_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");

        Thread.sleep(5000);
        Select se = new Select(driver.findElement(By.xpath("//select[@id='gh-cat']")));
        Thread.sleep(1000);

        se.selectByVisibleText("Crafts");

        driver.quit();

    }
}
