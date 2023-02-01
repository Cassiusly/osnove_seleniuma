package p30_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Napisati program koji
//ucitava stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
//Klik Primary dugme
//Ceka da se pojavi toasts u gornjem desnom uglu
//Ispisuje da se element pojavio
//Ceka da se izgubi toasts u gornjem desnom uglu
//Ispisuje da se elment izgubio
//Klik na primary dugme
//Ceka da se pojavi toasts u gornjem desnom uglu
//Ispisuje da se element pojavio
//Klik na x dugme iz toasts-a
//Ceka da se element izgubi
//Ispisuje da se element izgubio
public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Thread.sleep(1000);

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@id='basic-primary-trigger']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='basic-primary-example']/div[1]")));
        System.out.println("Element se pojavio.");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[contains(text(), 'Close')]")));
        System.out.println("Element se izgubio.");

        driver.findElement(By.xpath("//button[@id='basic-primary-trigger']")).click();
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='basic-primary-example']/div[1]")));
        System.out.println("Element se pojavio.");
        driver.findElement(By.xpath("//button[contains(text(), 'Close')]"));
        wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[contains(text(), 'Close')]")));
        System.out.println("Element se izgubio.");

        Thread.sleep(5000);
        driver.quit();

    }
}
