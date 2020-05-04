import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class BMICalculatorTest {

    @Test(description = "Check Normal Weight Category")
    public void categoryTest1() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("82");
        browser.findElement(By.name("ht")).sendKeys("185");
        browser.findElement(By.name("cc")).click();
        String category = browser.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Normal", "Категория верная");
        browser.quit();
    }

    @Test(description = "Check Obese Weight Category")
    public void categoryTest2() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("140");
        browser.findElement(By.name("ht")).sendKeys("185");
        browser.findElement(By.name("cc")).click();
        String category = browser.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Obese", "Категория верная");
        browser.quit();
    }


    @Test(description = "Check Underweight Category")
    public void categoryTest3() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("30");
        browser.findElement(By.name("ht")).sendKeys("185");
        browser.findElement(By.name("cc")).click();
        String category = browser.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Starvation", "Категория верная");
        browser.quit();
    }

    @Test
    public void lesson6() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //further refer to https://chromedriver.chromium.org/capabilities
        ChromeOptions options = new ChromeOptions();
        //       options.addArguments("--headless");
        options.addArguments("--start-maximized");
        WebDriver chrome = new ChromeDriver();
        chrome.manage().window().maximize();
        chrome.manage().window().setSize(new Dimension(1024, 768));
        //поиск элементов будет ожидать МАКСИМУМ 10 секунд до появления элемента, если элемент не появился, текст упадет с NoSuchElementException
        chrome.get("http://the-internet.herokuapp.com/iframe");
        chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //пример навигации
//        chrome.navigate().refresh();
//        chrome.navigate().back();
        //getWindowHandle method
//        String currentWindow = chrome.getWindowHandle();
        //frame and alerts require switchTo
        //сначала переключаемся на этот элемент, потом пытаемся найти тег <p>  с нужным текстом (не забыть обратно вернуться)
        chrome.switchTo().frame(chrome.findElement(By.id("mce_0_ifr")));
        chrome.findElement(By.xpath("//p[contains(text(),'Your content goes here.')]")).sendKeys("My Text");
        //вернуться назад из iframe
        chrome.switchTo().defaultContent();
//        chrome.switchTo().window(currentWindow);

/*
        //работа с алертами  - они бывают трех типов (есть которые можно закрыть
        Alert alert = chrome.switchTo().alert();
        alert.getText(); // И уже ассертить полученный текст
        alert.dismiss(); // закрыть алерт (close btn click)
                //второй тип алертом - нажать ОК and for cancel use dismiss
        alert.accept();
        alert.sendKeys(""); //если надо в алерте отправить текст в поле

 */
        WebElement element = chrome.findElement(By.id("mce_0_ifr"));
        chrome.quit();
    }
}
