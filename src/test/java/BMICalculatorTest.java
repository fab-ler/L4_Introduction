import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.CapabilitiesGenerator;

import static org.testng.Assert.assertEquals;

public class BMICalculatorTest {

    @Test(description = "Check Normal Weight Category")
    public void categoryTest1() {
        //    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("82");
        driver.findElement(By.name("ht")).sendKeys("185");
        driver.findElement(By.name("cc")).click();
        String category = driver.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Normal", "Категория верная");
        driver.quit();
    }

    @Test(description = "Check Obese Weight Category")
    public void categoryTest2() {
        //    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("140");
        driver.findElement(By.name("ht")).sendKeys("185");
        driver.findElement(By.name("cc")).click();
        driver category = driver.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Obese", "Категория верная");
        driver.quit();
    }


    @Test(description = "Check Underweight Category")
    public void categoryTest3() {
        //    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("30");
        driver.findElement(By.name("ht")).sendKeys("185");
        driver.findElement(By.name("cc")).click();
        String category = driver.findElement(By.name("desc")).getAttribute("value");
        assertEquals(category, "Your category is Starvation", "Категория верная");
        driver.quit();
    }
/*
    @Test
    public void lesson6() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //further refer to https://chromedriver.chromium.org/capabilities
        ChromeOptions options = new ChromeOptions();
        //       options.addArguments("--headless");
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(1024, 768));
        //поиск элементов будет ожидать МАКСИМУМ 10 секунд до появления элемента, если элемент не появился, текст упадет с NoSuchElementException
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //пример навигации
//        driver.navigate().refresh();
//        driver.navigate().back();
        //getWindowHandle method
//        String currentWindow = chrome.getWindowHandle();
        //frame and alerts require switchTo
        //сначала переключаемся на этот элемент, потом пытаемся найти тег <p>  с нужным текстом (не забыть обратно вернуться)
        driver.switchTo().frame(chrome.findElement(By.id("mce_0_ifr")));
        driver.findElement(By.xpath("//p[contains(text(),'Your content goes here.')]")).sendKeys("My Text");
        //вернуться назад из iframe
        driver.switchTo().defaultContent();
//        driver.switchTo().window(currentWindow);


        //работа с алертами  - они бывают трех типов (есть которые можно закрыть
        Alert alert = chrome.switchTo().alert();
        alert.getText(); // И уже ассертить полученный текст
        alert.dismiss(); // закрыть алерт (close btn click)
                //второй тип алертом - нажать ОК and for cancel use dismiss
        alert.accept();
        alert.sendKeys(""); //если надо в алерте отправить текст в поле

        WebElement element = chrome.findElement(By.id("mce_0_ifr"));
        driver.quit();
    }
*/
}
