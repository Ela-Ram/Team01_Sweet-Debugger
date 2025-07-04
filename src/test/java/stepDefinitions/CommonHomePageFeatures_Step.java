package stepDefinitions;

import java.util.Map;

import org.testng.Assert;

import common.ExcelReader;
import common.ConfigReader;
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
	private LoginUI_Page loginUI_page;

	public CommonHomePageFeatures_Step(TestContext context) {
		this.context = context;
		this.commonHomeFeaturesPageObj = context.getcommonHomeFeaturesPageObj();
		this.diaRiskAnalyzerPageObj = context.getDiaRiskAnalyzerPageObj();
		this.launch_pageObj = context.getLaunch_PageObj();
		this.loginUI_page = context.getLoginUI_Page();

	}

////////Background//////

	@Given("User calculates risk by entering values in all fields from {string} and {string} after clicking on Check Your Risk button")
	public void user_calculates_risk_by_entering_values_in_all_fields_from_and_after_clicking_on_check_your_risk_button(
			String launch, String launch_02) {
		launch_pageObj.clickCheckYrRiskButton();
		diaRiskAnalyzerPageObj.fillRiskAnalyzerForm(launch, launch_02);
		diaRiskAnalyzerPageObj.clickCalRiskAnalyzerbtn();
	}

	@When("User continue with email button after entering a email as in {string} and {string} on Create Account Page")
	public void user_continue_with_email_button_after_entering_a_email_as_in_and_on_create_account_page(String launch,
			String launch_02) {
		commonHomeFeaturesPageObj.ClickCreateAccountButton();
		Map<String, String> testData = ExcelReader.getTestData(launch, launch_02);
		String email = testData.get("Email");
		commonHomeFeaturesPageObj.enterEmail(email);
		loginUI_page.clickContinueWithEmailButton();
	}

	@When("User clicks create account button after filling all fields as in {string} and {string} launch")
	public void user_clicks_create_account_button_after_filling_all_fields_as_in_and(String launch, String launch_03) {
		Map<String, String> testData = ExcelReader.getTestData(launch, launch_03);
		String fullname = testData.get("Fullname");
		String username = testData.get("Username");
		String password = testData.get("Password");
		commonHomeFeaturesPageObj.enterAllFieldstoCompleteForm(fullname, username, password);
		commonHomeFeaturesPageObj.clickTermsCond();
		commonHomeFeaturesPageObj.ClickCreateAccountButton();
	}

	@When("Registered user clicks Continue with Email after enetering email ID")
	public void registered_user_clicks_continue_with_email_after_enetering_email_id() {
		String regemail = ConfigReader.getProperty("Reg_Email");
		// String password = ConfigReader.getProperty("password");
		loginUI_page.enterEmail(regemail);
		loginUI_page.clickContinueWithEmailButton();
	}

	@Given("User is in password auth page")
	public void user_is_in_password_auth_page_launch() {

		commonHomeFeaturesPageObj.isPAsswordAuthPageOpened();

	}

	@When("Registered user clicks the signin after entering password")
	public void registered_user_clicks_the_signin_after_entering_password() {
		commonHomeFeaturesPageObj.enterpassword();

		System.out.println("*** user entered passsword");
		commonHomeFeaturesPageObj.clickSignInbutton();
		System.out.println("*** user clicked signin");

	}

	@Then("User should see {string} text on the left side of the page")
	public void user_should_see_text_on_the_left_side_of_the_page(String appNameonHomePage) {
		commonHomeFeaturesPageObj.appNameonHomePage(appNameonHomePage);
	}

	@Then("User should see name displayed at the top-right corner of the home page  {string} and {string}")
	public void user_should_see_name_displayed_at_the_top_right_corner_of_the_home_page_and(String launch,
			String launch_04) {
		commonHomeFeaturesPageObj.isUserNamedisplayedonHomePage(launch, launch_04);
	}

	@Then("User should see Logout link in the top-right corner")
	public void user_should_see_logout_link_in_the_top_right_corner() {
		boolean expected = commonHomeFeaturesPageObj.isLogOutButtonDisplayed();
		Assert.assertEquals(expected, true);
		System.out.println("Passed: Logout button is present");
	}

	@Then("User should see top navigation bar on the page")
	public void user_should_see_top_navigation_bar_on_the_page() {
		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.istopNAvigationBarPresent();
	}

	@Then("User should see {string} tab1 in the top navigation bar")
	public void user_should_see_tab1_in_the_top_navigation_bar(String homeTab) {
		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.ishomeTabPresent(homeTab);

	}

	@Then("User should see {string} tab2 in the top navigation bar")
	public void user_should_see_tab2_in_the_top_navigation_bar(String dashboardTab) {
		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.isDashboardTabPresent(dashboardTab);

	}

	@Then("User should see {string} tab3 in the top navigation bar")
	public void user_should_see_tab3_in_the_top_navigation_bar(String educationTab) {
		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.isEducationTabPresent(educationTab);

	}

	@Then("User should see {string} section heading on the home page")
	public void user_should_see_section_heading_on_the_home_page(String currentStatusSection) {
		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.isCurrentstatusSectionDispalyed(currentStatusSection);
	}

	@Then("User should see {string} label below Current Status")
	public void user_should_see_label_below_current_status(String lastUpdatedText) {
		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.isLastUpdatedTextDispalyed(lastUpdatedText);

	}

	@Then("User should see timestamp displayed next to the Last updated label")
	public void user_should_see_timestamp_displayed_next_to_the_last_updated_label() {
		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.lastUpdateTimeFormatDispalyed();
	}

	@Then("User should see last updated timestamp in {int}-hour format or {string} format")
	public void user_should_see_last_updated_timestamp_in_hour_format_or_format(Integer int1, String string) {
		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.lastUpdateTimeFormatDispalyed();

	}

	@Then("User should see {int}-hour clock indicator with AM\\/PM")
	public void user_should_see_hour_clock_indicator_with_am_pm(Integer int1) {
		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.lastUpdateTimeFormatDispalyed();

	}

	@Then("User should see {string} label1")
	public void user_should_see_label1(String latestHbA1cLabel) {
		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.isLastestHbA1cLAbelDispalyed(latestHbA1cLabel);
	}

	@Then("User should see {string} label2")
	public void user_should_see_label2(String BMI) {
		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.isBMILAbelDispalyed(BMI);
	}

	@Then("User should see {string} label3")
	public void user_should_see_label3(String AvgBldSugarLabel) {
		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.isAvgBldSugarDispalyed(AvgBldSugarLabel);
	}

	@Then("User should see Latest HbA1C value")
	public void user_should_see_latest_hb_a1c_value() {
		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.isLastestHbA1cValueDisplayed();
	}

	@Then("User should see BMI value")
	public void user_should_see_bmi_value() {
		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.isBMIValueDisplayed();
	}

	@Then("User should see Average Blood Sugar value")
	public void user_should_see_average_blood_sugar_value() {
		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.isAvgBldSugarValueDisplayed();
	}

	@Then("User should see {string} as the condition text")
	public void user_should_see_as_the_condition_text(String string) {
		commonHomeFeaturesPageObj.waitTillHomePageloads();

	}

	@Then("User should see {string} as the BMI category")
	public void user_should_see_as_the_bmi_category(String string) {
		commonHomeFeaturesPageObj.waitTillHomePageloads();

	}

	@Then("User should see mg\\/dL unit below Average Blood Sugar")
	public void user_should_see_mg_d_l_unit_below_average_blood_sugar() {

		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.verifyAvgBldSugarUnit();
	}

	@Then("User should see {string} title")
	public void user_should_see_title(String todayMealPlanTitle) {
		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.verifyTitleTodaysMealPlan(todayMealPlanTitle);
	}

	@Then("User should see {string} section")
	public void user_should_see_section(String todayMealPlanTitle) {
		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.verifyTitleTodaysMealPlan(todayMealPlanTitle);

	}

	@Then("User should see {string} tab should be selected by default")
	public void user_should_see_tab_should_be_selected_by_default(String breakfast) {
		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.isBreakfastTabVisibleByDefault(breakfast);
	}

	@Then("User should see sidebar tab container within the flex layout")
	public void user_should_see_sidebar_tab_container_within_the_flex_layout() {
		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.presenceOfSidetab();
	}

	@Then("User should see {string} label in the sidebar section")
	public void user_should_see_label_in_the_sidebar_section(String mealPlan) {
		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.isMealPlanoptionPresent(mealPlan);
	}

	@Then("User should see {string} label2 in the sidebar section")
	public void user_should_see_label2_in_the_sidebar_section(String exercise) {
		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.isExerciseOptionPresent(exercise);
	}

	@Then("User should see utensil icon in the Meal Plan tab")
	public void user_should_see_utensil_icon_in_the_meal_plan_tab() {
		commonHomeFeaturesPageObj.waitTillHomePageloads();

	}

	@Then("User should see dumbbell icon in the Exercise tab")
	public void user_should_see_dumbbell_icon_in_the_exercise_tab() {
		commonHomeFeaturesPageObj.waitTillHomePageloads();

	}

	@Then("User should see {string} button in the Meal Plan section")
	public void user_should_see_button_in_the_meal_plan_section(String string) {
		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.isViewFullMealPalnBtnPresent();
	}

}
