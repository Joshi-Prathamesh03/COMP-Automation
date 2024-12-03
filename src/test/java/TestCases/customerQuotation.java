package TestCases;


import org.testng.annotations.Test;

import ReusableCodeForTestCases.BaseTest;
import pageObjectsFile.quotation;

public class customerQuotation extends BaseTest{
	@Test
	public void generateQuote() throws InterruptedException {
		quote = new quotation(driver);
		quote.createQuotation();
		quote.quoteForm();
	}
}
