package _03_Assigment;

import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _03 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.snapdeal.com/");

        WebElement search=driver.findElement(By.id("inputValEnter"));
        search.sendKeys("teddy bear");
        
        WebElement searchFind=driver.findElement(By.className("sd-icon-search-under-catagory"));
        searchFind.click();
    
        WebElement sonuc=driver.findElement(By.className("nnn"));
        System.out.println("sonuc.getText().contains= " + sonuc.getText().contains("results for teddy bear"));

        MyFunc.Bekle(5);
        driver.quit();
    }
}
