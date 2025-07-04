package stepDefinitions;

import org.testng.Assert;

import common.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.UpgradeToPremiumSubscription_Page;

public class UpgradeToPremiumSubscription_Step {
	
	private TestContext context;
	private UpgradeToPremiumSubscription_Page premiumSubscription;
	
	public UpgradeToPremiumSubscription_Step (TestContext context) {
		
		this.context = context;
		this.premiumSubscription=context.getpremiumSubscription();
	}
	

	@Given("User is in upgrade to premium page")
	public void user_is_in_upgrade_to_premium_page() {
		
		premiumSubscription.navigateToPremiumPage();
	}
	
	@When("User clicks the {string} button without entering any card details")
	public void user_clicks_the_button_without_entering_any_card_details(String string) {
		
		
	    premiumSubscription.isClickPayBtn();
	}
	
	@Then("User should see validation messages for all required fields")
	public void user_should_see_validation_messages_for_all_required_fields() {
		
	  Assert.assertTrue(premiumSubscription.areAllPaymentErrorsDisplayed(),"One or more payment validation messages are not displayed.");
	
	}
	
	@When("User clicks the {string} button with invalid card number")
	public void user_clicks_the_button_with_invalid_card_number(String string) {

		premiumSubscription.invalidCardNumberInput();
		premiumSubscription.isClickPayBtn();
	}
	
	@Then("error message should be displayed")
	public void error_message_should_be_displayed() {
	    
	Assert.assertTrue(premiumSubscription.cardNumberErrorDisplayed(),"Card Number error message is not displayed");
	}
	
	@When("User clicks the {string} button with expired card")
	public void user_clicks_the_button_with_expired_card(String string) {
		
	   premiumSubscription.expiredDateInput();
	   premiumSubscription.isClickPayBtn();
	}
	
	@Then("error message should be displayed condition for expired card")
	public void error_message_should_be_displayed_condition_for_expired_card() {
	    
		Assert.assertTrue(premiumSubscription.expirationDateErrorDisplayed(),"Error message should nott displayed for Expired Card");
	}
	
	@When("User clicks the {string} button with valid payment details")
	public void user_clicks_the_button_with_valid_payment_details(String string) {
	  
		premiumSubscription.validPaymentDetails(); 
	//	premiumSubscription.isClickPayBtn();
	}
	
	@Then("User should be redirected to the confirmation or home page with premium access enabled")
	public void user_should_be_redirected_to_the_confirmation_or_home_page_with_premium_access_enabled() {
	   
		premiumSubscription.clickHomePageBtn();
		premiumSubscription.navigateToPremiumAccessOfHomePage();
	}

}
