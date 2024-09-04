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
import pageObjectsFile.addNewCaseModal;
import pageObjectsFile.login;

public class BaseTest {
	public WebDriver driver;
	public login log;
	public addNewCase addCase;
//	public addNewCaseModal addCaseModal;

	public WebDriver initDriver() throws IOException {
		Properties prop = new Properties();
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
		log = new login(driver);
		log.hitURL();
		log.loginIntoApp("9158882210", "Technative#1");
		return log;

	}

	@AfterMethod()
	public void instanceClose() {
		driver.close();
	}
}
