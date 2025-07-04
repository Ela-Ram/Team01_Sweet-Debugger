package pageObject;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.ConfigReader;
import common.ExcelReader;
import common.TestContext;
import io.cucumber.java.en.When;

public class CommomHomePageFeature_Page {

	private WebDriver driver;
	// private Helper helper;
	LaunchPage_Page launch_pageObj;
	DiabetesRiskAnalyzer_Page diaRiskAnalyzerPageObj;

	public CommomHomePageFeature_Page(TestContext context) {
		this.driver = context.getDriver();
		// this.helper = context.getHelper();
		PageFactory.initElements(driver, this);
		this.launch_pageObj = context.getLaunch_PageObj();
		this.diaRiskAnalyzerPageObj = context.getDiaRiskAnalyzerPageObj();
	}

	@FindBy(xpath = "//button[contains(text(), 'Create Account')]")
	WebElement CreateAccountButton;
	@FindBy(xpath = "//input[@id=':r6:-form-item']")
	WebElement emailField;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordField;
	@FindBy(name = "password")
	WebElement enterPasswordOnAuthPAge;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement continueWithEmailButton;
	@FindBy(xpath = "//input[@id=':rd:-form-item']")
	WebElement firstNameField;
	@FindBy(xpath = "//div/input[@id=':rd:-form-item']")
	WebElement fullNameField;
	@FindBy(xpath = "//div/input[@id=':re:-form-item']")
	WebElement userNameField;
	@FindBy(xpath = "//button[@id='terms']")
	WebElement checkPrivacyPolicy;
	@FindBy(xpath = "//button[contains(text(),'Sign in')]")
	WebElement SignInbutton;
	@FindBy(xpath = "//div/span[contains(text(), 'SweetBalance')]")
	WebElement appNameOnHomePage;
	@FindBy(xpath = "//div[@class='flex items-center space-x-4']/span[contains(text(),'SweetDebugger')]")
	WebElement userNameOnHomePage;
	@FindBy(xpath = "//button[contains(text(),'Logout')]")
	WebElement logoutButton;
	@FindBy(xpath = "//div[@class='max-w-7xl mx-auto px-4']")
	WebElement topNavBar;
	@FindBy(xpath = "//button[contains(text(),'Home')]")
	WebElement HomeTab;
	@FindBy(xpath = "//button[contains(text(),'Dashboard')]")
	WebElement DashboardTab;
	@FindBy(xpath = "//button[contains(text(),'Education')]")
	WebElement EducationTab;
	@FindBy(xpath = "//button[contains(text(),'Education')]")
	WebElement latestHba1cLabel;
	@FindBy(xpath = "//span[@class='text-3xl font-bold text-gradient bg-clip-text text-transparent bg-gradient-to-r from-violet-600 to-fuchsia-600']")
	WebElement latestHba1cValue;
	@FindBy(xpath = "//span[@class='text-3xl font-bold text-gradient bg-clip-text text-transparent bg-gradient-to-r from-indigo-600 to-purple-600']")
	WebElement BMIValue;
	@FindBy(xpath = "//span[@class='text-3xl font-bold text-gradient bg-clip-text text-transparent bg-gradient-to-r from-indigo-600 to-purple-600']")
	WebElement AvgBloodSugarValue;
	@FindBy(xpath = "//div[@class='text-sm font-bold text-rose-500']")
	WebElement AvgBloodSugarUnit;
	@FindBy(xpath = "//div[@class='flex-1 p-6']")
	WebElement todayMealPlanSection;
	@FindBy(xpath = "//button[contains(text(),'Breakfast')]")
	WebElement breakfastTab;
	@FindBy(xpath = "//div[@class='flex flex-col space-y-2 p-4']")
	WebElement sideTab;
	@FindBy(xpath = "//button[contains(text(),'View Full Meal Plan')]")
	WebElement viewFullMealPlanButton;
	@FindBy(xpath = "//button[contains(text(),'Lunch')]")
	WebElement lunchTab;
	@FindBy(xpath = "//button[contains(text(),'Dinner')]")
	WebElement dinnerTab;
	@FindBy(xpath = "//button[contains(text(),'Snacks')]")
	WebElement snacksTab;
	@FindBy(xpath = "//div[@class='text-gray-800 font-medium']")
	WebElement dishTitle;
	@FindBy(xpath = "//h3[contains(text(),'Pre-Meal')]")
	WebElement preMeal;
	@FindBy(xpath = "//div/span[contains(text(),'AM')]")
	WebElement breakfastTime;
	@FindBy(xpath = "//div/span[contains(text(),'PM')]")
	WebElement lunchTime;
	@FindBy(xpath = "//div/span[contains(text(),'PM')]")
	WebElement dinnerTime;

	public void verifyTimeIndicator_Breakfast(String breakfastIndicator) {
		String text = breakfastTime.getText().trim();
		Assert.assertTrue("expected text not found", text.contains(breakfastIndicator));
		System.out.println("expected text found" + text);
	}

	public void verifyTimeIndicator_lunch(String lunchIndicator) {
		lunchTab.click();
		String text = lunchTime.getText().trim();
		Assert.assertTrue("expected text not found", text.contains(lunchIndicator));
		System.out.println("expected text found" + text);
	}

	public void verifyTimeIndicator_dinner(String dinnerIndicator) {
		dinnerTab.click();
		String text = dinnerTime.getText().trim();
		Assert.assertTrue("expected text not found", text.contains(dinnerIndicator));
		System.out.println("expected text found" + text);
	}

	public void isdishTitleVisible() {
		Assert.assertTrue("Dish Title missing", dishTitle != null);
		String expected = dishTitle.getText();
		System.out.println("Dish Title: " + expected);
		System.out.println("Passed: Dish Title is visible");
	}

	public void clicksnacksTab() {
		snacksTab.click();
	}

	public void clickDinnerTab() {
		dinnerTab.click();
	}

	public void clickBreakFastButton() {
		breakfastTab.click();
	}

	public void clickLunchButton() {
		lunchTab.click();
	}

	public void isSnacksTabVisible() {
		boolean expected = snacksTab.isDisplayed();
		Assert.assertEquals(expected, true);
		System.out.println("Passed: Snacks tab is visibale and active");
	}

	public void isDinnerTabVisible() {
		boolean expected = dinnerTab.isDisplayed();
		Assert.assertEquals(expected, true);
		System.out.println("Passed: Dinner tab is visibale and active");
	}

	public void isLunchTabVisible() {
		boolean expected = lunchTab.isDisplayed();
		Assert.assertEquals(expected, true);
		System.out.println("Passed: Lunch tab is visibale and active");
	}

	public void isViewFullMealPalnBtnPresent() {
		boolean expected = viewFullMealPlanButton.isDisplayed();
		Assert.assertEquals(expected, true);
		System.out.println("Passed: Full Meal Plan button is present");
	}

	public void isMealPlanoptionPresent(String mealPlan) {
		String pageSource = driver.getPageSource();
		boolean expected = pageSource.contains(mealPlan);
		Assert.assertEquals(expected, true);
		System.out.println("PAssed: " + mealPlan + " title dispalyed");
	}

	public void isExerciseOptionPresent(String exercise) {
		String pageSource = driver.getPageSource();
		boolean expected = pageSource.contains(exercise);
		Assert.assertEquals(expected, true);
		System.out.println("PAssed: " + exercise + " title dispalyed");
	}

	public void presenceOfSidetab() {
		boolean expected = sideTab.isDisplayed();
		Assert.assertEquals(expected, true);
		System.out.println("Passed: Side tab is present");
	}

	public void isBreakfastTabVisibleByDefault(String breakfast) {
		String expected = breakfastTab.getText();
		Assert.assertEquals(expected, breakfast);
		System.out.println("Passed: Breakfast tab is visibale and active");
	}

	public void isPreMealPresentInAllMeals() {
		String[] mealTabs = { "Breakfast", "Lunch", "Dinner", "Snacks" };

		for (String tab : mealTabs) {
			try {
				WebElement tabElement = driver.findElement(By.xpath("//button[normalize-space()='" + tab + "']"));
				tabElement.click();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
				wait.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Pre-Meal')]")));
				List<WebElement> preMealItems = driver.findElements(By.xpath("//h3[contains(text(),'Pre-Meal')]"));
				Assert.assertFalse("Pre-meal item not found in " + tab + " tab", preMealItems.isEmpty());
				System.out.println("Pre-meal item is present in " + tab + " tab.");
			} catch (Exception e) {
				System.err.println("Error in tab: " + tab + " -" + e.getMessage());
				Assert.fail("Exception while verifying Pre-meal in tab: " + tab);
			}
		}
	}

	public void isBreakfastTabPresent() {
		String expected = breakfastTab.getText();
		Assert.assertEquals(expected, "Breakfast");
		System.out.println("Passed: Breakfast tab is visibale and active");
	}

	public void verifyTitleTodaysMealPlan(String todayMealPlanTitle) {
		String pageSource = driver.getPageSource();
		boolean expected = pageSource.contains(todayMealPlanTitle);
		Assert.assertEquals(expected, true);
		System.out.println("PAssed: " + todayMealPlanTitle + " title dispalyed");
	}

	public void verifyAvgBldSugarUnit() {
		String AvgBloodSugar = AvgBloodSugarUnit.getText();
		Assert.assertEquals("mg/dL", AvgBloodSugar);
		System.out.println("AvgBloodSugar unit value: " + AvgBloodSugar);
	}

	public void isAvgBldSugarValueDisplayed() {
		WebElement field = AvgBloodSugarValue;
		String expected = field.getText();
		Assert.assertTrue(" AvgBloodSugar Value is empty or has no visible value!",
				expected != null && !expected.trim().isEmpty());
		System.out.println("AvgBloodSugar displays value: " + expected);

	}

	public void isBMIValueDisplayed() {
		WebElement field = BMIValue;
		String expected = field.getText();
		Assert.assertTrue(" BMI Value is empty or has no visible value!",
				expected != null && !expected.trim().isEmpty());
		System.out.println("BMI displays value: " + expected);

	}

	public void isLastestHbA1cValueDisplayed() {
		WebElement field = latestHba1cValue;
		String expected = field.getText();
		Assert.assertTrue(" HbA1c Value is empty or has no visible value!",
				expected != null && !expected.trim().isEmpty());
		System.out.println("HbA1c displays value: " + expected);
	}

	public void isLastestHbA1cLAbelDispalyed(String latestHbA1cLabel) {
		String pageSource = driver.getPageSource();
		Assert.assertTrue("Tab not found!", pageSource.contains(latestHbA1cLabel));
		System.out.println("Passed: " + latestHbA1cLabel + " Label is Present");
	}

	public void isBMILAbelDispalyed(String BMI) {
		String pageSource = driver.getPageSource();
		Assert.assertTrue("Tab not found!", pageSource.contains(BMI));
		System.out.println("Passed: " + BMI + " Label is Present");
	}

	public void isAvgBldSugarDispalyed(String AvgBldSugarLabel) {
		String pageSource = driver.getPageSource();
		Assert.assertTrue("Tab not found!", pageSource.contains(AvgBldSugarLabel));
		System.out.println("Passed: " + AvgBldSugarLabel + " Label is Present");
	}

	public void lastUpdateTimeFormatDispalyed() {
		String pageSource = driver.getPageSource();

		Pattern pattern = Pattern.compile("Last updated:\\s*(\\d{1,2}:\\d{2}:\\d{2}\\s?(AM|PM))");
		Matcher matcher = pattern.matcher(pageSource);

		if (matcher.find()) {
			String time = matcher.group(1);
			System.out.println("Last updated time found: " + time);
		} else {
			Assert.fail("Last updated time in format 'hh:mm:ss AM/PM' not found.");
		}

	}

	public void isCurrentstatusSectionDispalyed(String currentStatusSection) {
		String pageSource = driver.getPageSource();
		Assert.assertTrue("Tab not found!", pageSource.contains(currentStatusSection));
		System.out.println("Passed: Current Status Text is Present");
	}

	public void isLastUpdatedTextDispalyed(String lastUpdatedText) {
		String pageSource = driver.getPageSource();
		Assert.assertTrue("Tab not found!", pageSource.contains(lastUpdatedText));
		System.out.println("Passed: Last Updated Text is Present");
	}

	public void istopNAvigationBarPresent() {
		boolean expected = topNavBar.isDisplayed();
		Assert.assertEquals(expected, true);
		System.out.println("Passed: Top Navigation Bar is present");
	}

	public void ishomeTabPresent(String homeTab) {
		String pageSource = driver.getPageSource();
		Assert.assertTrue("Tab not found!", pageSource.contains(homeTab));
		System.out.println("Passed: Home Tab is present");
	}

	public void isDashboardTabPresent(String dashboardTab) {
		String pageSource = driver.getPageSource();
		Assert.assertTrue("Tab not found!", pageSource.contains(dashboardTab));
		System.out.println("Passed: Dashboard Tab is present");
	}

	public void isEducationTabPresent(String educationTab) {
		String pageSource = driver.getPageSource();
		Assert.assertTrue("Tab not found!", pageSource.contains(educationTab));
		System.out.println("Passed: Education Tab is present");
	}

	public boolean isLogOutButtonDisplayed() {
		return logoutButton.isDisplayed();

	}

	public void isUserNamedisplayedonHomePage(String launch, String launch_04) {
		Map<String, String> testData = ExcelReader.getTestData(launch, launch_04);
		String expectedUserName = testData.get("Fullname");
		String actual = userNameOnHomePage.getText().trim();
		Assert.assertEquals("Logged in user ID mismatch", expectedUserName, actual);
		System.out.println("Passed: Correct user ID " + expectedUserName + "is displayed on the home page");

	}

	public void ClickCreateAccountButton() {
		CreateAccountButton.click();
	}

	public void clickSignInbutton() {
		SignInbutton.click();

	}

	public void enterEmail(String email) {
		emailField.sendKeys(email);
	}

	public void enterpassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickContinueWithEmailButton() {
		continueWithEmailButton.click();
	}

	public void clickTermsCond() {
		checkPrivacyPolicy.click();
	}

	public void enterEmailID(String launch, String launch_02) {
		Map<String, String> testData = ExcelReader.getTestData(launch, launch_02);
		String email = testData.get("Email");
		enterEmail(email);
		clickContinueWithEmailButton();
	}

	public void enterpassword() {
		String password = ConfigReader.getProperty("password");
		enterpassword(password);
		System.out.println("**** user entered passsword" + password);
	}

	public void enterAllFieldstoCompleteForm(String fullname, String username, String password) {
		fullNameField.sendKeys(fullname);
		userNameField.sendKeys(username);
		passwordField.sendKeys(password);
	}

	public boolean isPasswordFieldvisible() {
		return passwordField.isDisplayed();
	}

	public void isPAsswordAuthPageOpened() {
		passwordField.click();
		boolean actual = passwordField.isDisplayed();
		Assert.assertEquals(actual, true);
		System.out.println("Passed: User on password auth page");

	}

	public void appNameonHomePage(String appNameonHomePage) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(appNameOnHomePage));
		String pageSource = driver.getPageSource();
		boolean actual = pageSource.contains(appNameonHomePage);
		driver.navigate().refresh();
		Assert.assertEquals(actual, true);
		System.out.println("Passed: " + appNameonHomePage + " is dispalyed");
	}

	public void waitTillHomePageloads() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(appNameOnHomePage));
	}

}
