package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import ReusableCodeForTestCases.BaseTest;
import pageObjectsFile.addNewCase;

public class createCaseTest extends BaseTest {

	@Test
	public void newCaseCreation() throws InterruptedException {

		addCase = new addNewCase(driver);
		addCase.addNewOrRenewalCase("Kothurd", "prathamesh@waybeyond.tech");
	}

}
