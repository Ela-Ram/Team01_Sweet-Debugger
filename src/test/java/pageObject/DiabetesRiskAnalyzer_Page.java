package pageObject;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.jspecify.annotations.Nullable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import common.ExcelReader;
import common.Helper;
import common.TestContext;
import io.cucumber.datatable.DataTable;

public class DiabetesRiskAnalyzer_Page {
	private WebDriver driver;
	private Helper helper;
	LaunchPage_Page launch_pageObj;
	
	

@FindBy (xpath="//div/p[text()='Answer a few questions to assess your risk of developing diabetes']")
By instructionOnRiskAnalyzer;
@FindBy (xpath="//button[text()='Cancel']")
WebElement cancelButton;
@FindBy (xpath="//button[text()='Calculate Risk']")
WebElement calRiskButton;
@FindBy (xpath="//div/input[@id='risk_age']")
WebElement ageField;
@FindBy (xpath="//div/input[@id='risk_weight']")
WebElement weightField;
@FindBy (xpath="//input[@id='risk_familyHistory']")
WebElement familyHisCheckbox;
@FindBy (xpath="//select[@id='risk_activity']")
WebElement PhyActivityLevelDropbox;
@FindBy (xpath="//select[@id='risk_bloodPressure']")
WebElement BloodPressureDropbox;
@FindBy (xpath="//select[@id='risk_diet']")
WebElement DietQualDropbox;
@FindBy (xpath="//div[@id='radix-:r3:']")
WebElement DiabetesRiskAnalyzerPage;
@FindBy (xpath="//div/h2[@id='radix-:r4:']")
WebElement AssessmentResult;


public DiabetesRiskAnalyzer_Page(TestContext context)
{
	this.driver = context.getDriver();
	this.helper = context.getHelper();
	PageFactory.initElements(driver, this);
	this.launch_pageObj = context.getLaunch_PageObj();
	
}

public void isInstructionDisplayed(String expectedInstruction)
{
	String pageSource = driver.getPageSource();
	boolean actual = pageSource.contains(expectedInstruction);	
	Assert.assertEquals(actual, true);
	System.out.println("Passed: Instruction dispalyed as expected");
}

public void isCancelButtonPresent()
{
	Assert.assertEquals(cancelButton.isDisplayed(), true);
	System.out.println("PAssed: Cancel button is present");
	}

public void isCalRiskButtonPresent()
{
	Assert.assertEquals(calRiskButton.isDisplayed(), true);
	System.out.println("PAssed: Calculate Risk button is present");
	}

public void isCalRiskButtonDisabled()
{
	boolean expected = calRiskButton.isEnabled();
	Assert.assertEquals(expected,false);
	System.out.println("Passed: Button is disabled");
}

public void isAgefiledwithStepperControl() 
{
	String fieldType = ageField.getAttribute("type");
	String expectedType = "number";
	if (expectedType.equals(fieldType)) 
	{
		Assert.assertEquals(expectedType, fieldType);
		System.out.println("Age field is a number input with steppers");
	}
	else
	{
		System.out.println("Age field is not a number input with steppers");
	}
}

public void isWeightfiledwithStepperControl() 
{
	String fieldType = weightField.getAttribute("type");
	String expectedType = "number";
	Assert.assertEquals("Weight field is a number input with steppers",expectedType, fieldType);
	System.out.println("Weight field is a number input with steppers");
	
}

	public void isFamilyHisCheckboxDispalyed()
	{
		boolean expected = familyHisCheckbox.isDisplayed();
		Assert.assertEquals("Not available",expected, true);
		System.out.println("PAssed: Family History checkbox is present");
	}

	public void placeholderAgeField(String expectedPlaceHolderVal)
	{
		String placeHolder = ageField.getAttribute("placeholder");
		String expectedVal = expectedPlaceHolderVal;
		Assert.assertEquals(expectedVal,placeHolder);	
		System.out.println("PAssed: placeholder value " +placeHolder+ " is present");
	}

	public void placeholderWeightField(String expectedPlaceHolderVal)
	{
		String placeHolder = weightField.getAttribute("placeholder");
		String expectedVal = expectedPlaceHolderVal;
		Assert.assertEquals(expectedVal,placeHolder);	
		System.out.println("PAssed: placeholder value " +placeHolder+ " is present");
	}

	public void isPhyActivityLeveldropboxpresent()
	{
		boolean exectedfield = PhyActivityLevelDropbox.isDisplayed();
		Assert.assertEquals(exectedfield,true);
		System.out.println("Passed: expected field is present");
	}
	public void isBloodPressuredropboxpresent()
	{
		boolean exectedfield = BloodPressureDropbox.isDisplayed();
		Assert.assertEquals(exectedfield,true);
		System.out.println("Passed:  expected field is present");
	}

	public void isDietQualdropboxpresent()
	{
		boolean exectedfield = DietQualDropbox.isDisplayed();
		Assert.assertEquals(exectedfield,true);
		System.out.println("Passed:  expected field is present");
	}
	public void defaultPhyActLevValue(String defaultval1)
	{	
		WebElement activityDropdown = driver.findElement(By.id("risk_activity"));
		Select select = new Select(activityDropdown);
	    WebElement selectedOption = select.getFirstSelectedOption();
	    String expected = defaultval1;
	    String actualText = selectedOption.getText();
	    Assert.assertEquals("Default option text mismatch!", expected, actualText);
	    System.out.println("Passed: Default value selected is " +actualText);	
	}

	public void defaultBloodPressureValue(String defaultval2)
	{	
		WebElement bloodPressureDropdown = driver.findElement(By.id("risk_bloodPressure"));
		
		Select select = new Select(bloodPressureDropdown);
	    WebElement selectedOption = select.getFirstSelectedOption();
	    String expected = defaultval2;
	    String actualText = selectedOption.getText();
	    Assert.assertEquals("Default option text mismatch!", expected, actualText);
	    System.out.println("Passed: Default value selected is " +actualText);	
	}
	
	public void defaultDietQualityValue(String defaultval3)
	{	
		WebElement dietQualityDropdown = driver.findElement(By.id("dietQualityDropdown"));

		Select select = new Select(dietQualityDropdown);
	    WebElement selectedOption = select.getFirstSelectedOption();
	    String expected = defaultval3;
	    String actualText = selectedOption.getText();
	    Assert.assertEquals("Default option text mismatch!", expected, actualText);
	    System.out.println("Passed: Default value selected is " +actualText);	
	}
	
	public void physicalActivityDropDownOption(DataTable dataTable) {
	   
	    List<String> expectedOptions = dataTable.asList();

	    WebElement dropdownElement = driver.findElement(By.id("risk_activity")); 
	    Select dropdown = new Select(dropdownElement);

	    List<String> actualOptions = dropdown.getOptions()
	        .stream()
	        .map(option -> option.getText().trim())
	        .collect(Collectors.toList());

	    Assert.assertEquals("Dropdown options do not match expected values.", expectedOptions, actualOptions);
	}


	public void bloodPressureDropDownOptions(DataTable dataTable) {
		   
	    List<String> expectedOptions = dataTable.asList();

	    WebElement dropdownElement = driver.findElement(By.id("risk_bloodPressure")); 
	    Select dropdown = new Select(dropdownElement);

	    List<String> actualOptions = dropdown.getOptions()
	        .stream()
	        .map(option -> option.getText().trim())
	        .collect(Collectors.toList());

	    Assert.assertEquals("Dropdown options do not match expected values.", expectedOptions, actualOptions);
	}

	public void dietQualityDropDownOptions(DataTable dataTable) {
		   
	    List<String> expectedOptions = dataTable.asList();

	    WebElement dropdownElement = driver.findElement(By.id("risk_diet")); 
	    Select dropdown = new Select(dropdownElement);

	    List<String> actualOptions = dropdown.getOptions()
	        .stream()
	        .map(option -> option.getText().trim())
	        .collect(Collectors.toList());

	    Assert.assertEquals("Dropdown options do not match expected values.", expectedOptions, actualOptions);
	}


	public boolean naviagtedToRiskAnalyzer() 
	{
	
		boolean expectedpage = DiabetesRiskAnalyzerPage.isDisplayed();
		return expectedpage;
		
	}
	
	

	public void clickCancel()
	{
		cancelButton.click();
	}
	
	public void clickCalRiskAnalyzerbtn()
	{
		calRiskButton.click();
	}

	public void homePage(String homepage)
	{
		boolean currentPage = driver.getCurrentUrl().contains(homepage);
		System.out.println("*****"+currentPage);
		Assert.assertEquals(currentPage,true);
		System.out.println("PAssed: User navigated to Home Page");
		
	}
	
	public void enterAge(String Age) {
	    ageField.sendKeys(Age);      
	}
	
	public void enterWeight(String Weight) {
	    weightField.sendKeys(Weight);      
	}
	
	public void selectphysicalActivity(String PhysicalActivityLevel) {
		PhyActivityLevelDropbox.sendKeys(PhysicalActivityLevel);  
	   
	}
	
	public void selectBloodPressure(String BloodPressure) {
		BloodPressureDropbox.sendKeys(BloodPressure);      
	}
	
	public void selectDietQuality(String DietQuality) {
		DietQualDropbox.sendKeys(DietQuality);      
	}

	public void fillRiskAnalyzerForm(String Sheet, String TestCaseId)
	{
		Map<String, String> testData = ExcelReader.getTestData(Sheet, TestCaseId);
			String Age = testData.get("Age");
			String Weight = testData.get("Weight");
			String PhysicalActivityLevel = testData.get("PhysicalActivityLevel");
			String BloodPressure = testData.get("BloodPressure");
			String DietQuality =  testData.get("DietQuality");
			
			enterAge(Age);
			enterWeight(Weight);
			selectphysicalActivity(PhysicalActivityLevel);
			selectBloodPressure(BloodPressure);
			selectDietQuality(DietQuality);	
	
	}
	
	public void fillRiskAnalyzerForm1(String launch, String launch_01)
	{
		Map<String, String> testData = ExcelReader.getTestData(launch, launch_01);
			String Age = testData.get("Age");
			String Weight = testData.get("Weight");
			String PhysicalActivityLevel = testData.get("PhysicalActivityLevel");
			String BloodPressure = testData.get("BloodPressure");
			String DietQuality =  testData.get("DietQuality");
			
			enterAge(Age);
			enterWeight(Weight);
			selectphysicalActivity(PhysicalActivityLevel);
			selectBloodPressure(BloodPressure);
			selectDietQuality(DietQuality);	
	
	}
	
	public boolean isCalRiskButtonEnabled()
	{
		return calRiskButton.isEnabled();
		
	}
	
	public void isAssessmentReultPageDispalyed(String assessmentResult)
	{
		String pagesource = driver.getPageSource();
		boolean expected = pagesource.contains(assessmentResult);
		Assert.assertEquals(expected,true);
		System.out.println("PAssed: User is navigate to the " +assessmentResult+ " Page");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	





	}


