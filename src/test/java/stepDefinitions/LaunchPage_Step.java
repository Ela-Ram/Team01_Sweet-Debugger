package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import common.TestContext;
import io.cucumber.java.en.*;
import pageObject.LaunchPage_Page;

public class LaunchPage_Step {

	private TestContext context;
	LaunchPage_Page launchPageObj;

	public LaunchPage_Step(TestContext context) {
		this.context = context;
		this.launchPageObj = context.getLaunch_PageObj();
	}

	@Given("User launches the browser")
	public void user_launches_the_browser() {

	}

	@When("User enters the SweetBalance url")
	public void user_enters_the_sweet_balance_url() {

	}

	@Then("User should see SweetBalance")
	public void user_should_see_sweet_balance() {
		String actual = launchPageObj.get_AppName();
		Assert.assertEquals(actual, "SweetBalance");
		System.out.println("The Application name is:" + actual);
	}

	@Then("User should see Our Terms of Service and Privacy Policy have recently been updated")
	public void user_should_see_our_terms_of_service_and_privacy_policy_have_recently_been_updated() {
		boolean actual = launchPageObj.policyDetails();
		Assert.assertEquals(actual, true);

	}

	@Then("User should see Smart Diabetes Tracking Powered by AI")
	public void user_should_see_smart_diabetes_tracking_powered_by_ai() {

		boolean actual = launchPageObj.getAppHeading();
		Assert.assertEquals(actual, true);
	}

	@Then("User should see User should see a Start Today input button")
	public void user_should_see_user_should_see_a_input_button() {

		boolean actual = launchPageObj.isStartTodaybuttondispalyed();
		Assert.assertEquals(actual, true);

	}

	@Then("User should see User should see the text {string}")
	public void user_should_see_user_should_see_text(String diaToolsHeading) {
		boolean heading = launchPageObj.isDiabetesToolsHeadingDisplayed(diaToolsHeading);
		Assert.assertEquals(heading, true);
		System.out.println("****** " + diaToolsHeading + " ****** Heading is present");

	}

	@Then("User should see User should see a first card with title {string}")
	public void user_should_see_user_should_see_a_card_with_title(String healthTrackingCard) {
		boolean card1 = launchPageObj.ishealthTrackingCardDisplayed(healthTrackingCard);
		Assert.assertEquals(card1, true);
		System.out.println("****** " + healthTrackingCard + " ****** first Card is present");

	}

	@Then("User should see User should see a second card with title {string}")
	public void user_should_see_user_should_see_a_second_card_with_title(String NutriCard) {
		boolean card1 = launchPageObj.isNutritionCardDisplayed(NutriCard);
		Assert.assertEquals(card1, true);
		System.out.println("****** " + NutriCard + " ****** second Card is present");
	}

	@Then("User should see User should see a third card with title {string}")
	public void user_should_see_user_should_see_a_third_card_with_title(String SamrtCard) {
		boolean card2 = launchPageObj.isSmartCardDisplayed(SamrtCard);
		Assert.assertEquals(card2, true);
		System.out.println("****** " + SamrtCard + " ****** third Card is present");
	}

//	@Then("User should see User should see the text {string}")
//	public void user_should_see_user_should_see_text1(String HealthTrackingInfo) {
//	    
//	    
//	}

//	@Then("User should see User should see the text ")
//	public void user_should_see_user_should_see_text1() {
//		
//		launchPageObj.isHealthCardInfoDisplayed();
//	    
//	}

	@Then("User should see User should see text1 Monitor glucose levels, medication, and vital statistics, Easy logging of daily readings,Visualize trends over time,Set personalized targets")
	public void user_should_see_user_should_see_text1_monitor_glucose_levels_medication_and_vital_statistics_easy_logging_of_daily_readings_visualize_trends_over_time_set_personalized_targets() {
		launchPageObj.isHealthCardInfoDisplayed();
	}

	@Then("User should see User should see the text  {string}")
	public void user_should_see_user_should_see_the_text(String commaSeparatedText) {
		launchPageObj.isNutritionInfoDisplayed(commaSeparatedText);

	}

	@Then("User should see User should see the smartInsights text  {string}")
	public void user_should_see_user_should_see_the_smart_insights_text(String commaSeparatedText) {
		launchPageObj.isSmartInsightsInfoDisplayed(commaSeparatedText);
	}

	@Then("User should see User should see heart icon")
	public void user_should_see_user_should_see_heart_icon() {

		launchPageObj.isHeartIconDisplayed();

	}

	@Then("User should see User should see activity inside square icon")
	public void user_should_see_user_should_see_activity_inside_square_icon() {
		launchPageObj.isActivityIconDisplayed();

	}

	@Then("User should see User should see clock icon")
	public void user_should_see_user_should_see_clock_icon() {
		launchPageObj.isClockIconDisplayed();
	}

	@Then("User should see User should see a testimonial from user {string}")
	public void user_should_see_user_should_see_a_testimonial_from_user(String JamesD) {

		launchPageObj.isJamesDTestimonialDispalyed(JamesD);
	}

	@Then("User should see User should see a secon testimonial from user {string}")
	public void user_should_see_user_should_see_a_secon_testimonial_from_user(String MariaL) {
		launchPageObj.isMariaLTestimonialDispalyed(MariaL);
	}

	@Then("User should see User should see a third testimonial from user {string}")
	public void user_should_see_user_should_see_a_third_testimonial_from_user(String RobertT) {
		launchPageObj.isRobertTTestimonialDispalyed(RobertT);
	}

	@Then("User should see User should see {string} text is visible above testimonial section")
	public void user_should_see_user_should_see_text_is_visible_above_testimonial_section(String communityHeading) {

		launchPageObj.isCommunitySectionHeadingDispalyed(communityHeading);
	}

	@Then("User should see User should see {int} yellow stars above Join our community of successful members text")
	public void user_should_see_user_should_see_yellow_stars_above_join_our_community_of_successful_members_text(
			Integer expectednoOfStars) {
		launchPageObj.starsForCommunitySection(expectednoOfStars);
	}

	@Then("User should see User should see {int} stars under first tetsimonial of James D.")
	public void user_should_see_user_should_see_stars_under_first_tetsimonial_of_james_d(Integer expectedRatingJamesD) {
		launchPageObj.verifyExpectedRatingJamesD(expectedRatingJamesD);
	}

	@Then("User should see User should see {int} stars under second tetsimonial of Maria L.")
	public void user_should_see_user_should_see_stars_under_second_tetsimonial_of_maria_l(
			Integer expectedRatingMariaL) {
		launchPageObj.verifyExpectedRatingMariaL(expectedRatingMariaL);
	}

	@Then("User should see User should see {int} stars under third tetsimonial of Robert T")
	public void user_should_see_user_should_see_stars_under_third_tetsimonial_of_robert_t(
			Integer expectedRatingRobertT) {
		launchPageObj.verifyExpectedRatingRobert(expectedRatingRobertT);
	}

	@Then("User should see User should see a section with heading {string}")
	public void user_should_see_user_should_see_a_section_with_heading(String BottomSectionHeading) {
		launchPageObj.verifyBottomSectionHeading(BottomSectionHeading);
	}

	@Then("User should see User should see a button labeled {string}")
	public void user_should_see_user_should_see_a_button_labeled(String checkYrRiskBtn) {
		launchPageObj.isCheckYourRiskbtnPresent(checkYrRiskBtn);
	}
	
	////////////////Feature - Verify Homepage navigation components////////////////////////////
	
	@When("User click the Start Today button")
	public void user_click_the_start_today_button() {
		launchPageObj.clickStartTodayButton();
	}

	@Then("User should be redirected to the Login page")
	public void user_should_be_redirected_to_the_login_page() {
		launchPageObj.verifyLandedToLoginPage();   
	    
	}

	@When("User look at the top right corner")
	public void user_look_at_the_top_right_corner() {
	    launchPageObj.pageScrollUp();
	    
	}

	@Then("User  should see a link labeled {string}")
	public void user_should_see_a_link_labeled(String loginBtn) {
	    launchPageObj.isLoginButtonDisplayed(loginBtn);
	    
	}

	@When("User click on the Login link")
	public void user_click_on_the_login_link() {
	    launchPageObj.clickLoginLink();
	}

	@When("User click on Check Your Risk button")
	public void user_click_on_check_your_risk_button() {
	    launchPageObj.clickCheckYrRiskButton();
	}
	
	@Then("User should be redirected to the assessment modal dialog")
	public void user_should_be_redirected_to_the_assessment_modal_dialog() {
	  launchPageObj.verifyIfRiskAssessmentformOpened();
	    
	    
	}
////////////#Feature: Non-Functional Testing - Home Page///////////////

	@Then("Page should be fully loaded within {int} seconds")
	public void page_should_be_fully_loaded_within_seconds(Duration expectedLoadTime) {
	    
	    
	}

	@Then("All elements are readable and accessible without horizontal scrolling")
	public void all_elements_are_readable_and_accessible_without_horizontal_scrolling() {
	    
	    
	}

	@Then("All major sections are accessible with appropriate labels and alt texts")
	public void all_major_sections_are_accessible_with_appropriate_labels_and_alt_texts() {
	    
	    
	}

	@Then("User finds the design visually appealing and readable")
	public void user_finds_the_design_visually_appealing_and_readable() {
	    
	    
	}

	@Then("User can access other sections without scrolling up")
	public void user_can_access_other_sections_without_scrolling_up() {
	    
	    
	}

	@Then("User has a consistent experience across browsers")
	public void user_has_a_consistent_experience_across_browsers() {
	    
	    
	}

}
