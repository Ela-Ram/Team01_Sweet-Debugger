package pageObject;

import org.openqa.selenium.WebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import common.Helper;
import common.TestContext;

public class Launch_PageObj {

	private WebDriver driver;
	private Helper helper;

	@FindBy(xpath = "//div[@class='text-white text-2xl font-bold']")
	WebElement appName;
	@FindBy(xpath = "//div[@class='w-full bg-blue-100 px-4 py-2 text-center text-sm text-blue-800']")
	WebElement policy_details;
	@FindBy(xpath = "//div/h1[contains(text(),'Smart Diabetes Tracking ')]")
	WebElement app_heading;
	@FindBy(xpath = "//div/button[contains(text(),'Start Today')]")
	WebElement startTodayButton;
	@FindBy(xpath = "//*[name()='svg' and contains(@class, 'heart')]")
	WebElement heartIcon;
	@FindBy(xpath = "//*[name()='svg' and contains(@class, 'lucide-square-activity')]")
	WebElement activityIcon;
	@FindBy(xpath = "//*[name()='svg' and contains(@class, 'lucide-clock')]")
	WebElement clockIcon;

	public Launch_PageObj(TestContext context) {
		this.driver = context.getDriver();
		this.helper = context.getHelper();
		PageFactory.initElements(driver, this);
	}

	public boolean get_appName() // in Boolean - verify if field is available or not
	{
		return appName.isDisplayed();

	}

	public String get_AppName() // get name by string
	{
		return appName.getText();
	}

	public boolean policyDetails() {
		return policy_details.isDisplayed();
	}

	public boolean getAppHeading() {
		return app_heading.isDisplayed();
	}

	public boolean isStartTodaybuttondispalyed() {
		return startTodayButton.isDisplayed();
	}

	public boolean isDiabetesToolsHeadingDisplayed(String diaToolsHeading) {
		WebElement diabetesToolsHeading = driver.findElement(By.xpath("//div/h2[text()='" + diaToolsHeading + "']"));

		return diabetesToolsHeading.isDisplayed();
	}

	public boolean ishealthTrackingCardDisplayed(String healthTrackingCard) {
		WebElement healthtrackcard = driver.findElement(By.xpath("//div/h3[text()='" + healthTrackingCard + "']"));

		return healthtrackcard.isDisplayed();
	}

	public boolean isNutritionCardDisplayed(String NutriCard) {
		WebElement nutitioncard = driver.findElement(By.xpath("//div/h3[text()='" + NutriCard + "']"));

		return nutitioncard.isDisplayed();
	}

	public boolean isSmartCardDisplayed(String smartCard) {
		WebElement smartInsightcard = driver.findElement(By.xpath("//div/h3[text()='" + smartCard + "']"));

		return smartInsightcard.isDisplayed();
	}

	public void isHealthCardInfoDisplayed() // passing values though x-path itself
	{

		List<WebElement> paragraphList = (List<WebElement>) driver.findElements(By.xpath(
				"//p[text()='Easy logging of daily readings' or text()='Visualize trends over time' or text()='Set personalized targets']"));

		for (WebElement element : paragraphList) {
			String text = element.getText();
			System.out.println("Verifying paragraph: " + text);
			Assert.assertTrue(element.isDisplayed());
		}
	}

	public void isNutritionInfoDisplayed(String commaSeparatedText) // passing comma seperated values through gherkin
	{
		String[] expectedTexts = commaSeparatedText.split(",");

		for (String expected : expectedTexts) {
			String cleanExpected = expected.trim();
			System.out.println("Checking: " + cleanExpected);

			List<WebElement> matchingElements = driver.findElements(
					By.xpath("//div[@class='p-6 pt-0 space-y-2']//p[contains(text(),'" + cleanExpected + "')]"));

			Assert.assertTrue(!matchingElements.isEmpty());
		}

	}

	public void isSmartInsightsInfoDisplayed(String commaSeparatedText) // passing comma seperated values through
																		// gherkin
	{
		String[] expectedTexts = commaSeparatedText.split(",");

		for (String expected : expectedTexts) {
			String cleanExpected = expected.trim();
			System.out.println("Checking: " + cleanExpected);

			List<WebElement> matchingElements = driver.findElements(
					By.xpath("//div[@class='p-6 pt-0 space-y-2']//p[contains(text(),'" + cleanExpected + "')]"));

			Assert.assertTrue(!matchingElements.isEmpty());
		}

	}

	public void isHeartIconDisplayed() {
		boolean icon = heartIcon.isDisplayed();

		Assert.assertTrue(icon, "Icon not displayed");
		System.out.println(" Passed: Icon is visible.");

	}

	public void isActivityIconDisplayed() {
		boolean icon = activityIcon.isDisplayed();

		Assert.assertTrue(icon, "Icon not displayed");
		System.out.println(" Passed: Icon is visible.");

	}

	public void isClockIconDisplayed() {
		boolean icon = clockIcon.isDisplayed();

		Assert.assertTrue(icon, "Icon not displayed");
		System.out.println(" Passed: Icon is visible.");

	}

	public void isJamesDTestimonialDispalyed(String JamesD) {
		WebElement JamesTestimonial = driver.findElement(By.xpath("//div[@class='ml-3']/p[text()='" + JamesD + "']"));
		boolean actual = JamesTestimonial.isDisplayed();

		Assert.assertEquals(actual, true);
		System.out.println(" Passed: Testimonial of " + JamesD + " is visible.");

	}

	public void isMariaLTestimonialDispalyed(String MariaL) {
		WebElement MariaTestimonial = driver.findElement(By.xpath("//div[@class='ml-3']/p[text()='" + MariaL + "']"));
		boolean actual = MariaTestimonial.isDisplayed();

		Assert.assertEquals(actual, true);
		System.out.println(" Passed: Testimonial of " + MariaL + " is visible.");

	}

	public void isRobertTTestimonialDispalyed(String RobertT) {
		WebElement RobertTestimonial = driver.findElement(By.xpath("//div[@class='ml-3']/p[text()='" + RobertT + "']"));
		boolean actual = RobertTestimonial.isDisplayed();

		Assert.assertEquals(actual, true);
		System.out.println(" Passed: Testimonial of " + RobertT + " is visible.");

	}

	public void isCommunitySectionHeadingDispalyed(String communityHeading)

	{
		WebElement communitymsg = driver.findElement(
				By.xpath("//div[@class='flex justify-center gap-1 mb-4']/../p[text()='" + communityHeading + "']"));
		boolean actual = communitymsg.isDisplayed();

		Assert.assertEquals(actual, true);
		System.out.println(" Passed: " + communityHeading + " is visible.");

	}

	public void starsForCommunitySection(int expectednoOfStars) {
		List<WebElement> starforCommunitySection = (List<WebElement>) driver
				.findElements(By.xpath("//div[@class='flex justify-center gap-1 mb-4']/*[name()='svg']"));
		int actualstarcount = starforCommunitySection.size();
		System.out.println("Found " + actualstarcount + " star icons above Community Section.");
		Assert.assertEquals(expectednoOfStars, actualstarcount);
	}

	public void verifyExpectedRatingJamesD(Integer expectedRatingJamesD) {
		List<WebElement> RatingJamesD = driver.findElements(
				By.xpath("//div[@class='ml-3']/p[text()='James D.']/../div[@class='flex']/*[name()='svg']"));
		int actualRatingCount = RatingJamesD.size();
		System.out.println("Found " + actualRatingCount + " star icons for JamesD.");

		Assert.assertEquals(expectedRatingJamesD, actualRatingCount);
		System.out.println("Passed: Rating is as expected for JamesD.");

	}

	public void verifyExpectedRatingMariaL(Integer expectedRatingMariaL) {
		List<WebElement> RatingMaria = driver.findElements(
				By.xpath("//div[@class='ml-3']/p[text()='Maria L.']/../div[@class='flex']/*[name()='svg']"));
		int actualRatingCount = RatingMaria.size();
		System.out.println("Found " + actualRatingCount + " star icons for MariaL.");

		Assert.assertEquals(expectedRatingMariaL, actualRatingCount);
		System.out.println("Passed: Rating is as expected for MariaL.");

	}

	public void verifyExpectedRatingRobert(Integer expectedRatingRobertT) {
		List<WebElement> RatingRobert = driver.findElements(
				By.xpath("//div[@class='ml-3']/p[text()='Robert T.']/../div[@class='flex']/*[name()='svg']"));
		int actualRatingCount = RatingRobert.size();
		System.out.println("Found " + actualRatingCount + " star icons for RobertT.");

		Assert.assertEquals(expectedRatingRobertT, actualRatingCount);
		System.out.println("Passed: Rating is as expected for RobertT.");

	}

	public void verifyBottomSectionHeading(String BottomSectionHeading) {

		WebElement bottomsectionHeading = driver
				.findElement(By.xpath("//div[@class='max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 text-center']/h2[text()='"
						+ BottomSectionHeading + "']"));
		boolean actualheading = bottomsectionHeading.isDisplayed();
		Assert.assertEquals(actualheading, true);
		Reporter.log("Passed: Bottom section heading is dispalyed");
	}

	public void isCheckYourRiskbtnPresent(String checkYrRiskBtn) {
		WebElement Button = driver.findElement(
				By.xpath("//../div[@class='flex flex-col sm:flex-row gap-4 justify-center']/button[contains (text(), '"
						+ checkYrRiskBtn + "')]"));
		boolean actualbutton = Button.isDisplayed();
		Assert.assertEquals(actualbutton, true);
		System.out.println(Button + " button is present");
	}

}
