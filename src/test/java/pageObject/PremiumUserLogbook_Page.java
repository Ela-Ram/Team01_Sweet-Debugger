package pageObject;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.Helper;
import common.TestContext;

public class PremiumUserLogbook_Page {
	private WebDriver driver;
	private WebElement element;
	private List<WebElement> elementList;
	private  Helper helperObj;

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
	@FindBy(xpath = "//h2[@class='text-2xl font-semibold mb-6']/..//*[name()='svg']//*[name()='g' and @class='recharts-layer recharts-cartesian-axis recharts-xAxis xAxis']//*[name()='g' and @class='recharts-layer recharts-cartesian-axis-tick']") List<WebElement> glucoseXAxis;
	@FindBy(xpath = "//*[name()='svg']//*[name()='circle' and @class='recharts-dot recharts-line-dot']") List<WebElement> dotChartGlucose;

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
	@FindBy(xpath = "//h2[text()='Meal & Nutrition']/../..//*[name()='svg']//*[name()='g' and @class='recharts-layer recharts-cartesian-axis recharts-xAxis xAxis']//*[name()='g' and @class='recharts-layer recharts-cartesian-axis-tick']") List<WebElement> dailyXAxis;
	@FindBy(xpath = "//h3[text()='Daily Nutrition Breakdown']/..//*[name()='svg']//*[name()='path' and @class='recharts-rectangle']") List<WebElement> dailyNoBar;
	@FindBy(xpath = "//h2[text()='Meal & Nutrition']/../..//*[name()='svg']//*[name()='path' and @class='recharts-sector']") List<WebElement> noPieChart;
	
	//Premium User Logbook - Physical Activity
	@FindBy(xpath = "//h2[text()='Physical Activity']/../..") WebElement activitySection;
	@FindBy(xpath = "//h2[text()='Physical Activity']") WebElement activityTitle;
	@FindBy(xpath = "//*[name()='svg' and @class='lucide lucide-activity mr-2 text-blue-400']") WebElement activityIcon;
	@FindBy(xpath = "//div[text()='Total Calories']") WebElement totalCalories;
	@FindBy(xpath = "//div[text()='Daily Average']") WebElement dailyAvg;
	@FindBy(xpath = "//div[text()='Peak Day']") WebElement peakDay;
	@FindBy(xpath = "//*[name()='svg']//*[name()='tspan' and @x='10']") WebElement caloriesYAxis;
	@FindBy(xpath = "//h2[text()='Physical Activity']/../..//*[name()='svg']//*[name()='g' and @class='recharts-layer recharts-cartesian-axis recharts-xAxis xAxis']//*[name()='g' and @class='recharts-layer recharts-cartesian-axis-tick']") List<WebElement> activityXAxis;
	@FindBy(xpath = "//h2[text()='Physical Activity']/../..//*[name()='svg']//*[name()='path' and @class='recharts-rectangle']") List<WebElement> activityEmptyChart;
	@FindBy(xpath = "//div[text()='Total Calories']/..//div[@class='text-violet-600']") WebElement totalCalValue ;
	@FindBy(xpath = "//div[text()='Daily Average']/..//div[@class='text-amber-600']") WebElement dailyAvgValue ;
	@FindBy(xpath = "//div[text()='Peak Day']/..//div[@class='text-rose-600']") WebElement peakDayValue ;
	
	//Premium User Logbook - Medication Dosage
	@FindBy(xpath = "//h2[text()='Medication Dosage']/../../..") WebElement medicationSection;
	@FindBy(xpath = "//h2[text()='Medication Dosage']") WebElement medicationTitle;
	@FindBy(xpath = "//*[name()='svg' and @class='lucide lucide-pill mr-2 text-red-400']") WebElement medicationIcon;
	@FindBy(xpath = "//h2[text()='Medication Dosage']/../../..//*[name()='svg']//*[name()='tspan' and @x='25']") WebElement numberOfDoses;
	@FindBy(xpath = "//*[name()='svg']//*[name()='path' and @name='Taken']") WebElement dosesTaken;
	@FindBy(xpath = "//*[name()='svg']//*[name()='path' and @name='Missed']") WebElement dosesMissed;
	@FindBy(xpath =  "//div[text()='Total Scheduled']/../div[@class='text-violet-600']") WebElement totalDoseNoVal;
	@FindBy(xpath =  "//div[text()='Doses Taken']/../div[@class='text-emerald-600']") WebElement dosesTakenNoVal;
	@FindBy(xpath =  "//div[text()='Doses Missed']/../div[@class='text-amber-600']") WebElement dosesMissedNoVal;
	@FindBy(xpath =  "//div[text()='Total Scheduled']") WebElement totalSchText;
	@FindBy(xpath =  "//div[text()='Doses Taken']") WebElement dosesTakenText;
	@FindBy(xpath =  "//div[text()='Doses Missed']") WebElement dosesMissedText;
	@FindBy(xpath = "//h2[text()='Medication Dosage']/../../..//*[name()='svg']//*[name()='path' and @class='recharts-rectangle']") List<WebElement> noMedicationData;
	//h2[text()='Medication Dosage']/../../..//*[name()='svg']//*[name()='path' and @class='recharts-rectangle']
	
	//Premium User Logbook - Log Review
	@FindBy(xpath = "//h2[@class='text-2xl font-semibold text-white mb-4']") WebElement logReviewTitle;
	@FindBy(xpath = "//th[text()='Date']") WebElement dateHeader;
	@FindBy(xpath = "//th[text()='Blood Glucose']") WebElement bloodGluHeader;
	@FindBy(xpath = "//th[text()='Nutrition']") WebElement nutritionHeader;
	@FindBy(xpath = "//th[text()='Activity']") WebElement activityHeader;
	@FindBy(xpath = "//th[text()='Medication']") WebElement medicationHeader;
	@FindBy(xpath = "//tr[@class='border-b border-white/10']/td[1]") List<WebElement> dateCol;
	@FindBy(xpath = "//tr[@class='border-b border-white/10']/td[2]") List<WebElement> glucoseCol;
	@FindBy(xpath = "//tr[@class='border-b border-white/10']/td[3]") List<WebElement> nutritionCol;
	@FindBy(xpath = "//tr[@class='border-b border-white/10']/td[4]") List<WebElement> activityCol;
	@FindBy(xpath = "//tr[@class='border-b border-white/10']/td[5]") List<WebElement> medicationCol;
	
	
	public PremiumUserLogbook_Page(TestContext context) {
		this.driver = context.getDriver();
		this.helperObj = context.getHelper();
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
		case "Physical Activity":
			element = activitySection;
			break;
		case "Medication Dosage":
			element = medicationSection;
			break;
		case "Physical Activity Icon":
			element = activityIcon;
			break;
		case "Medication Dosage Icon":
			element = medicationIcon;
			break;
		case "Date":
			element = dateHeader;
			break;
		case "Blood Glucose":
			element = bloodGluHeader;
			break;
		case "Nutrition":
			element = nutritionHeader;
			break;
		case "Activity":
			element = activityHeader;
			break;
		case "Medication":
			element = medicationHeader ;
			break;
		}
		return helperObj.checkElementDisplayed(element);
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
		case "Physical Activity":
			element = activityTitle;
			break;
		case "Medication Dosage":
			element = medicationTitle;
			break;
		case "Log Review":
			element = logReviewTitle;
			break;
		case "Calories":
			element = caloriesYAxis;
			break;
		case "Number of Doses":
			element = numberOfDoses;
			break;
		case "total calories":
			element = totalCalValue;
			break;
		case "daily average":
			element = dailyAvgValue;
			break;
		case "Peak Day":
			element = peakDayValue;
			break;
		case "Total scheduled":
			element = totalDoseNoVal;
			break;
		case "Doses Taken":
			element = dosesTakenNoVal;
			break;
		case "Doses Missed":
			element = dosesMissedNoVal;
			break;
		}
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		helperObj.waitForVisibleElement(element);
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
		case "Total Calories":
			element = totalCalories ;
			break;
		case "Daily Average":
			element = dailyAvg;
			break;
		case "Peak Day":
			element = peakDay;
			break;
		case "Total Sceduled Color":
			element = totalSchText;
			break;
		case "Doses Taken Color":
			element = dosesTakenText;
			break;
		case "Doses Missed Color":
			element = dosesMissedText;
			break;
		}
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		helperObj.waitForVisibleElement(element);
		color = element.getCssValue("color");
		return color;
	}

	public boolean getAlignment() {
		Point p1 = totalCalories.getLocation();
		Point p2 = dailyAvg.getLocation();
		Point p3 = peakDay.getLocation();
		int xCoord1 = p1.getX();
		int xCoord2 = p2.getX();
		int xCoord3 = p3.getX();
		int yCoord1 = p1.getY();
		int yCoord2 = p2.getY();
		int yCoord3 = p3.getY();
		if(xCoord1<xCoord2 && xCoord2<xCoord3 && yCoord1==yCoord2 && yCoord2==yCoord3) {
			return true;
		}
		else return false;
	}

	public String getFillAttribute(String scenario) {
		WebElement element;
		String color= null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		switch (scenario) {
		case "Doses Taken":
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[name()='svg']//*[name()='path' and @name='Taken']")));
			color = element.getAttribute("fill");
			break;
		case "Doses Missed":
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[name()='svg']//*[name()='path' and @name='Missed']")));
			color = element.getAttribute("fill");
			break;
		}
		return color;
	}

	public boolean checkDays() {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMM dd, yyyy");
		for (WebElement eachDateCol : dateCol) {
			String eachDateText = eachDateCol.getText();
			try {
				LocalDate.parse(eachDateText, dateFormat);
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	public boolean checkLastSevenDays() {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMM dd, yyyy");
		int i=0;
		for (WebElement eachDateCol : dateCol) {
			String eachDateText = eachDateCol.getText();
			String lastSevenDays = LocalDate.now().minusDays(i).format(dateFormat);
			if(lastSevenDays.equals(eachDateText)) {
				i++;
			}
			else return false;    
		}
		return true;
	}

	public boolean checkLastSevenDaysXAxis(String scenario) {
		DateTimeFormatter dateFormat = null;
		List<WebElement> element = null;
		switch (scenario) {
		case "Blood Glucose Tracker":
			dateFormat = DateTimeFormatter.ofPattern("MMM dd");
			element = glucoseXAxis;
			break;
		case "Daily Nutrition Breakdown":
			dateFormat = DateTimeFormatter.ofPattern("MMM dd");
			element = dailyXAxis;
			break;
		case "Physical Activity":
			dateFormat = DateTimeFormatter.ofPattern("MMM dd");
			element = activityXAxis;
			break;
		}
		int i=6;
		for (WebElement eachDate : element) {
			String eachDateText = eachDate.getText();
			String lastSevenDays = LocalDate.now().minusDays(i).format(dateFormat);
			if(lastSevenDays.equals(eachDateText)) {
				i--;
			}
			else return false;    
		}
		return true;
	}

	public boolean checkNoElement(String scenario) {
		switch (scenario) {
		case "dailyNoBar":
			elementList = dailyNoBar;
			break;
		case "noPieChart":
			elementList = noPieChart;
			break;
		case "No Activity":
			elementList = activityEmptyChart;
			break;
		case "No Medication":
			elementList = noMedicationData;
			break;
			
		}
		if (elementList.isEmpty()) {
		    return true;
		}
		else return false;
	}
	
	public boolean checkValuesLogReview(String scenario) {
		switch (scenario) {
		case "blood glucose":
			elementList = glucoseCol;
			break;
		case "nutrient":
			elementList = nutritionCol;
			break;
		case "activity":
			elementList = activityCol;
			break;
		case "Medication":
			elementList = medicationCol;
			break;
			
		}
		
		for (WebElement eachCol : elementList) {
			String eachText = eachCol.getText();
			if(!eachText.equals("-")) {
				return false;    
			}
		}
		return true;
	}

}
