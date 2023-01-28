package d24_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        ArrayList<String> nizToDo = new ArrayList<>();

        nizToDo.add("Visit Paris");
        nizToDo.add("Visit Prague");
        nizToDo.add("Visit London");
        nizToDo.add("Visit New York");
        nizToDo.add("Visit Belgrade");

        driver.manage().window().maximize();
        driver.get("https://example.cypress.io/todo");

        Thread.sleep(500);
        for (int i = 0; i < nizToDo.size(); i++) {
            driver.findElement(By.className("new-todo")).sendKeys(nizToDo.get(i));
            Thread.sleep(3000);
            driver.findElement(By.className("new-todo")).sendKeys(Keys.ENTER);
        }
        Thread.sleep(5000);
        driver.quit();
    }
}
