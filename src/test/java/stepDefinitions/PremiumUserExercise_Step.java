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
		this.exercisePageObj = context.getPremiunUserEx_page();
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
//		driver.findElement(By.xpath("//span[@class='block text-s mt-1']")).click();
		exercisePageObj.clickExerciseBtn();
	}

	@Then("{string} is displayed")
	public void is_displayed(String scenario) {
		switch (scenario) {
		case "ViewFullSchedule":
//			System.out.println("inside viewfullschedule");
			isVisible = exercisePageObj.isViewFullScheduleBtnVisible();
			Assert.assertTrue(isVisible, "View Full Schedule is not visible");
			break;
		case "WarmUp":
			isVisible = exercisePageObj.isWarmUpBtnVisible();
			Assert.assertTrue(isVisible, "Warm Up is not visible");
			break;
		case "MainWorkout":
			isVisible = exercisePageObj.isMainWorkoutBtnVisible();
			Assert.assertTrue(isVisible, "Main Workout is not visible");
			break;
		case "CoolDown":
			isVisible = exercisePageObj.isCoolDownBtnVisible();
			Assert.assertTrue(isVisible, "Cool Down is not visible");
			break;
		case "ExerciseName":
			isVisible = exercisePageObj.isExcerciseNameVisible();
			Assert.assertTrue(isVisible, "Exercise Name is not visible");
			break;
		case "Description":
			isVisible = exercisePageObj.isExerciseDescriptionVisible();
			Assert.assertTrue(isVisible, "Exercise Description is not visible");
			break;
		case "Duration":
			isVisible = exercisePageObj.isExerciseDurationVisible();
			Assert.assertTrue(isVisible, "Duration is not visible");
			break;
		case "Calories":
			isVisible = exercisePageObj.isExerciseCaloriesVisible();
			Assert.assertTrue(isVisible, "Calories is not visible");
			break;
		case "IntensityLevel":
			isVisible = exercisePageObj.isExerciseIntensityVisible();
			Assert.assertTrue(isVisible, "Intensity Level is not visible");
			break;
		case "MarkAsCompleted":
			isVisible = exercisePageObj.isMarkAsCompletedVisible();
			Assert.assertTrue(isVisible, "Mark As Completed is not visible");
			break;
		case "SuccessDialog":
			isVisible = exercisePageObj.isSuccessDialogVisible();
			Assert.assertTrue(isVisible, "Success Dialog is not visible");
			break;
		case "Completed":
			isVisible = exercisePageObj.isCompletedVisible();
			Assert.assertTrue(isVisible, "Completed is not visible");
			break;
		case "UndoOption":
			isVisible = exercisePageObj.isUndoOptionVisible();
			Assert.assertTrue(isVisible, "Undo Option is not visible");
			break;
		case "ExerciseSchedule":
			String actPageUrl = exercisePageObj.get_currentPageUrl();
			Assert.assertTrue(actPageUrl.contains("exercise-schedule"), "User not redirected to Exercise schedule");
			break;
		case "TodaysExerciseSchedule":
			isVisible = exercisePageObj.isTodaysExerciseScheduleTitleVisible();
			Assert.assertTrue(isVisible, "Todays Exercise Schedule is not visible");
			break;
		case "BacktoHome":
			isVisible = exercisePageObj.isBacktoHomeBtnVisible();
			Assert.assertTrue(isVisible, "Back to Home is not visible");
			break;
		case "WarmUpToday":
			isVisible = exercisePageObj.isWarmUpVisible();
			Assert.assertTrue(isVisible, "Warm Up is not visible");
			break;
		case "WarmUpExerciseName":
			isVisible = exercisePageObj.isWarmUpExerciseNameVisible();
			Assert.assertTrue(isVisible, "Warm Up Exercise Name is not visible");
			break;
		case "WarmUpDescription":
			isVisible = exercisePageObj.isWarmUpDescriptionVisible();
			Assert.assertTrue(isVisible, "Warm Up Description is not visible");
			break;
		case "WarmUpDuration":
			isVisible = exercisePageObj.isWarmUpDurationVisible();
			Assert.assertTrue(isVisible, "WarmUp Duration is not visible");
			break;
		case "WarmUpCalories":
			isVisible = exercisePageObj.isWarmUpCaloriesVisible();
			Assert.assertTrue(isVisible, "WarmUp Calories is not visible");
			break;
		case "WarmUpIntensityLevel":
			isVisible = exercisePageObj.isWarmUpIntensityLevelVisible();
			Assert.assertTrue(isVisible, "WarmUp Intensity Level is not visible");
			break;
		case "MainWorkoutToday":
			isVisible = exercisePageObj.isMainWorkoutVisible();
			Assert.assertTrue(isVisible, "Main Workout is not visible");
			break;
		case "MainExerciseName":
			isVisible = exercisePageObj.isMainExerciseNameVisible();
			Assert.assertTrue(isVisible, "Main Workout Exercise Name is not visible");
			break;
		case "MainDescription":
			isVisible = exercisePageObj.isMainDescriptionVisible();
			Assert.assertTrue(isVisible, "Main Workout Description is not visible");
			break;
		case "MainDuration":
			isVisible = exercisePageObj.isMainDurationVisible();
			Assert.assertTrue(isVisible, "Main Workout Duration is not visible");
			break;
		case "MainCalories":
			isVisible = exercisePageObj.isMainCaloriesVisible();
			Assert.assertTrue(isVisible, "Main Workout Calories is not visible");
			break;
		case "MainIntensityLevel":
			isVisible = exercisePageObj.isMainIntensityLevelVisible();
			Assert.assertTrue(isVisible, "Main Workout Intensity Level is not visible");
			break;
		case "CoolDownToday":
			isVisible = exercisePageObj.isCoolDownVisible();
			Assert.assertTrue(isVisible, "Cool Down is not visible");
			break;
		case "CoolDownExerciseName":
			isVisible = exercisePageObj.isCoolDownExerciseNameVisible();
			Assert.assertTrue(isVisible, "Cool Down Exercise Name is not visible");
			break;
		case "CoolDownDescription":
			isVisible = exercisePageObj.isCoolDownDescriptionVisible();
			Assert.assertTrue(isVisible, "Cool Down Description is not visible");
			break;
		case "CoolDownDuration":
			isVisible = exercisePageObj.isCoolDownDurationVisible();
			Assert.assertTrue(isVisible, "Cool Down Duration is not visible");
			break;
		case "CoolDownCalories":
			isVisible = exercisePageObj.isCoolDownCaloriesVisible();
			Assert.assertTrue(isVisible, "Cool Down Calories is not visible");
			break;
		case "CoolDownIntensityLevel":
			isVisible = exercisePageObj.isCoolDownIntensityLevelVisible();
			Assert.assertTrue(isVisible, "Cool Down Intensity Level is not visible");
			break;
		case "TotalDuration":
			isVisible = exercisePageObj.isTotalDurationVisible();
			Assert.assertTrue(isVisible, "Total Duration is not visible");
			break;
		
		}

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
