package stepDefinitions;


import java.util.Map;
import org.testng.Assert;
import common.ExcelReader;
import common.LoggerLoad;
import common.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LoginUI_Page;
import pageObject.PremiumUserExercise_Page;

public class PremiumUserExercise_Step {

	private TestContext context;
	private  PremiumUserExercise_Page exercisePageObj;
	boolean isVisible;
	private  LoginUI_Page loginUI_page;

	public PremiumUserExercise_Step (TestContext context) {
		this.context = context;
		this.exercisePageObj = context.getPremiumUserEx_page();
		this.loginUI_page = context.getLoginUI_Page();
	}

	@Given("The user is in the Home page and clicks Sign In of premium account")
	public void the_user_is_in_the_home_page_and_clicks_sign_in_of_premium_account() {
		loginUI_page.clickLoginGutton();
	}

	@When("The user enters valid credentials as in {string} and {string} and logs in of premium account")
	public void the_user_enters_valid_credentials_and_logs_in_of_premium_account(String Sheet, String Testcase_ID) {
		Map<String, String> testData = ExcelReader.getTestData(Sheet, Testcase_ID);
		String email = testData.get("Email");
		String password = testData.get("Password");
		loginUI_page.enterEmail(email);
		loginUI_page.clickContinueWithEmailButton();
		loginUI_page.enterPassword(password);
		loginUI_page.clickContinueWithEmailButton();
	}

	@Given("User is in the homepage of premium account")
	public void user_is_in_the_homepage_of_premium_account() {
		LoggerLoad.info("User is in Home Page of Premium User");
	}

	@When("User clicks the Exercise option from the side panel of premium account")
	public void user_clicks_the_exercise_option_from_the_side_panel_of_premium_account() {
		exercisePageObj.clickExerciseBtn();
	}

	@Then("{string} is displayed in premium account")
	public void is_displayed_in_premium_account(String scenario) {
		isVisible = exercisePageObj.isElementDisplayed(scenario);
		Assert.assertTrue(isVisible, scenario + " is not visible");

	}

	@Given("User is in the Exercise section of premium account")
	public void user_is_in_the_exercise_section_of_premium_account() {
		exercisePageObj.clickExerciseBtn();
		LoggerLoad.info("User is in Exercise section of Premium user");
	}

	@When("User clicks the Main Workout Tab of premium account")
	public void user_clicks_the_main_workout_tab_of_premium_account() {
		exercisePageObj.clickMainWorkoutBtn();
	}

	@When("User clicks the Cool Down Tab of premium account")
	public void user_clicks_the_cool_down_tab_of_premium_account() {
		exercisePageObj.clickCoolDownBtn();
	}
	

	@When("User clicks the Mark As Completed button of premium account")
	public void user_clicks_the_mark_as_completed_button_of_premium_account() {
		exercisePageObj.clickMarkAsCompleted();
	}
	
	@Given("User is in the Exercise section of premium account after completing exercise")
	public void user_is_in_the_exercise_section_of_premium_account_after_completing_exercise() {
		exercisePageObj.clickExerciseBtn();
		exercisePageObj.clickMarkAsCompleted();
		LoggerLoad.info("User is in Exercise section of Premium user after completing exercise");
	}

	@When("User clicks Undo after marking Exercise as completed")
	public void user_clicks_undo_after_marking_exercise_as_completed() {
		exercisePageObj.clickUndoOption();
	}

	@Then("Button changes back to Mark As Completed in the Exercise section of premium account")
	public void button_changes_back_to_mark_as_completed_in_the_Exercise_section_of_premium_account() {
		isVisible = exercisePageObj.isMarkAsCompletedVisible();
		Assert.assertTrue(isVisible, "Mark As Completed is not visible");
	}

	@When("User clicks the View Full Schedule button of premium account")
	public void user_clicks_the_view_full_schedule_button_of_premium_account() {
		exercisePageObj.clickViewFullScheduleBtn();
	}
	
	@Then("User should redirect to Exercise schedule of premium account")
	public void user_should_redirect_to_exercise_schedule_of_premium_account() {
		String actPageUrl = exercisePageObj.get_currentPageUrl();
		Assert.assertTrue(actPageUrl.contains("exercise-schedule"), "User not redirected to Exercise schedule");
	}

	@Then("Exercise intensity should low\\/medium\\/hard of premium account")
	public void exercise_intensity_should_low_medium_hard_of_premium_account() {
		String actIntensity = exercisePageObj.getIntesityLevel().trim();
		Assert.assertTrue(actIntensity.equals("Low") || actIntensity.equals("Medium") || actIntensity.equals("Hard"),"Unexpected intensity level");
	}

	@Then("total duration should equal the sum of all individual durations of premium account")
	public void total_duration_should_equal_the_sum_of_all_individual_durations_of_premium_account() {
		int sum = exercisePageObj.getSumDuration();
		int total = exercisePageObj.getTotalDuration();
		Assert.assertEquals(sum, total, "Sum and Total Duration do not match");

	}

	@Then("total calories should equal the sum of all individual calories of premium account")
	public void total_calories_should_equal_the_sum_of_all_individual_calories_of_premium_account() {
		int sum = exercisePageObj.getSumCalories();
		int total = exercisePageObj.getTotalCalories();
		Assert.assertEquals(sum, total, "Sum and Total Calories do not match");

	}

}
