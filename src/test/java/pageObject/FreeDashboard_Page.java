package pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.Helper;
import common.LoggerLoad;
import common.TestContext;

public class FreeDashboard_Page {
	private WebDriver driver;
	private Helper helper;
	private static final String REGEX_AGE_150 = "^(?:1[0-4][0-9]|[1-9][0-9]?|150)$";
	private static final String REGEX_HEIGHT_300 = "^(?:[1-9]|[1-9][0-9]|1[0-9]{2}|2[0-9]{2}|300)$";
	private static final String REGEX_WEIGHT_500 = "^(?:[1-9]|[1-9][0-9]|[1-4][0-9]{2}|500)$";

	public FreeDashboard_Page(TestContext context) {
		this.driver = context.getDriver();
		this.helper = context.getHelper();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='Dashboard']")
	WebElement dashBoard;

	@FindBy(xpath = "//div/h3[contains(text(),'Welcome Back,')]")
	private WebElement welcomeMessage;

	@FindBy(xpath = "//div/p[contains(text(),'manage your diet,')]")
	private WebElement displayMessage;

	@FindBy(xpath = "//button[contains(text(),'Upgrade to Premium')]")
	private WebElement upgradePremium;

	@FindBy(xpath = "//span[contains(text(),'Account Information')]")
	private WebElement accountInformation;

	@FindBy(xpath = "//button[normalize-space()='Save Changes']")
	private WebElement saveChanges;

	@FindBy(id = "age")
	private WebElement ageField;

	@FindBy(id = "height")
	private WebElement heightField;

	@FindBy(id = "weight")
	private WebElement weightField;

	@FindBy(id = "exerciseLevel")
	private WebElement exerciseLevelDropdown;

	@FindBy(id = "cuisinePreference")
	private WebElement cuisinePreferenceDropdown;

	@FindBy(id = "allergies")
	private WebElement allergiesDropdown;

	@FindBy(xpath = "//button[normalize-space()='Save Changes']")
	private WebElement saveChangesButton;

	@FindBy(xpath = "//div[@role='listbox']//div[@role='option']")
	List<WebElement> exerciseLevelOptions;

	@FindBy(xpath = "//div[@role='listbox']//div[@role='option']")
	List<WebElement> cuisinePreferenceOptions;

	@FindBy(xpath = "//div[@role='listbox']//div[@role='option']")
	List<WebElement> allergiesOptions;

	@FindBy(xpath = "//span[contains(text(),'Stress Management Techniques')]")
	private WebElement stressManagementTechniques;

	@FindBy(xpath = "//button[@role='tab' and text()='Meditation']")
	private WebElement meditationTab;

	public void dashBoardClick() {
		helper.waitForClickableWebElement(dashBoard).click();
	}

	public boolean isWelcomeMessageCorrect(String expectedUserName) {
		String actualText = welcomeMessage.getText().trim();
		String expectedText = "Welcome Back," + expectedUserName;
		return actualText.equalsIgnoreCase(expectedText);
	}

	public boolean isWelcomeMessageBelowDescriptionDispalyed() {
		return helper.checkElementDisplayed(displayMessage);
	}

	public boolean isUpgradePremiumDispalyed() {
		return helper.checkElementDisplayed(upgradePremium);
	}

	public boolean isAccountInformationDispalyed() {
		return helper.checkElementDisplayed(accountInformation);
	}

	public boolean isSaveChangesDispalyed() {
		return helper.checkElementDisplayed(saveChanges);
	}

	public boolean areAllAccountInfoFieldsDisplayed() {
		return ageField.isDisplayed() && heightField.isDisplayed() && weightField.isDisplayed()
				&& exerciseLevelDropdown.isDisplayed() && cuisinePreferenceDropdown.isDisplayed()
				&& allergiesDropdown.isDisplayed() && saveChangesButton.isDisplayed();
	}

	public void enterDigits(WebElement element, String value, String regex) {
		element.clear();
		if (value != null && value.matches(regex)) {
			element.sendKeys(value);
		}
	}

	public boolean isNumeric(String value, String regex) {
		return value != null && value.matches(regex);// accepts digits
	}

	public void enterAge() {
		enterDigits(ageField, "40", REGEX_AGE_150);
	}

	public boolean getAgeValue() {
		String age = ageField.getAttribute("value").trim();
		if (isNumeric(age, REGEX_AGE_150))
			return true;
		return false;
	}

	public boolean getHeightValue() {
		String age = heightField.getAttribute("value").trim();
		if (isNumeric(age, REGEX_HEIGHT_300))
			return true;
		return false;
	}

	public void enterHeight() {
		enterDigits(heightField, "150", REGEX_HEIGHT_300);
	}

	public boolean getWeightValue() {
		String age = weightField.getAttribute("value").trim();
		if (isNumeric(age, REGEX_WEIGHT_500))
			return true;
		return false;
	}

	public void enterWeight() {
		enterDigits(weightField, "75", REGEX_WEIGHT_500);
	}

	public void exerciseLevelDropdownClick() {
		helper.waitForClickableWebElement(exerciseLevelDropdown).click();
	}

	public boolean isExerciseDropdownDisplayed() {
		List<String> allDropdownOptionsText = helper.getTexts(exerciseLevelOptions);
		for (String option : allDropdownOptionsText) {
			String text = option.trim();
			if (!text.equalsIgnoreCase("Easy") && !text.equalsIgnoreCase("Medium") && !text.equalsIgnoreCase("Hard"))
				return false;
		}
		return true;
	}

	public boolean iscuisinePreferenceDropdownDisplayed() {
		List<String> allDropdownOptionsText = helper.getTexts(cuisinePreferenceOptions);
		for (String option : allDropdownOptionsText) {
			String text = option.trim();
			if (!text.equalsIgnoreCase("Indian") && !text.equalsIgnoreCase("American")
					&& !text.equalsIgnoreCase("Continental") && !text.equalsIgnoreCase("Mediterranean")
					&& !text.equalsIgnoreCase("Asian") && !text.equalsIgnoreCase("Middle Eastern")
					&& !text.equalsIgnoreCase("Mexican"))
				return false;
		}
		return true;
	}

	public void allergiesDropdownClick() {
		helper.waitForClickableWebElement(allergiesDropdown).click();
	}

	public boolean isAllergiesDropdownDisplayed() {
		List<String> allDropdownOptionsText = helper.getTexts(allergiesOptions);
		for (String option : allDropdownOptionsText) {
			String text = option.trim();
			LoggerLoad.info(text);
			if (!text.equalsIgnoreCase("None") && !text.equalsIgnoreCase("Dairy") && !text.equalsIgnoreCase("Gluten")
					&& !text.equalsIgnoreCase("Nuts") && !text.equalsIgnoreCase("Shellfish")
					&& !text.equalsIgnoreCase("Soy") && !text.equalsIgnoreCase("Eggs")
					&& !text.equalsIgnoreCase("Other"))
				return false;
		}
		return true;
	}

	@FindBy(xpath = "//button[@role='combobox' and @id='cuisinePreference']")
	WebElement cuisineDropdown;

	public void cuisinePreferenceClick() {
		helper.waitForClickableWebElement(cuisineDropdown).click();
	}


	public void scrolltoStressManagement() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", stressManagementTechniques);
	}

	public boolean isStressManagementDisplayed() {
		return helper.checkElementDisplayed(stressManagementTechniques);
	}

	@FindBy(xpath = "//div[@role='tablist']/button")
	List<WebElement> navigationBarTab;

	public boolean isNavigationBarTabDisplayed() {
		List<String> allDropdownOptionsText = helper.getTexts(navigationBarTab);
		for (String option : allDropdownOptionsText) {
			String text = option.trim();
			LoggerLoad.info(text);
			if (!text.equalsIgnoreCase("Meditation") && !text.equalsIgnoreCase("Breathing")
					&& !text.equalsIgnoreCase("Movement") && !text.equalsIgnoreCase("Mindfulness"))
				return false;
		}
		return true;
	}

	@FindBy(css = "button[role='tab']")
	private List<WebElement> tabs;

	public boolean isTextDisplayedAfterClickingTabs(WebElement targetElement) {
		for (WebElement tab : tabs) {
			helper.waitForClickableWebElement(tab).click();

			// Wait for the target element to be visible after clicking the tab
			if (helper.checkElementDisplayed(targetElement)) {
				return true; // Element is displayed after clicking this tab
			}
		}
		return false; // Element not displayed after any tab click
	}

	@FindBy(xpath = "//div[contains(text(),'Breathing')]")
	WebElement breathingText;

	@FindBy(xpath = "//div[contains(text(),'Mindfulness')]")
	WebElement mindfulnessText;

	@FindBy(xpath = "//h3[contains(text(),'Guided Meditation')]")
	WebElement guidedMeditation;

	public void guidedMeditationTabClick() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", guidedMeditation);
	}

	public boolean isGuidedMeditationDisplayed() {
		return helper.checkElementDisplayed(guidedMeditation);
	}

	public void meditationTabClick() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", meditationTab);
		helper.waitForClickableWebElement(meditationTab).click();
	}

	@FindBy(xpath = "//button[contains(text(),'min')]")
	private List<WebElement> durationButtons;


	@FindBy(xpath = "//div[@class='flex space-x-2']/button")
	private List<WebElement> meditationDuration;

	public boolean isMeditationDurationDisplayed() {
		List<String> allDropdownOptionsText = helper.getTexts(meditationDuration);
		for (String option : allDropdownOptionsText) {
			String text = option.trim();
			LoggerLoad.info(text);
			if (!text.equalsIgnoreCase("5 min") && !text.equalsIgnoreCase("10 min") && !text.equalsIgnoreCase("15 min"))
				return false;
		}
		return true;
	}

	@FindBy(xpath = "//*[text()='0:00']")
	private WebElement startTime;

	@FindBy(xpath = "//*[text()='5:00']")
	private WebElement endTime;

	public boolean isMeditationAudioBarDisplayed() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", meditationTab);
		helper.waitForClickableWebElement(meditationTab).click();
		boolean isStartVisible = helper.checkElementDisplayed(startTime);
		boolean isEndVisible = helper.checkElementDisplayed(endTime);
		return isStartVisible && isEndVisible;
	}

	@FindBy(xpath = "//button[contains(@class, 'bg-white/30')and contains(@class, 'h-16')]")
	WebElement audioButton;

	@FindBy(xpath = "//div[contains(@class, 'flex justify-between')]/span[1]")
	WebElement currentTime;

	@FindBy(xpath = "//div[contains(@class, 'flex justify-between')]/span[2]")
	WebElement totalDuration;

	public void audioBtnClick() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", audioButton);
		helper.waitForClickableWebElement(audioButton).click();

	}

	public int getAudioPlaybackProgressInSecondsAfterWait(int waitTimeInMillis) throws InterruptedException {
		String timeBefore = currentTime.getText();
		Thread.sleep(waitTimeInMillis);
		String timeAfter = currentTime.getText();
		int beforeSeconds = convertToSeconds(timeBefore);
		int afterSeconds = convertToSeconds(timeAfter);
		return afterSeconds - beforeSeconds;
	}

	private int convertToSeconds(String time) {
		String[] parts = time.split(":");
		return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
	}

	@FindBy(xpath = "//button[@role='tab' and text()='Movement']")
	WebElement movementTab;

	@FindBy(xpath = "//*[text()='Gentle Movement']")
	WebElement gentleMovement;

	@FindBy(xpath = "//*[text()='Present Moment Awareness']")
	WebElement momentAwareness;

	@FindBy(xpath = "//div[@class='bg-white/10 rounded-lg p-6']/p")
	WebElement momentDescription;

	@FindBy(xpath = "//ul[@class='space-y-2 text-sm text-black/80']/li")
	List<WebElement> momentDescriptionList;

	public boolean ismomentDescriptionDisplayed() {
		return helper.isTextEqual(momentDescription, "Simple stretches to release tension:");
	}

	public boolean ismomentDescriptionListDisplayed() {
		List<String> allDropdownOptionsText = helper.getTexts(momentDescriptionList);
		for (String option : allDropdownOptionsText) {
			String text = option.trim();
			if (!text.equalsIgnoreCase("• Neck rolls - 5 times each direction")
					&& !text.equalsIgnoreCase("• Shoulder circles - 10 times")
					&& !text.equalsIgnoreCase("• Wrist and ankle rotations")
					&& !text.equalsIgnoreCase("• Gentle torso twists"))
				return false;
		}
		return true;
	}

	@FindBy(xpath = "//div[@class='bg-white/10 rounded-lg p-6']/p")
	WebElement mindfulnessDescription;

	@FindBy(xpath = "//ul[@class='space-y-2 text-sm text-black/80']/li")
	List<WebElement> mindfulnessDescriptionList;

	public boolean isMindfulnessDescriptionDisplayed() {
		return helper.isTextEqual(mindfulnessDescription, "Focus on your senses:");
	}

	public boolean isMindfulnessDescriptionListDisplayed() {
		List<String> allDropdownOptionsText = helper.getTexts(mindfulnessDescriptionList);
		for (String option : allDropdownOptionsText) {
			String text = option.trim();
			LoggerLoad.info(text);
			if (!text.equalsIgnoreCase("• Notice 5 things you can see")
					&& !text.equalsIgnoreCase("• Identify 4 things you can touch")
					&& !text.equalsIgnoreCase("• Listen for 3 different sounds")
					&& !text.equalsIgnoreCase("• Find 2 things you can smell")
					&& !text.equalsIgnoreCase("• Observe 1 thing you can taste"))
				return false;
		}
		return true;
	}

	@FindBy(xpath = "//div[@class='flex items-start']/span")
	List<WebElement> diabetesManagementSectionList;

	@FindBy(xpath = "(//h4[contains(text(),'Benefits for Diabetes Management')])[1]")
	WebElement diabetesManagementSection;

	public void diabetesManagementSectionView() {
		meditationTabClick();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", diabetesManagementSection);
	}

	public boolean isdiabetesManagementSectionListDisplayed() {

		List<String> allDropdownOptionsText = helper.getTexts(diabetesManagementSectionList);
		for (String option : allDropdownOptionsText) {
			String text = option.trim();
			LoggerLoad.info(text);
			if (!text.equalsIgnoreCase("Reduces Stress Hormones - Lowers cortisol that can increase blood glucose")
					&& !text.equalsIgnoreCase("Improves Sleep - Better sleep leads to better glucose control")
					&& !text.equalsIgnoreCase("Reduces Diabetes Distress - Helps manage overwhelm from diabetes care"))
				return false;
		}
		return true;
	}

	public void movementTabClick() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", movementTab);
		helper.waitForClickableWebElement(movementTab).click();
	}

	@FindBy(xpath = "//button[@role='tab' and text()='Mindfulness']")
	WebElement mindfulnessTab;

	public void mindfulnessTabClick() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mindfulnessTab);
		helper.waitForClickableWebElement(mindfulnessTab).click();
	}

	public boolean isgentleMovementDisplayed() {
		return helper.checkElementDisplayed(gentleMovement);
	}

	public boolean ismomentAwarenessDisplayed() {
		return helper.checkElementDisplayed(momentAwareness);
	}

	@FindBy(xpath = "//button[@role='tab' and text()='Breathing']")
	WebElement breathingTab;

	@FindBy(xpath = "//*[text()='Start Breathing Exercise']")
	WebElement startBreathingExercise;

	public void breathingTabClick() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", breathingTab);
		helper.waitForClickableWebElement(breathingTab).click();
	}

	@FindBy(xpath = "//div[@class='text-center']/h3")
	WebElement breathingTechnique;

	@FindBy(xpath = "//div[@class='text-center']/p")
	WebElement naturalTranquilizer;

	public boolean isstartBreathingExerciseDisplayed() {
		return helper.checkElementDisplayed(startBreathingExercise);
	}

	public boolean isBreathingTabDTechniqueDisplayed() {
		if (!helper.checkElementDisplayed(breathingTechnique) && !helper.checkElementDisplayed(naturalTranquilizer)) {
			return false;
		}
		return true;
	}

	@FindBy(xpath = "//p[text()='Cycles completed']")
	WebElement cyclesCompletedText;
	@FindBy(xpath = "//p[text()='0']")
	WebElement zeroText;
	@FindBy(xpath = "//p[text()='Current phase']")
	WebElement currentPhase;
	@FindBy(xpath = "//p[text()='—']")
	WebElement hyphenText;

	public boolean iscyclesCompletedTextDisplayed() {
		if (!helper.checkElementDisplayed(cyclesCompletedText) && !helper.checkElementDisplayed(zeroText)) {
			return false;
		}
		return true;
	}

	public boolean iscurrentPhaseTextDisplayed() {
		if (!helper.checkElementDisplayed(currentPhase) && !helper.checkElementDisplayed(hyphenText)) {
			return false;
		}
		return true;
	}

	@FindBy(xpath = "//div[@class='grid grid-cols-3 gap-4 text-center mt-6']/div/p")
	List<WebElement> breathingStepsList;

	public boolean isBreathingStepsListDisplayed() {
		List<String> allDropdownOptionsText = helper.getTexts(breathingStepsList);
		for (String option : allDropdownOptionsText) {
			String text = option.trim();
			if (!text.equalsIgnoreCase("Inhale") && !text.equalsIgnoreCase("4 seconds")
					&& !text.equalsIgnoreCase("Hold") && !text.equalsIgnoreCase("7 seconds")
					&& !text.equalsIgnoreCase("Exhale") && !text.equalsIgnoreCase("8 seconds"))
				return false;
		}
		return true;
	}

	@FindBy(xpath = "//button[contains(text(),'Start Breathing Exercise')]")
	private WebElement startButton;

	@FindBy(xpath = "//p[text()='Cycles completed']/following-sibling::p")
	private WebElement cycleCounter;

	public void clickStartBreathingExerciseButton() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", startButton);
		startButton.click();
	}

	public int getCycleCount() {
		return Integer.parseInt(cycleCounter.getText().trim());
	}

	public boolean hasCycleStarted() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait.until(driver -> {
			try {
				int count = getCycleCount();
				return count > 0;
			} catch (NumberFormatException e) {
				return false;
			}
		});
	}

	public void enterValue(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public void enterAgeField() {
		enterValue(ageField, "151");
	}

	public void enterHeightField() {
		enterValue(heightField, "283");
	}

	public void enterweightField() {
		enterValue(weightField, "10");
	}

	public void saveChangesClick() {
		helper.waitForClickableWebElement(saveChanges).click();
	}

	public void enterInvalid() throws InterruptedException {
		enterAgeField();
		enterHeightField();
		enterweightField();
		Thread.sleep(3000);
		saveChangesClick();
	}


}
