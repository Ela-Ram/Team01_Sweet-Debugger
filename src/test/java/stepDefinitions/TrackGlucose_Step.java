package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import common.ConfigReader;
import common.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LoginUI_Page;
import pageObject.TrackGlucose_Page;

public class TrackGlucose_Step {

	private TestContext context;
	private TrackGlucose_Page trackGlucose;
	private LoginUI_Page loginUI_page;
	
	public TrackGlucose_Step(TestContext context) {
		
		this.context = context;
		this.trackGlucose=context.getTrackGlucose();
		this.loginUI_page = context.getLoginUI_Page();
	}
	
	@When("User enter Premium User credential")
	public void user_enter_premium_user_credential() {
	    
		String premiumEmail = ConfigReader.getProperty("PremiumUser_Email");
		
		String premiumPwd = ConfigReader.getProperty("Premiumuser_password");
		
		loginUI_page.enterEmail(premiumEmail);
		
		loginUI_page.clickContinueWithEmailButton();
		
		loginUI_page.enterPassword(premiumPwd);
		
		loginUI_page.clickContinueWithEmailButton();
		
	}

	@Given("Premium User is in Home Page")
	public void premium_user_is_in_home_page() {
		
	   trackGlucose.premiumUserHomePage();
	   
	   
	}

	@When("Premium User clicks Blood Glucose")
	public void premium_user_clicks_blood_glucose() {

		trackGlucose.clickGlucoseBtn();
	}

	@Then("Premium User should see {string} Track Glucose Heading")
	public void premium_user_should_see(String expectedHeading) {
		
		Assert.assertTrue(trackGlucose.headingTrackGlucose(), "user should not see heading");
	}
    
	@Then("User should see subtext {string}")
	public void user_should_see_subtext(String string) {
	   
		 Assert.assertTrue(trackGlucose.verifySubtext(),"user not able to see subText");
	}
	
	@Then("User should see field for Blood Glucose Level, Reading Type,Date")
	public void user_should_see_field_for_blood_glucose_level_reading_type_date() {
	    
		Assert.assertTrue(trackGlucose.verifyFieldLabels(),
				"User should not see fields for Blood Glucose level, Reading Type,Date");
	}
	
	@Then("User should see text field for blood glucose")
	public void user_should_see_text_field_for_blood_glucose() {
	   
		Assert.assertTrue(trackGlucose.verifyTextFieldBloodGlcose(),
				"User should not see text field for blood glucose");
	}
	
	@Then("User should see text {string} blood glucose")
	public void user_should_see_text_blood_glucose(String string) {
	    
		Assert.assertEquals(trackGlucose.verifyPlaceholderBloodGulcose(), "Enter blood glucose level");
	}

	@Then("User should see {string} level")
	public void user_should_see_level(String string) {
	
		Assert.assertTrue(trackGlucose.verifymgdl(),"user should not see mgdl level");
	}
	
	@Then("User should see three transition details  with text {string}")
	public void user_should_see_three_transition_details_with_text(String string) {
	    
		Assert.assertTrue(trackGlucose.verifyTextTransitionDetails(),"user should not see three transition details text");
				 
	}

	@Then("User should see Red color in low")
	public void user_should_see_red_color_in_low() {
	    
		String actualHex = trackGlucose.getLowStatusColorHex();
	    System.out.println("Low status color (hex): " + actualHex);

	    Assert.assertEquals(actualHex, "#dc2626", "Low status is not the expected red shade.");
		
	}
	
	@Then("User should see green color in normal")
	public void user_should_see_green_color_in_normal() {
 
	    String actualHex = trackGlucose.getNormalStatusColorHex();
	    System.out.println("Normal status color (hex): " + actualHex);

	    Assert.assertEquals(actualHex, "#16a34a", "Normal status is not the expected green shade.");
	}
	
	@Then("User should see yellow color in high")
	public void user_should_see_yellow_color_in_high() {

		String actualHex = trackGlucose.getHighStatusColorHex();
	    System.out.println("High status color (hex): " + actualHex);
	    Assert.assertEquals(actualHex, "#d97706", "High status is not the expected yellow shade.");
	}
	
	@Then("User should see button {string}")
	public void user_should_see_button(String string) {

		 Assert.assertTrue(trackGlucose.areAllReadingTypeButtonsVisible(),
		            "One or more reading type buttons (Fasting, Pre-meal, Post-meal, Bedtime) are not visible.");
		
	}
	
	@Then("User should see date picker")
	public void user_should_see_date_picker() {

		Assert.assertTrue(trackGlucose.isDatePickerVisible(), "Date picker is not visible.");
	}
	
	@Then("User should see last ready details")
	public void user_should_see_last_ready_details() {
       
		Assert.assertTrue(trackGlucose.isLastReadingDetailsVisible(),
	            "Last reading details are not visible.");

	}
	
	@Then("User should see record reading button")
	public void user_should_see_record_reading_button() {

		 Assert.assertTrue(trackGlucose.isRecordReadingButtonVisible(),
		            "Record Reading button is not visible.");
	}
	
}
