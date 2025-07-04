package stepDefinitions;

import java.time.Duration;

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

	@Given("User launches the browser_launch")
	public void user_launches_the_browser_launch() {

	}

	@When("User enters the SweetBalance url from launch")
	public void user_enters_the_sweet_balance_url_from_launch() {

	}

	@Then("User should see SweetBalance_launch")
	public void user_should_see_sweet_balance_from_launch_page_launch() {
		String actual = launchPageObj.get_AppName();
		Assert.assertEquals(actual, "SweetBalance");
		System.out.println("The Application name is:" + actual);
	}

	@Then("User should see Our Terms of Service and Privacy Policy have recently been updated_launch")
	public void user_should_see_our_terms_of_service_and_privacy_policy_have_recently_been_updated_launch() {
		boolean actual = launchPageObj.policyDetails();
		Assert.assertEquals(actual, true);

	}

	@Then("User should see Smart Diabetes Tracking Powered by AI_launch_launch")
	public void user_should_see_smart_diabetes_tracking_powered_by_ai_launch() {

		boolean actual = launchPageObj.getAppHeading();
		Assert.assertEquals(actual, true);
	}

	@Then("User should see User should see a Start Today input button_launch")
	public void user_should_see_user_should_see_a_input_button_launch() {

		boolean actual = launchPageObj.isStartTodaybuttondispalyed();
		Assert.assertEquals(actual, true);

	}

	@Then("User should see User should see the text {string}_launch")
	public void user_should_see_user_should_see_text_launch(String diaToolsHeading) {
		boolean heading = launchPageObj.isDiabetesToolsHeadingDisplayed(diaToolsHeading);
		Assert.assertEquals(heading, true);
		System.out.println("****** " + diaToolsHeading + " ****** Heading is present");

	}

	@Then("User should see User should see a first card with title {string}_launch")
	public void user_should_see_user_should_see_a_card_with_title(String healthTrackingCard) {
		boolean card1 = launchPageObj.ishealthTrackingCardDisplayed(healthTrackingCard);
		Assert.assertEquals(card1, true);
		System.out.println("****** " + healthTrackingCard + " ****** first Card is present");

	}

	@Then("User should see User should see a second card with title {string}_launch")
	public void user_should_see_user_should_see_a_second_card_with_title(String NutriCard) {
		boolean card1 = launchPageObj.isNutritionCardDisplayed(NutriCard);
		Assert.assertEquals(card1, true);
		System.out.println("****** " + NutriCard + " ****** second Card is present");
	}

	@Then("User should see User should see a third card with title {string}_launch")
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

	@Then("User should see User should see textt Monitor glucose levels, medication, and vital statistics, Easy logging of daily readings,Visualize trends over time,Set personalized targets_launch")
	public void user_should_see_user_should_see_textt_monitor_glucose_levels_medication_and_vital_statistics_easy_logging_of_daily_readings_visualize_trends_over_time_set_personalized_targets_launch() {
		launchPageObj.isHealthCardInfoDisplayed();
	}

	@Then("User should see User should see the text  {string} launch")
	public void user_should_see_user_should_see_the_text_launch(String commaSeparatedText) {
		launchPageObj.isNutritionInfoDisplayed(commaSeparatedText);

	}

	@Then("User should see User should see the smartInsights text  {string}_launch")
	public void user_should_see_user_should_see_the_smart_insights_text_launch(String commaSeparatedText) {
		launchPageObj.isSmartInsightsInfoDisplayed(commaSeparatedText);
	}

	@Then("User should see User should see heart icon_launch")
	public void user_should_see_user_should_see_heart_icon_launch() {

		launchPageObj.isHeartIconDisplayed();

	}

	@Then("User should see User should see activity inside square icon_launch ")
	public void user_should_see_user_should_see_activity_inside_square_icon_launch() {
		launchPageObj.isActivityIconDisplayed();

	}

	@Then("User should see User should see clock icon_launch")
	public void user_should_see_user_should_see_clock_icon() {
		launchPageObj.isClockIconDisplayed();
	}

	@Then("User should see User should see a testimonial from user {string}_launch")
	public void user_should_see_user_should_see_a_testimonial_from_user_launch(String JamesD) {

		launchPageObj.isJamesDTestimonialDispalyed(JamesD);
	}

	@Then("User should see User should see a secon testimonial from user {string}_launch")
	public void user_should_see_user_should_see_a_secon_testimonial_from_user_launch(String MariaL) {
		launchPageObj.isMariaLTestimonialDispalyed(MariaL);
	}

	@Then("User should see User should see a third testimonial from user {string}_launch")
	public void user_should_see_user_should_see_a_third_testimonial_from_user_launch(String RobertT) {
		launchPageObj.isRobertTTestimonialDispalyed(RobertT);
	}

	@Then("User should see User should see {string} text is visible above testimonial section_launch")
	public void user_should_see_user_should_see_text_is_visible_above_testimonial_section_launch(String communityHeading) {

		launchPageObj.isCommunitySectionHeadingDispalyed(communityHeading);
	}

	@Then("User should see User should see {int} yellow stars above Join our community of successful members text_launch")
	public void user_should_see_user_should_see_yellow_stars_above_join_our_community_of_successful_members_text_launch(
			Integer expectednoOfStars) {
		launchPageObj.starsForCommunitySection(expectednoOfStars);
	}

	@Then("User should see User should see {int} stars under first tetsimonial of James D._launch")
	public void user_should_see_user_should_see_stars_under_first_tetsimonial_of_james_d_launch(Integer expectedRatingJamesD) {
		launchPageObj.verifyExpectedRatingJamesD(expectedRatingJamesD);
	}

	@Then("User should see User should see {int} stars under second tetsimonial of Maria L._launch")
	public void user_should_see_user_should_see_stars_under_second_tetsimonial_of_maria_l_launch(
			Integer expectedRatingMariaL) {
		launchPageObj.verifyExpectedRatingMariaL(expectedRatingMariaL);
	}

	@Then("User should see User should see {int} stars under third tetsimonial of Robert T_launch")
	public void user_should_see_user_should_see_stars_under_third_tetsimonial_of_robert_t_launch(
			Integer expectedRatingRobertT) {
		launchPageObj.verifyExpectedRatingRobert(expectedRatingRobertT);
	}

	@Then("User should see User should see a section with heading {string}_launch")
	public void user_should_see_user_should_see_a_section_with_heading_launch(String BottomSectionHeading) {
		launchPageObj.verifyBottomSectionHeading(BottomSectionHeading);
	}

	@Then("User should see User should see a button labeled {string}_launch")
	public void user_should_see_user_should_see_a_button_labeled_launch(String checkYrRiskBtn) {
		launchPageObj.isCheckYourRiskbtnPresent(checkYrRiskBtn);
	}
	
	////////////////Feature - Verify Homepage navigation components////////////////////////////
	
	@When("User click the Start Today button launch")
	public void user_click_the_start_today_button_launch() {
		launchPageObj.clickStartTodayButton();
	}

	@Then("User should be redirected to the Login page_launch")
	public void user_should_be_redirected_to_the_login_page_launch() {
		launchPageObj.verifyLandedToLoginPage();   
	    
	}

	@When("User look at the top right corner_launch")
	public void user_look_at_the_top_right_corner_launch() {
	    launchPageObj.pageScrollUp();
	    
	}

	@Then("User  should see a link labeled {string}_launch")
	public void user_should_see_a_link_labeled_launch(String loginBtn) {
	    launchPageObj.isLoginButtonDisplayed(loginBtn);
	    
	}

	@When("User click on the Login link launch")
	public void user_click_on_the_login_link_launch() {
	    launchPageObj.clickLoginLink();
	}

	@When("User click on Check Your Risk button launch")
	public void user_click_on_check_your_risk_button_launch() {
	    launchPageObj.clickCheckYrRiskButton();
	}
	
	@Then("User should be redirected to the assessment modal dialog_launch")
	public void user_should_be_redirected_to_the_assessment_modal_dialog_launch() {
	  launchPageObj.verifyIfRiskAssessmentformOpened();
	    
	    
	}
////////////#Feature: Non-Functional Testing - Home Page///////////////

	@Then("Page should be fully loaded within {int} seconds_launch")
	public void page_should_be_fully_loaded_within_seconds_launch(Duration expectedLoadTime) {
	    
	    
	}

	@Then("All elements are readable and accessible without horizontal scrolling_launch")
	public void all_elements_are_readable_and_accessible_without_horizontal_scrolling_launch() {
	    
	    
	}

	@Then("All major sections are accessible with appropriate labels and alt texts_launch")
	public void all_major_sections_are_accessible_with_appropriate_labels_and_alt_texts_launch() {
	    
	    
	}

	@Then("User finds the design visually appealing and readable_launch")
	public void user_finds_the_design_visually_appealing_and_readable_launch() {
	    
	    
	}

	@Then("User can access other sections without scrolling up_launch")
	public void user_can_access_other_sections_without_scrolling_up_launch() {
	    
	    
	}

	@Then("User has a consistent experience across browsers_launch")
	public void user_has_a_consistent_experience_across_browsers_launch() {
	    
	    
	}

}
