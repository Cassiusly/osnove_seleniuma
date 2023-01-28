package d24_1_2023;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");

        for (int i = 0; i < 5; i++) {
            driver.findElement(By.xpath("//*[@type='button']")).click();
            driver.findElement(By.name("name")).sendKeys("Anita Nestorovic");
            driver.findElement(By.name("department")).sendKeys("Quality Assurance");
            driver.findElement(By.name("phone")).sendKeys("+38163456789");
            driver.findElement(By.xpath("//tbody/tr[last()]/td[last()]/a[@class='add']")).click();
            Thread.sleep(500);
        }

        driver.quit();
    }
}
