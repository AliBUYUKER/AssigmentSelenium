package _04_Assigment;

import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _04 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        WebElement calculate=driver.findElement(By.id("calculate"));
        calculate.click();

        WebElement input=driver.findElement(By.id("number1"));
        input.sendKeys("5");

        WebElement input2=driver.findElement(By.id("number2"));
        input2.sendKeys("5");

        WebElement clicCalculate= driver.findElement(By.id("calculate"));
        clicCalculate.click();

        WebElement answer=driver.findElement(By.id("answer"));
        System.out.println("answer.getText() = " + answer.getText());

        MyFunc.Bekle(5);
        driver.quit();
    }
}
