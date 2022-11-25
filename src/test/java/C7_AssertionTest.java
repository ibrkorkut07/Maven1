import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C7_AssertionTest {

    // https://www.bestbuy.com/ Adresine gidin
    // urlTest => Sayfa URL’inin https://www.bestbuy.com/ 'a esit oldugunu test edin
    // titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    // logoTest => BestBuy logosunun görüntülendigini test edin
    // Francais LinkTest => Fransizca Linkin görüntülen diğini test edin

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        driver.manage().window().maximize();
        driver.get("https://www.bestbuy.com/");
    }

    // urlTest => Sayfa URL’inin https://www.bestbuy.com/ 'a esit oldugunu test edin
    @Test
    public void urlTest() {
        String actualUrl = driver.getCurrentUrl();
        String expUrl = "https://www.bestbuy.com/";
        Assert.assertEquals(expUrl, actualUrl);
    }

    // titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    @Test
    public void titleTest() {
        Assert.assertFalse(driver.getTitle().contains("Rest"));
    }

    // logoTest => BestBuy logosunun görüntülendigini test edin
    @Test
    public void logoTest() {
        Assert.assertTrue(driver.findElement(By.xpath("(//img[@class='logo'])[1]")).isDisplayed());
    }

    // Canada LinkTest => Canada (Fransizca) Linkin görüntülendiğini test edin
    @Test
    public void linkTest() {
        Assert.assertTrue(driver.findElement(By.xpath("(//a[@class='canada-link'])[1]")).isDisplayed());
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
