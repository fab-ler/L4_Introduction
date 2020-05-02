import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class InputTest {
    @Test
    void InputTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver chrome = new ChromeDriver();
        chrome.get("http://the-internet.herokuapp.com/inputs");
        chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement element = chrome.findElement(By.xpath("//div[@class='example']//input"));
        element.sendKeys("some text input to check"); // CTRL V selenium check for
        element.clear();
//        element.getText();
//        element.getAttribute("value");
//        element.getAttribute("class");
    }
}
