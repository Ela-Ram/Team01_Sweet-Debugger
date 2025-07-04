package stepDefinitions;

import java.util.List;

import org.testng.Assert;

import common.ConfigReader;
import common.LoggerLoad;
import common.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.HomeFreeUser_page;

public class HomePageFreeUser_Step {

	private TestContext context;
	private HomeFreeUser_page homeFreeUser_page;

	public HomePageFreeUser_Step(TestContext context) {
		this.context = context;
		this.homeFreeUser_page = context.getHomeFreeUser_page();
	}

	@Given("User is landed on free page")
	public void user_is_landed_on_free_page() {
		LoggerLoad.info("Free User is landed on free page ");
	}

	@Then("User should see the navigation bar displaying items in the order: {string}, {string}, {string}")
	public void user_should_see_the_navigation_bar_displaying_items_in_the_order(String tab1, String tab2,
			String tab3) {

		List<String> actualTabs = homeFreeUser_page.getNavigationTab();
		List<String> expectedTabs = List.of(tab1, tab2, tab3);

		Assert.assertEquals(actualTabs, expectedTabs, "Navigation tabs are not in expected order");
	}

	@Then("User should see a caret toggle icon next to the Today's Meal Plan title")
	public void user_should_see_a_caret_toggle_icon_next_to_the_today_s_meal_plan_title() {
		Assert.assertTrue(homeFreeUser_page.isHomePageToggle(), "Home Page Toggle is not displayed");
	}

	@Then("User should see Nutrition Insights heading for each of the meal section")
	public void user_should_see_nutrition_insights_heading_for_each_of_the_meal_section() {
		Assert.assertTrue(homeFreeUser_page.isNutrientInsightTextDisplayed(), "Nutrient Insight is not displayed");
	}

	@Then("User should see horizontal bar for Carbs, Protein, and Fat")
	public void user_should_see_horizontal_bar_for_carbs_protein_and_fat() {
		Assert.assertTrue(homeFreeUser_page.areNutrientBarsDisplayed(), "Nutrient Horizontal Bar is not displayed");
	}

	@When("User clicks meal section from FreeUser")
	public void user_clicks_meal_section() {
		homeFreeUser_page.mealPlanClick();
	}

	@Then("The {string} value should be displayed HomePageNutrientValue")
	public void the_value_should_be_displayed_HomePageNutrientValue(String scenario) {
		switch (scenario) {
		case "Pre-Meal":
			Assert.assertTrue(homeFreeUser_page.ispreMealTextDisplayed(), scenario + " is not displayed");
			break;
		case "Carbs":
			Assert.assertTrue(homeFreeUser_page.isCarbTextDisplayed(), scenario + " is not displayed");
			break;
		case "Protein":
			Assert.assertTrue(homeFreeUser_page.isProteinTextDisplayed(), scenario + " is not displayed");
			break;
		case "Fat":
			Assert.assertTrue(homeFreeUser_page.isFatTextDisplayed(), scenario + " is not displayed");
			break;

		case "Meal Time":
			Assert.assertTrue(homeFreeUser_page.isMealTimeDisplayed(), scenario + " is not displayed");
			break;

		case "Snacks PM":
			Assert.assertTrue(homeFreeUser_page.isPMTimeDisplayed(), scenario + " is not displayed");
			break;

		case "hh:mm Time":
			Assert.assertTrue(homeFreeUser_page.isCorrectTimeFormatDisplayed(), scenario + " is not displayed");
			break;
		case "snack Three Clock":
			Assert.assertTrue(homeFreeUser_page.isSnackThreeClockDisplayed(), scenario + " is not displayed");
			break;
		case "Dot Indicator":
			Assert.assertTrue(homeFreeUser_page.isDotIndicatorDisplayed(), scenario + " is not displayed");
			break;
		case "View Full Plan":
			homeFreeUser_page.viewFullPlan();
			String ExpectedUrl = ConfigReader.getProperty("subcriptionURL");
			Assert.assertEquals(homeFreeUser_page.getCurrentTitle(), ExpectedUrl,
					"Navigation to subscription upgrade page failed");
			break;

		}
	}

	@When("User clicks exercise section from HomePage")
	public void user_clicks_exercise_section_homePage() {
		homeFreeUser_page.exerciseClick();
	}

	@Then("The {string} in Home page Excercise should be displayed")
	public void the_in_home_page_excercise_should_be_displayed(String scenario) {
		switch (scenario) {
		case "Exercise Section":
			Assert.assertTrue(homeFreeUser_page.isTodaysExercisePlanTextDisplayed(), scenario + " is not displayed");
			break;
		case "Two Exercise List":
			Assert.assertEquals(homeFreeUser_page.morningExercisegetText(), ConfigReader.getProperty("MorningExerciseText"), "Morning Exercise Text is not displayed");
			Assert.assertEquals(homeFreeUser_page.eveningExercisegetText(), ConfigReader.getProperty("YogaSessionText"), "Yoga Session Exercise Text is not displayed");
			
			break;
		case "Time In Each Exercise":
			Assert.assertTrue(homeFreeUser_page.isTimeElementsDisplayed(), scenario + " is not displayed");
			break;
		case "Title in Each ExercisePlan":
			Assert.assertTrue(homeFreeUser_page.isExerciseTitlesDisplayed(), scenario + " is not displayed");
			break;
		case "MorningExercise Time":
			Assert.assertTrue(homeFreeUser_page.isMorningExerciseTimeDisplayed(), "Morning Exercise time is not Displayed  ");

			break;
		case "EveningExercise Time":
			Assert.assertTrue(homeFreeUser_page.isEveningExerciseTimeDisplayed(),"Evening Exercise Time is not displayed ");
			break;
		case "Time Format":
			Assert.assertTrue(homeFreeUser_page.isAllExerciseTimesValidFormat(), scenario + " is not displayed");
			break;
		case "Time Duration":
			Assert.assertTrue(homeFreeUser_page.isTimeDurationTextDisplayed(), scenario + " is not displayed");
			break;
		case "Time Duration Format":
			Assert.assertTrue(homeFreeUser_page.isTimeDurationFormatDisplayed(), scenario + " is not displayed");
			break;
		case "Dot Indicator":
			Assert.assertTrue(homeFreeUser_page.isDotDisplayed(), scenario + " is not displayed");
			break;
		case "Intensity Level":
			Assert.assertTrue(homeFreeUser_page.isIntensityLevel(), scenario + " is not displayed");
			break;
		case "View Full Schedule":
			Assert.assertEquals(homeFreeUser_page.viewFullScheduleGetText(),
					ConfigReader.getProperty("viewFullScheduleText"), "view Full Schedule is not displayed");
			break;

		case "View Full Schedule Subscription":
			homeFreeUser_page.viewFullScheduleClick();
			String ExpectedUrl = ConfigReader.getProperty("subcriptionURL");
			Assert.assertEquals(homeFreeUser_page.getCurrentTitle(), ExpectedUrl,
					"Navigation to subscription upgrade page failed");
			break;

		}
	}
}
