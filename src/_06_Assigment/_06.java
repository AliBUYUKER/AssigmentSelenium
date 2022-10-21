package _06_Assigment;

import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _06 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        WebElement fakeAlerts = driver.findElement(By.id("fakealerttest"));
        fakeAlerts.click();

        WebElement showAlert= driver.findElement(By.id("modaldialog"));
        showAlert.click();

        WebElement ok = driver.findElement(By.className("dialog-button"));
        ok.click();

        MyFunc.Bekle(5);
        driver.quit();


    }
}
