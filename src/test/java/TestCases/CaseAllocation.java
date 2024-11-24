package TestCases;

import org.testng.annotations.Test;

import ReusableCodeForTestCases.BaseTest;
import pageObjectsFile.caseAllocation;

public class CaseAllocation extends BaseTest{
	@Test
	public void allocationCheck() {
		allocation = new caseAllocation(driver);
		allocation.caseAllocationCheck();
	}
}
