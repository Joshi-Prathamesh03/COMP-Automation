package pageObjectsFile;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

	@FindBy(xpath = "//input[@value='Generate Renewal Quotation']")
	WebElement qutoCheckbox;

	@FindBy(css = "button[title='Click to search']")
	WebElement searchBtn;

	@FindBy(xpath = "(//span[contains(text(),'Generate Renewal Quotation')])[2]")
	WebElement genratorQuote;

	@FindBy(css = "#previousPolicyPDF-0")
	WebElement previousPolicy;

	@FindBy(css = "#image-0-0")
	WebElement previousPolicyView;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "alternateEmailID")
	WebElement alternateEmail;

	@FindBy(id = "pan")
	WebElement panNumber;

	@FindBy(css = "label[for='isQuotationZeroDep-0-Yes']")
	WebElement zeroDepSelection;

	@FindBy(css = "#orderSource")
	WebElement insCompany;

	@FindBy(css = "#latestQuotationPDF-0")
	WebElement quotFile;

	@FindBy(css = "#image-0-7")
	WebElement uploadedQuoteFile;

	@FindBy(css = "#latestQuotationPolicyIDV")
	WebElement quotIDV;

	@FindBy(css = "#latestQuotationAmount")
	WebElement quotAmt;

	@FindBy(xpath = "//button[contains(text(),'Complete')]")
	WebElement completeBtn;

	public void createQuotation() {
		spilledOverTab.click();
		filterBtn.click();

		pendingAction.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('.multi-select-container').scrollTop=600");
		qutoCheckbox.click();
		searchBtn.click();

		genratorQuote.click();

	}

	@SuppressWarnings("null")
	public void quoteForm() throws InterruptedException {

		previousPolicy.sendKeys(System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\VIN_Validation.png");

		String emailValue = email.getAttribute("value");
		String altEmail = alternateEmail.getAttribute("value");
		String PAN = panNumber.getAttribute("value");

		if (emailValue == null && emailValue.isEmpty() && altEmail == null && altEmail.isEmpty() && PAN == null
				&& PAN.isEmpty()) {
			email.sendKeys("prathamesh@waybeyond.tech");
			alternateEmail.sendKeys("harshada@waybeyond.tech");
			panNumber.sendKeys("BGHYT7865Q");
		}

		zeroDepSelection.click();
		Select insuCompany = new Select(insCompany);
		insuCompany.selectByIndex(2);

		quotFile.sendKeys(System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\VIN_Validation.png");

		quotIDV.sendKeys("1500000");
		quotAmt.sendKeys("50000");
		Thread.sleep(4000);
		completeBtn.click();

//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("document.querySelector('#formModalContainer-0').scrollTop=600");

		// Actions action = new Actions(driver);
//		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).perform();

	}
	public void checkFileUplods() {
		
	}

}
