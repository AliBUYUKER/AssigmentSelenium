package _02_Assigment;


import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Map;

public class _02 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.applitools.com/");
        String[] id = new String[2];
        id[0] = "username";
        id[1] = "password";
        String[] giris = new String[2];
        giris[0] = "ttechno@gmail.com";
        giris[1] = "techno123";
        for (int i = 0; i < id.length; i++) {
            WebElement deneme = driver.findElement(By.id(id[i]));
            deneme.sendKeys(giris[i]);
        }
        WebElement submit = driver.findElement(By.className("btn"));
        submit.click();

        WebElement text = driver.findElement(By.id("time"));
        System.out.println("text.getText().contains() = " + text.getText().contains("Your nearest branch closes in: 30m 5s"));

        MyFunc.Bekle(5);
        driver.quit();


    }
}
