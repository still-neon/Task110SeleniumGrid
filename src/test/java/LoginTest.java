import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;

public class LoginTest {

    private WebDriver driver;
    private String TITLE = "Mail.Ru: почта, поиск в интернете, новости, игры";

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capability = DesiredCapabilities.firefox();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
    }

    @Test
    public void login() throws Exception{

        driver.get("https://mail.ru/");
        assertEquals(driver.getTitle(), TITLE);

    }
}