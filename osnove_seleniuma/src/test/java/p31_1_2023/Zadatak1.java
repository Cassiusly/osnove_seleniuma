package p31_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;
//Napisati program koji:
//Krairajte folder za fajlove u okviru projekta pod nazivom test_data
//U folder skinite i postavite proizvoljnu sliku
//Ucitava stranu https://tus.io/demo.html
//Skrola do dela za upload fajla
//Aploadujte sliku
//Cekajte da se pojava dugme za download fajla
public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Thread.sleep(1000);

        String uploadImgPath = new File("test_data/Irises-Vincent_van_Gogh.jpg").getAbsolutePath();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        driver.get("https://tus.io/demo.html");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(By.id("js-upload-container"))).click();
        actions.perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'Download Irises-Vincent_van_Gogh.jpg')]")));

        System.out.println(uploadImgPath);

        Thread.sleep(5000);
        driver.quit();
    }
}
