import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utils.CapabilitiesGenerator;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class SelectTest {
    @Test
    void InputTest() {
        // System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.get("http://the-internet.herokuapp.com/dropdown");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Select select = new Select(driver.findElement(By.id("dropdown")));
        List<WebElement> options = select.getOptions();
//        assertEquals(options.get(0).getText(), 0, "Please select an option");
//        assertEquals(options.get(1), 1, "Option 1");
//        assertEquals(options.get(2), 2, "Option 2");
        select.selectByVisibleText("Option 1");
        assertEquals(select.getFirstSelectedOption().getText(), "Option 1", "Option 1 is not selected");
        //либо так написать
        // options.get(1).isSelected();
        driver.quit();
    }
}
