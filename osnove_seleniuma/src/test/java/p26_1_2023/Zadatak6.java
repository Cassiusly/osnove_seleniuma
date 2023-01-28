package p26_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//adatak
//Ucitati stranicu https://cms.demo.katalon.com/
//Maksimizovati prozor
//Proveriri da li je je crno MENU dugme vidljivo (Ispisati poruke u konzoli)
//Prostavite duzinu prozora na 700px i visinu na 700px
//Proverite da li je crno MENU dugme vidljivo (Ispisati poruke u konzoli)
public class Zadatak6 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        boolean isDisplayed = driver.findElement(By.className("menu-toggle")).isDisplayed();


    }
}
