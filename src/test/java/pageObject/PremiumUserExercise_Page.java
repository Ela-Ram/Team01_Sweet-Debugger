package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import common.TestContext;

public class PremiumUserExercise_Page {

	private WebDriver driver;

	//Premium User Exercise Page
	@FindBy(xpath = "//span[@class='block text-s mt-1']/..") WebElement exerciseBtn;
	@FindBy(xpath = "//div[@class='flex justify-between items-center']/button") WebElement viewFullScheduleBtn;
	@FindBy(xpath = "//button[text()='Warm Up']") WebElement warmUpBtn;
	@FindBy(xpath = "//button[text()='Main Workout']") WebElement mainWorkoutBtn;
	@FindBy(xpath = "//button[text()='Cool Down']") WebElement coolDownBtn;
	@FindBy(xpath = "//h3[@class='font-semibold']") WebElement excerciseName;
	@FindBy(xpath = "//p[@class='text-gray-600 mb-2']") WebElement exerciseDescription;
	@FindBy(xpath = "//span[contains(text(),'Duration')]") WebElement exerciseDuration;
	@FindBy(xpath = "//span[contains(text(),'Calories')]") WebElement exerciseCalories;
	@FindBy(xpath = "//span[contains(text(),'Intensity')]") WebElement exerciseIntensity;
	@FindBy(xpath = "//span[text()='Mark as Completed']") WebElement markAsCompleted;
	@FindBy(xpath = "//div[@class='text-sm font-semibold']") WebElement successDialog;
	@FindBy(xpath = "//span[@class='text-sm']") WebElement completed;
	@FindBy(xpath = "//button[text()='Undo']") WebElement undoOption;

	//Premium User Todays Exercise Schedule page 
	@FindBy(xpath = "//h1[@class='text-3xl font-bold text-white']") WebElement todaysExerciseScheduleTitle;
	@FindBy(xpath = "//button[text()='Back to Home']") WebElement backtoHomeBtn;
	@FindBy(xpath = "//h2[text()='Warm Up']") WebElement warmUp;
	@FindBy(xpath = "//h2[text()='Warm Up']/..//h3") WebElement warmUpExerciseName;
	@FindBy(xpath = "//h2[text()='Warm Up']/..//p") WebElement warmUpDescription;
	@FindBy(xpath = "//h2[text()='Warm Up']/..//span[contains(text(),'Duration')]") WebElement warmUpDuration;
	@FindBy(xpath = "//h2[text()='Warm Up']/..//span[contains(text(),'Calories')]") WebElement warmUpCalories;
	@FindBy(xpath = "//h2[text()='Warm Up']/..//span[contains(text(),'Intensity')]") WebElement warmUpIntensityLevel;
	@FindBy(xpath = "//h2[text()='Main Workout']") WebElement mainWorkout;
	@FindBy(xpath = "//h2[text()='Main Workout']/..//h3") WebElement mainExerciseName;
	@FindBy(xpath = "//h2[text()='Main Workout']/..//p") WebElement mainDescription;
	@FindBy(xpath = "//h2[text()='Main Workout']/..//span[contains(text(),'Duration')]") WebElement mainDuration;
	@FindBy(xpath = "//h2[text()='Main Workout']/..//span[contains(text(),'Calories')]") WebElement mainCalories;
	@FindBy(xpath = "//h2[text()='Main Workout']/..//span[contains(text(),'Intensity')]") WebElement mainIntensityLevel;
	@FindBy(xpath = "//h2[text()='Cool Down']") WebElement coolDown;
	@FindBy(xpath = "//h2[text()='Cool Down']/..//h3") WebElement coolDownExerciseName;
	@FindBy(xpath = "//h2[text()='Cool Down']/..//p") WebElement coolDownDescription;
	@FindBy(xpath = "//h2[text()='Cool Down']/..//span[contains(text(),'Duration')]") WebElement coolDownDuration;
	@FindBy(xpath = "//h2[text()='Cool Down']/..//span[contains(text(),'Calories')]") WebElement coolDownCalories;
	@FindBy(xpath = "//h2[text()='Cool Down']/..//span[contains(text(),'Intensity')]") WebElement coolDownIntensityLevel;
	@FindBy(xpath = "//span[contains(text(),'Total Duration')]") WebElement totalDuration;
	@FindBy(xpath = "//span[contains(text(),'Total Calories')]") WebElement totalCalories;


	public PremiumUserExercise_Page(TestContext context) {
		this.driver = context.getDriver();
		PageFactory.initElements(driver, this);
	}

	public void premiumUserLogin() {

		driver.findElement(By.xpath("//div[@class='flex space-x-4']")).click();
		driver.findElement(By.name("email")).sendKeys("Team01PremiumUser@gmail.com");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.name("password")).sendKeys("Team01PremiumUser");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	private boolean checkElementDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void clickExerciseBtn() {
		exerciseBtn.click();	
	}
	public boolean isViewFullScheduleBtnVisible() {
		return checkElementDisplayed(viewFullScheduleBtn);
	}

	public boolean isWarmUpBtnVisible() {
		return warmUpBtn.isDisplayed();
	}

	public boolean isMainWorkoutBtnVisible() {
		return mainWorkoutBtn.isDisplayed();
	}

	public boolean isCoolDownBtnVisible() {
		return coolDownBtn.isDisplayed();
	}

	public void clickMainWorkoutBtn() {
		mainWorkoutBtn.click();	
	}

	public void clickCoolDownBtn() {
		coolDownBtn.click();	
	}

	public boolean isExcerciseNameVisible() {
		return excerciseName.isDisplayed();
	}

	public boolean isExerciseDescriptionVisible() {
		return exerciseDescription.isDisplayed();
	}

	public boolean isExerciseDurationVisible() {
		return exerciseDuration.isDisplayed();
	}

	public boolean isExerciseCaloriesVisible() {
		return exerciseCalories.isDisplayed();
	}

	public boolean isExerciseIntensityVisible() {
		return exerciseIntensity.isDisplayed();
	}

	public boolean isMarkAsCompletedVisible() {
		return markAsCompleted.isDisplayed();
	}

	public void clickMarkAsCompleted() {
		try {
			if(isUndoOptionVisible()) {
				undoOption.click();
				markAsCompleted.click();
			}
		}
		catch (Exception e) {
			markAsCompleted.click();
		}
	}

	public boolean isSuccessDialogVisible() {
		return successDialog.isDisplayed();
	}

	public boolean isCompletedVisible() {
		return completed.isDisplayed();
	}

	public boolean isUndoOptionVisible() {
		return undoOption.isDisplayed();
	}

	public void clickUndoOption() {
		undoOption.click();
	}

	public void clickViewFullScheduleBtn() {
		viewFullScheduleBtn.click();
	}

	public boolean isTodaysExerciseScheduleTitleVisible() {
		return todaysExerciseScheduleTitle.isDisplayed();
	}

	public boolean isBacktoHomeBtnVisible() {
		return backtoHomeBtn.isDisplayed();
	}

	public boolean isWarmUpVisible() {
		return warmUp.isDisplayed();
	}

	public boolean isWarmUpExerciseNameVisible() {
		return warmUpExerciseName.isDisplayed();
	}

	public boolean isWarmUpDescriptionVisible() {
		return warmUpDescription.isDisplayed();
	}

	public boolean isWarmUpDurationVisible() {
		return warmUpDuration.isDisplayed();
	}

	public boolean isWarmUpCaloriesVisible() {
		return warmUpCalories.isDisplayed();
	}

	public boolean isWarmUpIntensityLevelVisible() {
		return warmUpIntensityLevel.isDisplayed();
	}

	public boolean isMainWorkoutVisible() {
		return mainWorkout.isDisplayed();
	}

	public boolean isMainExerciseNameVisible() {
		return mainExerciseName.isDisplayed();
	}

	public boolean isMainDescriptionVisible() {
		return mainDescription.isDisplayed();
	}

	public boolean isMainDurationVisible() {
		return mainDuration.isDisplayed();
	}

	public boolean isMainCaloriesVisible() {
		return mainCalories.isDisplayed();
	}

	public boolean isMainIntensityLevelVisible() {
		return mainIntensityLevel.isDisplayed();
	}

	public boolean isCoolDownVisible() {
		return coolDown.isDisplayed();
	}

	public boolean isCoolDownExerciseNameVisible() {
		return coolDownExerciseName.isDisplayed();
	}

	public boolean isCoolDownDescriptionVisible() {
		return coolDownDescription.isDisplayed();
	}

	public boolean isCoolDownDurationVisible() {
		return coolDownDuration.isDisplayed();
	}

	public boolean isCoolDownCaloriesVisible() {
		return coolDownCalories.isDisplayed();
	}

	public boolean isCoolDownIntensityLevelVisible() {
		return coolDownIntensityLevel.isDisplayed();
	}

	public boolean isTotalDurationVisible() {
		return totalDuration.isDisplayed();
	}

	public String get_currentPageUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public String getIntesityLevel() {
		String intensity = warmUpIntensityLevel.getText();
		String split[] = intensity.split(":");
		return split[1];
	}

	public int getSumDuration() {
		String warmDuration = warmUpDuration.getText();
		String mnDuration = mainDuration.getText();
		String coolDuration = coolDownDuration.getText();
		String warmDur = warmDuration.split(":")[1].trim().split(" ")[0];
		String mnDur = mnDuration.split(":")[1].trim().split(" ")[0];
		String coolDur = coolDuration.split(":")[1].trim().split(" ")[0];
		int sum = Integer.parseInt(warmDur) + Integer.parseInt(mnDur) + Integer.parseInt(coolDur);
		return sum;
	}

	public int getTotalDuration() {
		String totalDur = totalDuration.getText();
		String TotalDurSplit = totalDur.split(":")[1].trim().split(" ")[0];
		return Integer.parseInt(TotalDurSplit);
	}

	public int getSumCalories() {
		String warmCalories = warmUpCalories.getText();
		String mnCalories = mainCalories.getText();
		String coolCalories = coolDownCalories.getText();
		String warmCal = warmCalories.split(":")[1].trim();
		String mnCal = mnCalories.split(":")[1].trim();
		String coolCal = coolCalories.split(":")[1].trim();
		int sum = Integer.parseInt(warmCal) + Integer.parseInt(mnCal) + Integer.parseInt(coolCal);
		return sum;
	}

	public int getTotalCalories() {
		String totalCal = totalCalories.getText();
		String TotalCalSplit = totalCal.split(":")[1].trim();
		return Integer.parseInt(TotalCalSplit);
	}

}
