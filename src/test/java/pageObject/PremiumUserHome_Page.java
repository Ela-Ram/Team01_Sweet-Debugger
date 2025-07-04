package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.Helper;
import common.TestContext;

public class PremiumUserHome_Page {

	private WebDriver driver;
	private Helper helper;

	public PremiumUserHome_Page(TestContext context) {
		this.driver = context.getDriver();
		this.helper = context.getHelper();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='Home']")
	WebElement home;

	@FindBy(xpath = "//button[text()='🎯 Challenge Yourself Today!']")
	WebElement flashingtab;

	@FindBy(xpath = "//div[contains(@class, 'space-x-8')]/button")
	public List<WebElement> navigationTabs;

	@FindBy(xpath = "//img[contains(@alt, 'character illustration')]")
	WebElement genderImage;

	@FindBy(xpath = "//span[contains(text(),'😐')]")
	WebElement emojiImage;
	@FindBy(xpath = "//div[contains(text(), 'Mood:')]")
	WebElement labelUnderImage;
	@FindBy(xpath = "//button[normalize-space()='Log']")
	WebElement logButton;
	@FindBy(xpath = "//button[normalize-space()='Weekly Plan']")
	WebElement weeklyPlanBtn;
	@FindBy(xpath = "//h2[text()='Record New Data']")
	WebElement recordNewData;

	@FindBy(xpath = "//div[contains(@class, 'grid') and contains(@class, 'grid-cols-2')]/button")
	public List<WebElement> buttonOptionsNewRecordData;

	@FindBy(xpath = "//span[contains(text(),'Blood Glucose')]")
	WebElement bloodGlucose;
	@FindBy(xpath = "//span[contains(text(),'Physical Activity')]")
	WebElement physicalActivity;
	@FindBy(xpath = "//span[contains(text(),'Food Intake')]")
	WebElement foodIntake;
	@FindBy(xpath = "//span[contains(text(),'Medication')]")
	WebElement medication;
	@FindBy(xpath = "//div[@class='space-y-6']/div/h3[text()='Pre-Meal']")
	WebElement preMealText;
	@FindBy(xpath = "//div[contains(@class,'bg-gray-100/60')]/button")
	public List<WebElement> mealSection;
	@FindBy(xpath = "//div[@class='space-y-6']/div/h3/span[text()='⏰']")
	WebElement preMealIcon;
	@FindBy(xpath = "//div[text()='None' and contains(@class, 'text-gray-800') and contains(@class, 'font-medium')]")
	WebElement noneDefaultSnacks;
	@FindBy(xpath = "//button[text()='Snacks']")
	WebElement snacksTab;
	@FindBy(xpath = "(//div[@class='flex items-center text-sm text-gray-500 mt-1 space-x-4']/span)[2]")
	WebElement snacksNoneCalorie;
	@FindBy(xpath = "//div[text()='Handful of almonds (15-20)' and contains(@class, 'text-gray-800') and contains(@class, 'font-medium')]")
	WebElement mealTitleSnackMainMeal;

	public void homeClick() {
		helper.waitForClickableWebElement(home);
	}

	public List<String> getNavigationTab() {
		List<String> actualTabs = new ArrayList<>();
		for (WebElement btn : navigationTabs) {
			System.out.println(btn.getText());
			actualTabs.add(btn.getText().trim());
		}
		return actualTabs;
	}

	public boolean getflashingTabText() {
		return helper.isTextEqual(flashingtab, "🎯 Challenge Yourself Today!");
	}
//	public void isTabFlashing() {
//		 String animationName = flashingtab.getCssValue("animation-name");
//		 System.out.println("Animaltion " + animationName);
//		//return helper.isTextEqual(flashingtab, "🎯 Challenge Yourself Today!");
//	}
	public boolean isAnimationDurationMatched() {
		String actualDuration = flashingtab.getCssValue("animation-duration");
		if (!actualDuration.equalsIgnoreCase("0.2s")) {
			return false;
		}
		return true;
	}
	
	public String getgenderNameText() {
		String imageSrc = genderImage.getAttribute("src");
		System.out.println("Image source: " + imageSrc);
		return imageSrc;
	}

	public boolean isemojiImageDispalyed() {
		return helper.checkElementDisplayed(emojiImage);
	}

	public boolean isLabelUnderImageDispalyed() {
		return helper.checkElementDisplayed(labelUnderImage);
	}

	public boolean isLogButtonDispalyed() {
		return helper.checkElementDisplayed(logButton);
	}

	public boolean isweeklyPlanBtnDispalyed() {
		return helper.checkElementDisplayed(weeklyPlanBtn);
	}

	public boolean isrecordNewDataDispalyed() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", recordNewData);
		return helper.checkElementDisplayed(recordNewData);
	}

	public boolean isbuttonOptionsNewRecordDataDisplayed() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				buttonOptionsNewRecordData.get(0));
		List<String> allDropdownOptionsText = helper.getTexts(buttonOptionsNewRecordData);
		for (String option : allDropdownOptionsText) {
			String text = option.trim();
			System.out.println(text);
			if (!text.equalsIgnoreCase("Blood Glucose") && !text.equalsIgnoreCase("Physical Activity")
					&& !text.equalsIgnoreCase("Food Intake") && !text.equalsIgnoreCase("Medication"))
				return false;
		}
		return true;
	}

	public boolean isBloodGlucoseDisplayed() {
		return helper.checkElementDisplayed(bloodGlucose);
	}

	public boolean isphysicalActivityDisplayed() {
		return helper.checkElementDisplayed(physicalActivity);
	}

	public boolean isFoodIntakeDisplayed() {
		return helper.checkElementDisplayed(foodIntake);
	}

	public boolean isMedicationDisplayed() {
		return helper.checkElementDisplayed(medication);
	}

	public void preMealClick() {
		helper.waitForClickableWebElement(preMealText).click();
	}

	public boolean isPreMealTextDisplayed() {
		for (WebElement btn : mealSection) {
			helper.waitForClickableWebElement(btn).click();
			if (!preMealText.isDisplayed())
				return false;
		}
		return true;
	}

	public boolean ispreMealIconDisplayed() {
		for (WebElement btn : mealSection) {
			helper.waitForClickableWebElement(btn).click();
			if (!preMealIcon.isDisplayed())
				return false;
		}
		return true;
	}

	public void snacksTabClick() {
		helper.waitForClickableWebElement(snacksTab).click();
	}

	public boolean isNoneTextDefaultSnacksDisplayed() {
		return helper.checkElementDisplayed(noneDefaultSnacks);
	}

	public boolean isSnacksNoneCalorieDisplayed() {
		return helper.checkElementDisplayed(snacksNoneCalorie);
	}

	public boolean isMealTitleSnackMainMealDisplayed() {
		return helper.checkElementDisplayed(mealTitleSnackMainMeal);
	}

}
