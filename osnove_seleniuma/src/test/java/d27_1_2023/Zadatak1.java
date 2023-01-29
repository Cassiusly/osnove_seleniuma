package d27_1_2023;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("section-basic-example")));
        actions.perform();


        driver.findElement(By.xpath("//button[@id='basic-primary-trigger']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='basic-secondary-trigger']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='basic-success-trigger']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='basic-danger-trigger']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='basic-warning-trigger']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='basic-info-trigger']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='basic-light-trigger']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='basic-dark-trigger']")).click();
        Thread.sleep(1000);

        boolean buttons = true;
        try{
            driver.findElement(By.xpath("//div[contains(@class, 'toast fade mx-auto toast')]"));
        }
        catch (NoSuchElementException error){
            buttons=false;
        }
        if (buttons){
            System.out.println("Radi!!!");
        }
        else{
            System.out.println("Ne pojavljuje se");
        }
        driver.quit();
    }
}
