package p30_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//5.Zadatak
//Napisati program koji:
//Ucitava stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
//Vrsi klik na Primary dugme, Secondary, Sucess, Danger
//Ceka da broj toasts-a bude 4
//Ispisuje poruku, toasts su prikazani
//Ceka da broj toasts-a bude 0
//Ispisuje poruku, toasts su se izgubili
public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Thread.sleep(1000);

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");
        driver.findElement(By.xpath("//button[@id='basic-primary-trigger']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='basic-secondary-trigger']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='basic-success-trigger']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='basic-danger-trigger']")).click();
        Thread.sleep(1000);

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[contains(@class, )]")))


    }
}
