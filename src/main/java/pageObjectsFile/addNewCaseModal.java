package pageObjectsFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class addNewCaseModal {
	WebDriver driver;

	public addNewCaseModal(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
//			driver.findElement(By.cssSelector("span[title='Add New Case']")).click();
//	WebElement dropdown = driver.findElement(By.name("case"));
//	Select typeOfCase = new Select(dropdown);
//	typeOfCase.selectByIndex(2);
//	driver.findElement(By.id("searchVin")).sendKeys("KM8JT3AF4FU002641");
//	driver.findElement(By.xpath("//button[contains(text(), 'Create Case')]")).click();

	@FindBy(css = "span[title='Add New Case")
	WebElement addNewCaseNavButton;

	@FindBy(name = "case")
	WebElement caseType;
	
	@FindBy(id = "searchVin")
	WebElement VIN;
	
	@FindBy(xpath = "//button[contains(text(), 'Create Case')]")
	WebElement createCaseBtn;

	public void AddNewCase(String vinNumber) {
		addNewCaseNavButton.click();

		Select typeOfCase = new Select(caseType);
		typeOfCase.selectByIndex(2);
		
		VIN.sendKeys(vinNumber);
		createCaseBtn.click();
	}

}
