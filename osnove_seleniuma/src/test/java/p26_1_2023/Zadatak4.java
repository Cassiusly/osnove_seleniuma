package p26_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Napisati program koji ucitava stranicu http://cms.demo.katalon.com/my-account/, cekira Remember me checkbox.
//Na kraju programa proverite da li je element cekiran. Izguglajte kako mozemo da proverimo da li je element cekiran.
public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://cms.demo.katalon.com/my-account/");

        Thread.sleep(5000);
        if (driver.findElement(By.id("rememberme")).isSelected()) {
            System.out.println("Cekirano je.");
        } else {
            System.out.println("Nije cekirano.");
        }

        Thread.sleep(1000);
        driver.quit();
    }
}
