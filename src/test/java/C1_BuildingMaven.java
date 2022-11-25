import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C1_BuildingMaven {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        // https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");
        // arama kutusunu locate edelim
        // “Samsung headphones” ile arama yapalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Samsung headphones" + Keys.ENTER);

        // Bulunan sonuc sayisini yazdiralim
        System.out.println(driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]")).getText());
        // Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[5]")).click();
        // Sayfadaki tum basliklari yazdiralim
        System.out.println(driver.findElement(By.xpath("//div[@id='navbar']")).getText());
        driver.quit();
    }
}
