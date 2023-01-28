package p24_1_2023;
//3.Zadatak
//Napisati program koji ima:
//Niz stranica (niz stringova) koje treba da ucita. Niz je:
//https://google.com/
//https://youtube.com/
//https://www.ebay.com/
//https://www.kupujemprodajem.com/
//Program petljom prolazi kroz niz stranica i svaku stranicu ucitava preko get ili navigate i od
// svake stranice na ekranu ispisuje naslov stranice. Kako od stranice procitati naslov imate na ovom linku
//U prevodu u konzoli treba da se ispisu:
//Google
//YouTube
//Electronics, Cars, Fashion, Collectibles & More | eBay
//KupujemProdajem
//Zatvara pretrazivac
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        ArrayList<String> nizStringova = new ArrayList<>();
        nizStringova.add("https://google.com/");
        nizStringova.add("https://youtube.com/");
        nizStringova.add("https://www.ebay.com/");
        nizStringova.add("https://www.kupujemprodajem.com/");

        for (int i = 0; i < nizStringova.size(); i++) {
            driver.manage().window().maximize();
//            Thread.sleep(5000);
            driver.get(nizStringova.get(i));
            // getTitle() to obtain page title
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());
        }
        driver.close();
    }
}
