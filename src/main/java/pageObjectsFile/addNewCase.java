package pageObjectsFile;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;
//import org.testng.annotations.Test;

public class addNewCase {

	WebDriver driver;
	Random randomValue = new Random();

	String[] firstName = { "Prathamesh", "Rajesh", "John", "Jane", "Michael", "Emily", "David", "Sarah", "Daniel",
			"Jessica", "James", "Laura" };

	String[] middleName = { "Prathamesh", "Rajesh", "John", "Jane", "Michael", "Emily", "David", "Sarah", "Daniel",
			"Jessica", "James", "Laura" };

	String[] lastName = { "Joshi", "kulkarni", "Chavan", "Patel", "Singh", "Sharma", "Gupta", "Kumar", "Reddy", "Rao",
			"Das", "Nair", "Iyer" };

	String[] mobile = { "9186527410", "9186527411", "9186527412", "9186527413", "9186527414", "9186527415",
			"9186527416", "9186527417", "9186527418", "9186527419", "91865274120", "9186527421", "9186527422" };

	String[] VIN = { "KM8JT3AF4FU002650", "KM8JT3AF4FU002652", "KM8JT3AF4FU002653", "KM8JT3AF4FU002654",
			"KM8JT3AF4FU002655", "KM8JT3AF4FU002656", "KM8JT3AF4FU002657", "KM8JT3AF4FU002658", "KM8JT3AF4FU002659",
			"KM8JT3AF4FU002660" };

	String[] engineNumber = { "KJ8JT3AF4F11", "KJ8JT3AF4F12", "KJ8JT3AF4F13", "KJ8JT3AF4F14", "KJ8JT3AF4F15",
			"KJ8JT3AF4F16", "KJ8JT3AF4F17", "KJ8JT3AF4F18", "KJ8JT3AF4F19", "KJ8JT3AF4F20" };

	String[] regNumber = { "MH12TY1111", "MH12TY1112", "MH12TY1113", "MH12TY1114", "MH12TY1115", "MH12TY1116",
			"MH12TY1117", "MH12TY1118", "MH12TY1119", "MH12TY1120", "MH12TY1121" };

	public addNewCase(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Click on Add New Case tab in the right navigation panel
	@FindBy(css = "span[title='Add New Case]")
	WebElement addNewCaseNavButton;

	@FindBy(name = "case")
	WebElement caseType;

	@FindBy(id = "searchVin")
	WebElement VIN1;

	@FindBy(xpath = "//button[contains(text(), 'Create Case')]")
	WebElement createCaseBtn;

// Filling customer details tab details
	@FindBy(id = "field-proposerType")
	WebElement proposerType;

	@FindBy(id = "field-salutation")
	WebElement salutation;

	@FindBy(id = "firstName")
	WebElement custFirstName;

	@FindBy(id = "middleName")
	WebElement custMiddleName;

	@FindBy(id = "lastName")
	WebElement custLastName;

// Error handling for last name

	@FindBy(css = "div[id='lastName-input-box'] p[class='fs-10 text-color-red']")
	WebElement lastNameErrorMessage;

	@FindBy(id = "address")
	WebElement custaddress;

	@FindBy(id = "field-state")
	WebElement state;

	@FindBy(id = "field-city")
	WebElement city;

	@FindBy(id = "pincode")
	WebElement pinCode;

	@FindBy(css = "label[for='isGSTNumberAvailable-0-no']")
	WebElement gstNumberRadioButton;

	@FindBy(id = "mobile")
	WebElement mobileNumber;

	@FindBy(css = "label[for='doyouHaveaWhatsappNumber-0-yes']")
	WebElement whatsappNumberRadioButton;

	@FindBy(css = "label[for='isWhatsappNumberSameAsMobile-0-yes'")
	WebElement whatsappNumberRadioButtonConfirmation;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(xpath = "//button[contains(text(), 'Next')]")
	WebElement nextButton;

	// Entering Vehicle details values

	@FindBy(id = "field-brand")
	WebElement carBrand;

	@FindBy(id = "field-selectedModelName")
	WebElement carModel;

	@FindBy(id = "field-fuelType")
	WebElement fuelType;

	@FindBy(id = "field-selectedVariantName")
	WebElement varient;

	@FindBy(id = "vin")
	WebElement myVin;

	@FindBy(id = "engineNumber")
	WebElement enginNumber;

	@FindBy(id = "registrationNo")
	WebElement regiNumber;

	@FindBy(xpath = "//button[contains(text(), 'Next')]")
	WebElement nxtBtn;

	// Entering policy details values

	@FindBy(id = "previousPolicyStartDate")
	WebElement previusPolicyStartDate;

	@FindBy(id = "previousPolicyDateOfExpiry")
	WebElement previousPolicyExpiryDate;

	@FindBy(id = "previousPolicyIssuedDate")
	WebElement previousPolicyIssuedDate;

	@FindBy(id = "previousPolicyNo")
	WebElement previousPolicyNumber;

	@FindBy(id = "field-leadStatus")
	WebElement leadSatus;

	@FindBy(css = "label[for='isCaseAssigned-2-yes']")
	WebElement isCaseAssignedRadioButton;

	@FindBy(css = "div[class='display-block'] select[type='text']")
	WebElement assignee;

	@FindBy(css = "button[title='Complete Task']")
	WebElement completeTaskBtn;

	public void addNewOrRenewalCase(String address, String custEmail) throws InterruptedException {
		// Adding the data in the Add New/Renewal Case modal
		addNewCaseNavButton.click();

		Select typeOfCase = new Select(caseType);
		typeOfCase.selectByIndex(2);

		int getVIN = randomValue.nextInt(VIN.length);
		String selectedVIN = VIN[getVIN];
		VIN1.sendKeys(selectedVIN);

		String enterdVIN = VIN1.getAttribute("value");
		System.out.println("VINNNNNNNNNNN: " + enterdVIN);
		createCaseBtn.click();

		// Adding the data in the Customer details tab
		// Selecting a proposer type while adding a new case
		Select proposerType1 = new Select(proposerType);
		proposerType1.selectByValue("Individual");

		// Selecting a Salutation type while adding a new case
		Select salutation1 = new Select(salutation);
		salutation1.selectByValue("Mr.");

		// Get customer first name
		int getCustomerFirstNameFromArray = randomValue.nextInt(firstName.length);
		String custFstName = firstName[getCustomerFirstNameFromArray];
		custFirstName.sendKeys(custFstName);

		// Get customer middle name
		int getCustomerMiddleNameFromArray = randomValue.nextInt(middleName.length);
		String custMidName = middleName[getCustomerMiddleNameFromArray];
		custMiddleName.sendKeys(custMidName);

		// Get customer last name
		int getCustomerLastNameFromArray = randomValue.nextInt(lastName.length);
		String custlstName = lastName[getCustomerLastNameFromArray];
		custLastName.sendKeys(custlstName);

		// Get the address
		custaddress.sendKeys(address);

		// Selecting the state dropdown
		Select custState = new Select(state);
		custState.selectByValue("Maharashtra");

		Select myCity = new Select(city);
		myCity.selectByValue("Pune");

		pinCode.sendKeys("411038");

		gstNumberRadioButton.click();

		int custMobNumber = randomValue.nextInt(mobile.length);
		String myMobNumber = mobile[custMobNumber];
		mobileNumber.sendKeys(myMobNumber);

		whatsappNumberRadioButton.click();
		whatsappNumberRadioButtonConfirmation.click();
		email.sendKeys(custEmail);

		nextButton.click();

		// Entering the data in the Vehicle Details Tab
		Select vehicleBrand = new Select(carBrand);
		vehicleBrand.selectByIndex(1);

		Select model = new Select(carModel);
		model.selectByIndex(1);

		Select fuel = new Select(fuelType);
		fuel.selectByIndex(1);

		Select carVarient = new Select(varient);
		carVarient.selectByIndex(1);

		myVin.sendKeys(enterdVIN);
		System.out.println("Caught youuuuu ahhaaaa!!! " + enterdVIN);

		int engineNo = randomValue.nextInt(engineNumber.length);
		String vehicleEngineNumber = engineNumber[engineNo];
		enginNumber.sendKeys(vehicleEngineNumber);

		int registNumber = randomValue.nextInt(regNumber.length);
		String vehicleRegNumber = regNumber[registNumber];
		regiNumber.sendKeys(vehicleRegNumber);

		nxtBtn.click();

		// Entering the data in the policy details
		previusPolicyStartDate.sendKeys("09152023");
		previousPolicyExpiryDate.sendKeys("09152024");
		previousPolicyIssuedDate.sendKeys("09122023");
		previousPolicyNumber.sendKeys("549854654985");

		Select custLeadStatus = new Select(leadSatus);
		custLeadStatus.selectByValue("Open");

		isCaseAssignedRadioButton.click();

		Select caseAssignee = new Select(assignee);
		caseAssignee.selectByIndex(2);

		Thread.sleep(5000);
		completeTaskBtn.click();

	}

}
