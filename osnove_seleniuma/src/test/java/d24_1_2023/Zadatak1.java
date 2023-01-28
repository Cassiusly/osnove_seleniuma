package d24_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Maksimizirati prozor
//Ucitati stranicu https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
//Prijavite se na sistem
//Username: Admin
//Password: admin123
//Cekanje od 5s
//U input za pretragu iz navigacije unesite tekst Me
//Kliknite na prvi rezultat pretrage (to ce biti Time)
//Cekanje od 1s
//Kliknite u headeru na svog avatara (to ce biti na ime: Paul Collings)
//Klinkite na logout
//Cekanje od 5s
//Zatvorite pretrazivac
public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");


        Thread.sleep(5000);

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@placeholder='Search']")).sendKeys("Me");

        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@href='/web/index.php/time/viewTimeModule']")).click();

        Thread.sleep(1000);

        driver.findElement(By.className("oxd-userdropdown-name")).click();
        driver.findElement(By.className("oxd-userdropdown-link")).click();

        Thread.sleep(5000);

        driver.close();

    }
}
