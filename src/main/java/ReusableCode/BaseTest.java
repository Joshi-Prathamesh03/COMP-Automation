package ReusableCode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BaseTest {
	WebDriver driver;
	
	public BaseTest(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "select[name='records']")
	WebElement totalRecordsPerPage;
	
	
	public void pagination() {
		Select totalRecords = new Select(totalRecordsPerPage);
		totalRecords.selectByIndex(5);
	}
}
