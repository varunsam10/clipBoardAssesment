import PageObject.Amazon;
import org.testng.annotations.Test;

public class TC_Amazon_001 extends BaseClass{

    @Test
    public void searchTV() throws InterruptedException {
        driver.get(baseURL);
        Amazon az = new Amazon(driver);
        az.clickHamburgerBtn();
        az.clickTVOptionFromCategory();
        az.sortHighToLowOption();
        az.selectTheSecondHighestItem();
    }
}
