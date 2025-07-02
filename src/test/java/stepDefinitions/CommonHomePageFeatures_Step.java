package stepDefinitions;

import common.TestContext;
import io.cucumber.java.en.*;
import pageObject.CommomHomePageFeature_Page;
import pageObject.DiabetesRiskAnalyzer_Page;
import pageObject.LaunchPage_Page;
import pageObject.LoginUI_Page;

public class CommonHomePageFeatures_Step {

	
	private TestContext context;
	DiabetesRiskAnalyzer_Page diaRiskAnalyzerPageObj;
	LaunchPage_Page launch_pageObj;
	CommomHomePageFeature_Page commonHomeFeaturesPageObj;
	private  LoginUI_Page loginUI_page;
	
	
	public CommonHomePageFeatures_Step(TestContext context)
	{
		this.context = context;
		this.commonHomeFeaturesPageObj = context.getcommonHomeFeaturesPageObj();
		this.diaRiskAnalyzerPageObj = context.getDiaRiskAnalyzerPageObj();
		this.launch_pageObj = context.getLaunch_PageObj();
		this.loginUI_page = context.getLoginUI_Page();
		
	}
	
////////Background//////
	
//	@When("Enter Email Id from {string} and {string}")
//	public void enter_email_id_from_and(String launch, String launch_02) {
//		diaRiskAnalyzerPageObj.clickCalRiskAnalyzerbtn();
//		commonHomeFeaturesPageObj.clickCreateAccountButton(); 
//		commonHomeFeaturesPageObj.enterEmailID(launch, launch_02);
//	}

	@When("user completes profile by providing email {string}")
	public void user_completes_profile(String email) {
		diaRiskAnalyzerPageObj.clickCalRiskAnalyzerbtn();
		commonHomeFeaturesPageObj.clickCreateAccountButton();
		loginUI_page.enterEmail(email);
		loginUI_page.clickContinueWithEmailButton();
		
	}
	
	
///////////////////Background finish///////////////

@Given("User is in password auth page")
public void user_is_in_password_auth_page() {
	
	
    
}

@When("User clicks sign in after entering password")
public void user_clicks_sign_in_after_entering_password() {
    
    
}

@Then("User should see SweetBalance text on the left side of the page")
public void user_should_see_sweet_balance_text_on_the_left_side_of_the_page() {
    
    
}

@Then("User should see name displayed at the top-right corner of the home page")
public void user_should_see_name_displayed_at_the_top_right_corner_of_the_home_page() {
    
    
}

@Then("User should see Logout link in the top-right corner")
public void user_should_see_logout_link_in_the_top_right_corner() {
    
    
}

@Then("User should see top navigation bar on the page")
public void user_should_see_top_navigation_bar_on_the_page() {
    
    
}

@Then("User should see {string} tab in the top navigation bar")
public void user_should_see_tab_in_the_top_navigation_bar(String string) {
    
    
}

@Then("User should see {string} section heading on the home page")
public void user_should_see_section_heading_on_the_home_page(String string) {
    
    
}

@Then("User should see {string} label below Current Status")
public void user_should_see_label_below_current_status(String string) {
    
    
}

@Then("User should see timestamp displayed next to the {string} label")
public void user_should_see_timestamp_displayed_next_to_the_label(String string) {
    
    
}

@Then("User should see last updated timestamp in {int}-hour format or {string} format")
public void user_should_see_last_updated_timestamp_in_hour_format_or_format(Integer int1, String string) {
    
    
}

@Then("User should see {int}-hour clock indicator with AM\\/PM")
public void user_should_see_hour_clock_indicator_with_am_pm(Integer int1) {
    
    
}

@Then("User should see {string} label")
public void user_should_see_label(String string) {
    
    
}

@Then("User should see Latest HbA1C value")
public void user_should_see_latest_hb_a1c_value() {
    
    
}

@Then("User should see BMI value")
public void user_should_see_bmi_value() {
    
    
}

@Then("User should see Average Blood Sugar value")
public void user_should_see_average_blood_sugar_value() {
    
    
}

@Then("User should see {string} as the condition text")
public void user_should_see_as_the_condition_text(String string) {
    
    
}

@Then("User should see {string} as the BMI category")
public void user_should_see_as_the_bmi_category(String string) {
    
    
}

@Then("User should see mg\\/dL unit below Average Blood Sugar")
public void user_should_see_mg_d_l_unit_below_average_blood_sugar() {
    
    
}

@Then("User should see {string} title")
public void user_should_see_title(String string) {
    
    
}

@Then("User should see {string} section")
public void user_should_see_section(String string) {
    
    
}

@Then("User should see {string} tab should be selected by default")
public void user_should_see_tab_should_be_selected_by_default(String string) {
    
    
}

@Then("User should see sidebar tab container within the flex layout")
public void user_should_see_sidebar_tab_container_within_the_flex_layout() {
    
    
}

@Then("User should see {string} label in the sidebar section")
public void user_should_see_label_in_the_sidebar_section(String string) {
    
    
}

@Then("User should see utensil icon in the Meal Plan tab")
public void user_should_see_utensil_icon_in_the_meal_plan_tab() {
    
    
}

@Then("User should see dumbbell icon in the Exercise tab")
public void user_should_see_dumbbell_icon_in_the_exercise_tab() {
    
    
}

@Then("User should see {string} button in the Meal Plan section")
public void user_should_see_button_in_the_meal_plan_section(String string) {
    
    
}

}
