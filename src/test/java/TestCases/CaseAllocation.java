package TestCases;

import org.testng.annotations.Test;

import ReusableCodeForTestCases.BaseTest;
import pageObjectsFile.caseAllocation;

public class CaseAllocation extends BaseTest {
	@Test
	public void allocationCheck() {
		allocation = new caseAllocation(driver);
		System.out.println("In Allocation Check Methrod");
		allocation.caseAllocationFilterCheck();
	}

	@Test
	public void caseSearchViaInputBox() {
		allocation = new caseAllocation(driver);
		System.out.println("In case Search Via Input Box");
		allocation.searchCasesByInputSearch();
	}

	@Test
	public void allocateCase() {
		allocation = new caseAllocation(driver);
		System.out.println("In allocate single Case");
		allocation.allocateSingleCase();
	}
	
	@Test
	public void bulkAlloationCheck() throws InterruptedException {
		allocation = new caseAllocation(driver);
		System.out.println("In bulk Alloation Check");
		allocation.bulkAlloation();
	}

}
