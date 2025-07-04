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
	
	@Then("User should see no bars in Daily Nutrition breakdown section of premium account")
	public void user_should_see_no_bars_in_daily_nutrition_breakdown_section_of_premium_account() {
		isNotVisible = logbookPageObj.checkNoElement("dailyNoBar");
		Assert.assertTrue(isNotVisible, "Chart is visible");	    
	}

	@Then("User should not see any pie chart in seven day aggregate Nutrition section of premium account")
	public void user_should_not_see_any_pie_chart_in_seven_day_aggregate_nutrition_section_of_premium_account() {
		isNotVisible = logbookPageObj.checkNoElement("noPieChart");
		Assert.assertTrue(isNotVisible, "Chart is visible");	 	    
	}

	@Then("User should see the {string} displayed {string} in Daily nutrition")
	public void user_should_see_the_displayed_in_Daily_nutrition(String scenario, String expText) {
		String actValue = logbookPageObj.getText(scenario);
	    Assert.assertEquals(actValue, "0g (0%)");	    
	}

	@Then("User should see no bars in the chart for {string} logs")
	public void user_should_see_no_bars_in_the_chart_for_logs(String scenario) {
		isNotVisible = logbookPageObj.checkNoElement(scenario);
		Assert.assertTrue(isNotVisible, "Chart is visible");		    
	}

	@Then("User should see {string} has {string} value for no activity")
	public void user_should_see_has_value_for_no_avtivity(String scenario, String expValue) {
		String actValue = logbookPageObj.getText(scenario);
	    Assert.assertEquals(actValue, expValue);		    
	}

	@Then("User should see no value for no activity")
	public void user_should_see_no_value_for_no_avtivity() {
		String actValue = logbookPageObj.getText("Peak Day");
		Assert.assertNull(actValue,"Value Present in Peak Day");
	}

	@Then("User should see {string}  value in the {string} medication statistics")
	public void user_should_see_value_in_the_medication_statistics(String expValue, String scenario) {
		String actValue = logbookPageObj.getText(scenario);
	    Assert.assertEquals(actValue, expValue);	    
	}

	@Then("User should see {string} colour {string} text in Medication Dosage section")
	public void user_should_see_colour_text_in_Medication_Dosage_section(String rgba, String scenario) {
		String actColor = logbookPageObj.getColor(scenario);
		Assert.assertTrue(actColor.contains(rgba), "Color does not match");
	}

	@Then("User should see hyphen - for all the days under {string} in log review section")
	public void user_should_see_hyphen_for_all_the_days_under_in_log_review_section(String scenario) {
		boolean noValue = logbookPageObj.checkValuesLogReview(scenario);
		Assert.assertTrue(noValue, "Value is present in " +scenario);
	    
	}

}
