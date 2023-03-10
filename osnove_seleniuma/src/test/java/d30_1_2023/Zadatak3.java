package d30_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Zadatak
//Napisati program koji:
//Pre nego sto krenete u automatizaciju prvo sve korake uradite rucno
//Implicitno cekanje za trazenje elemenata je maksimalno 10s
//Implicitno cekanje za ucitavanje stranice je 5s
//Ucitava stranicu https://docs.katalon.com/
//Maksimizuje prozor
//Od html elementa cita data-theme atribut.
//Proverava da li je sadrzaj u tom atributu light i ispisuje odgovarajuce poruke
//Klikce na dugme za zamenu tema
//Ponovo cita data-theme atribut html elementa i validira da u atributu stoji vrednost dark
//Izvrsava kombinaciju tastera CTRL + K. Koristan link  za keyboard actions…kako izvrsavati
// precice preko Actions objekta
//Ceka da se dijalog za pretragu pojavi
//Zatim od inputa za pretragu cita atribut type i proverava da je vrednost tog atributa search
//Zatvara pretrazivac
public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://docs.katalon.com/");

        Thread.sleep(3000);

        if(driver.findElement(By.xpath("//html")).getAttribute("data-theme").equals("light")){
            System.out.println("Atribut 'data-theme' sadrzi 'light'.");
        } else {
            System.out.println("Atribut 'data-theme' ne sadrzi 'light'.");
        }

        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[contains(@class, 'toggleButton')]")).click();

        if(driver.findElement(By.xpath("//html")).getAttribute("data-theme").equals("dark")){
            System.out.println("Atribut 'data-theme' sadrzi 'dark'.");
        } else {
            System.out.println("Atribut 'data-theme' ne sadrzi 'dark'.");
        }

        Thread.sleep(3000);

        new Actions(driver).keyDown(Keys.CONTROL).sendKeys("k").perform();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='DocSearch-Modal']"))));

        Thread.sleep(3000);

        if(driver.findElement(By.xpath("//input[@class='DocSearch-Input']")).getAttribute("type").equals("search")){
            System.out.println("Atribut 'type' sadrzi 'search'.");
        } else {
            System.out.println("Atribut 'type' ne sadrzi 'search'.");
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
