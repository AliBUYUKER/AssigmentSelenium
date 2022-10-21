package _01_Assigment;


import Utility.MyFunc;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _01 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://demoqa.com/text-box");

        WebElement fullName=driver.findElement(By.id("userName"));
        fullName.sendKeys("Automation");

        WebElement email=driver.findElement(By.id("userEmail"));
        email.sendKeys("Testing@gmail.com");

        WebElement current=driver.findElement(By.id("currentAddress"));
        current.sendKeys("Testing Current Address");

        WebElement permanent=driver.findElement(By.id("permanentAddress"));
        permanent.sendKeys("Testing Permanent Address");

        WebElement submit= driver.findElement(By.id("submit"));
        submit.click();

        WebElement nameHere=driver.findElement(By.id("name"));
        System.out.println("nameHere.getText().contains(\"Automation\") = " + nameHere.getText().contains("Automation"));

        WebElement mailHere=driver.findElement(By.id("email"));
        System.out.println("mailHere.getText().contains(\"Testing\") = " + mailHere.getText().contains("Testing"));

        MyFunc.Bekle(5);
        driver.quit();



    }
}
