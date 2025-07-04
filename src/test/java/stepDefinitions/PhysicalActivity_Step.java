package stepDefinitions;

import org.testng.Assert;

import common.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.PhysicalActivity_Page;

public class PhysicalActivity_Step {
	
	private TestContext context;
	private PhysicalActivity_Page physicalActivity;
	
	public PhysicalActivity_Step(TestContext context) {
		
		this.context = context;
		this.physicalActivity= context.getPhysicalActivity();
		
	}
	
	
	@When("Premium User clicks physical activity")
	public void premium_user_clicks_physical_activity() {
	    
		physicalActivity.clickphysicalActivity();
	}

	@Then("User should see title {string} Physical Activity")
	public void user_should_see_title_physical_activity(String string) {
	  
		Assert.assertTrue(physicalActivity.headingPhysicalActivity(),"user should not see title");
	}

	@Then("User should see subtext {string} in physical activity")
	public void user_should_see_subtext_in_physical_activity(String string) {
	  
		Assert.assertTrue(physicalActivity.verifysubtextTrackJourney(),"user should not see subtext");
	}

	@Then("User should see field for Activity Type, Duration,Date,Intensity in physical activity")
	public void user_should_see_field_for_activity_type_duration_date_intensity_in_physical_activity() {
	   
		Assert.assertTrue(physicalActivity.verifyFieldLabels(), "One or more labels are not visible");
	}

	@Then("User should see  dropdown for activity type")
	public void user_should_see_dropdown_for_activity_type() {
	  
		Assert.assertTrue(physicalActivity.isDurationInputVisible(), "Duration input is not visible");
	}

	@Then("User should see  {string} in physical activity option")
	public void user_should_see_in_physical_activity1(String expectedOptions) {
	 
		Assert.assertTrue(physicalActivity.verifyActivityOptions(expectedOptions), "Activity Type options mismatch");
	
	}

	@Then("User should see  input field for duration")
	public void user_should_see_input_field_for_duration() {
	
		Assert.assertTrue(physicalActivity.isDurationInputVisible(), "Duration input is not visible");
	}

	@Then("User should see {string} in placeholder field")
	public void user_should_see_in_placeholder_field(String expectedPlaceholder) {
	 
		Assert.assertEquals(physicalActivity.getDurationPlaceholder(), expectedPlaceholder, "Placeholder text mismatch");
	}

	@Then("User should see drop down duration")
	public void user_should_see_drop_down_duration() {
		
		Assert.assertTrue(physicalActivity.isDurationUnitDropdownVisible(), "Duration unit dropdown is not visible");
	
	}

	@Then("User should see {string} minutes and hours in physical activity")
	public void user_should_see_minutes_and_hours_in_physical_activity(String expected) {
	   
		 Assert.assertTrue(physicalActivity.verifyDurationUnitOptions(expected),"Duration units mismatch");
			        	        		  
	}
	
	@Then("User should see date picker in physical activity")
	public void user_should_see_date_picker_in_physical_activity() {
	
	
		Assert.assertTrue(physicalActivity.isDatePickerButtonVisible(), "Date picker is not visible");
	}

	@Then("User should see intensity field in physical activity")
	public void user_should_see_intensity_field_in_physical_activity() {
	 
		Assert.assertTrue(physicalActivity.isIntensityOptionsVisible(), "One or more intensity options are not visible");
	}
	@Then("User should see {string} in physical activity")
	public void user_should_see_in_physical_activity(String expected) {
		
		 Assert.assertTrue(physicalActivity.verifyIntensityOptions(expected),
			        "Intensity buttons mismatch");
	}

	@Then("User should see save activity button in physical activity")
	public void user_should_see_save_activity_button_in_physical_activity() {

		Assert.assertTrue(physicalActivity.isSaveButtonVisible(), "Save Activity button is not visible");
	}
	
	

}
