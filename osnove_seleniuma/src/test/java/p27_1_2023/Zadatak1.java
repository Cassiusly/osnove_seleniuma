package p27_1_2023;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/modal-dialogs");
        driver.findElement(By.id("showLargeModal")).click();
        if (new Helper().elementExist(driver, By.id("example-modal-sizes-title-lg"))) {
            System.out.println("Element postoji.");
        } else {
            System.out.println("Element ne postoji.");
        }

        Thread.sleep(5000);
        driver.quit();
    }
}