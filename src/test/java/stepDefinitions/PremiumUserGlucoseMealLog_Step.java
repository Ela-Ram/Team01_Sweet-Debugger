package stepDefinitions;

import org.testng.Assert;
import common.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.PremiumUserLogbook_Page;

public class PremiumUserGlucoseMealLog_Step {
	
	private TestContext context;
	private  PremiumUserLogbook_Page logbookPageObj;
	boolean isVisible;

	public PremiumUserGlucoseMealLog_Step (TestContext context) {
		this.context = context;
		this.logbookPageObj = context.getPremiumUserLogbook_page();
	}
	
	@When("User clicks Logbook button of premium account")
	public void user_clicks_logbook_button_of_premium_account() {
		logbookPageObj.clickLogBookBtn();
	}

	@Then("User should see {string} section of premium account")
	public void user_should_see_of_section_of_premium_account(String scenario) {
		isVisible = logbookPageObj.isElementDisplayed(scenario);
		Assert.assertTrue(isVisible, scenario + " is not visible");	    
	}

	@Then("User should see title {string} of premium account")
	public void user_should_see_title_of_premium_account(String scenario) {
	    String actTitle = logbookPageObj.getText(scenario);
	    Assert.assertEquals(actTitle, scenario);
	}

	@Then("User should see {string} displayed in {string} of premium account")
	public void user_should_see_displayed_in_of_premium_account(String scenario, String rgba) {
	    String actColor = logbookPageObj.getColor(scenario);
	    Assert.assertTrue(actColor.contains(rgba), "Color does not match");
	}

	@Then("User should see the range for {string} be {string} of premium account")
	public void user_should_see_the_range_for_be_of_premium_account(String scenario, String range) {
		String actRange = logbookPageObj.getText(scenario);
	    Assert.assertEquals(actRange, range); 
	}

	@Then("User should see the X-axis display the last seven days ending today for {string} of premium account")
	public void user_should_see_the_x_axis_display_the_last_seven_days_ending_today_for_of_premium_account(String scenario) {
		boolean lastSevenDays = logbookPageObj.checkLastSevenDaysXAxis(scenario);
		Assert.assertTrue(lastSevenDays, "Last Seven Days not displayed");
	}

	@Then("User should see Y-axis minimum value  {int} in glucose chart")
	public void user_should_see_y_axis_minimum_value_in_glucose_chart(Integer value) {
		String actValue = logbookPageObj.getText("yAxisMin");
	    Assert.assertEquals(actValue, Integer.toString(value));	    
	}

	@Then("User should see Y-axis Maximum value {int} in glucose chart")
	public void user_should_see_y_axis_maximum_value_in_glucose_chart(Integer value) {
		String actValue = logbookPageObj.getText("yAxisMax");
	    Assert.assertEquals(actValue, Integer.toString(value));	    	    
	}

	@Then("User should see Icon  on the left side of Meal & Nutrition title of premium account")
	public void user_should_see_icon_on_the_left_side_of_title_of_premium_account() {
		isVisible = logbookPageObj.isElementDisplayed("Meal Icon");
		Assert.assertTrue(isVisible, "Meal Icon is not visible");		    
	}

	@Then("User should see the section {string} of premium account")
	public void user_should_see_the_section_of_premium_account(String scenario) {
		isVisible = logbookPageObj.isElementDisplayed(scenario);
		Assert.assertTrue(isVisible, scenario + " is not visible");	    
	}

	@Then("User should see {string} text colour {string} of premium account")
	public void user_should_see_text_colour_of_premium_account(String scenario, String rgba) {
		String actColor = logbookPageObj.getColor(scenario);
	    Assert.assertTrue(actColor.contains(rgba), "Color does not match");
	}

	@Then("User should see {string} with nutrient distribution for premium account")
	public void user_should_see_bars_with_nutrient_distribution_of_premium_account(String scenario) {
		isVisible = logbookPageObj.isElementDisplayed(scenario);
		Assert.assertTrue(isVisible, scenario + " is not visible");		    
	}


	@Then("User should see the value in the {string} Daily nutrition breakdown section")
	public void user_should_see_the_value_in_the_Daily_nutrition_breakdown_section(String scenario) {
		String actValue = logbookPageObj.getText(scenario);
	    Assert.assertNotEquals(actValue, "0g (0%)");	    
	}

}
