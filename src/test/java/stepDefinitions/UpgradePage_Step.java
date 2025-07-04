package stepDefinitions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import common.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.UpgradePage_page;

public class UpgradePage_Step {

	private TestContext context;
	private UpgradePage_page UpgradePage;
	

	public UpgradePage_Step(TestContext context) {
		
		this.context = context;
		this.UpgradePage =context.getUpgradepage();
		
	}
	
	@Given("User is in upgrade page")
	public void user_is_in_upgrade_page() {
	 
		 UpgradePage.navigateToUpgradePage();
	}
	
	@When("User clicks the {string} button")
	public void user_clicks_the_button(String string) {
	    UpgradePage.clickUpgradeToPremiumBtn();
	}
	
	@Then("User should be redirected to the subscription payment screen")
	public void user_should_be_redirected_to_the_subscription_payment_screen() {
	 
		  Assert.assertTrue(UpgradePage.isPaymentScreenVisible(),"Payment screen is not visible");
	}
	
	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedHeading) {
		Assert.assertTrue(UpgradePage.isUpgradeHeadingVisible(),"Upgrade page heading not visible");
	}
	
	@Then("User should see {string}")
	public void user_should_see(String expectedMessage) {
	   
		Assert.assertTrue(UpgradePage.isUpgradeMessageVisible(),"Upgrade message is not visible");

	   Assert.assertEquals(UpgradePage.getUpgradeMessageText(), expectedMessage, "Upgrade message text mismatch!");
	}
	
	@Then("User should see text {string}")
	public void user_should_see_text(String string) {
		
		 Assert.assertTrue(UpgradePage.isPremiumFeaturesTextVisible(),"'premium features' text is not visible on the page");
	  
	}
	@Then("User should see text list of\"✓Personalized meal plans,✓Advanced analytics,✓Priority support\"")
	public void user_should_see_text_list_of_personalized_meal_plans_advanced_analytics_priority_support() {
	
		Assert.assertTrue(UpgradePage.areAllFeaturesVisible(), "Not all premium features are visible");
	}
	
	@Then("User should see monthly price {string}")
	public void user_should_see_monthly_price(String expectedText) {
		
		Assert.assertTrue(UpgradePage.isPremiumPriceTextVisible(),"Expected text '" + expectedText + "' is not visible");
	}
	
	@Then("User should see cancel anytime text below the pricing details")
	public void user_should_see_cancel_anytime_text_below_the_pricing_details() {
		
		Assert.assertTrue(UpgradePage.isCancelAnytimeTextVisible(), "'Cancel anytime' text is not visible");
	    Assert.assertTrue(UpgradePage.isCancelAnytimeTextBelowPrice(), "'Cancel anytime' text is not positioned below the pricing details");
	}
	
	@Then("User should see heading {string}")
	public void user_should_see_heading(String expectedHeading) {
		
		
		String actualHeading = UpgradePage.getHeadingText(); 
	    System.out.println("Actual heading text: '" + actualHeading + "'");
	    Assert.assertEquals(actualHeading, expectedHeading, "Heading text mismatch");
	
	}
	
	@Then("User should see card number, expiration , cvv field")
	public void user_should_see_card_number_expiration_cvv_field() {
	
		Assert.assertTrue(UpgradePage.areCardFieldsVisible(), "One or more Stripe payment fields are not visible.");
	}
	
	@Then("User should see {string} button")
	public void user_should_see_button(String string) {
	  
		 Assert.assertTrue(UpgradePage.isPayButtonVisible(), "Pay button is not visible");
	}
	
	@Then("User should see terms of service and auto-renewal notice")
	public void user_should_see_terms_of_service_and_auto_renewal_notice() {
	    
		Assert.assertTrue(UpgradePage.isTermsAndAutoRenewalNoticeVisible(),"Terms of Service and auto-renewal notice is not visible");
	
	}
	@Then("User should see presence of terms {string}")
	public void user_should_see_presence_of_terms(String expectedText) {
	 
		String actualText = UpgradePage.getTermsAndRenewalText();
	    System.out.println("Actual Text: " + actualText);
	    Assert.assertEquals(actualText, expectedText, "Terms and auto-renewal text does not match.");
	}
	
	@When("user clicks the {string} free button")
	public void user_clicks_the_free_button(String string) {
		
	    UpgradePage.clickContinueFreeBtn();
	}
	
	@Then("User should be redirected to the home page")
	public void user_should_be_redirected_to_the_home_page() {
		Assert.assertTrue(UpgradePage.isHomePageDisplayed(), "User not redirected to the home page");
		
	}
		
}
