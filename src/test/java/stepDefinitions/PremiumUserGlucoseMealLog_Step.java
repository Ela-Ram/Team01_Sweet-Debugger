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
	
	@When("User clicks Logbook button")
	public void user_clicks_logbook_button() {
		logbookPageObj.clickLogBookBtn();
	}

	@Then("User should see {string}")
	public void user_should_see(String scenario) {
		isVisible = logbookPageObj.isElementDisplayed(scenario);
		Assert.assertTrue(isVisible, scenario + " is not visible");	    
	}

	@Then("User should see title {string}")
	public void user_should_see_title(String scenario) {
	    String actTitle = logbookPageObj.getText(scenario);
	    Assert.assertEquals(actTitle, scenario);
	}

	@Then("User should see {string} displayed in {string}")
	public void user_should_see_displayed_in(String scenario, String rgba) {
	    String actColor = logbookPageObj.getColor(scenario);
	    Assert.assertEquals(actColor, rgba);
	    
	}

	@Then("User should see the range for {string} be {string}")
	public void user_should_see_the_range_for_be(String scenario, String range) {
		String actRange = logbookPageObj.getText(scenario);
	    Assert.assertEquals(actRange, range);
	    
	}

	@Then("User should see the X-axis display the last seven days ending today for {string}")
	public void user_should_see_the_x_axis_display_the_last_seven_days_ending_today_for(String string) {
	    
	    
	}

	@Then("User should see Y-axis minimum value  {int}")
	public void user_should_see_y_axis_minimum_value(Integer value) {
		String actValue = logbookPageObj.getText("yAxisMin");
	    Assert.assertEquals(actValue, Integer.toString(value));	    
	}

	@Then("User should see Y-axis Maximum value {int}")
	public void user_should_see_y_axis_maximum_value(Integer value) {
		String actValue = logbookPageObj.getText("yAxisMax");
	    Assert.assertEquals(actValue, Integer.toString(value));	    	    
	}

	@Then("User should see Icon  on the left side of Meal & Nutrition title")
	public void user_should_see_icon_on_the_left_side_of_title() {
		isVisible = logbookPageObj.isElementDisplayed("Meal Icon");
		Assert.assertTrue(isVisible, "Meal Icon is not visible");		    
	}

	@Then("User should see the section {string}")
	public void user_should_see_the_section(String scenario) {
		isVisible = logbookPageObj.isElementDisplayed(scenario);
		Assert.assertTrue(isVisible, scenario + " is not visible");	    
	}

	@Then("User should see {string} text colour {string}")
	public void user_should_see_text_colour(String scenario, String rgba) {
		String actColor = logbookPageObj.getColor(scenario);
	    Assert.assertEquals(actColor, rgba);	    
	}

	@Then("User should see {string} with nutrient distribution")
	public void user_should_see_bars_with_nutrient_distribution(String scenario) {
		isVisible = logbookPageObj.isElementDisplayed(scenario);
		Assert.assertTrue(isVisible, scenario + " is not visible");		    
	}


	@Then("User should see the value in the {string}")
	public void user_should_see_the_value_in_the(String scenario) {
		String actValue = logbookPageObj.getText(scenario);
	    Assert.assertNotEquals(actValue, "0g (0%)");	    
	}

}
