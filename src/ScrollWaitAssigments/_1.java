package ScrollWaitAssigments;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;

public class _1 extends BaseDriver {
    @Test
    public void Test1() {
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");

        for (int i = 0; i < 4; i++) {
            System.out.println("i = " + i);
            WebElement firstNamber = driver.findElement(By.xpath("//input[@name='number1']"));
            MyFunc.ilk = MyFunc.randomNumber();
            System.out.println("MyFunc.ilk = " + MyFunc.ilk);
            firstNamber.sendKeys("" + MyFunc.ilk + "");
            WebElement secondNamber = driver.findElement(By.xpath("//input[@name='number2']"));
            MyFunc.ikinci = MyFunc.randomNumber();
            System.out.println("MyFunc.iki = " + MyFunc.ikinci);
            secondNamber.sendKeys("" + MyFunc.ikinci + "");
            WebElement operation = driver.findElement(By.xpath("//select[@name='selectOperation']/option[@value='" + i + "']"));
            operation.click();
            WebElement calculataeButton = driver.findElement(By.xpath("//input[@id='calculateButton']"));
            calculataeButton.click();
            WebElement tik = driver.findElement(By.xpath("//input[@name='intSelection']"));
            tik.click();
            WebElement answer = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
            MyFunc.Bekle(2);
            System.out.println(answer.getAttribute("value"));
            System.out.println("MyFunc.asert(i, MyFunc.ilk, MyFunc.ikinci) = " + MyFunc.asert(i, MyFunc.ilk, MyFunc.ikinci));

            Assert.assertTrue("Hatalı sonuç", answer.getAttribute("value").equals(MyFunc.asert(i, MyFunc.ilk, MyFunc.ikinci)));

            MyFunc.Bekle(2);
            robot.keyPress(KeyEvent.VK_F5);
            robot.keyRelease(KeyEvent.VK_F5);
        }
        driverBekleKapat();
    }

    @Test
    public void Test2() {
        driver.get("https://www.youtube.com/");
        WebElement search = driver.findElement(By.xpath("//input[@id='search']"));
        search.sendKeys("Selenium");
        WebElement buttonSearch = driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
        buttonSearch.click();

        List<WebElement> titles = driver.findElements(By.xpath("//div[@class='style-scope ytd-item-section-renderer'and@id='contents']/*[@lockup=\"true\"]"));
        do {
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            titles.addAll(driver.findElements(By.xpath("//div[@class='style-scope ytd-item-section-renderer'and@id='contents']/*[@lockup=\"true\"]")));
            while (titles.size()>80)
                titles.remove(titles.size()-1);
        }while (titles.size()<80);
        System.out.println("titles.size() = " + titles.size());
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        titles.get(79).click();
        //MyFunc.Bekle(4);
        wait.until(ExpectedConditions.urlContains("watch"));
        System.out.println(" = " +driver.getTitle());
        driverBekleKapat();
    }

    @Test
    public void Test3() {
        driver.get("https://www.google.com.tr/?hl=tr");
        // MyFunc.Bekle(2);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_T);
        StringSelection selection=new StringSelection("https://tr-tr.facebook.com/");
        Clipboard clipboard= Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection,selection);
        MyFunc.Bekle(2);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Set<String> windowIdler=driver.getWindowHandles();
        System.out.println(windowIdler.size());
        for (String id:windowIdler){
            if (driver.switchTo().window(id).getCurrentUrl().contains("facebook")){
                driver.close();
            }}
        driverBekleKapat();
    }

    @Test
    public void Test4() {
        driver.get(" https://demoqa.com/browser-windows");
        WebElement alerts = driver.findElement(By.xpath("//span[text()='Alerts']"));
        alerts.click();
        WebElement clickMe = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
        clickMe.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue("Hatalı mesaj", driver.switchTo().alert().getText().equals("This alert appeared after 5 seconds"));
        driver.switchTo().alert().accept();
        driverBekleKapat();
    }

    @Test
    public void Test5() {
        driver.get("https://demoqa.com/dynamic-properties");
        WebElement button = driver.findElement(By.xpath("//button[.='Will enable 5 seconds']"));
        Assert.assertFalse("Hatalı button", button.isEnabled());
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.='Will enable 5 seconds']")));
        Assert.assertTrue("Hatalı button", button.isEnabled());
        button.click();
        driverBekleKapat();
    }

    @Test
    public void Test6() {
        driver.get("https://demoqa.com/dynamic-properties");
        WebElement button = driver.findElement(By.xpath("//button[.='Will enable 5 seconds']"));
        Assert.assertTrue("Hatalı button", button.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.='Will enable 5 seconds']")));
        Assert.assertTrue("Hatalı button", button.isDisplayed());
        button.click();
        driverBekleKapat();
    }

    @Test
    public void Test7() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/ ");
        WebElement addElement = driver.findElement(By.xpath("//button[.='Add Element']"));
        addElement.click();
        MyFunc.Bekle(1);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.='Delete']")));
        WebElement delete = driver.findElement(By.xpath("//div[@id=\"elements\"]/button"));
        Assert.assertTrue("Hatalı buton", delete.isDisplayed());
        MyFunc.Bekle(1);
        delete.click();
        Assert.assertFalse("Hatalı buton", delete.isSelected());
        driverBekleKapat();
    }
}
