package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.TestContext;

public class PremiumUserLogbook_Page {
	private WebDriver driver;
	private WebElement element;
	private  PremiumUserExercise_Page exercisePageObj;
	
	@FindBy(xpath = "//button[text()='Logbook']") WebElement logBookBtn;
	
	//Premium User Logbook - Blood Glucose Tracker
	@FindBy(xpath = "//h2[@class='text-2xl font-semibold mb-6']/..") WebElement bloodGlucoseSection;
	@FindBy(xpath = "//h2[@class='text-2xl font-semibold mb-6']") WebElement bloodGlucoseTitle;
	@FindBy(xpath = "//div[text()='Fasting']") WebElement fasting;
	@FindBy(xpath = "//div[text()='Pre-Meal']") WebElement preMeal;
	@FindBy(xpath = "//div[text()='Post-Meal']") WebElement postMeal;
	@FindBy(xpath = "//div[text()='Bedtime']") WebElement bedtime;
	@FindBy(xpath = "//div[text()='Fasting']/../div[@class='text-violet-600']") WebElement fastingRange;
	@FindBy(xpath = "//div[text()='Pre-Meal']/../div[@class='text-emerald-600']") WebElement preMealRange;
	@FindBy(xpath = "//div[text()='Post-Meal']/../div[@class='text-amber-600']") WebElement postMealRange;
	@FindBy(xpath = "//div[text()='Bedtime']/../div[@class='text-rose-600']") WebElement bedtimeRange;
	@FindBy(xpath = "//*[name()='svg']//*[name()='text' and @y='309']") WebElement yAxisMin;
	@FindBy(xpath = "//h2[@class='text-2xl font-semibold mb-6']/..//*[name()='svg']//*[name()='text' and @y='12']") WebElement yAxisMax;
	
	//Premium User Logbook - Meal & Nutrition
	@FindBy(xpath = "//h2[text()='Meal & Nutrition']/../..") WebElement mealSection;
	@FindBy(xpath = "//h2[text()='Meal & Nutrition']") WebElement mealTitle;
	@FindBy(xpath = "//*[name()='svg' and @class='lucide lucide-cooking-pot mr-2 text-green-400']") WebElement mealIcon;
	@FindBy(xpath = "//h3[text()='7-Day Aggregate Nutrition']/..") WebElement sevenDaySection;
	@FindBy(xpath = "//h3[text()='Daily Nutrition Breakdown']/..") WebElement dailySection;
	@FindBy(xpath = "//h3[text()='7-Day Aggregate Nutrition']/..//span[text()='Carbs']") WebElement carbs;
	@FindBy(xpath = "//h3[text()='7-Day Aggregate Nutrition']/..//span[text()='Protein']") WebElement protein;
	@FindBy(xpath = "//h3[text()='7-Day Aggregate Nutrition']/..//span[text()='Fats']") WebElement fats;
	@FindBy(xpath = "//h3[text()='Daily Nutrition Breakdown']/..//*[name()='svg']//*[name()='g' and @class='recharts-layer recharts-bar']") WebElement bar;
	@FindBy(xpath = "//*[name()='svg']//*[name()='g' and @class='recharts-layer recharts-pie-sector']") WebElement pieChart;
	@FindBy(xpath = "//span[text()='Carbs']/../..//*[@class='mt-1 text-gray-600']") WebElement carbsCard;
	@FindBy(xpath = "//span[text()='Protein']/../..//*[@class='mt-1 text-gray-600']") WebElement proteinCard;
	@FindBy(xpath = "//span[text()='Fats']/../..//*[@class='mt-1 text-gray-600']") WebElement fatsCard;
	
	
	public PremiumUserLogbook_Page(TestContext context) {
		this.driver = context.getDriver();
		this.exercisePageObj = context.getPremiumUserEx_page();
		PageFactory.initElements(driver, this);
	}
	
	public void clickLogBookBtn() {
		logBookBtn.click();	
	}
	
	public boolean isElementDisplayed(String scenario) {
		switch (scenario) {
		case "Blood Glucose Tracker":
			element = bloodGlucoseSection;
			break;
		case "Meal & Nutrition":
			element = mealSection;
			break;
		case "Meal Icon":
			element = mealIcon;
			break;
		case "7-Day Aggregate Nutrition":
			element = sevenDaySection;
			break;
		case "Daily Nutrition breakdown":
			element = dailySection;
			break;
		case "Bar":
			element = bar;
			break;
		case "Pie":
			element = pieChart;
			break;
		}
		return exercisePageObj.checkElementDisplayed(element);
	}
	
	public String getText(String scenario) {
		String text = null;
		switch (scenario) {
		case "Blood Glucose Tracker":
			element = bloodGlucoseTitle;
			break;
		case "Meal & Nutrition":
			element = mealTitle;
			break;
		case "Fasting":
			element = fastingRange;
			break;
		case "Pre-Meal":
			element = preMealRange;
			break;
		case "Post-Meal":
			element = postMealRange;
			break;
		case "Bedtime":
			element = bedtimeRange;
			break;
		case "yAxisMin":
			element = yAxisMin;
			break;
		case "yAxisMax":
			element = yAxisMax;
			break;
		case "CarbsCard":
			element = carbsCard;
			break;
		case "ProteinCard":
			element = proteinCard;
			break;
		case "FatsCard":
			element = fatsCard;
			break;
		}
		
		text = element.getText();
		return text;
	}
	
	public String getColor(String scenario) {
		String color = null;
		switch (scenario) {
		case "Fasting":
			element = fasting;
			break;
		case "Pre-Meal":
			element = preMeal;
			break;
		case "Post-Meal":
			element = postMeal;
			break;
		case "Bedtime":
			element = bedtime;
			break;
		case "Carbs":
			element = carbs;
			break;
		case "Protein":
			element = protein;
			break;
		case "Fats":
			element = fats;
			break;
		}
		color = element.getCssValue("color");
		return color;
	}
	
}
