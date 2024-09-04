package pageObjectsFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login {
	WebDriver driver;

	public login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "email")
	WebElement MobNumber;

	@FindBy(name = "emailButton")
	WebElement nextBtn;

	@FindBy(name = "uniquePassword")
	WebElement password;

	@FindBy(name = "loginButton")
	WebElement loginBtn;

	public void hitURL() {
		driver.get("https://testapp.crystalauto.co.in");
	}

	public void loginIntoApp(String userMobNumber, String userPassword) {
		MobNumber.sendKeys(userMobNumber);
		nextBtn.click();

		password.sendKeys(userPassword);
		loginBtn.click();

	}

}
