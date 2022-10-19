package com.qa.orangehrm.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.orangehrm.base.TestBase;

public class HomePage extends TestBase {
	
	//object repository login
	
	@FindBy (id="txtUsername")
	WebElement username;
	@FindBy (id="txtPassword")
	WebElement password;
	@FindBy (className ="button")
	WebElement loginbtn;
	
	//Time menu
	@FindBy(xpath="//*[@id=\"menu_time_viewTimeModule\"]/b")
	WebElement Time;
	
	//MyTimesheet menu
	@FindBy(xpath="//*[@id=\"menu_time_Timesheets\"]")
	WebElement Timesheet;
	@FindBy(xpath="//*[@id=\"menu_time_viewMyTimesheet\"]")
	WebElement Mytimesheet;
	@FindBy(xpath="//*[@id=\"startDates\"]")
	WebElement Datedropbox;
	@FindBy(xpath="//*[@id=\"btnAddTimesheet\"]")
	WebElement Addtimesheetbox;
	@FindBy(xpath="//*[@id=\"time_date\"]")
	WebElement Datebox;
	@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[1]/td[6]")
	WebElement pickupdate;
	@FindBy(xpath="//*[@id=\"addTimesheetBtn\"]")
	WebElement okbtn;
	@FindBy(xpath="//*[@id=\"addCancel\"]")
	WebElement cancelbtn;
	@FindBy(xpath="//*[@id=\"createTimesheet\"]/div[1]/a")
	WebElement closebtn;
	
	//Edit menu
	@FindBy(xpath="//*[@id=\"initialRows_0_toDelete\"]")
	WebElement checkbox;
	@FindBy(xpath="//*[@id=\"initialRows_1_toDelete\"]")
	WebElement checkbox2;
	@FindBy(xpath="//*[@id=\"btnEdit\"]")
	WebElement editbtn;
	@FindBy(xpath="//*[@id=\"initialRows_0_projectName\"]")
	WebElement projectnamebox;
	@FindBy(xpath="//*[@id=\"initialRows_1_projectName\"]")
	WebElement projectnamebox2;
	@FindBy(xpath="//*[@id=\"initialRows_0_projectActivityName\"]")
	WebElement projectactivitybox;
	@FindBy(xpath="//*[@id=\"initialRows_1_projectActivityName\"]")
	WebElement projectactivitybox2;
	@FindBy(xpath="//*[@id=\"initialRows_0_0\"]]")
	WebElement monbox;
	@FindBy(xpath="//*[@id=\"initialRows_0_1\"]")
	WebElement tuebox;
	@FindBy(xpath="//*[@id=\"initialRows_0_2\"]")
	WebElement wedbox;
	@FindBy(xpath="//*[@id=\"initialRows_0_3\"]")
	WebElement thrubox;
	@FindBy(xpath="//*[@id=\"initialRows_0_4\"]")
	WebElement fribox;
	@FindBy(xpath="//*[@id=\"initialRows_0_5\"]")
	WebElement satbox;
	@FindBy(xpath="//*[@id=\"initialRows_0_6\"]")
	WebElement sunbox;
	@FindBy(xpath="//*[@id=\"submitSave\"]")
	WebElement savebtn;
	@FindBy(xpath="//*[@id=\"btnAddRow\"]")
	WebElement addrowbtn;
	@FindBy(xpath="//*[@id=\"initialRows_1_projectName\"]")
	WebElement addrow1;
	@FindBy(xpath="//*[@id=\"submitRemoveRows\"]")
	WebElement removebtn;
	@FindBy(xpath="//*[@id=\"btnBack\"]")
	WebElement cancelbutton;
	@FindBy(xpath="//*[@id=\"btnSubmit\"]")
	WebElement submitbtn;
	@FindBy(xpath="//*[@id=\"btnEdit\"]")
	WebElement Edit1;
	
	
	//Employee timesheet menu
	
	@FindBy(xpath="//*[@id=\"menu_time_viewEmployeeTimesheet\"]")
	WebElement Employeetimesheet;
	@FindBy(xpath="//*[@id=\"employee\"]")
	WebElement Employeename;
	@FindBy(xpath="//*[@id=\"btnView\"]")
	WebElement Viewbtn;
	@FindBy(xpath="//*[@id=\"viewSubmitted\"]")
	WebElement Timesheetpendingaction;
	@FindBy(xpath="//*[@id=\"txtComment\"]")
	WebElement commentbox;
	@FindBy(xpath="//*[@id=\"btnApprove\"]")
	WebElement approvebtn;
	@FindBy(xpath="//*[@id=\"btnReject\"]")
	WebElement rejectbtn;
	

	//initialization 
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void assertHomePageTitle() {
		assertEquals(driver.getTitle(), "OrangeHRM");
	}
	

	
	//Time menu
	
	public TimeMenu clickontimemenu() {
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginbtn.click();
		Time.click();
		return new TimeMenu();
	}
	
	public MyTimeMenu clickonmytimemenu() {
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginbtn.click();
		Time.click();
		Timesheet.click();
		Mytimesheet.click();
		return new MyTimeMenu();
	}
	
	public DateDropBox clickondatedropbox() {
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginbtn.click();
		Time.click();
		Timesheet.click();
		Mytimesheet.click();
		Datedropbox.click();
		return new DateDropBox();
	}
	
	public AddTime clickonaddtimsheet() {
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginbtn.click();
		Time.click();
		Timesheet.click();
		Mytimesheet.click();
		Datedropbox.sendKeys("2022-06-06 to 2022-06-12");
		Addtimesheetbox.click();
		return new AddTime();
	}
	
	
	public AddTime clickonpickupdate() {
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginbtn.click();
		Time.click();
		Timesheet.click();
		Mytimesheet.click();
		Addtimesheetbox.click();
		Datebox.click();
		pickupdate.click();
		return new AddTime();
	}
	
	public AddTime clickonokbtn() {
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginbtn.click();
		Time.click();
		Timesheet.click();
		Mytimesheet.click();
		Datedropbox.sendKeys("2022-06-06 to 2022-06-12");
		Addtimesheetbox.click();
		
		okbtn.click();
		return new AddTime();
	}
	
	
	
	public AddTime clickonclose() {
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginbtn.click();
		Time.click();
		Timesheet.click();
		Mytimesheet.click();
		Datedropbox.sendKeys("2022-06-06 to 2022-06-12");
		Addtimesheetbox.click();
		closebtn.click();
		return new AddTime();
	}
	
	
	//Edit menu 
	
	public CheckBox clickoncheckbox() {
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginbtn.click();
		Time.click();
		Timesheet.click();
		Mytimesheet.click();
		Datedropbox.sendKeys("2022-06-06 to 2022-06-12");
		Addtimesheetbox.click();
		closebtn.click();
		editbtn.click();
		checkbox.click();
		return new CheckBox();
	}
	
	public CheckBox2 clickoncheckbox2() {
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginbtn.click();
		Time.click();
		Timesheet.click();
		Mytimesheet.click();
		Datedropbox.sendKeys("2022-06-06 to 2022-06-12");
		Addtimesheetbox.click();
		closebtn.click();
		editbtn.click();
		checkbox2.click();
		return new CheckBox2();
	}
	
	public EditBtn clickoneditbtn() {
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginbtn.click();
		Time.click();
		Timesheet.click();
		Mytimesheet.click();
		Datedropbox.sendKeys("2022-06-06 to 2022-06-12");
		Addtimesheetbox.click();
		closebtn.click();
		editbtn.click();
		return new EditBtn();
	}
	
	public EditBtn clickonprojectname() {
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginbtn.click();
		Time.click();
		Timesheet.click();
		Mytimesheet.click();
		Datedropbox.sendKeys("2022-06-06 to 2022-06-12");
		Addtimesheetbox.click();
		closebtn.click();
		editbtn.click();
		projectnamebox.sendKeys("Global Corp and Co - Global Software phase - 1");
		return new EditBtn();
	}
	
	public EditBtn clickonactivitybox() {
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginbtn.click();
		Time.click();
		Timesheet.click();
		Mytimesheet.click();
		Datedropbox.sendKeys("2022-06-06 to 2022-06-12");
		Addtimesheetbox.click();
		closebtn.click();
		editbtn.click();
		projectnamebox.sendKeys("Global Corp and Co - Global Software phase - 1");
		projectactivitybox.sendKeys("Bug Fixes");
		return new EditBtn();
	}
	
	public EditBtn clickonsavebtn() {
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginbtn.click();
		Time.click();
		Timesheet.click();
		Mytimesheet.click();
		Datedropbox.sendKeys("2022-06-06 to 2022-06-12");
		Addtimesheetbox.click();
		closebtn.click();
		editbtn.click();
		projectnamebox.sendKeys("Global Corp and Co - Global Software phase - 1");
		projectactivitybox.sendKeys("Bug Fixes");
		savebtn.click();
		return new EditBtn();
		
	}
	
	public EditBtn clickonaddrowbtn() {
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginbtn.click();
		Time.click();
		Timesheet.click();
		Mytimesheet.click();
		Datedropbox.sendKeys("2022-06-06 to 2022-06-12");
		Addtimesheetbox.click();
		closebtn.click();
		editbtn.click();
		projectnamebox.sendKeys("Global Corp and Co - Global Software phase - 1");
		projectactivitybox.sendKeys("Bug Fixes");
		addrowbtn.click();
		return new EditBtn();
		
	}
	
	public EditBtn clickonaddrow1() {
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginbtn.click();
		Time.click();
		Timesheet.click();
		Mytimesheet.click();
		Datedropbox.sendKeys("2022-06-06 to 2022-06-12");
		Addtimesheetbox.click();
		closebtn.click();
		editbtn.click();
		projectnamebox.sendKeys("Global Corp and Co - Global Software phase - 1");
		projectactivitybox.sendKeys("Bug Fixes");
		addrowbtn.click();
		projectnamebox2.sendKeys("Global Corp and Co - Global Software phase - 2");
		projectactivitybox2.sendKeys("QA Testing");
		addrow1.click();
		return new EditBtn();
		
	}
	
	
	public EditBtn clickonremovebtn() {
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginbtn.click();
		Time.click();
		Timesheet.click();
		Mytimesheet.click();
		Datedropbox.sendKeys("2022-06-06 to 2022-06-12");
		Addtimesheetbox.click();
		closebtn.click();
		editbtn.click();
		projectnamebox.sendKeys("Global Corp and Co - Global Software phase - 1");
		projectactivitybox.sendKeys("Bug Fixes");
		addrowbtn.click();
		projectnamebox2.sendKeys("Global Corp and Co - Global Software phase - 2");
		projectactivitybox2.sendKeys("QA Testing");
		addrow1.click();
		removebtn.click();
		return new EditBtn();
	}
	
	public EditBtn clickoncancelbutton() {
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginbtn.click();
		Time.click();
		Timesheet.click();
		Mytimesheet.click();
		Datedropbox.sendKeys("2022-06-06 to 2022-06-12");
		Addtimesheetbox.click();
		closebtn.click();
		editbtn.click();
		projectnamebox.sendKeys("Global Corp and Co - Global Software phase - 1");
		projectactivitybox.sendKeys("Bug Fixes");
		cancelbutton.click();
		return new EditBtn();
	}
	
	public EditBtn clickonsubmitbtn() {
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginbtn.click();
		Time.click();
		Timesheet.click();
		Mytimesheet.click();
		Datedropbox.sendKeys("2022-06-06 to 2022-06-12");
		Addtimesheetbox.click();
		closebtn.click();
		editbtn.click();
		projectnamebox.sendKeys("Global Corp and Co - Global Software phase - 1");
		projectactivitybox.sendKeys("Bug Fixes");
		cancelbutton.click();
		Timesheet.click();
		submitbtn.click();
		return new EditBtn();
		
	}
	
	
	//Employeetimesheet
	
	public EmployeeTimeMenu clickonemployeetimemenu() {
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginbtn.click();
		Time.click();
		Timesheet.click();
		Employeetimesheet.click();
		return new EmployeeTimeMenu();
	}
	
	public EmployeeTimeMenu clickonemployeenamebox() {
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginbtn.click();
		Time.click();
		Timesheet.click();
		Employeetimesheet.click();
		Employeename.sendKeys("Charlie Carter");
		return new EmployeeTimeMenu();
	}
	
	public ViewBtn clickonviewbtn() {
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginbtn.click();
		Time.click();
		Timesheet.click();
		Employeetimesheet.click();
		Employeename.sendKeys("Charlie Carter");
		Viewbtn.click();
		return new ViewBtn();
	}
	
	public ViewBtn clickontimesheetaction() {
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginbtn.click();
		Time.click();
		Timesheet.click();
		Employeetimesheet.click();
		Employeename.sendKeys("Charlie Carter");
		Viewbtn.click();
		Timesheetpendingaction.click();
		return new ViewBtn();
	}
	
	public ViewBtn clickoncommentbox() {
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginbtn.click();
		Time.click();
		Timesheet.click();
		Employeetimesheet.click();
		Employeename.sendKeys("Charlie Carter");
		Viewbtn.click();
		Timesheetpendingaction.click();
		Timesheet.click();
		commentbox.sendKeys("abcdefghijkl");
		return new ViewBtn();
	}
	
	public ViewBtn clickonapprovebtn() {
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginbtn.click();
		Time.click();
		Timesheet.click();
		Employeetimesheet.click();
		Employeename.sendKeys("Charlie Carter");
		Viewbtn.click();
		Timesheetpendingaction.click();
		Timesheet.click();
		commentbox.sendKeys("abcdefghijkl");
		approvebtn.click();
		return new ViewBtn();
	}
	
	public ViewBtn clickonrejectbtn() {
		username.sendKeys("Admin");
		password.sendKeys("admin123");
		loginbtn.click();
		Time.click();
		Timesheet.click();
		Employeetimesheet.click();
		Employeename.sendKeys("Charlie Carter");
		Viewbtn.click();
		Timesheetpendingaction.click();
		Timesheet.click();
		commentbox.sendKeys("abcdefghijkl");
		rejectbtn.click();
		return new ViewBtn();
	}

}
