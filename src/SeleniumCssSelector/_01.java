package SeleniumCssSelector;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _01 extends BaseDriver {
    @Test
    public void Test1() {
        driver.get("http://demoqa.com/text-box");
        WebElement fullName = driver.findElement(By.cssSelector("[placeholder='Full Name']"));
        fullName.sendKeys("Automation");
        WebElement email = driver.findElement(By.cssSelector("[placeholder='name@example.com']"));
        email.sendKeys("Testing@gmail.com");
        WebElement current = driver.findElement(By.cssSelector("div>[placeholder='Current Address']"));
        current.sendKeys("Testing Current Address");
        WebElement parametre = driver.findElement(By.cssSelector("div>[id='permanentAddress']"));
        parametre.sendKeys("Testing Permanent Address");
        WebElement submit = driver.findElement(By.cssSelector("div>[id='submit']"));
        submit.click();
        WebElement resultName = driver.findElement(By.cssSelector("div[class='border col-md-12 col-sm-12']>[id='name']"));
        Assert.assertTrue("Hatalı sonuç", resultName.getText().contains("Automation"));
        WebElement resultEmail = driver.findElement(By.cssSelector("div[class='border col-md-12 col-sm-12']>[id='email']"));
        Assert.assertTrue("Hatalı sonuç", resultEmail.getText().contains("Testing"));
        //driverBekleKapat();
    }

    @Test
    public void Test2() {
        driver.get("https://demo.applitools.com/");
        WebElement userName = driver.findElement(By.cssSelector("[id='username']"));
        userName.sendKeys("ttechno@gmail.com");
        WebElement password = driver.findElement(By.cssSelector("[id='password']"));
        password.sendKeys("techno123");
        WebElement submit = driver.findElement(By.cssSelector("[id='log-in']"));
        submit.click();
        WebElement result = driver.findElement(By.cssSelector("[id='time']"));
        Assert.assertTrue("Hatalı sonuç", result.getText().equals("Your nearest branch closes in: 30m 5s"));
       // driverBekleKapat();
    }

    @Test
    public void Test3() {
        driver.get("https://www.snapdeal.com/");
        WebElement search = driver.findElement(By.cssSelector("[id='inputValEnter']"));
        search.sendKeys("teddy bear");
        WebElement searchClick = driver.findElement(By.cssSelector("[class='searchTextSpan']"));
        searchClick.click();
        WebElement result = driver.findElement(By.cssSelector("[class='search-result-txt-section  marT12']"));
        Assert.assertTrue("Hatalı sonuç", result.getText().contains("results for teddy bear"));
       // driverBekleKapat();
    }

    @Test
    public void Test4() {
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement calculate = driver.findElement(By.cssSelector("[id='calculatetest']"));
        calculate.click();
        WebElement input1 = driver.findElement(By.cssSelector("[id='number1']"));
        input1.sendKeys("5");
        WebElement input2 = driver.findElement(By.cssSelector("[id='number2']"));
        input2.sendKeys("5");
        WebElement cal = driver.findElement(By.cssSelector("[id='calculate']"));
        cal.click();
        WebElement answer = driver.findElement(By.cssSelector("[id='answer']"));
        Assert.assertTrue("Hatalı Sonuç", answer.getText().equals("10"));
        //driverBekleKapat();
    }

    @Test
    public void Test5() {
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement alert = driver.findElement(By.cssSelector("[id='fakealerttest']"));
        alert.click();
        WebElement fake = driver.findElement(By.cssSelector("[id='fakealert']"));
        fake.click();
        WebElement ok = driver.findElement(By.cssSelector("[id='dialog-ok']"));
        ok.click();
        //driverBekleKapat();
    }

    @Test
    public void Test6() {
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement alert = driver.findElement(By.cssSelector("[id='fakealerttest']"));
        alert.click();
        WebElement showModal = driver.findElement(By.cssSelector("[id='modaldialog']"));
        showModal.click();
        WebElement ok = driver.findElement(By.cssSelector("[id='dialog-ok']"));
        ok.click();
       driverBekleKapat();
    }
}
