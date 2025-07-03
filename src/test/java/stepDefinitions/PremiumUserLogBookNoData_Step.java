package stepDefinitions;

import org.testng.Assert;
import common.TestContext;
import io.cucumber.java.en.Then;
import pageObject.PremiumUserLogbook_Page;

public class PremiumUserLogBookNoData_Step {
	
	private TestContext context;
	private  PremiumUserLogbook_Page logbookPageObj;
	boolean isNotVisible;
	
	public PremiumUserLogBookNoData_Step (TestContext context) {
		this.context = context;
		this.logbookPageObj = context.getPremiumUserLogbook_page();
	}
	
	@Then("User should see no bars in Daily Nutrition breakdown section")
	public void user_should_see_no_bars_in_daily_nutrition_breakdown_section() {
		isNotVisible = logbookPageObj.checkNoElement("dailyNoBar");
		Assert.assertTrue(isNotVisible, "Chart is visible");	    
	}

	@Then("User should not see any pie chart in seven day aggregate Nutrition section")
	public void user_should_not_see_any_pie_chart_in_seven_day_aggregate_nutrition_section() {
		isNotVisible = logbookPageObj.checkNoElement("noPieChart");
		Assert.assertTrue(isNotVisible, "Chart is visible");	 	    
	}

	@Then("User should see the {string} displayed {string}")
	public void user_should_see_the_displayed(String scenario, String expText) {
		String actValue = logbookPageObj.getText(scenario);
	    Assert.assertEquals(actValue, "0g (0%)");	    
	}

	@Then("User should see no bars in the chart")
	public void user_should_see_no_bars_in_the_chart() {
		isNotVisible = logbookPageObj.checkNoElement("activityEmptyChart");
		Assert.assertTrue(isNotVisible, "Chart is visible");	
	    
	}

	@Then("User should see {string} has {string} value")
	public void user_should_see_has_value(String scenario, String expValue) {
		String actValue = logbookPageObj.getText(scenario);
	    Assert.assertEquals(actValue, expValue);		    
	}

	@Then("User should see no value")
	public void user_should_see_no_value() {
		String actValue = logbookPageObj.getText("Peak Day");
		Assert.assertNull(actValue,"Value Present in Peak Day");
	}

	@Then("User should see {string}  value in the {string} statistics")
	public void user_should_see_value_in_the_statistics(String expValue, String scenario) {
		String actValue = logbookPageObj.getText(scenario);
	    Assert.assertEquals(actValue, expValue);
	    
	}

	@Then("User should see {string} colour {string} text")
	public void user_should_see_colour_text(String rgba, String scenario) {
		String actColor = logbookPageObj.getColor(scenario);
	    Assert.assertEquals(actColor, rgba);	  
	    
	}

	@Then("User should see hyphen - for all the days under {string}")
	public void user_should_see_hyphen_for_all_the_days_under(String scenario) {
		boolean noValue = logbookPageObj.checkValuesLogReview(scenario);
		Assert.assertTrue(noValue, "Value is present in " +scenario);
	    
	}

}
