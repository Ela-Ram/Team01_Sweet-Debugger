package pageObject;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.Helper;
import common.LoggerLoad;
import common.TestContext;

public class HomeFreeUser_page {

	private WebDriver driver;
	private Helper helper;
	private static final Pattern TIME_12_HOUR_PATTERN = Pattern.compile("^(1[0-2]|0?[1-9]):[0-5][0-9]\\s?(AM|PM)$");
	private static final Pattern TIME_DURATION_FOMAT_PATTERN = Pattern.compile("^\\d{1,3}\\s?mins$");

	public HomeFreeUser_page(TestContext context) {

		this.driver = context.getDriver();
		this.helper = context.getHelper();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(@class, 'space-x-8')]/button")
	public List<WebElement> navigationTabs;

	@FindBy(xpath = "//*[name()='svg' and contains(@class, 'rotate-180')]")
	WebElement toggle;

	@FindBy(xpath = "//div[contains(@class,'bg-gray-100/60')]/button")
	public List<WebElement> mealSection;

	@FindBy(xpath = "//div[text()='Nutrition Insights']")
	WebElement nutrientInsightText;

	@FindBy(xpath = "//div[@class='flex gap-4 mb-4']/div")
	public List<WebElement> nutrientBar;

	@FindBy(xpath = "//div[@class='flex gap-4 mb-4']//div[contains(@class, 'text-gray-600')]")
	public List<WebElement> horizontalBarText;

	@FindBy(xpath = "//div[starts-with(text(),'Pre-')]")
	WebElement preMealText;

	@FindBy(xpath = "//span[contains(text(),'Meal Plan')]")
	WebElement mealPlan;

	@FindBy(xpath = "//div[contains(text(),'Carbs: ')]")
	WebElement carbsText;
	
	@FindBy(xpath = "//div[contains(text(),'Protein: ')]")
	WebElement proteinText;
	
	@FindBy(xpath = "//div[contains(text(),'Fat: ')]")
	WebElement fatText;
	
	@FindBy(xpath = "//span[contains(text(),'AM') or contains(text(),'PM')]")
	WebElement timeText;
	
	@FindBy(xpath = "//span[@class='mx-2' and text()='•']")
	WebElement dotIndicator;
	
	@FindBy(xpath = "//button[contains(text(),'View Full Plan')]")
	WebElement viewFullPlan;

	@FindBy(xpath = "//span[contains(text(),'Exercise')]")
	WebElement exercise;

	@FindBy(xpath = "//div[@class='space-y-6']/div/h2")
	WebElement todaysExercisePlanText;
	
	@FindBy(css = "span.text-violet-600.font-medium")
	private List<WebElement> timePresent;

	@FindBy(xpath = "//span[text()='7:00 AM']")
	WebElement morningExerciseTime;

	@FindBy(xpath = "//span[text()='5:00 PM']")
	WebElement eveningExerciseTime;

	@FindBy(xpath = "//div[contains(text(),'mins')]")
	public List<WebElement> timeDurationText;

	@FindBy(xpath = "//button[contains(text(),'View Full Schedule')]")
	WebElement viewFullSchedule;

	public boolean isHomePageToggle() {
		return helper.checkElementDisplayed(toggle);
	}
	
	public List<String> getNavigationTab() {
		List<String> actualTabs = new ArrayList<>();
		for (WebElement btn : navigationTabs) {
			actualTabs.add(btn.getText().trim());
		}
		return actualTabs;
	}

	public boolean isNutrientInsightTextDisplayed() {
		for (WebElement btn : mealSection) {
			helper.waitForClickableWebElement(btn).click();
			if (!nutrientInsightText.isDisplayed())
				return false;
		}
		return true;
	}

	public boolean areNutrientBarsDisplayed() {
		if (nutrientBar.size() != 3) {
			return false;
		}
		for (int i = 0; i < 3; i++) {
			WebElement bar = nutrientBar.get(i);

			if (!bar.isDisplayed()) {
				return false;
			}
		}
		return true;
	}

	public void mealPlanClick() {
		helper.waitForClickableWebElement(mealPlan).click();
	}

	public boolean isTextDisplayed(WebElement element) {
		for (WebElement btn : mealSection) {
			helper.waitForClickableWebElement(btn).click();
			if (!element.isDisplayed()) {
				return false;
			}
		}
		return true;
	}

	public boolean isCarbTextDisplayed() {
		return isTextDisplayed(carbsText);
	}

	public boolean isProteinTextDisplayed() {
		return isTextDisplayed(proteinText);
	}

	public boolean isFatTextDisplayed() {
		return isTextDisplayed(fatText);
	}

	public boolean ispreMealTextDisplayed() {
		return isTextDisplayed(preMealText);
	}

	public boolean isMealTimeDisplayed() {

		return isTextDisplayed(timeText);
	}

	public boolean isDinnerTimeDisplayed() {

		return isTextDisplayed(timeText);
	}

	public boolean isPMTimeDisplayed() {
		for (WebElement btn : mealSection) {
			helper.waitForClickableWebElement(btn).click();
			if (btn.getText().equalsIgnoreCase("Snacks")) {
				return timeText.getText().contains("PM");
			}
		}
		return false;
	}

	public boolean isSnackThreeClockDisplayed() {
		for (WebElement btn : mealSection) {
			helper.waitForClickableWebElement(btn).click();
			if (btn.getText().equalsIgnoreCase("Snacks")) {
				return timeText.getText().contains("3:00");
			}
		}
		return false;
	}

	public boolean isCorrectTimeFormatDisplayed() {
		for (WebElement btn : mealSection) {
			helper.waitForClickableWebElement(btn).click();
			LoggerLoad.info(timeText.getText());
			if (TIME_12_HOUR_PATTERN.matcher(timeText.getText()).matches()) {
				return true;
			}

		}
		return false;
	}

	public boolean isDotIndicatorDisplayed() {
		for (WebElement btn : mealSection) {
			helper.waitForClickableWebElement(btn).click();
			if (!dotIndicator.isDisplayed()) {
				return false;
			}
		}
		return true;
	}

	public void viewFullPlan() {
		helper.waitForClickableWebElement(viewFullPlan).click();
	}

	public String getCurrentTitle() {
		return driver.getCurrentUrl();
	}

	public void exerciseClick() {
		helper.waitForClickableWebElement(exercise).click();
	}

	public boolean isTodaysExercisePlanTextDisplayed() {
		todaysExercisePlanText.isDisplayed();
		return true;
	}

	public List<WebElement> getTimeElements() {
		return timePresent;
	}

	public boolean isTimeElementsDisplayed() {
		for (WebElement timeElementPresent : timePresent) {
			if (!timeElementPresent.isDisplayed()) {
				return false;
			}
		}
		return true;
	}

	@FindBy(xpath = "//span[text()='Morning Walk']")
	private WebElement morningWalkTitle;

	@FindBy(xpath = "//span[text()='Yoga Session']")
	private WebElement yogaSessionTitle;

	public boolean isExerciseTitlesDisplayed() {
		return morningWalkTitle.isDisplayed() && yogaSessionTitle.isDisplayed();
	}

	public boolean isMorningExerciseTimeDisplayed() {
		return morningExerciseTime.isDisplayed();
	}

	public boolean isEveningExerciseTimeDisplayed() {
		return eveningExerciseTime.isDisplayed();
	}

	public String morningExercisegetText() {
		return morningWalkTitle.getText();
	}

	public String eveningExercisegetText() {
		return yogaSessionTitle.getText();
	}

	public boolean isMorningExerciseTimeValid() {
		return TIME_12_HOUR_PATTERN.matcher(morningExerciseTime.getText().trim()).matches();
	}

	public boolean isEveningExerciseTimeValid() {
			return TIME_12_HOUR_PATTERN.matcher(eveningExerciseTime.getText().trim()).matches();
	}

	public boolean isAllExerciseTimesValidFormat() {
		return isMorningExerciseTimeValid() && isEveningExerciseTimeValid();
	}

	public boolean isTimeDurationTextDisplayed() {

		return isWebElementsDisplayed(timeDurationText);
	}

	public boolean isWebElementsDisplayed(List<WebElement> elements) {
		for (WebElement element : elements) {
			if (!element.isDisplayed()) {
				return false;
			}
		}
		return true;
	}

	public boolean isTimeDurationFormatDisplayed() {
		for (WebElement element : timeDurationText) {
			String fullText = element.getText().trim();
		
			if (!fullText.contains("•")) {
				return false;
			}

			String[] parts = fullText.split("•");
			String durationPart = parts[0].trim();
			
					if (!TIME_DURATION_FOMAT_PATTERN.matcher(durationPart).matches()) {
					return false;
			}
		}

		return true;
	}

	public boolean isDotDisplayed() {
		for (WebElement element : timeDurationText) {
			String fullText = element.getText().trim();
			
			if (!fullText.contains("•")) {
				return false;
			}
		}
		return true;
	}

	public boolean isIntensityLevel() {
		for (WebElement element : timeDurationText) {
			String fullText = element.getText().trim();
		
			if (!fullText.contains("intensity")) {
					return false;
			}
		}
		return true;
	}

	public String viewFullScheduleGetText() {
		return viewFullSchedule.getText();
	}

	public void viewFullScheduleClick() {
		helper.waitForClickableWebElement(viewFullSchedule).click();
	}
	
	
}