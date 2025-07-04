package stepDefinitions;

import java.io.ObjectInputFilter.Config;
import java.util.List;

import org.testng.Assert;

import common.ConfigReader;
import common.LoggerLoad;
import common.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.PremiumUserHome_Page;

public class PremiumUserHomePage_Step {

	private TestContext context;
	private PremiumUserHome_Page premiumUserHome_page;

	public PremiumUserHomePage_Step(TestContext context) {
		this.context = context;
		this.premiumUserHome_page = context.premiumUserHome_page();
	}

	@Given("User landed on Premium page")
	public void user_landed_on_premium_page() {
		LoggerLoad.info("Premium User is landed on Home page ");
	}

	@When("When User click the Premium home page")
	public void user_click_the_Premium_home_page() {
		premiumUserHome_page.homeClick();
	}

	@Then("User should see the navigation bar displaying items in the order: {string}, {string}, {string}, {string}")
	public void user_should_see_the_navigation_bar_displaying_items_in_the_order_home_logbook_dashboard_education(
			String tab1, String tab2, String tab3, String tab4) {
		List<String> actualTabs = premiumUserHome_page.getNavigationTab();
		List<String> expectedTabs = List.of(tab1, tab2, tab3, tab4);

		Assert.assertEquals(actualTabs, expectedTabs, "Navigation tabs are not in expected order");
	}

	@Then("The {string} in Premium User Excercise should be displayed")
	public void the_in_premium_user_excercise_should_be_displayed(String scenario) {
		switch (scenario) {
		case "Animation Challenge Yourself Is Flashing":
			//premiumUserHome_page.isTabFlashing();
			//Assert.assertTrue(premiumUserHome_page.getflashingTabText());
			break;
		case "Duration of Animation Challenge Yourself":
			Assert.assertTrue(premiumUserHome_page.isAnimationDurationMatched(),
					" Animation Duration is not matched with 0.2s");
			break;

		case "Challenge Yourself Text":
			Assert.assertTrue(premiumUserHome_page.getflashingTabText(),"Challenge Yourself Text is not visible");
			break;
		case "Gender Image":
			Assert.assertEquals(premiumUserHome_page.getgenderNameText(), ConfigReader.getProperty("genderImg"));
			break;
		case "Emoji Image ":
			Assert.assertTrue(premiumUserHome_page.isemojiImageDispalyed(), " Emjoi is not displayed");
			break;
		case "Label under Image":
			Assert.assertTrue(premiumUserHome_page.isLabelUnderImageDispalyed(), "Label Under Image is not displayed");
			break;
		case "log button":
			Assert.assertTrue(premiumUserHome_page.isLogButtonDispalyed(), "Log Button is not displayed");
			break;
		case "Weekly plan":
			Assert.assertTrue(premiumUserHome_page.isweeklyPlanBtnDispalyed(), "Weekly Plan Button is not displayed");
			break;
		case "Record New Data":
			Assert.assertTrue(premiumUserHome_page.isrecordNewDataDispalyed(), "Record New Data is not displayed");
			break;
		case "Options Below Record New Data":
			Assert.assertTrue(premiumUserHome_page.isbuttonOptionsNewRecordDataDisplayed(),
					"Four Options Below Record New Data is not displayed");
			break;
		case "BloodGlucoseButton":
			Assert.assertTrue(premiumUserHome_page.isBloodGlucoseDisplayed(), "Blood Glucose button is not displayed");
			break;
		case "Physical Activity":
			Assert.assertTrue(premiumUserHome_page.isphysicalActivityDisplayed(), "Physical Activity is not displayed");
			break;
		case "Food Intake":
			Assert.assertTrue(premiumUserHome_page.isFoodIntakeDisplayed(), "Food Intake button is not displayed");
			break;
		case "Medication":
			Assert.assertTrue(premiumUserHome_page.isMedicationDisplayed(), "Medication button is not displayed");
			break;
		}
	}

	@When("User clicks meal section Premium Home Page")
	public void user_clicks_meal_section_premium_home_page() {
		premiumUserHome_page.preMealClick();
	}

	@Then("The {string} in Premium UserExcercise PreMeal should be displayed")
	public void the_in_premium_user_excercise_pre_meal_should_be_displayed(String scenario) {

		switch (scenario) {
		case "Pre Meal In All Meal Section":
			Assert.assertTrue(premiumUserHome_page.isPreMealTextDisplayed(),
					"Pre Meal is not displayed in all Meal Section");
			break;
		case "Pre Meal Icon In All Meal Section":
			Assert.assertTrue(premiumUserHome_page.ispreMealIconDisplayed(),
					"Pre Meal Icon is not displayed in all Meal Section");
			break;
		}
	}

	@When("User clicks snacks section Premium Home Page")
	public void user_clicks_snacks_section_premium_home_page() {
		premiumUserHome_page.snacksTabClick();
	}

	@Then("The {string} in Premium UserExcercise Snacks should be displayed")
	public void the_in_premium_user_excercise_snacks_should_be_displayed(String scenario) {
		switch (scenario) {
		case "None PreMeal Snack By Default":
			Assert.assertTrue(premiumUserHome_page.isNoneTextDefaultSnacksDisplayed(),
					"None Text is not displayed as default in all Snacks Section");
			break;
		case "None PreMeal Snack Calorie":
			Assert.assertTrue(premiumUserHome_page.isSnacksNoneCalorieDisplayed(),
					"Zero Calories Text is not displayed as default in all Snacks Section");
			break;
		}

	}

}