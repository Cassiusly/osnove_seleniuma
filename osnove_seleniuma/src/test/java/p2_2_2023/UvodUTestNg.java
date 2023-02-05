package p2_2_2023;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class UvodUTestNg {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass //pravi drajver

    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

    }
     @BeforeMethod
     public void before(){
        this.driver = new ChromeDriver();
         this.driver.get("https://www.google.com/");
         this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

     }
    @Test
    @Description("TC-1 Login with invalid creditentials.")
    public void googleTitle() throws InterruptedException {
        // napravili smo objekat i pozivamo ga ovako

//        if (driver.getTitle().equals("Google")){
//            System.out.println("Jeste google");
//        } else {
//            System.out.println("Nije google.");
//        }

        int numberOfLink = driver.findElements(By.tagName("a")).size();
        Assert.assertEquals(numberOfLink, 18, "Number of links on home page");
// Message pise samo kad fejluje test

    }


    @Test
    public void googleURL() throws InterruptedException {

//
        Assert.assertEquals(driver.getTitle(), "Google"); //svi moraju da prodju assertioon tests
        driver.findElement(By.name("q")).click();
        System.out.println("Kraj");

        //Assertion Error
        //Renderer
        //NoSuchElementExeption
        //Wait greska
        //Drugi test posle se izvrsava osim ovih u metodi
    }

//    @AfterMethod
//    public void after(){
//        System.out.println("After method");
//    }
//
    @AfterClass
    public void afterClass() throws InterruptedException { //konfiguracija drajvera

        Thread.sleep(5000);
        this.driver.quit();
    }
}
