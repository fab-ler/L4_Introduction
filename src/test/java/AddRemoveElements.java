import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddRemoveElements {
    @Test
    void FindElementsTestExample() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver chrome = new ChromeDriver();
        chrome.get("http://the-internet.herokuapp.com/add_remove_elements/");
        chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        List<WebElement> elements = chrome.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        //посчитаем кол-во элементов и проверим ассертом, что изначально кнопок нет:
        assertEquals(elements.size(), 0, "кнопка delete доступна, хотя ее быть не должно");
        //кликнем на кнопку add element чтобы появились кнопки delete
        chrome.findElement(By.xpath("//*[@onclick='addElement()']")).click();
        //перезапишем массиви еще раз поищем элементы
        elements = chrome.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        assertEquals(elements.size(), 1, "должна быть доступна только одна кнопка");

        chrome.findElement(By.xpath("//*[@onclick='addElement()']")).click();
        elements = chrome.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        assertEquals(elements.size(), 2, "должна быть доступна 2 кнопки");

        //проверим удалеие 2й кнопки
        elements.get(1).click();
        //повторно ищем и проверяем что осталось 1 кнопка
        elements = chrome.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        assertEquals(elements.size(), 1, "должна быть доступна только одна кнопка");

        /*
        //можно через for each
        for(WebElement el: elements) {
            el.click();
        }
        for(int i=0; i<elements.size(); i++) {
            elements.get(i).click();
        }
        */

        // если хочу проверить что есть элемент с каким-то текстом?
        //пройдемся по коллекции и найдем нужный элемент с нужным текстом
        /*
        boolean isFound = false;
        for(WebElement el: elements) {
            if(el.getText() == "тот текст, что я ищу") {
                isFound = true;
                break;
            }
        }
        assertTrue(isFound, "текст найден");
        */

        //либо ищем текст по xpath и сделаем assetTrue что размер коллекции больше 0

        boolean isFound = false;
        for (WebElement el : elements) {
            if (el.getText() == "тот текст, что я ищу") {
                isFound = true;
                break;
            }
        }
        elements = chrome.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        assertTrue(elements.size() > 0, "все ок");

        chrome.quit();
    }
}
