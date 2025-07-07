package stepDefinitions;

import common.TestContext;
import io.cucumber.java.en.*;
import pageObject.CommomHomePageFeature_Page;
import pageObject.DiabetesRiskAnalyzer_Page;
import pageObject.LaunchPage_Page;
import pageObject.LoginUI_Page;

public class CommonHomePageFeature2and3_Step {
	private TestContext context;
	DiabetesRiskAnalyzer_Page diaRiskAnalyzerPageObj;
	LaunchPage_Page launch_pageObj;
	CommomHomePageFeature_Page commonHomeFeaturesPageObj;
	private LoginUI_Page loginUI_page;

	public CommonHomePageFeature2and3_Step(TestContext context) {

		this.context = context;
		this.commonHomeFeaturesPageObj = context.getcommonHomeFeaturesPageObj();
		this.diaRiskAnalyzerPageObj = context.getDiaRiskAnalyzerPageObj();
		this.launch_pageObj = context.getLaunch_PageObj();
		this.loginUI_page = context.getLoginUI_Page();
	}

	@Given("User is logged into the app")
	public void user_is_logged_into_the_app() {

	}

	@When("User clicks on the Breakfast section")
	public void user_clicks_on_the_breakfast_section() {
		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.clickBreakFastButton();

	}

	@Then("Breakfast details  become visible")
	public void breakfast_details_become_visible() {
		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.isBreakfastTabPresent();
	}

	@When("User clicks on the Lunch section")
	public void user_clicks_on_the_lunch_section() {
		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.clickLunchButton();

	}

	@Then("Lunch details  become visible")
	public void lunch_details_become_visible() {
		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.isLunchTabVisible();

	}

	@When("User clicks on the Dinner section")
	public void user_clicks_on_the_dinner_section() {
		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.clickDinnerTab();

	}

	@Then("Dinner details  become visible")
	public void dinner_details_become_visible() {
		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.isDinnerTabVisible();

	}

	@When("User clicks on the Sancks section")
	public void user_clicks_on_the_sancks_section() {
		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.clicksnacksTab();

	}

	@Then("Snacks details  become visible")
	public void snacks_details_become_visible() {
		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.isSnacksTabVisible();

	}

	@When("User clicks meal section")
	public void user_clicks_meal_section() {

	}

	@Then("User should see User should see dish title")
	public void user_should_see_user_should_see_dish_title() {
		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.isdishTitleVisible();

	}

	@Then("User should see User should see the pre-meal item name")
	public void user_should_see_user_should_see_the_pre_meal_item_name() {
		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.isPreMealPresentInAllMeals();
	}
	
	@Then("User should see User should see indicator {string} for breakfast pre-meal")
	public void user_should_see_user_should_see_indicator_for_breakfast_pre_meal(String breakfastIndicator) {
		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.verifyTimeIndicator_Breakfast(breakfastIndicator);

	}

	@Then("User should see User should see indicator {string} for lunch  pre-meal")
	public void user_should_see_user_should_see_indicator_for_lunch_pre_meal(String lunchIndicator) {
		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.verifyTimeIndicator_lunch(lunchIndicator);

	}

	@Then("User should see User should see indicator {string} for dinner  pre-meal")
	public void user_should_see_user_should_see_indicator_for_dinner_pre_meal(String dinnerIndicator) {
		commonHomeFeaturesPageObj.waitTillHomePageloads();
		commonHomeFeaturesPageObj.verifyTimeIndicator_dinner(dinnerIndicator);
	}

}
