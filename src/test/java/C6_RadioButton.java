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

public class C6_RadioButton {

    // https://www.facebook.com adresine gidin
    // Cookies’i kabul edin
    // "Create an Account" button’una basin
    // "radio buttons" elementlerini locate edin
    // Secili degilse cinsiyet butonundan size uygun olani secin

    static WebDriver driver;
    static WebElement radiobuttonFemale;
    static WebElement radiobuttonMale;
    static WebElement radiobuttonCustom;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("(//button[@value='1'])[3]")).click();
        driver.findElement(By.linkText("Create new account")).click();

    }

    @Test
    public void radioButtonTest() throws InterruptedException {
        radiobuttonFemale = driver.findElement(By.xpath("//input[@value='1']"));
        radiobuttonMale = driver.findElement(By.xpath("//input[@value='2']"));
        radiobuttonCustom = driver.findElement(By.xpath("//input[@value='-1']"));
        radiobuttonMale.click();
        Assert.assertTrue(radiobuttonMale.isSelected());
        Thread.sleep(3333);
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }
}
