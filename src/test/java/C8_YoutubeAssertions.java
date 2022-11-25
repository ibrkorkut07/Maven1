import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C8_YoutubeAssertions {
    // https://www.youtube.com adresine gidin
    // titleTest => Sayfa başlığının YouTube ” oldugunu test edin
    // imageTest => YouTube resminin görüntülendiğini isDisplayed()) test edin
    //      Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    // wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        driver.manage().window().maximize();
        // https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");
        driver.findElement(By.xpath("(//div[@class='yt-spec-touch-feedback-shape__fill'])[11]")).click();
    }

    // titleTest => Sayfa başlığının "YouTube" oldugunu test edin
    @Test
    public void titleTest() {
        Assert.assertTrue(driver.getTitle().equals("YouTube"));
    }

    // imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    @Test
    public void imageTest() {

        Assert.assertTrue(driver.findElement(By.xpath("(//a[@id='logo'])[1]")).isDisplayed());
        // Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='search']")).isEnabled());
    }

    // wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    @Test
    public void wrongTitleTest() {
        Assert.assertFalse(driver.getTitle().equals("youtube"));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
