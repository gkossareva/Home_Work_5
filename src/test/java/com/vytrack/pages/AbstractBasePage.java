package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtilities;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class AbstractBasePage {
    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 20);

    @FindBy(tagName = "h1")
    protected WebElement pageLogo;

//    @FindBy(xpath="//span[@class='title title-level-1' and contains(text(),'Activities')]")
//    protected WebElement activitiesBtn;

    protected Actions actions;
@FindBy(css = "a[title='Create Calendar event']")
protected WebElement createCalendarEventBtn;




//    private By currentUserBy = By.cssSelector("#user-menu > a");
//    private By ownerBy = By.className("select2-chosen");
//    private By titleBy = By.cssSelector("[name='oro_calendar_event_form[title]']");
//    private By startDateBy = By.cssSelector("[id*='date_selector_oro_calendar_event_form_start-uid']");
//    private By startTimeBy = By.cssSelector("[id*='time_selector_oro_calendar_event_form_start-uid']");
//    @BeforeMethod
//    public void setup(){
//        driver = DriverFactory.createDriver("chrome");
//        driver.get("https://qa2.vytrack.com/user/login");
//        driver.manage().window().maximize();
//        actions = new Actions(driver);
//        BrowserUtils.wait(3);
//        driver.findElement(usernameBy).sendKeys(storeManagerUserName);
//        driver.findElement(passwordBy).sendKeys(storeManagerPassword, Keys.ENTER);
//        BrowserUtils.wait(5);
//        //hover over Activities
//        actions.moveToElement(driver.findElement(activitiesBy)).perform();
//        BrowserUtils.wait(2);
//        driver.findElement(By.linkText("Calendar Events")).click();
//        BrowserUtils.wait(5);
//    public void navigateToActivities() {
//        actions = new Actions(driver);
//        actions.moveToElement(driver.findElement(By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]"))).perform();
//        BrowserUtilities.waitForPageToLoad(5);
//        driver.findElement(By.linkText("Calendar Events")).click();
//        BrowserUtilities.waitForPageToLoad(2);
//
//    }
    public void navigateTo(String tabName, String moduleName) {
        String tabNameXpath = "//span[@class='title title-level-1' and contains(text(),'" + tabName + "')]";
        String moduleXpath = "//span[@class='title title-level-2' and text()='" + moduleName + "']";

        WebElement tabElement = driver.findElement(By.xpath(tabNameXpath));
        WebElement moduleElement = driver.findElement(By.xpath(moduleXpath));

        Actions actions = new Actions(driver);

        BrowserUtilities.wait(4);

        actions.moveToElement(tabElement).
                pause(2000).
                click(moduleElement).
                build().perform();

        BrowserUtilities.wait(4);



    }
//
//    @FindBy(tagName = "h2")
//    protected WebElement pageSubtitle;

//    public String getPageSubtitleText(){
//        BrowserUtilities.waitForPageToLoad(10);
//        return pageSubtitle.getText().trim();
//    }
//
    public String getPageLogoText() {
        return pageLogo.getText();
    }

    public AbstractBasePage() {
        PageFactory.initElements(driver, this);
    }

//    /**
//     * Specify component name as a parameter, like: View all products or Orders
//     * @param component
//     */
//    public void navigateTo(String component) {
//        String locator = "//a[text()='" + component + "']";
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).click();
    }
