package pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import common.Helper;
import common.TestContext;

public class PremiumUserExercise_Page {

	private WebDriver driver;
	private Helper helper;
	private WebElement element;

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
		this.helper = context.getHelper(); 
		PageFactory.initElements(driver, this);
	}


	public void clickExerciseBtn() {
		exerciseBtn.click();	
	}

	public void clickMainWorkoutBtn() {
		mainWorkoutBtn.click();	
	}

	public void clickCoolDownBtn() {
		coolDownBtn.click();	
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

	public void clickUndoOption() {
		try {
			if(isMarkAsCompletedVisible()) {
				markAsCompleted.click();
				undoOption.click();
			}
		}
		catch (Exception e) {
			undoOption.click();
		}
	}

	public boolean isUndoOptionVisible() {
		return undoOption.isDisplayed();
	}

	public void clickViewFullScheduleBtn() {
		viewFullScheduleBtn.click();
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

	public boolean isElementDisplayed(String scenario) {
		switch (scenario) {
		case "ViewFullSchedule":
			element = viewFullScheduleBtn;
			break;
		case "WarmUp":
			element = warmUpBtn;
			break;
		case "MainWorkout":
			element = mainWorkoutBtn;
			break;
		case "CoolDown":
			element = coolDownBtn;
			break;
		case "ExerciseName":
			element = excerciseName;
			break;
		case "Description":
			element = exerciseDescription;
			break;
		case "Duration":
			element = exerciseDuration;
			break;
		case "Calories":
			element = exerciseCalories;
			break;
		case "IntensityLevel":
			element = exerciseIntensity;
			break;
		case "MarkAsCompleted":
			element = markAsCompleted;
			break;
		case "SuccessDialog":
			element = successDialog;
			break;
		case "Completed":
			element = completed;
			break;
		case "UndoOption":
			element = undoOption;
			break;
		case "TodaysExerciseSchedule":
			element = todaysExerciseScheduleTitle;
			break;
		case "BacktoHome":
			element = backtoHomeBtn;
			break;
		case "WarmUpToday":
			element = warmUp;
			break;
		case "WarmUpExerciseName":
			element = warmUpExerciseName;
			break;
		case "WarmUpDescription":
			element = warmUpDescription;
			break;
		case "WarmUpDuration":
			element = warmUpDuration;
			break;
		case "WarmUpCalories":
			element = warmUpCalories;
			break;
		case "WarmUpIntensityLevel":
			element = warmUpIntensityLevel;
			break;
		case "MainWorkoutToday":
			element = mainWorkout;
			break;
		case "MainExerciseName":
			element = mainExerciseName;
			break;
		case "MainDescription":
			element = mainDescription;
			break;
		case "MainDuration":
			element = mainDuration;
			break;
		case "MainCalories":
			element = mainCalories;
			break;
		case "MainIntensityLevel":
			element = mainIntensityLevel;
			break;
		case "CoolDownToday":
			element = coolDown;
			break;
		case "CoolDownExerciseName":
			element = coolDownExerciseName;
			break;
		case "CoolDownDescription":
			element = coolDownDescription;
			break;
		case "CoolDownDuration":
			element = coolDownDuration;
			break;
		case "CoolDownCalories":
			element = coolDownCalories;
			break;
		case "CoolDownIntensityLevel":
			element = coolDownIntensityLevel;
			break;
		case "TotalDuration":
			element = totalDuration;
			break;		
		}
		return helper.checkElementDisplayed(element);

	}

}
