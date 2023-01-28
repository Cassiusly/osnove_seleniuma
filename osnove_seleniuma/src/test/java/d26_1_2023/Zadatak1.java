package d26_1_2023;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import java.util.ArrayList;
import java.util.List;


public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        ArrayList<String> niz = new ArrayList<>();
        niz.add("Visit Paris");
        niz.add("Visit Prague");
        niz.add("Visit London");
        niz.add("Visit New York");
        niz.add("Visit Belgrade");
        driver.manage().window().maximize();

        driver.get("https://example.cypress.io/todo");

        List<WebElement> lista = driver.findElements(By.xpath("//ul[@class='todo-list']/li"));
        int pocetnoStanje = lista.size();
        int novoStanje = 0;
        for (int i = 0; i < niz.size(); i++) {
            driver.findElement(By.className("new-todo")).sendKeys(niz.get(i));
            driver.findElement(By.className("new-todo")).sendKeys(Keys.ENTER);
            novoStanje = novoStanje + 1;
        }
        int zbir = novoStanje + pocetnoStanje;
        System.out.println("Novo stanje je: " + zbir);
        Thread.sleep(5000);
        Actions actions = new Actions(driver);


        for (int i = 0; i < niz.size() + pocetnoStanje; i++) {
            WebElement dugme = driver.findElement(By.xpath("//ul[@class='todo-list']/li/div"));
            actions.moveToElement(dugme).perform();
            driver.findElement(By.xpath("//ul[@class='todo-list']/li/div/button")).click();
            zbir = zbir - 1;
        }
        if (zbir == 0){
            System.out.println("Stanje u listi je 0");
        }
        driver.quit();
   }
}

