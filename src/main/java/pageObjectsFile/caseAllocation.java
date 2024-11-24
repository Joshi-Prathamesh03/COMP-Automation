package pageObjectsFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class caseAllocation {
	WebDriver driver;

	public caseAllocation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div[title='Case Allocation']")
	WebElement allocationMenu;

	public void caseAllocationCheck() {
		allocationMenu.click();
	}
}