package p26_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

//Napisti program koji:
//Ucitava stranicu https://s.bootsnipp.com/iframe/z80en
//Hvata sve elemente prve kolone i stampa tekst svakog elementa.
// Kako da od nekog elementa procitamo tekst imate na sledecem linku
//Ceka 1s
//Hvata sve elemente prvog reda i stampa tekst svakog elementa
//Ceka 5s
//Zatvara pretrazivac
//Stampa treba da bude kao u primeru:
//John
//Mary
//July
public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        List<WebElement> elements = new ArrayList<>();
        driver.manage().window().maximize();

        driver.get("https://s.bootsnipp.com/iframe/z80en");
        Thread.sleep(1000);

        elements = driver.findElements(By.xpath("//div[@id='lorem']//tbody/tr/td[1]"));

        for (int i = 0; i < elements.size(); i++) {
            String s = elements.get(i).getText();
            System.out.println(s);
        }

//       WebElement p1 =  driver.findElement(By.xpath("//div[@id='lorem']//tbody/tr[1]/td[1]"));
//        String s1 = p1.getText();
//
//        WebElement p2 = driver.findElement(By.xpath("//div[@id='lorem']//tbody/tr[2]/td[1]"));
//        String s2 = p2.getText();
//
//
//        WebElement p3 = driver.findElement(By.xpath("//div[@id='lorem']//tbody/tr[3]/td[1]"));
//        String s3 = p3.getText();


        Thread.sleep(5000);

        driver.close();
//
//        System.out.println(s1);
//        System.out.println(s2);
//        System.out.println(s3);
    }
}
