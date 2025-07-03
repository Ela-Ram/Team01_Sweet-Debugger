package stepDefinitions;

import org.testng.Assert;
import common.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObject.PremiumUserLogbook_Page;

public class PremiumUserActivityMedicationLog_Step {
	
	private TestContext context;
	private  PremiumUserLogbook_Page logbookPageObj;
	boolean isVisible;

	public PremiumUserActivityMedicationLog_Step (TestContext context) {
		this.context = context;
		this.logbookPageObj = context.getPremiumUserLogbook_page();
	}
	
	@Then("User should see the icons on left side of {string} title")
	public void user_should_see_the_icons_on_left_side_of_title(String scenario) {
		isVisible = logbookPageObj.isElementDisplayed(scenario);
		Assert.assertTrue(isVisible, scenario + " is not visible");		   
	}

	@Then("User should see exactly three statistic cards displayed horizontally")
	public void user_should_see_exactly_three_statistic_cards_displayed_horizontally() {
		boolean isAligned = logbookPageObj.getAlignment();
		Assert.assertTrue(isAligned, "Total calories,Daily Average,Peak day are not displayed horizontally");		
	}

	@Then("User should see y-axis  clearly labeled with the text {string}")
	public void user_should_see_y_axis_clearly_labeled_with_the_text(String scenario) {
		String actValue = logbookPageObj.getText(scenario);
	    Assert.assertEquals(actValue, scenario);   
	}

	@Then("user should see the bars displayed only for days with logged activities")
	public void user_should_see_the_bars_displayed_only_for_days_with_logged_activities() {
	    
	   
	}

	@Then("User should see the text Number of Doses on Y-axis")
	public void user_should_see_the_text_number_of_doses_on_y_axis() {
		String actValue = logbookPageObj.getText("Number of Doses");
	    Assert.assertEquals(actValue, "Number of Doses"); 	   
	}
	

	@Then("User should see {string} colour bar for {string}")
	public void user_should_see_colour_bar_for(String expColor, String scenario) {
		String actColor = logbookPageObj.getFillAttribute(scenario);
	    Assert.assertEquals(actColor, expColor); 
	}

	@Then("User should see table header {string}")
	public void user_should_see_table_header(String scenario) {
		isVisible = logbookPageObj.isElementDisplayed(scenario);
		Assert.assertTrue(isVisible, scenario + "header is not visible");	
	   
	}

	@Then("User should see date of last seven days including today")
	public void user_should_see_date_of_last_seven_days_including_today() {
		boolean lastSevenDays = logbookPageObj.checkLastSevenDays();
		Assert.assertTrue(lastSevenDays, "Last Seven Days not displayed");
	   
	}

	@Then("User should see the date format as {string}")
	public void user_should_see_the_date_format_as(String string) {
		boolean dateFormat = logbookPageObj.checkDays();
		Assert.assertTrue(dateFormat, "Date format does not match");	
	}

	@Then("User should see the date ordered in descending order for last seven days including today")
	public void user_should_see_the_date_ordered_in_descending_order_for_last_days_including_today() {
		boolean lastSevenDays = logbookPageObj.checkLastSevenDays();
		Assert.assertTrue(lastSevenDays, "Last Seven Days not in descending order");	   
	}

	@Given("User log blood glucose value in Home page")
	public void user_log_blood_glucose_value_in_home_page() {
	    
	   
	}

	@Then("User should see logged value for those days under Blood glucose")
	public void user_should_see_logged_value_for_those_days_under_blood_glucose() {
	    
	   
	}

	@Given("User log Nutrient value in Home page")
	public void user_log_nutrient_value_in_home_page() {
	    
	   
	}

	@Then("User should see logged value for those days under Nutrient value")
	public void user_should_see_logged_value_for_those_days_under_nutrient_value() {
	    
	   
	}

	@Then("User should see logged value for those days under physical activity")
	public void user_should_see_logged_value_for_those_days_under_physical_activity() {
	    
	   
	}

	@Given("User log Medication dosage in Home page")
	public void user_log_medication_dosage_in_home_page() {
	    
	   
	}

	@Then("User should see logged value for those under Medication Dosage")
	public void user_should_see_logged_value_for_those_under_medication_dosage() {
	    
	   
	}

}
