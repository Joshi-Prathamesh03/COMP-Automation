package pageObjectsFile;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableCode.BaseTest;

public class quotation extends BaseTest {
	WebDriver driver;

	public quotation(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(),'Splilled Over')]")
	WebElement spilledOverTab;

	@FindBy(xpath = "//span[@class='flex-c-m cursor-pointer']")
	WebElement filterBtn;

	@FindBy(xpath = "//body/div[contains(@class,'display-flex notranslate')]/div[@id='app']/div/div[@class='h-100vh workspace-list']/div[@class='h-100vh-50']/div[@class='isDesktop']/div[@class='m-t-8 col-lg-12 p-r-0 p-l-0 pos-relative']/div[@class='col-xs-12 bor-rad-all-5 p-r-0 p-l-0']/div[@class='col-xs-12 h-40px workspace-filter p-r-0 p-l-0 display-flex flex-r-m justify-between m-b-8']/div[@class='col-xs-8 m-t-10 p-l-11']/div[contains(@class,'modal show-modal')]/div[@class='modal-content is-full-height is-small-filter']/section[@class='modal-body modal-full-height no-padding']/div[@class='bg-white flex']/div[@class='col-xs-12 p-13']/div[@class='h-full w-full']/div[2]/div[1]/div[1]/div[1]")
	WebElement pendingAction;
	
	@FindBy(xpath="//input[@value='Generate Renewal Quotation']")
	WebElement qutoCheckbox;
	
	@FindBy(css="button[title='Click to search']")
	WebElement searchBtn;
	
	public void createQuotation() {
		spilledOverTab.click();
		filterBtn.click();
		
		pendingAction.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('.multi-select-container').scrollTop=600");
		qutoCheckbox.click();
		searchBtn.click();
		
	}

}
