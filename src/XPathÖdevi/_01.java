package XPathÖdevi;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _01 extends BaseDriver {
    @Test
    public void Test1(){
        driver.get("http://demoqa.com/text-box");
        WebElement fullname=driver.findElement(By.xpath("//*[@placeholder='Full Name']"));
        fullname.sendKeys("Automation");
        WebElement email=driver.findElement(By.xpath("//*[@placeholder='name@example.com']"));
        email.sendKeys("Testing@gmail.com");
        WebElement current= driver.findElement(By.xpath("//*[@placeholder='Current Address']"));
        current.sendKeys("Testing Current Address");
        WebElement parametre= driver.findElement(By.xpath("//*[@id='permanentAddress']"));
        parametre.sendKeys("Testing Permanent Address");
        WebElement submit= driver.findElement(By.xpath("//*[@class='btn btn-primary']"));
        submit.click();
        WebElement result1= driver.findElement(By.xpath("//*[@id='name']"));
        Assert.assertTrue(result1.getText().contains("Automation"));
        WebElement result2= driver.findElement(By.xpath("//*[@id='email']"));
        Assert.assertTrue(result2.getText().contains("Testing"));
        driverBekleKapat();
    }
    @Test
    public void Test2(){
       driver.get(" https://demo.applitools.com/");
       WebElement userName= driver.findElement(By.xpath("//*[@id='username']"));
       userName.sendKeys("ttechno@gmail.com");
       WebElement password= driver.findElement(By.xpath("//*[@id='password']"));
       password.sendKeys("techno123");
       WebElement sing=driver.findElement(By.xpath("//*[@id='log-in']"));
       sing.click();
       WebElement result=driver.findElement(By.xpath("//*[@id='time']"));
       Assert.assertTrue("Hatalı sonuç",result.getText().equals("Your nearest branch closes in: 30m 5s"));
       driverBekleKapat();
    }
    @Test
    public void Test3(){
        driver.get("https://www.snapdeal.com/");
        WebElement search= driver.findElement(By.xpath("//*[@id='inputValEnter']"));
        search.sendKeys("teddy bear");
        WebElement searchClick= driver.findElement(By.xpath("//*[@class='searchTextSpan']"));
        searchClick.click();
        WebElement result= driver.findElement(By.xpath("//*[@data-pagename='searchResult']"));
        Assert.assertTrue("Hatalı Sonuç",result.getText().contains("results for teddy bear"));
        driverBekleKapat();
    }
    @Test
    public void Test4(){
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement calculate= driver.findElement(By.xpath("//*[@id='calculatetest']"));
        calculate.click();
        WebElement input= driver.findElement(By.xpath("//*[@id='number1']"));
        input.sendKeys("5");
        WebElement input2= driver.findElement(By.xpath("//*[@id='number2']"));
        input2.sendKeys("5");
        WebElement hesap= driver.findElement(By.xpath("//*[@id='calculate']"));
        hesap.click();
        WebElement answer=driver.findElement(By.xpath("//*[@id='answer']"));
        Assert.assertTrue("Hatalı sonuç",answer.getText().equals("10"));
        driverBekleKapat();
    }
    @Test
    public void Test5(){
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement fakeAllerts=driver.findElement(By.xpath("//*[@id='fakealerttest']"));
        fakeAllerts.click();
        WebElement show= driver.findElement(By.xpath("//*[@id='fakealert']"));
        show.click();
        WebElement ok= driver.findElement(By.xpath("//*[@id='dialog-ok']"));
        ok.click();
        driverBekleKapat();
    }
    @Test
    public void Test6(){
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement fakeAllerts=driver.findElement(By.xpath("//*[@id='fakealerttest']"));
        fakeAllerts.click();
        WebElement modal=driver.findElement(By.xpath("//*[@id='modaldialog']"));
        modal.click();
        WebElement ok= driver.findElement(By.xpath("//*[@id='dialog-ok']"));
        ok.click();
        driverBekleKapat();
    }
}
