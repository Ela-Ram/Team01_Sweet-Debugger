package stepDefinitions;

import java.util.Map;

import org.testng.Assert;

import common.ConfigReader;
import common.ExcelReader;
import common.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LoginUI_Page;

public class Login_Step {
	
	private TestContext context;
	private  LoginUI_Page loginUI_page;
	
	public Login_Step(TestContext context) {
	this.context = context;
    this.loginUI_page = context.getLoginUI_Page();
	}
	
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
		loginUI_page.clickLoginGutton();
	}
	
	@When("User clicks continue with email button after entering a email as in {string} and {string}")
	public void user_clicks_continue_with_email_button_after_entering_a_email_as_in_and(String Sheet, String Testcase_ID) {
		Map<String, String> testData = ExcelReader.getTestData(Sheet, Testcase_ID);
		String email = testData.get("Email");
		loginUI_page.enterEmail(email);
		loginUI_page.clickContinueWithEmailButton();
	}

	@Then("User should see Complete your profile")
	public void user_should_see_complete_your_profile() {
		Assert.assertTrue(loginUI_page.isCompleteProfileFormDisplayed(),"Complete profile form not displayed");
	}

	@Then("User should see validation error")
	public void user_should_see_validation_error() {
		String expected = ExcelReader.getTestData("login", "login_02").get("Expected");
		String actual = loginUI_page.getEmailErrorText();
	    Assert.assertEquals(actual, expected, "Mismatch");
	}
	
	@When("Registered user clicks continue with email button after entering valid email")
	public void registered_user_clicks_continue_with_email_button_after_entering_valid_email() {
		String regemail = ConfigReader.getProperty("Reg_Email");
		loginUI_page.enterEmail(regemail);
		loginUI_page.clickContinueWithEmailButton();
	}
	
	

	@Then("User should see password field")
	public void user_should_see_password_field() {
		Assert.assertTrue(loginUI_page.isPasswordFieldVisible(),"Password Field not displayed");
	   
	}

	@Then("User should see Sign in button")
	public void user_should_see_sign_in_button() {
		 Assert.assertTrue(loginUI_page.isContinueWithEmailButtonEnabled(),"SignIn Button not displayed");
	}

	@Then("User should see email id  in sub text")
	public void user_should_see_email_id_in_sub_text() {
		Assert.assertTrue(loginUI_page.isEmailSubTextVisible(),"Email subtext is not visible");
	}

	@Then("User should see Forgot password link")
	public void user_should_see_forgot_password_link() {
		Assert.assertTrue(loginUI_page.isForgotPasswordlink(),"ForgotPasswordlink is not visible");
	}

	@Then("User should see expected Text as in {string} and {string}")
	public void user_should_see_expected_text_as_in_and(String Sheet, String TestCaseID) {
		Map<String, String> testData = ExcelReader.getTestData(Sheet, TestCaseID);
		String expected = testData.get("Expected");
		String actual = loginUI_page.getPasswordText();
		Assert.assertEquals(actual.trim(), expected.trim(), "Text mismatch:\nExpected: " + expected + "\nActual: " + actual);
	    
	}

	@When("Registered user clicks sign in after entering password")
	public void registered_user_clicks_sign_in_after_entering_password() {
		String regemail = ConfigReader.getProperty("Reg_Email");
		String password = ConfigReader.getProperty("password");
		loginUI_page.enterEmail(regemail);
		loginUI_page.clickContinueWithEmailButton();
		loginUI_page.enterPassword(password);
		loginUI_page.clickContinueWithEmailButton();
	}

	@Then("User should be navigted to Home page")
	public void user_should_be_navigted_to_home_page() {
		Assert.assertTrue(loginUI_page.isHomePageLoaded(),"Home Page is not visible");
	    
	}

	@Then("User should see Full Name input field")
	public void user_should_see_full_name_input_field() {
		Assert.assertTrue(loginUI_page.isFullNameFieldVisible(),"Full name field is not visible");
		
	}
	
	@Then("User should see Username input field")
	public void user_should_see_username_input_field() {
		Assert.assertTrue(loginUI_page.isUserNameFieldVisible(),"Username field is not visible");
	   
	}
	@Then("User should see Password input field")
	public void user_should_see_password_input_field() {
		Assert.assertTrue(loginUI_page.isPasswordFieldVisible(),"Password field is not visible");
	    
	}

	@Then("User should see Terms & Conditions checkbox")
	public void user_should_see_terms_conditions_checkbox() {
		Assert.assertTrue(loginUI_page.isCheckBoxVisible(),"Check Box is not visible");
	    
	}
	@Then("User should see Disabled Create Account button")
	public void user_should_see_disabled_create_account_button() {
		Assert.assertTrue(loginUI_page.isCreateAccountButtonDisabled(),"Create Account is not disabled");
	}

	@Given("User is on complete profile form page after entering email as in {string} and {string}")
	public void user_is_on_complete_profile_form_page_after_entering_email_as_in_and(String Sheet, String TestCaseID) {
		Map<String, String> testData = ExcelReader.getTestData(Sheet, TestCaseID);
		loginUI_page.clickLoginGutton();
		String email = testData.get("Email");
		loginUI_page.enterEmail(email);
		loginUI_page.clickContinueWithEmailButton();
		
	}

	@When("User checks the Terms & conditions box after filling all fields as in {string} and {string}")
	public void user_checks_the_terms_conditions_box_after_filling_all_fields_as_in_and(String Sheet, String TestCaseID) {
		Map<String, String> testData = ExcelReader.getTestData(Sheet, TestCaseID);
		String fullname= testData.get("Fullname");
		String username = testData.get("Username");
		String password = testData.get("Password");
		loginUI_page.enterAllFieldsCompleteForm(fullname, username, password);
		loginUI_page.clickCheckbox();
	    
	}

	@Then("Create Account button should be enabled")
	public void create_account_button_should_be_enabled() {
		 Assert.assertTrue(loginUI_page.isCreateAccountButtonEnabled(),"Create Account is not enabled");
	    
	}
	@When("User clicks create account button after filling all fields as in {string} and {string}")
	public void user_clicks_create_account_button_after_filling_all_fields_as_in_and(String Sheet, String TestCaseID) {
		Map<String, String> testData = ExcelReader.getTestData(Sheet, TestCaseID);
		String fullname= testData.get("Fullname");
		String username = testData.get("Username");
		String password = testData.get("Password");
		loginUI_page.enterAllFieldsCompleteForm(fullname, username, password);
		loginUI_page.clickCheckbox();
		loginUI_page.clickCreateAccountButton();
	    
	}

	
	@Then("User should see {string} in login")
	public void user_should_see_in_login(String expected) {
		switch (expected.toLowerCase().trim()) {
      case "Fullname error message":
      	Assert.assertTrue(loginUI_page.isFullNameErrorVisible(),"FullName Error is not visible");
  	    break;
      case "Username error message":
      	Assert.assertTrue(loginUI_page.isUserNameErrorVisible(),"UserName Error is not visible");
  	    break;
     case "upload blood report":
      	Assert.assertTrue(loginUI_page.isUploadBloodReportButtonVisible(),"Blood Report Button is not visible");
  	    break;
      case "Step Through Onboarding button ":
     	 Assert.assertTrue(loginUI_page.isStepThroughOnboardingButtonVisible(),"Step Through Onboarding Button is not visible");
           break;
	}
	}

	

}
