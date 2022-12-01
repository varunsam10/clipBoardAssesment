package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Set;

public class Amazon {
    WebDriver ldriver;
    public String actualMessage = "About this item\n" +
            "Resolution : 4K Ultra HD (3840 x 2160) Resolution || Refresh Rate : 100 Hertz\n" +
            "Connectivity: 4 HDMI ports to connect set top box || Blu-ray speakers or a gaming console || 2 USB ports to connect hard drives or other USB devices\n" +
            "Sound: 60 Watts Output - 4.2.2 Ch|| Powerful Speakers with Dolby Atmos || Surround Sound || Active Voice Amplifier || Adaptive Sound+\n" +
            "Smart TV Features : Mirroring || Tap View ||Multi-View || Music Wall || Mobile Camera Support || Wireless Dex || Auto Game Mode (ALLM) || Game Motion Plus || Dynamic Black EQ || Surround Sound || Super Ultra Wide Game View ||Mini Map Zoom || FreeSync Premium Pro || HGiG\n" +
            "Display: Matte Display || One Billion Color || PQI 4600 || 100% Colour Volume with Quantum Dot || Wide Viewing Angle || AI Upscale || Neo Quantum Processor 4K || Quantum Matrix Technology || Motion Xcelerator Turbo Pro || Real Depth Enhancer || LED Clear Motion\n" +
            "Warranty Information: 1 year comprehensive warranty plus additional 1 years on panel by brand from date of invoice\n" +
            "Installation: TV Table stand is not included in the box with this model. customer may ask for Table Top Stand or Wall Mount which will be provided to the customer at the time of installation, please directly call Samsung support on [Please visit brand website for tollfree numbers] and provide product's model name as well as seller's details mentioned on the invoice\n" +
            "Easy Returns: This product is eligible for replacement within 10 days of delivery in case of any product defects, damage or features not matching the description\n" +
            "› See more product details";
    public Amazon(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath = "//*[@id=\"nav-logo-sprites\"]")
    @CacheLookup
    WebElement homeLogo;

    @FindBy(xpath = "//*[@id=\"nav-hamburger-menu\"]")
    @CacheLookup
    WebElement hamBurgerbtn;

    @FindBy(xpath = "//div[@id=\"hmenu-content\"]")
    @CacheLookup
    WebElement hmenuOverlay;

    @FindBy(xpath = "//div[@id=\"hmenu-content\"]//a[@data-menu-id=9]")
    @CacheLookup
    WebElement tvAppbtn;
    @FindBy(xpath = "//div[@id=\"hmenu-content\"]//a[@data-ref-tag=\"nav_em_1_9_BT_0_main_menu\"]")
    @CacheLookup
    WebElement mainMenuBtn;

    @FindBy(xpath = "//*[@id=\"hmenu-content\"]/ul[9]/li[3]")
    @CacheLookup
    WebElement tvbtn;
    @FindBy(xpath = "//div[@class=\"a-container\"]")
    @CacheLookup
    WebElement mainContainer;

    @FindBy(xpath = "//*[@id=\"s-refinements\"]/div[24]/div/span")
    @CacheLookup
    WebElement brandFilter;

    @FindBy(xpath = "//*[@id=\"s-refinements\"]/div/ul/li/span/a[contains(@href,'Samsung')]")
    @CacheLookup
    WebElement samsungFilterbtn;

    @FindBy(xpath = "")
    @CacheLookup
    WebElement allOption;

    @FindBy(xpath = "//*[@id=\"a-autoid-0\"]")
    @CacheLookup
    WebElement sortBtn;

    @FindBy(xpath = "//*[@id=\"s-result-sort-select_2\"]")
    @CacheLookup
    WebElement highSortOption;


    @FindBy(xpath = "//*[@cel_widget_id=\"MAIN-SEARCH_RESULTS-2\"]")
    @CacheLookup
    WebElement secondHighestOption;

    @FindBy(xpath = "//*[@id=\"feature-bullets\"]")
    @CacheLookup
    WebElement aboutDescription;

    public Amazon() {

    }

    public void clickHamburgerBtn() {
        hamBurgerbtn.click();
        webDriverWait(hmenuOverlay);
    }

    public void webDriverWait(WebElement element) {
        WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickTVOptionFromCategory() throws InterruptedException {
        scrollTo(tvAppbtn);
        tvAppbtn.click();
        webDriverWait(mainMenuBtn);
        tvbtn.click();
        webDriverWait(mainContainer);
        Thread.sleep(2000);
        scrollTo(brandFilter);
        Thread.sleep(2000);
        samsungFilterbtn.click();
        Thread.sleep(2000);
    }

    private void scrollTo(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) ldriver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void sortHighToLowOption() throws InterruptedException {
        sortBtn.click();
        Thread.sleep(2000);
        highSortOption.click();
        Thread.sleep(2000);
        secondHighestOption.click();
        Thread.sleep(2000);
    }

    public void selectTheSecondHighestItem() throws InterruptedException {
        String parentWindow = ldriver.getWindowHandle();
        Set<String> windows = ldriver.getWindowHandles();
        for(String window:windows){
            if(!window.equals(parentWindow)){
                ldriver.switchTo().window(window);
                System.out.println(aboutDescription.getText());
            }
        }
        Thread.sleep(2000);
        scrollTo(aboutDescription);
        Assert.assertEquals(actualMessage,aboutDescription.getText());
        System.out.println(aboutDescription.getText());
    }
}

