package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtilities;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class CalendarEventsPage extends AbstractBasePage {
    WebDriver driver = Driver.getDriver();
    Actions actions = new Actions(driver);

    @FindBy(xpath ="(//ul[@class=\"nav nav-pills icons-holder launchers-list\"])[1]//li//a[@title=\"View\"]")
    public WebElement view;
    @FindBy(xpath = "(//ul[@class=\"nav nav-pills icons-holder launchers-list\"])[1]//li//a[@title=\"Edit\"]")
    public WebElement edit;
    @FindBy(xpath = "(//ul[@class=\"nav nav-pills icons-holder launchers-list\"])[1]//li//a[@title=\"Delete\"]")
    public WebElement delete;


    @FindBy(xpath = "//i[@class='fa-cog hide-text']")
    public WebElement gridBtn;

//    @FindBy(xpath = "//div[@class='toolbar']//tr//td[3]")
//    public WebElement gridOptions;

@FindBy(xpath = "//span[text()='Title']")
public WebElement title;

//@FindBy(xpath = "//a[@class='btn-success btn dropdown-toggle']")
@FindBy(xpath = "(//*[@data-toggle='dropdown'])[4]")
    public WebElement saveCloseBtn;

@FindBy(xpath = "//ul//li//button[contains(text(),'Save and Close')]")
public WebElement saveClosedropdown;

@FindBy(xpath = "//ul//li//button[contains(text(),'Save and New')] ")
public WebElement saveAndNewdropdown;

@FindBy(xpath = "(//ul//li//button[contains(text(),'Save')])[3]")
public WebElement saveBtndropdown;

@FindBy(css = "a[title='Cancel']")
public WebElement cancelBtn;

    @FindBy(css = "h1[class='oro-subtitle']")
  public WebElement allCalendarEventsTitle;

    @FindBy(xpath = "(//input[@placeholder='time'])[1]")
    public WebElement startTime;

    @FindBy(xpath = "(//input[@placeholder='time'])[2]")
    public WebElement endTime;

    @FindBy(css = "[id^='oro_calendar_event_form_allDay']")
    public WebElement allDayEvnt;

    @FindBy(css="[id^='recurrence-repeat-view']")
    public WebElement repeatBox;

    @FindBy(css = "select[id^='recurrence-repeats-view']")
    public WebElement selectedOptions;

    @FindBy(xpath = "(//input[@type='radio'])[1]")
    public WebElement repeatEvery;

    @FindBy(xpath = "(//input[@type='radio'])[3]")
    public WebElement endsRadioBtn;

    @FindBy(xpath = "//span[contains(text(),'Never')]")
    public WebElement neverText;

    @FindBy(xpath = "//label[contains(text(),'Summary:')]")
    public WebElement summaryLabel;

    @FindBy(xpath = "//span[text()='Daily every 1 day']")
    public WebElement dailyEveryOneDayl;

    @FindBy(xpath = "(//input[@type='radio'])[4]")
    public WebElement afterRadioBtn;

    @FindBy(xpath = "(//input[@class='recurrence-subview-control__number'])[7]")
    public WebElement afterOccurencesBox;

    @FindBy(xpath = "//span[text()=', end after 10 occurrences']")
    public WebElement tenOccurencesText;

    @FindBy(xpath = "//span[text()='occurrences']")
    public WebElement occurencesText;

    @FindBy(xpath = "(//input[@type='radio'])[5]")
    public WebElement byRadioBtn;

    @FindBy(css = "input[class='datepicker-input hasDatepicker']")
    public WebElement dateBox;

    @FindBy(xpath = "//span[text()=', end by Nov 18, 2021']")
    public WebElement  dateText;

    @FindBy(css="input[value='monday']")
    public WebElement mondayCheckbox;

    @FindBy(css="input[value='friday']")
    public WebElement fridayCheckbox;

    @FindBy(xpath = "//span[text()='Weekly every 1 week on Monday, Friday']")
    public WebElement monFriText;
    public void clickCancelBtn(){

        wait.until(ExpectedConditions.elementToBeClickable(cancelBtn)).click();
    }

    public void clickOnSaveAndClose() {

        wait.until(ExpectedConditions.elementToBeClickable(saveCloseBtn)).click();
    }



public void navigateToCreateCalEvnt(){
    createCalendarEventBtn.click();
}
    public void diselectGridOptions(){

        List<WebElement> gridOptions = driver.findElements(By.xpath("//div[@class='toolbar']//tr//td[3]"));
        for (int i = 1; i < gridOptions.size(); i++) {
            gridOptions.get(i).click();
    }}


    public void hoverTestersMeeting() {
    actions.moveToElement(driver.findElement( By.cssSelector("body.desktop-version.lang-en:nth-child(2) div.app-page:nth-child(2) div.app-page__content div.app-page__main div.app-page__central-panel div.scrollable-container:nth-child(3) div.disable-scroll:nth-child(3) div.oro-datagrid div.other-scroll-container:nth-child(2) div.grid-scrollable-container div.grid-container table.grid.table-hover.table.table-bordered.table-condensed tbody.grid-body tr.grid-row.row-click-action:nth-child(1) td.action-cell.grid-cell.grid-body-cell:nth-child(9) div.more-bar-holder div.dropdown > a.dropdown-toggle"))).perform();

}
    public Integer timeDif() {
        wait.until(ExpectedConditions.visibilityOf(startTime));
        String startT= startTime.getAttribute("value");
       String endT=  endTime.getAttribute("value");
        String [] start =startT.split(":");
         int startValue = Integer.parseInt(start[0]);
        String [] end =endT.split(":");
                int endValue = Integer.parseInt(end[0]);
                if (startValue==12){
                    startValue-=12;
                }

            return endValue-startValue;
    }

    public void verifyStartTime(){
        wait.until(ExpectedConditions.visibilityOf(startTime)).click();
       actions.moveToElement(driver.findElement(By.xpath("/html/body/div[6]/ul/li[43]"))).click().perform();

        BrowserUtilities.wait(5);
    }
public String verifyEndTime(){
    wait.until(ExpectedConditions.visibilityOf(endTime));
    String endT=  endTime.getAttribute("value");

    return endT;
}


//public void allDayEvent(){
//        wait.until(ExpectedConditions.visibilityOf(allDayEvnt)).click();
//
//
//}

}
