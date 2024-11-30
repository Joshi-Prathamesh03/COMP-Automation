package pageObjectsFile;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import ReusableCode.BaseTest;

public class caseAllocation extends BaseTest {
	WebDriver driver;

	public caseAllocation(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div[title='Case Allocation']")
	WebElement allocationMenu;

	@FindBy(id = "search__input")
	WebElement searchCasesInput;

	@FindBy(css = "button[title='Filter']")
	WebElement alloationFilter;

	@FindBy(xpath = "//select[@name='expiryMonth']")
	WebElement expiryInMonthDropdown;

	@FindBy(xpath = "//select[@name='expiryYear']")
	WebElement expiryInYearDropdown;

	@FindBy(xpath = "//button[contains(text(),'Filter')]")
	WebElement filterBtn;

	@FindBy(xpath = "//select[@name='newAssignee']")
	WebElement newAssignee;

	@FindBy(xpath = "//button[contains(text(),'Confirm')]")
	WebElement confirmPopUpBtn;
	
	@FindBy(xpath="//label[@for='checkbox-all']")
	WebElement selectAllCheckbox;	
	
	@FindBy(xpath="//div[@id='floating-new-assignee']")
	WebElement floatingNewAssigneeBtn;
	
	@FindBy(xpath="//button[contains(text(),'Assign Cases')]")
	WebElement assignCasesBtn;
	
	@FindBy(xpath="(//div[@title='Close'])[2]")
	WebElement closeAssigneeModal;

	public void caseAllocationFilterCheck() {
		allocationMenu.click();
		pagination();
		alloationFilter.click();
		Select expiryMonth = new Select(expiryInMonthDropdown);
		expiryMonth.selectByIndex(12);

		Select expiryYear = new Select(expiryInYearDropdown);
		expiryYear.selectByValue("2024");

		filterBtn.click();

	}

	public void searchCasesByInputSearch() {
		allocationMenu.click();
		searchCasesInput.sendKeys("Ritesh Jaiswal");
		Actions a = new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
	}

	public void allocateSingleCase() {
		allocationMenu.click();
		Select newAssigneeDropdown = new Select(newAssignee);
		newAssigneeDropdown.selectByIndex(2);
		confirmPopUpBtn.click();
	}
	
	public void bulkAlloation() throws InterruptedException {
		allocationMenu.click();
		selectAllCheckbox.click();
		floatingNewAssigneeBtn.click();
		closeAssigneeModal.click();
//		Select newAssigneeDropdown = new Select(newAssignee);
//		newAssigneeDropdown.selectByIndex(4);
//		assignCasesBtn.click();
		
	}
}