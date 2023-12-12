
import com.example.config.AppiumConfig;
import com.example.pages.LeaguePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TheScoreAppTest {
    private AppiumDriver<MobileElement> driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        driver = new AndroidDriver<>(new URL(AppiumConfig.APPIUM_SERVER_URL), AppiumConfig.getCapabilities());
    }

    @Test
    public void testTheScoreApp() {
        LeaguePage leaguePage = new LeaguePage(driver);
        leaguePage.openLeaguePage();
        leaguePage.verifyPageOpensCorrectly();
        leaguePage.tapOnSubTab();
        leaguePage.verifyCorrectTabAndData();
        leaguePage.verifyBackNavigation();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
