package Utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.junit.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {
    public static WebDriver driver;
    public static JavascriptExecutor js;
    public static Actions actions;
    public static Robot robot;
    public static WebDriverWait wait;

    static
    {
        //ilk adımda çalışan kod kısmı
        KalanOncekileriKapat();
        Logger logger= Logger.getLogger(""); // sisteme ait bütün logları üreten objeye/servise ulaştım ""
        logger.setLevel(Level.SEVERE); // Sadece errorları göster

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");  // ChromeServici sessiz modda çalıştır
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();   // web sayfasını kontrol eden görevli
        actions=new Actions(driver);
        js=(JavascriptExecutor)driver;
        try {
            robot=new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        driver.manage().window().maximize();
        driver.manage().window().setPosition(new Point(2000,0));
        //driver.manage().window().maximize();  // Ekranı max yapıyor.
        driver.manage().deleteAllCookies();  // sitenin senin bilgisayarında yaptığı ayarlar siliniyor, sayfa başlangıç ayarlarına dönüyor

        Duration dr=Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr); // Sadece tüm sayfanın kodlarının bilgisyarınıza inmesi süresiyle ilgili
        //bu eklenmezse Selenium sayfa yüklenene kadar (sonsuza) bekler.: 30 sn süresince sayfanın yüklenmesini bekle yüklenmezse hata ver
        // eğer 2 sn yüklerse 30 sn. beklemez.
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(dr); // Bütün weblementlerin element bazında, elemente özel işlem yapılmadan önce
        // hazır hale gelmesi verilen mühlet yani süre. // eğer 2 sn yüklerse 30 sn. beklemez.
    }

    public static void driverBekleKapat()
    {
        MyFunc.Bekle(5);
        driver.close();
    }
    public static void KalanOncekileriKapat() {

        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (Exception ignored) {

        }
    }

    public static void muzikYukleniyor() throws InterruptedException {
        System.out.println("Müzik yukleniyor");
        String[]renkler=new String[11];
        renkler[0]="\u001B[41m";
        renkler[1]="\u001B[42m";
        renkler[2]="\u001B[43m";
        renkler[3]="\u001B[44m";
        renkler[4]="\u001B[45m";
        renkler[5]="\u001B[46m";
        renkler[6]="\u001B[41m";
        renkler[7]="\u001B[42m";
        renkler[8]="\u001B[43m";
        renkler[9]="\u001B[44m";
        renkler[10]="\u001B[45m";

        String M = "    ";
        for (int i = 0; i <= 10; i++) {
            Thread.sleep(1000);
            System.out.print("\r" + renkler[i]+ M + "\033[0m" + " % " + (i * 10));
            M = M.concat("    ");
        }
        System.out.println();
    }
    public static void UygulamaYukleniyor() throws InterruptedException {
        System.out.println("Rapor yukleniyor");
        String[]renkler=new String[11];
        renkler[0]="\u001B[41m";
        renkler[1]="\u001B[42m";
        renkler[2]="\u001B[43m";
        renkler[3]="\u001B[44m";
        renkler[4]="\u001B[45m";
        renkler[5]="\u001B[46m";
        renkler[6]="\u001B[41m";
        renkler[7]="\u001B[42m";
        renkler[8]="\u001B[43m";
        renkler[9]="\u001B[44m";
        renkler[10]="\u001B[45m";

        String M = "    ";
        for (int i = 0; i <= 10; i++) {
            Thread.sleep(1000);
            System.out.print("\r" + renkler[i]+ M + "\033[0m" + " % " + (i * 10));
            M = M.concat("    ");
        }
        System.out.println();
    }






}
