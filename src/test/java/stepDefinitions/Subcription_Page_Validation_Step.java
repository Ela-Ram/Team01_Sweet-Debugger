package stepDefinitions;

import org.testng.Assert;

import common.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.SubscriptionPage_page;


public class Subcription_Page_Validation_Step {
	
	private TestContext context;
	private  SubscriptionPage_page SubscriptionPage;

	public Subcription_Page_Validation_Step(TestContext context) {
		
		this.context = context;
		this.SubscriptionPage =context.getSubscriptionpage();
		
	}
	
	@Given("User should clicks Dashboard menu")
	public void user_should_clicks_dashboard_menu() {
		SubscriptionPage.clickDashboardMenu();
	   
	}

	@When("User should clicks Upgrade to Premium button")
	public void user_should_clicks_upgrade_to_premium_button() {
	    SubscriptionPage.clickUpgradeBtn();
	}

	@Then("Both Free and Premium should show Daily Meal Plan as available")
	public void both_free_and_premium_should_show_daily_meal_plan_as_available() {
	  
		Assert.assertTrue(SubscriptionPage.greenTick(),"Both Free and Premium show Daily Meal Plan");
	
	}

	@Then("Weekly Meal Plan should be available only in Premium")
	public void weekly_meal_plan_should_be_available_only_in_premium() {
	 
		Assert.assertTrue(SubscriptionPage.weeklyMealGreenTick(),"Weekly Meal Plan available only in Premium");
		
	}

	@Then("Personalized Exercise Plan should be available only in Premium")
	public void personalized_exercise_plan_should_be_available_only_in_premium() {
	    
		Assert.assertTrue(SubscriptionPage.PersonalizedExerciseGreenTick(),"Personalized Exercise Plan available only in Premium");
		
	}

	@Then("{int}-Day Quick Reversal Plan should be available only in Premium")
	public void day_quick_reversal_plan_should_be_available_only_in_premium(Integer int1) {
	  
		Assert.assertTrue(SubscriptionPage.quickReversalGreenTick(),"10 Days Quick Reversal Plan");
	}

	@Then("{int}-Day Blood Sugar Reduction Plan should be available only in Premium")
	public void day_blood_sugar_reduction_plan_should_be_available_only_in_premium(Integer int1) {
		
		Assert.assertTrue(SubscriptionPage.bloodSugarGreenTick(),"30 Days Blood Sugar Reduction Plan");
		
	}

	@Then("Both Free and Premium should show Glucose Level Graph as available")
	public void both_free_and_premium_should_show_glucose_level_graph_as_available() {
	   
		Assert.assertTrue(SubscriptionPage.gulcoseLevelFreeUser() && SubscriptionPage.gulcoseLevelPremiumUser(), 
			    "Glucose Level Graph should be available for both Free and Premium users");
	}

	@Then("Both Free and Premium should show BMI Calculation as available")
	public void both_free_and_premium_should_show_bmi_calculation_as_available() {

		Assert.assertTrue(SubscriptionPage.BMIfreeUser() && SubscriptionPage.BMIpremiumUser(),
				"BMI should be available for both free and premium Users");
	}

	@Then("Downloadable Meal Plan PDF should be available only in Premium")
	public void downloadable_meal_plan_pdf_should_be_available_only_in_premium() {
	
		Assert.assertTrue(SubscriptionPage.downloadablePremiumUser(),"Downloadable Meal Plan PDF should be available only in Premium");
	}

	@Then("Reminders should be available only in Premium")
	public void reminders_should_be_available_only_in_premium() {
	
		Assert.assertTrue(SubscriptionPage.remainderMAHpremiumUser(),"Reminders should be available only in Premium");
	}

	@Then("The {string} button should be visible")
	public void the_button_should_be_visible(String string) {

		Assert.assertTrue(SubscriptionPage.goForFreeBtn(),"Go For Free Button is visible");
	}

	@Then("The {string} premium button should be visible")
	public void the_premium_button_should_be_visible(String string) {
		
		Assert.assertTrue(SubscriptionPage.upgradeToPremiumBtn(),"Upgrade Premium Button is visible");
	}
	
	@Then("It should display {string} with {string} FreeAccount")
	public void it_should_display_with1(String string, String string2) {
	
		Assert.assertTrue(SubscriptionPage.checkFreeAccountLabel(), "\"Free Account\" label with \"$0 /month\" should be visible");
		
		String labelText = SubscriptionPage.getFreeAccountLabelText();
		    Assert.assertTrue(labelText.contains("Free Account"), "Text should contain 'Free Account'");
		    Assert.assertTrue(labelText.contains("$0"), "Text should contain '$0'");
		    Assert.assertTrue(labelText.contains("/month"), "Text should contain '/month'");
	}
	@Then("It should display {string} with {string} PremiumAccount")
	public void it_should_display_with(String string, String string2) {
	
		    Assert.assertTrue(SubscriptionPage.isPremiumAccountLabelDisplayed(), "Premium Account label should be visible");
		    String labelText = SubscriptionPage.getPremiumAccountLabelText();
		    Assert.assertTrue(labelText.contains("Premium Account") && labelText.contains("$9.99") && labelText.contains("/month"),
		    	    "Label should display 'Premium Account' with '$9.99 /month'");

		}

	@Then("Features not included should have red X icons")
	public void features_not_included_should_have_red_x_icons() {
       
		int actualCount = SubscriptionPage.getRedXIconCount();
	    Assert.assertTrue(actualCount > 0, "No red X icons found for excluded features");
	    Assert.assertTrue(SubscriptionPage.allRedXIconsAreDisplayed(), "Not all red X icons are visible");
		
	}

	@Then("All included features should have green checkmarks")
	public void all_included_features_should_have_green_checkmarks() {

		int count = SubscriptionPage.getGreenTickCount();
	    Assert.assertTrue(count > 0, "No green checkmarks found");
	    Assert.assertTrue(SubscriptionPage.areAllGreenTicksDisplayed(), "Some green checkmarks are not visible");
	}

	@Then("It should list exactly {int} features")
	public void it_should_list_exactly_features(Integer int1) {

		int expectedFeatureCount = 9;
	    Assert.assertEquals(SubscriptionPage.getFeatureCount(), expectedFeatureCount, "Feature count mismatch");
	
	}

	@Then("The {string} button should appear under the Free column")
	public void the_button_should_appear_under_the_free_column(String string) {
     
		Assert.assertTrue(SubscriptionPage.isContinueFreeButtonDisplayed(), 
		        "\"Go for free\" (Continue Free) button should be visible under Free column");
		
	}

	@Then("The {string} button should appear under the Premium column")
	public void the_button_should_appear_under_the_premium_column(String string) {
      
		Assert.assertTrue(SubscriptionPage.isUpgradeToPremiumButtonDisplayed(), 
		        "\"Upgrade to Premium\" button should be visible under the Premium column");

	}

	@Then("Terms & Conditions and Privacy Policy text should be visible")
	public void terms_conditions_and_privacy_policy_text_should_be_visible() {

		Assert.assertTrue(SubscriptionPage.isTermsAndConditionsVisible(), "Terms & Conditions text should be visible");
	    Assert.assertTrue(SubscriptionPage.isPrivacyPolicyVisible(), "Privacy Policy text should be visible");
	}

	@Then("It should show the text “Upgrade to premium for complete diabetes management”")
	public void it_should_show_the_text_upgrade_to_premium_for_complete_diabetes_management() {
		  
		Assert.assertTrue(SubscriptionPage.isUpgradeMessageDisplayed(),"Upgrade message should be visible");

		    String expectedText = "Upgrade to premium for complete diabetes management";
		    Assert.assertEquals(SubscriptionPage.getUpgradeMessageText().trim(), expectedText,"Upgrade message text does not match");

	}

	@Then("The Free and Premium plans should be displayed side-by-side in clearly separated columns")
	public void the_free_and_premium_plans_should_be_displayed_side_by_side_in_clearly_separated_columns() {

		 Assert.assertTrue(SubscriptionPage.areBothPlanColumnsDisplayed(), 
			        "Free and Premium plan columns should both be visible side by side");
	}

	
	
}
