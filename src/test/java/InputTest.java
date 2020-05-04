import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.CapabilitiesGenerator;

import java.util.concurrent.TimeUnit;

public class InputTest {
    @Test
    void InputTest() {
        // System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.get("http://the-internet.herokuapp.com/inputs");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement element = driver.findElement(By.xpath("//div[@class='example']//input"));
        element.sendKeys("some text input to check"); // CTRL V selenium check for
        element.clear();
//        element.getText();
//        element.getAttribute("value");
//        element.getAttribute("class");

        driver.quit();
    }
}
