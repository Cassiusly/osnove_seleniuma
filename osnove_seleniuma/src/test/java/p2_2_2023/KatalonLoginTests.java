package p2_2_2023;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

//1.Zadatak
//Kreirati klasu KatalonLoginTests za testove
//Base url: https://cms.demo.katalon.com
//Test #1: Visit login page from Nav bar
//Koraci:
//Ucitati home stranicu
//Kliknuti na My account link
//Verifikovati da je naslov stranice My account – Katalon Shop
//Verifikovati da se u url-u stranice javlja /my-account
//Za sve validacije ispisati odgovarajuce poruke u slucaju greske

//Test #2: Check input types
//Koraci:
//Ucitati /my-account stranicu
//Verifikovati da  polje za unos email-a za atribu type ima vrednost text
//Verifikovati da polje za unos lozinke za atribut type ima vrednost password
//Verifikovati da checkbox Remember me za atribut type ima vrednost checkbox
//Verifikovati da je Remember me checkbox decekiran. Koristan link kako naci
// informaciu da li je checkbox cekiran ili ne.
//Za sve validacije ispisati odgovarajuce poruke u slucaju greske

//Test #3: Display error when credentials are wrong
//Podaci:
//email: invalidemail@gmail.com
//password: invalid123
//Koraci:
//Ucitati /my-account stranicu
//Unesite email
//Unesite password
//Kliknite na login dugme
//Verifikovati da postoji element koji prikazuje gresku
//Verifikovati da je prikazana greska ERROR: Invalid email address
//Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//Verifikovati da smo idalje na login stranici posle greske, tako sto
// proveravamo da se url-u javlja /my-account
public class KatalonLoginTests {

    WebDriver driver;
    WebDriverWait wait;

    String baseUrl = "https://cms.demo.katalon.com";
    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

    }
    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }
    @Test(priority = 20)
    @Description("TC-1 Visit login page from Nav bar")
    public void testVisitLoginPageFromNavBar(){

        driver.get(this.baseUrl);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//li[contains(@class, 'page-item-10')]")).click();
        String title = driver.getTitle();
        String url = driver.getCurrentUrl();

        Assert.assertEquals(title, "My account – Katalon Shop", "Incorrect page, not on my account page.");
        Assert.assertTrue(url.contains("/my-account"), "Incorrect URL.");
    }

    @Test
    @Description("TC-2 Check input types.")
    public void testCheckInpuTypes (){
        driver.get("https://cms.demo.katalon.com/my-account/");


        WebElement emailInput = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertEquals("text", emailInput.getAttribute("type"), "Email input is incorrect.");
        WebElement passwordInput = driver.findElement(By.xpath("//*[@type='password']"));
        Assert.assertEquals("password", passwordInput.getAttribute("type"), "Password input is incorrect.");
        WebElement rememberMeInput = driver.findElement(By.id("rememberme"));
        Assert.assertFalse(rememberMeInput.isSelected(), "Remember me is checked.");
    }
    @Test
    @Description("Display error when credentials are wrong")
    public void testDisplayErrorCredentialsWrong(){
        driver.get("https://cms.demo.katalon.com/my-account/");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("invalidemail@gmail.com");
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("invalid123");
        driver.findElement(By.name("login")).click();
        WebElement error = driver.findElement(By.className("woocommerce-error"));
        Assert.assertTrue(error.isDisplayed(), "ERROR: Invalid email address");
        Assert.assertTrue(driver.getCurrentUrl().contains("/my-account"), "Url doesn't contain /my-account");


    }


    @AfterClass
    public void afterClass() throws InterruptedException { //konfiguracija drajvera

        Thread.sleep(5000);
        this.driver.quit();
    }
}
