package stepDefinitions;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import common.LoggerLoad;
import common.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.PremiumUserExercise_Page;

public class PremiumUserExercise_Step {

	private TestContext context;
	private  PremiumUserExercise_Page exercisePageObj;
	private WebDriver driver;
	boolean isVisible;

	public PremiumUserExercise_Step (TestContext context) {
		this.context = context;
		this.exercisePageObj = context.getPremiumUserEx_page();
		this.driver = context.getDriver();
	}

	@Given("The user is in the Home page and clicks Sign In")
	public void the_user_is_in_the_home_page_and_clicks_sign_in() {
		exercisePageObj.premiumUserLogin();

	}

	@When("The user enters valid credentials and logs in")
	public void the_user_enters_valid_credentials_and_logs_in() {


	}

	@Given("User is in the homepage")
	public void user_is_in_the_homepage() {
		LoggerLoad.info("User is in Home Page of Premium User");

	}

	@When("User clicks the Exercise option from the side panel")
	public void user_clicks_the_exercise_option_from_the_side_panel() {
		exercisePageObj.clickExerciseBtn();
	}

	@Then("{string} is displayed")
	public void is_displayed(String scenario) {
		isVisible = exercisePageObj.isElementDisplayed(scenario);
		Assert.assertTrue(isVisible, scenario + " is not visible");

	}

	@Given("User is in the Exercise section")
	public void user_is_in_the_exercise_section() {
		exercisePageObj.clickExerciseBtn();
		LoggerLoad.info("User is in Exercise section of Premium user");
	}

	@When("User clicks the Main Workout Tab")
	public void user_clicks_the_main_workout_tab() {
		exercisePageObj.clickMainWorkoutBtn();
	}

	@When("User clicks the Cool Down Tab")
	public void user_clicks_the_cool_down_tab() {
		exercisePageObj.clickCoolDownBtn();
	}
	

	@When("User clicks the Mark As Completed button")
	public void user_clicks_the_mark_as_completed_button() {
		exercisePageObj.clickMarkAsCompleted();
	}
	
	@Given("User is in the Exercise section after completing exercise")
	public void user_is_in_the_exercise_section_after_completing_exercise() {
		exercisePageObj.clickExerciseBtn();
		exercisePageObj.clickMarkAsCompleted();
		LoggerLoad.info("User is in Exercise section of Premium user after completing exercise");
	}

	@When("User clicks Undo after marking Exercise as completed")
	public void user_clicks_undo_after_marking_exercise_as_completed() {
		exercisePageObj.clickUndoOption();
	}

	@Then("Button changes back to Mark As Completed")
	public void button_changes_back_to_mark_as_completed() {
		isVisible = exercisePageObj.isMarkAsCompletedVisible();
		Assert.assertTrue(isVisible, "Mark As Completed is not visible");
	}

	@When("User clicks the View Full Schedule button")
	public void user_clicks_the_view_full_schedule_button() {
		exercisePageObj.clickViewFullScheduleBtn();
	}
	
	@Then("User should redirect to Exercise schedule")
	public void user_should_redirect_to_exercise_schedule() {
		String actPageUrl = exercisePageObj.get_currentPageUrl();
		Assert.assertTrue(actPageUrl.contains("exercise-schedule"), "User not redirected to Exercise schedule");
	}

	@Then("Exercise intensity should low\\/medium\\/hard")
	public void exercise_intensity_should_low_medium_hard() {
		String actIntensity = exercisePageObj.getIntesityLevel().trim();
		Assert.assertTrue(actIntensity.equals("Low") || actIntensity.equals("Medium") || actIntensity.equals("Hard"),"Unexpected intensity level");
	}

	@Then("total duration should equal the sum of all individual durations")
	public void total_duration_should_equal_the_sum_of_all_individual_durations() {
		int sum = exercisePageObj.getSumDuration();
		int total = exercisePageObj.getTotalDuration();
		Assert.assertEquals(sum, total, "Sum and Total Duration do not match");

	}

	@Then("total calories should equal the sum of all individual calories")
	public void total_calories_should_equal_the_sum_of_all_individual_calories() {
		int sum = exercisePageObj.getSumCalories();
		int total = exercisePageObj.getTotalCalories();
		Assert.assertEquals(sum, total, "Sum and Total Calories do not match");

	}

}
