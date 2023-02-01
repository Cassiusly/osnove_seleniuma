package p30_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

//6. Zadatak
//Napisati program koji:
//Ucitava stranicu https://tus.io/demo.html
//Hvata sve linkove sa stranice
//Skrola do svakog h3 elementa
//Od svakog h3 elementa cita text
public class Zadatak6 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Thread.sleep(1000);

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://tus.io/demo.html");

        List<WebElement> h3Elementi = driver.findElements(By.tagName("h3"));

        for (int i = 0; i < h3Elementi.size(); i++) {
            WebElement h3Element = h3Elementi.get(i);
            Actions actions = new Actions(driver);
            actions.moveToElement(h3Element).perform();
            String h3 = h3Element.getAttribute("");
            System.out.println();
        }

        Thread.sleep(5000);
        driver.quit();




    }
}
