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
		String regemail = ConfigReader.getProperty("Reg_Email");;
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

	

}
