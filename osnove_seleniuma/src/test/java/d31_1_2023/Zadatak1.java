package d31_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;

//Napisati program koji:
//Podesava:
//implicitno cekanje za trazenje elemenata od 10s
//implicitno cekanje za ucitavanje stranice od 10s
//eksplicitno cekanje podeseno na 10s
//Podaci:
//Potrebno je u projektu ukljuciti 4 slike:
//front.jpg
//left.jpg
//right.jpg
//back.jpg
//Koraci:
//Ucitava stranicu https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you
//Maksimizuje prozor
//Klik na edit ikonicu
//Klik na delete iz iskacuceg dijaloga
//Klik na Add Image dugme
//Sacekajte da se pojavi desni meni
//Uploadujte front.jpg sliku
//Sacekajte da je ispod uploada slike, broj slika 1.
//Klik na sliku
//Klik na Done dugme
//Sacekajte 2s
//Klik na Add Image dugme
//Sacekajte da se pojavi desni meni
//Uploadujte right.jpg sliku
//Sacekajte da je ispod uploada slike, broj slika 2.
//Klik na sliku
//Klik na Done dugme
//Sacekajte 2s
//Klik na Add Image dugme
//Sacekajte da se pojavi desni meni
//Uploadujte back.jpg sliku
//Sacekajte da je ispod uploada slike, broj slika 3.
//Klik na sliku
//Klik na Done dugme
//Sacekajte 2s
//Klik na Add Image dugme
//Sacekajte da se pojavi desni meni
//Uploadujte back.jpg sliku
//Sacekajte da je ispod uploada slike, broj slika 3.
//Klik na sliku
//Klik na Done dugme
//Sacekajte 2s
//Sacekajte da Next dugme bude klikljivo
//Klik na Next dugme
//Unesite tekst
//Klik na Next
//Klik na Preview
//Klik na Add to cart
//Sacekajte 5s
//Quit
public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");

        ArrayList<String> listaSlika = new ArrayList<>();
        listaSlika.add("front");
        listaSlika.add("left");
        listaSlika.add("right");
        listaSlika.add("back");

        for (int i = 0; i < listaSlika.size(); i++) {
            driver.findElement(By.xpath("//*[contains(@class, 'edit')]")).click();

            if(i == 0){
                driver.findElement(By.xpath("//*[contains(@id, 'remove')]")).click();
                driver.findElement(By.xpath("//*[contains(@class, 'edit')]")).click();
            }
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(@class, 'sc-eGugkK brCFVr')]"))));

            driver.findElement(By.xpath("//*[contains(@id, 'imageUpload')]"))
                    .sendKeys(new File("src/test/test_data/"+ listaSlika.get(i) +".jpg").getAbsolutePath());

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class, 'sc-dIfARi usMKB')]/div["+(i+1)+"]")));

            driver.findElement(By.xpath("//*[contains(@class, 'sc-dIfARi usMKB')]/div[1]/div/img")).click();

            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(@data-testid, 'container')]"))));

            driver.findElement(By.xpath("//*[contains(@type, 'submit')]")).click();

            Thread.sleep(5000);
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id, 'next-button')]")));
        driver.findElement(By.xpath("//*[contains(@id, 'next-button')]")).click();

        driver.findElement(By.xpath("//*[contains(@id, 'textareaID')]")).sendKeys("Nesto bla bla");
        driver.findElement(By.xpath("//*[contains(@id, 'next-button')]")).click();
        driver.findElement(By.xpath("//*[contains(@id, 'next-button')]")).click();
        driver.findElement(By.xpath("//*[contains(@id, 'next-button')]")).click();


        Thread.sleep(5000);
        driver.quit();
    }
}
