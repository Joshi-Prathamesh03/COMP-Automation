package ReusableCodeForTestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjectsFile.addNewCase;
import pageObjectsFile.caseAllocation;
import pageObjectsFile.login;

public class BaseTest {
	public WebDriver driver;
	public login log;
	public addNewCase addCase;
	public caseAllocation allocation;

	Properties prop = new Properties();
	
	public WebDriver initDriver() throws IOException {

		FileInputStream FIS = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\GlobalData.properties");

		prop.load(FIS);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("Driver not found!!!!!!!!!!!!");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;

	}

	@BeforeMethod()
	public login hitAppUrl() throws IOException {
		driver = initDriver();
		FileInputStream FIS = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\GlobalData.properties");
		prop.load(FIS);

		log = new login(driver);
		log.hitURL();

		String loginID = prop.getProperty("loginName");
		String Password = prop.getProperty("password");
		log.loginIntoApp(loginID, Password);

		return log;

	}

//	@AfterMethod()
//	public void instanceClose() {
//		driver.close();
//	}
}
