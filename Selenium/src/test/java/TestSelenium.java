import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.WebElement.*;

public class TestSelenium {


    @Test
    public void FindByCssSelector() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rozetka.com.ua//");
        WebElement inputField = driver.findElement(By.cssSelector("body > app-root > div > div > rz-header > header > div > div > div > form > div > div > input"));
        inputField.sendKeys("test");
        driver.findElement(By.cssSelector("body > app-root > div > div > rz-header > header > div > div > div > form > button")).click();
        driver.close();
    }

    @Test
    public void FindByXpath() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/");
        WebElement inputField = driver.findElement(By.xpath("//rz-user/button"));
        inputField.click();
        WebElement wait = new WebDriverWait(driver,10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"auth_email\"]")));
        WebElement login = driver.findElement(By.xpath("//*[@id=\"auth_email\"]"));
        login.sendKeys("test@gmail.com");
        driver.close();

    }

    @Test
    public void TestByID() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/");
        WebElement elementwait = new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("fat-menu")));
        WebElement category = driver.findElement(By.id("fat-menu"));
        category.click();
        driver.close();
    }

    @Test
    public void TestByClassName() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/");
        WebElement tabOpen = driver.findElement(By.className("header__button"));
        tabOpen.click();
        WebElement e = new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cdk-overlay-0\"]/nav/div/div[2]/ul[2]/li[2]/div[1]/rz-lang/ul/li[2]/a")));
        WebElement langchange = driver.findElement(By.xpath("//*[@id=\"cdk-overlay-0\"]/nav/div/div[2]/ul[2]/li[2]/div[1]/rz-lang/ul/li[2]/a"));
        langchange.click();
        driver.close();

    }

    @Test
    public void TestByLinkText() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rozetka.com.ua/");
        WebElement category = driver.findElement(By.id("fat-menu"));
        category.click();
        WebElement findcategory = driver.findElement(By.linkText("Ноутбуки и компьютеры"));
        findcategory.click();
        driver.close();
    }

    @Test
    public void TestByTagName() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/");
        WebElement category = driver.findElement(By.tagName("fat-menu"));
        driver.close();
    }

    @Test
    public void TestByPartialLinkText() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/");
        WebElement category = driver.findElement(By.id("fat-menu"));
        category.click();
        WebElement find = driver.findElement(By.partialLinkText("Ноутбуки и компьютеры"));
        driver.close();

    }

    @Test
    public void TestByName() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/");
        WebElement search = driver.findElement(By.name("search"));
        search.click();
    }

}


