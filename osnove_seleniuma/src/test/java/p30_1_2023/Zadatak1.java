package p30_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

//1.Zadatak
//Napisati program koji ucitava stranicu
// https://s.bootsnipp.com/iframe/klDWV i
// ceka da se ucita progress bar na 100% a
// zatim ispisuje tekst u konzoli “Stranica ucitana”
public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Thread.sleep(1000);

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://s.bootsnipp.com/iframe/klDWV");

        wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//div[@style='display: none;']")));

        Thread.sleep(3000);
        System.out.println("Stranica ucitana.");
        driver.quit();




    }
}
