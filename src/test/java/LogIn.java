import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.File;
import static java.util.concurrent.TimeUnit.SECONDS;

public class LogIn {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @Test
    public void login() throws Exception{

        driver.get("https://192.168.100.26/");

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(scrFile, new File("D:\\screenshot.png"));

        WebElement username = driver.findElement(By.xpath(".//*[@id='Username']"));
        WebElement password = driver.findElement(By.xpath(".//*[@id='Password']"));
        WebElement button = driver.findElement(By.xpath(".//*[@id='SubmitButton']"));

        username.sendKeys("EugenBorisik");
        password.sendKeys("qwerty12345");
        button.submit();

        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        WebElement linkText = driver.findElement(By.xpath("//ins[text()='Sign Out']"));

        Assert.assertEquals("Sign Out",linkText.getText());
    }
}