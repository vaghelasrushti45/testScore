
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.pages.BasePage;
import org.testng.Assert;

import java.time.Duration;

public class LeaguePage extends BasePage {

    @AndroidFindBy(id = "league_title_id")
    private MobileElement leagueTitle;

    @AndroidFindBy(id = "sub_tab_id")
    private MobileElement subTab;

    public LeaguePage(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public void openLeaguePage() {
        MobileElement league = driver.findElementById("league_id");
        league.click();
    }

    public void verifyPageOpensCorrectly() {
        Assert.assertTrue(leagueTitle.isDisplayed(), "League page did not open correctly");
    }

    public void tapOnSubTab() {
        subTab.click();
    }

    public void verifyCorrectTabAndData() {
        Assert.assertTrue(isOnCorrectTab(), "Incorrect tab is open");
    }

    public void verifyBackNavigation() {
        driver.navigate().back();
        Assert.assertTrue(leagueTitle.isDisplayed(), "Back navigation did not return to the previous page");
    }

    private boolean isOnCorrectTab() {
        return uniqueElementForCorrectTab.isDisplayed();
    }
}
