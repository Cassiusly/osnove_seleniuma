package p30_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//2. Zadatak
//Napisati program koji ucitava stranicu
// https://youtube.com i u search baru unosi
// tekste Breskvica i ceka da se pojavi vise od
// 3 rezultata iz padajuceg menija i zatim klikce na prvi.
public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Thread.sleep(1000);

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://youtube.com");

        WebElement searchBar = driver.findElement(By.name("search_query"));
        searchBar.sendKeys("Breskvica");
        searchBar.sendKeys(Keys.ARROW_DOWN);
        searchBar.sendKeys(Keys.ARROW_DOWN);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//*[contains(@class, 'sbsb_b')]//li"), 3));


        WebElement prviRezultat = driver.findElement(By.xpath("//*[contains(@class, 'sbsb_b')]//li[1]"));
        Thread.sleep(2000);
        prviRezultat.click();

        Thread.sleep(3000);
        driver.quit();

    }
}
