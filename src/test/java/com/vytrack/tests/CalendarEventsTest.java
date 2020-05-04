package com.vytrack.tests;

import com.vytrack.pages.AbstractBasePage;
import com.vytrack.pages.CalendarEventsPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.*;

public class CalendarEventsTest extends AbstractBaseTests {

//Navigate to “Activities -> Calendar Events”
//4. Hover on three dots “...” for “Testers meeting”
//calendar event
    @Test
    public void  navigateToDots(){

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        extentTest = extentReports.createTest("Verify that “view”, “edit” and “delete” options");

        calendarEventsPage.hoverTestersMeeting();
     assertTrue(calendarEventsPage.view.isDisplayed());
assertTrue(calendarEventsPage.edit.isDisplayed());
assertTrue(calendarEventsPage.delete.isDisplayed());
        extentTest.pass("view, edit and delete verified");

    }
@Test
    public void test2(){
        //Click on “Grid Options” button
    CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
    extentTest = extentReports.createTest("Verify that “Title” column still displayed");
    calendarEventsPage.gridBtn.click();
    //5. Deselect all options except “Title”
    calendarEventsPage.diselectGridOptions();
    //6. Verify that “Title” column still displayed
    assertTrue(calendarEventsPage.title.isDisplayed());
    extentTest.pass(" “Title” column is displayed");
}
@Test
public void test3(){
        //4.Click on “Create Calendar Event” button
    CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
    extentTest = extentReports.createTest("Verify that “Save And Close”, “Save And New” and “Save” options are available");
    calendarEventsPage.navigateToCreateCalEvnt();
    // 5.Expand “Save And Close” menu6.Verify that “Save And Close”,
   BrowserUtilities.waitForPageToLoad(10);
//    calendarEventsPage.saveCloseBtn.click();
    calendarEventsPage.clickOnSaveAndClose();
    BrowserUtilities.waitForPageToLoad(5);
    // “Save And New” and “Save” options are available

    assertEquals(calendarEventsPage.saveClosedropdown.getText(),"Save And Close");
    assertEquals(calendarEventsPage.saveAndNewdropdown.getText(),"Save And New");
    assertEquals(calendarEventsPage.saveBtndropdown.getText(),"Save");
    extentTest.pass("Verified that “Save And Close”, “Save And New” and “Save” options are available");
    }

    @Test
    public void test4(){
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        extentTest = extentReports.createTest("Verify that “All Calendar Events” page subtitle is displayed");
        //Click on “Create Calendar Event” button
        calendarEventsPage.navigateToCreateCalEvnt();
        //Then, click on “Cancel” button
      calendarEventsPage.clickCancelBtn();
        BrowserUtilities.wait(5);
        assertEquals(calendarEventsPage.allCalendarEventsTitle.getText(),"All Calendar Events");
        extentTest.pass("Verified that “All Calendar Events” page subtitle is displayed");
    }
    @Test
    public void test5() {

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        extentTest = extentReports.createTest("Verify that difference between end and start time is exactly 1 hour");
              calendarEventsPage.navigateToCreateCalEvnt();

       //Verify that difference between end and start time is exactly 1 hour
            assertTrue(calendarEventsPage.timeDif()==1);
        extentTest.pass("Verified that difference between end and start time is exactly 1 hour");
    }

     @Test
     public void test6() {
          //4.Click on “Create Calendar Event” button
         CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
         extentTest = extentReports.createTest("Verify that end time is equals to “10:00 PM”");
         calendarEventsPage.navigateToCreateCalEvnt();
        //5.Select “9:00 PM” as a start time
           calendarEventsPage.verifyStartTime();
         // 6.Verify that end time is equals to “10:00 PM”
        assertEquals(calendarEventsPage.verifyEndTime(),"10:00 PM");
         extentTest.pass("Verified that end time is equals to '10:00 PM'");
     }
      @Test
     public void test7() {
         //4.Click on “Create Calendar Event” button
         CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
         extentTest = extentReports.createTest("Verify that start and end date input boxes are displayed");
         calendarEventsPage.navigateToCreateCalEvnt();

         //5.Select “All-Day Event” checkbox
         // 6.Verify that “All-Day Event” checkbox is selected
         // 7.Verify that start and end time input boxes are not displayed
         // 8.Verify that start and end date input boxes are displayed
         calendarEventsPage.allDayEvnt.click();
         assertTrue(calendarEventsPage.allDayEvnt.isSelected());
         assertTrue(calendarEventsPage.startTime.isDisplayed());
         assertTrue(calendarEventsPage.endTime.isDisplayed());
          extentTest.pass("Verified that start and end date input boxes are displayed");
      }
      @Test
          public void test8() {
              //4.Click on “Create Calendar Event” button
              CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
              extentTest = extentReports.createTest("Verify that “Repeat” checkbox is selected");
              extentTest = extentReports.createTest("Verify that “Daily” is selected by default and Daily, Weekly, Monthly, Yearly are available in “Repeats” drop-down:");
              calendarEventsPage.navigateToCreateCalEvnt();
//5.Select “Repeat” checkbox6.Verify that “Repeat” checkbox is selected
          BrowserUtilities.wait(5);
              calendarEventsPage.repeatBox.click();
              BrowserUtilities.wait(5);
              assertTrue(calendarEventsPage.repeatBox.isSelected(),"“Repeat” checkbox is selected");
// 7.Verify that “Daily” is selected by default and following options are available in “Repeats” drop-down:
          Select options=new Select(calendarEventsPage.selectedOptions);

          assertEquals(options.getFirstSelectedOption().getText(), "Daily","is verified that Daily is selected by default");

          List<WebElement> getOptions = options.getOptions();
          assertEquals(getOptions.get(0).getText(),"Daily", "is verified");
          assertEquals(getOptions.get(1).getText(),"Weekly","is verified");
          assertEquals(getOptions.get(2).getText(),"Monthly","is verified");
          assertEquals(getOptions.get(3).getText(),"Yearly","is verified");
          extentTest.pass("Verified that “Repeat” checkbox is selected");
          extentTest.pass("that “Daily” is selected by default and Daily, Weekly, Monthly, Yearly are available in “Repeats” drop-down");
      }
    @Test
    public void test9() {
        //4.Click on “Create Calendar Event” button
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        extentTest = extentReports.createTest("Verify that “Repeat Every” radio button is selected");
        extentTest = extentReports.createTest("Verify that “Repeat Every” radio button is selected");
        extentTest = extentReports.createTest("Verify that “Never” radio button is selected as an “Ends” option");
        extentTest = extentReports.createTest("Verify that following message as a summary is displayed: “Summary: Daily every 1 day”");
        calendarEventsPage.navigateToCreateCalEvnt();
        //5.Select “Repeat” checkbox
        BrowserUtilities.wait(5);
        calendarEventsPage.repeatBox.click();
        BrowserUtilities.wait(5);
        // 6.Verify that “Repeat” checkbox is selected
        assertTrue(calendarEventsPage.repeatBox.isSelected(),"“Repeat” checkbox is selected");
        // 7.Verify that “Repeat Every” radio button is selected
        assertTrue(calendarEventsPage.repeatEvery.isSelected(),"“Repeat Every” checkbox is selected");
        // 8.Verify that “Never” radio button is selected as an “Ends” option.
        assertTrue(calendarEventsPage.endsRadioBtn.isSelected(),"“Repeat Every” checkbox is selected");
        assertEquals(calendarEventsPage.neverText.getText(),"Never", "“Never” radio button is selected as an “Ends” optio");
        // 9.Verify that following message as a summary is displayed: “Summary: Daily every 1 day”
        assertEquals(calendarEventsPage.dailyEveryOneDayl.getText(),"Daily every 1 day","Verified that Daily every 1 day is displayed");
        extentTest.pass("All tests passed");


    }
    @Test
    public void test10() {
        //4.Click on “Create Calendar Event” button
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        extentTest = extentReports.createTest("Verify that following message as a summary is displayed: “Summary: Daily every 1 day, endafter 10 occurrences”");
        calendarEventsPage.navigateToCreateCalEvnt();
        //5.Select “Repeat” checkbox
        BrowserUtilities.wait(5);
        calendarEventsPage.repeatBox.click();
        BrowserUtilities.wait(5);
        // 6.Select “After 10 occurrences” as an “Ends” option.
        calendarEventsPage.afterRadioBtn.click();
        calendarEventsPage.afterOccurencesBox.clear();
        calendarEventsPage.afterOccurencesBox.sendKeys("10");
        calendarEventsPage.occurencesText.click();
        // 7.Verify that following message as a summary is displayed: “Summary: Daily every 1 day, endafter 10 occurrences”

        String actualText=
               calendarEventsPage.summaryLabel.getText()+ " "+calendarEventsPage.dailyEveryOneDayl.getText()+calendarEventsPage.tenOccurencesText.getText();
assertEquals(actualText,"Summary: Daily every 1 day, end after 10 occurrences");
        extentTest.pass("Verified that following message as a summary is displayed: “Summary: Daily every 1 day, endafter 10 occurrences”");
}
    @Test
    public void test11() {
        //4.Click on “Create Calendar Event” button
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        extentTest = extentReports.createTest("Verify that following message as a summary is displayed: “Summary: Daily every 1 day, end by Nov 18, 2021”");
        calendarEventsPage.navigateToCreateCalEvnt();
//5.Select “Repeat” checkbox
        BrowserUtilities.wait(5);
        calendarEventsPage.repeatBox.click();
        BrowserUtilities.wait(5);
        calendarEventsPage.byRadioBtn.click();
// 6.Select “By Nov 18, 2021” as an “Ends” option.
        calendarEventsPage.dateBox.clear();
        calendarEventsPage.dateBox.sendKeys("Nov 18, 2021");
// 7.Verify that following message as a summary is displayed: “Summary: Daily every 1 day, end by Nov 18, 2021”
        String actualText=
                calendarEventsPage.summaryLabel.getText()+ " "+calendarEventsPage.dailyEveryOneDayl.getText()+calendarEventsPage.dateText.getText();
        assertEquals(actualText,"Summary: Daily every 1 day, end by Nov 18, 2021");
        extentTest.pass("Verified Verify that following message as a summary is displayed: “Summary: Daily every 1 day, end by Nov 18, 2021”");
    }
    @Test
    public void test12() {
        //4.Click on “Create Calendar Event” button
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        extentTest = extentReports.createTest("Verify that following message as a summary is displayed: “Summary: Daily every 1 day, end by Nov 18, 2021”");
        calendarEventsPage.navigateToCreateCalEvnt();
//5.Select “Repeat” checkbox
        BrowserUtilities.wait(5);
        calendarEventsPage.repeatBox.click();
        BrowserUtilities.wait(5);
        // 6.Select “Weekly” options as a “Repeat” option
        Select options=new Select(calendarEventsPage.selectedOptions);
        options.selectByVisibleText("Weekly");
        // 7.Select “Monday and Friday” options as a “Repeat On” options8.Verify that “Monday and Friday” options are selected
       calendarEventsPage.mondayCheckbox.click();
       calendarEventsPage.fridayCheckbox.click();
       assertTrue(calendarEventsPage.mondayCheckbox.isSelected());
       assertTrue(calendarEventsPage.fridayCheckbox.isSelected());
        // 9.Verify that following message as a summary is displayed: “Summary: Weekly every 1 week onMonday, Friday”
        String actualText=
                calendarEventsPage.summaryLabel.getText()+ " "+calendarEventsPage.monFriText.getText();
        assertEquals(actualText,"Summary: Weekly every 1 week on Monday, Friday");
        extentTest.pass("Tests passed");
    }}