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

public class C5_CheckBoxTest {

    // https://the-internet.herokuapp.com/checkboxes web sayfasına gidin.
    // Checkbox1 ve checkbox2 elementlerini locate edin.
    // Checkbox1 seçili değilse onay kutusunu tıklayın
    // Checkbox2 seçili değilse onay kutusunu tıklayın
    static WebDriver driver;
    static WebElement checkbox1Element;
    static WebElement checkbox2Element;

    @BeforeClass
    public static void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    public void checkbox1Test() {
        checkbox1Element= driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        if (!checkbox1Element.isSelected()) {
            checkbox1Element.click();
        }
    }

    @Test
    public void checkbox2Test() {
        checkbox2Element = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        if (!checkbox2Element.isSelected()) {
            checkbox2Element.click();
        }
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}