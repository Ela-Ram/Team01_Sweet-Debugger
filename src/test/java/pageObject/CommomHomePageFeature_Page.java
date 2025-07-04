package pageObject;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.ExcelReader;
//import common.Helper;
import common.TestContext;

public class CommomHomePageFeature_Page {

	
		private WebDriver driver;
		//private Helper helper;
		LaunchPage_Page launch_pageObj;
		DiabetesRiskAnalyzer_Page diaRiskAnalyzerPageObj;
		
		
		
	public CommomHomePageFeature_Page(TestContext context)
	{
		this.driver = context.getDriver();
		//this.helper = context.getHelper();
		PageFactory.initElements(driver, this);
		this.launch_pageObj = context.getLaunch_PageObj();
		this.diaRiskAnalyzerPageObj = context.getDiaRiskAnalyzerPageObj();
	}	
		
	@FindBy (xpath="//button[contains(text(), 'Create Account')]")
	WebElement CreateAccountButton;
	@FindBy (xpath="//input[@id=':r6:-form-item']")
	WebElement emailField;
	@FindBy(xpath = "//input[@name='password']") 
	WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']") WebElement continueWithEmailButton;
	@FindBy(xpath = "//input[@id=':rd:-form-item']") WebElement firstNameField;
	@FindBy(xpath = "//button[@id='terms']") WebElement checkPrivacyPolicy;
	
	public void clickCreateAccountButton()
	{
		CreateAccountButton.click();
	}
	
	public void enterEmail(String email) {
	    emailField.sendKeys(email);      
	}
	
	public void enterPassword(String password) {
		   passwordField.sendKeys(password);      
		}
	
	 public void clickContinueWithEmailButton() {
		   continueWithEmailButton.click();  
	   }

	public void enterEmailID(String launch, String launch_02)
	{
		Map<String, String> testData = ExcelReader.getTestData(launch, launch_02);
		String email = testData.get("Email");
		enterEmail(email);
		clickContinueWithEmailButton();
	}
	
	public void enterFirstName()
	{
		
	}




























































}

