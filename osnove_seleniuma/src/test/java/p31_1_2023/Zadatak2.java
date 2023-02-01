package p31_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

//Napisati program koji:
//Ucitava stranu https://blueimp.github.io/jQuery-File-Upload/
//Uploadujte sliku
//Ceka se da se pojavi slika u listi uploadovanih fajlova
//Koristite uslov da broj elemenata bude 1.
//Klik na Start dugme u okviru item-a koji se uploadovao
//Ceka se da se pojavi delete dugme pored itema
//Klik na delete dugme pored itema
//Ceka se da se element obrise
//Koristite da broj elemenata bude 0
public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().window().maximize();


        driver.findElement(By.name("files[]"));
        String uploadImgPath = new File("test_data/Irises-Vincent_van_Gogh.jpg").getAbsolutePath();

        System.out.println(uploadImgPath);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@role='presentation']")));

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody[@class='files']//button[1]"))).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//tbody[@class='files']//button[1]")));

        Thread.sleep(5000);
        driver.quit();



    }
}
