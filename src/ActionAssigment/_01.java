package ActionAssigment;

import Utility.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class _01 extends BaseDriver {
    @Test
    public void Odev1() {
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        Actions actions = new Actions(driver);
        List<WebElement> boxs = driver.findElements(By.xpath("//div[@class='dragableBox']"));
        ArrayList<String> citys = new ArrayList<>();
        for (WebElement e : boxs) {
            if (e.getAttribute("id").contains("box")) {
                citys.add(e.getAttribute("id"));
                System.out.println("e.getAttribute(\"id\") = " + e.getAttribute("id"));
            }
        }
        System.out.println("listBox = " + citys);
        List<WebElement> country = driver.findElements(By.xpath("//div[@class='dragableBoxRight']"));
        ArrayList<String> countryBoxs = new ArrayList<>();
        for (WebElement e : country) {
            if (e.getAttribute("id").contains("box")) {
                countryBoxs.add(e.getAttribute("id"));
                System.out.println("e.getAttribute(\"id\") = " + e.getAttribute("id"));
            }
        }
        System.out.println("countryBoxs = " + countryBoxs);

        for (int i = 0; i < citys.size(); i++) {
            for (int j = 0; j < citys.size(); j++) {
                WebElement cityss = driver.findElement(By.xpath("//div[@id='" + citys.get(i) + "']"));
                WebElement countrys = driver.findElement(By.xpath("//div[@id='" + countryBoxs.get(j) + "']"));
                actions.dragAndDrop(cityss, countrys).build().perform();
                WebElement boxsColor = driver.findElement(By.xpath("//div[@id='" + citys.get(i) + "']"));
                if (boxsColor.getCssValue("background").contains("rgb(0, 255, 0)")) {
                    break;
                }
            }
        }
        //driverBekleKapat();
    }
    @Test
    public void Odev2() throws InterruptedException {// //div[@id='q12']//following-sibling::div     //div[@id='"+countysBoxs.get(9)+"']//following-sibling::div
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-quiz/drag-drop-quiz-d2.html");
        Actions actions = new Actions(driver);
        List<WebElement> countrys = driver.findElements(By.xpath("//div[@class='dragDropSmallBox']"));
        ArrayList<String> countysBoxs = new ArrayList<>();
        ArrayList<String> citysBoxs = new ArrayList<>();
        for (WebElement e : countrys) {
            if (e.getAttribute("id").contains("q")) {
                System.out.println("e.getAttribute(\"id\") = " + e.getAttribute("id"));
                countysBoxs.add(e.getAttribute("id"));
            } else citysBoxs.add(e.getAttribute("id"));
        }
        for (int i = 0; i < citysBoxs.size(); i++) {
            for (int j = 0; j < citysBoxs.size(); j++) {
                WebElement cityss = driver.findElement(By.xpath("//div[@id='" + citysBoxs.get(i) + "']"));
                WebElement c = driver.findElement(By.xpath("//div[@id='" + countysBoxs.get(j) + "']//following-sibling::div"));
                Action aksiyon = actions.clickAndHold(cityss).build();
                aksiyon.perform();
                Thread.sleep(120);
                aksiyon = actions.moveToElement(c).release().build();
                aksiyon.perform();
                //WebElement boxsColor = driver.findElement(By.xpath("//div[@id='" + citysBoxs.get(i) + "']"));
                if (cityss.getCssValue("background").contains("rgb(0, 128, 0)")) {
                    countysBoxs.remove(j);
                    break;
                }
            }
        }
        // driverBekleKapat();
    }
    @Test
    public void Odev3() throws InterruptedException {
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-nodes/drag-drop-nodes.html");
        Actions actions = new Actions(driver);
        List<WebElement> cityss = driver.findElements(By.xpath("//div[@id='dhtmlgoodies_mainContainer']/div/ul"));
        ArrayList<String> boxs = new ArrayList<>();
        for (WebElement e : cityss) {
            boxs.add(e.getAttribute("id"));
        }
        System.out.println("citys = " + boxs);
        List<WebElement> countrys = driver.findElements(By.xpath("//ul[@id='allItems']/li"));
        ArrayList<String> students = new ArrayList<>();
        for (WebElement e : countrys) {
            students.add(e.getAttribute("id"));
        }
        System.out.println("countryss = " + students);
        for (int i = 0; i < students.size(); i++) {
            for (int j = 0; j < boxs.size(); j++) {
                WebElement cities = driver.findElement(By.xpath("//ul[@id='allItems']/li[@id='" + students.get(i) + "']"));
                WebElement cont = driver.findElement(By.xpath("//div[@id='dhtmlgoodies_mainContainer']/div/ul[@id='" + boxs.get(j) + "']"));
                Action aksiyon = actions.clickAndHold(cities).build();
                aksiyon.perform();
                Thread.sleep(250);
                aksiyon = actions.moveToElement(cont).release().build();
                aksiyon.perform();
                WebElement citiies = driver.findElement(By.xpath("//ul[@id='allItems']/li"));
                System.out.println("e.getAttribute(\"id\").contains(countryss.get(i)) = " + citiies.getAttribute("id").contains(students.get(i)));
                if ((!citiies.getAttribute("id").contains(students.get(i)))) {
                    break;
                }
            }

        }
        driverBekleKapat();
    }
    @Test
    public void Odev4() throws InterruptedException {
        // //ul[@id='allItems']/li[@id='node18']
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-nodes-quiz/drag-drop-nodes-quiz.html");
        Actions actions = new Actions(driver);
        List<WebElement> countrys = driver.findElements(By.xpath("//ul[@id='allItems']/li"));
        ArrayList<String> countysBoxs = new ArrayList<>();
        ArrayList<String> citysBoxs = new ArrayList<>();
        for (WebElement e : countrys) {
            if (e.getAttribute("id").contains("node")) {
                citysBoxs.add(e.getAttribute("id"));
            }
        }
        System.out.println("countysBoxs = " + citysBoxs);
        List<WebElement> citys = driver.findElements(By.xpath("//div[@id='dhtmlgoodies_mainContainer']/div/ul"));
        for (WebElement e : citys) {
            if (e.getAttribute("id").contains("box")) {
                System.out.println("e.getAttribute(\"id\") = " + e.getAttribute("id"));
                countysBoxs.add(e.getAttribute("id"));
            }
        }
        for (int i = 0; i < citysBoxs.size(); i++) {
            for (int j = 0; j < countysBoxs.size(); j++) {
                WebElement cityss = driver.findElement(By.id(citysBoxs.get(i)));
                WebElement countryys = driver.findElement(By.id(countysBoxs.get(j)));
                Action aksiyon = actions.clickAndHold(cityss).build();
                aksiyon.perform();
                Thread.sleep(120);
                aksiyon = actions.moveToElement(countryys).release().build();
                aksiyon.perform();
                /*WebElement boxsColor = driver.findElement(By.id(citysBoxs.get(i)));*/
                if (cityss.getCssValue("background").contains("rgb(0, 128, 0)")) {
                    break;
                }
            }
        }driver.switchTo().alert().accept();
         driverBekleKapat();
    }
}
