package stepDefinitions;

import org.testng.Assert;

import common.ConfigReader;
import common.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.FreeDashboard_Page;
import pageObject.LoginUI_Page;

public class FreeDashboard_Step {

	private TestContext context;
	private LoginUI_Page loginUI_page;
	private FreeDashboard_Page freeDashboardPage;

	public FreeDashboard_Step(TestContext context) {
		this.context = context;
		this.freeDashboardPage = context.freeDashboard_page();
	}

	@When("User clicks the Dashboard on the navigation bar")
	public void user_clicks_the_dashboard_on_the_navigation_bar() {
		freeDashboardPage.dashBoardClick();
	}

	@Then("User should see the Welcome Back,full name message")
	public void user_should_see_the_welcome_back_full_name_message() {
		Assert.assertTrue(freeDashboardPage.isWelcomeMessageCorrect(ConfigReader.getProperty("ProfileName")));
	}

	@Then("The {string} should be displayed")
	public void the_should_be_displayed(String scenario) {

		switch (scenario) {
		case "Displayed Message":
			Assert.assertTrue(freeDashboardPage.isWelcomeMessageBelowDescriptionDispalyed(),
					scenario + " is not displayed");
			break;
		case "Upgrade Premium":
			Assert.assertTrue(freeDashboardPage.isUpgradePremiumDispalyed(), scenario + " is not displayed");
			break;
		case "Account Information":
			Assert.assertTrue(freeDashboardPage.isAccountInformationDispalyed(), scenario + " is not displayed");
			break;
		case "Save Changes":
			Assert.assertTrue(freeDashboardPage.isSaveChangesDispalyed(), scenario + " is not displayed");
			break;
		case "Account Information All Fields":
			Assert.assertTrue(freeDashboardPage.areAllAccountInfoFieldsDisplayed(),
					scenario + " are not displayed properly");
			break;
		}
	}

	@Given("User is in FreeDashboard Page")
	public void user_is_in_dashboard_page() {
		freeDashboardPage.dashBoardClick();
	}

	@When("User edit age field with valid data")
	public void user_edit_age_field_with_valid_data() {
		freeDashboardPage.enterAge();
	}

	@Then("User should see that entered age is displayed in that field")
	public void user_should_see_that_entered_age_is_displayed_in_that_field() {
		Assert.assertTrue(freeDashboardPage.getAgeValue());
	}

	@When("User edit height field with valid data")
	public void user_edit_height_field_with_valid_data() {
		freeDashboardPage.enterHeight();
	}

	@Then("User should see that entered height is displayed in height field")
	public void user_should_see_that_entered_height_is_displayed_in_height_field() {
		Assert.assertTrue(freeDashboardPage.getHeightValue());
	}

	@When("User edit weight field with valid data")
	public void user_edit_weight_field_with_valid_data() {
		freeDashboardPage.enterWeight();
	}

	@Then("User should see that entered weight is displayed in weight field")
	public void user_should_see_that_entered_weight_is_displayed_in_weight_field() {
		Assert.assertTrue(freeDashboardPage.getWeightValue());
	}

	@When("User clicks the dropdown of Exercise Routine Level")
	public void user_clicks_the_dropdown_of_exercise_routine_level() {
		freeDashboardPage.exerciseLevelDropdownClick();
	}

	@Then("User should see the dropdown with options Easy,Medium,Hard")
	public void user_should_see_the_dropdown_with_options_easy_medium_hard() {
		Assert.assertTrue(freeDashboardPage.isExerciseDropdownDisplayed(),
				" Exercise routine level dropdown is not displayed");
	}

	@When("User clicks the dropdown of Cuisine Preferences")
	public void user_clicks_the_dropdown_of_cuisine_preferences() {
		freeDashboardPage.cuisinePreferenceClick();
	}

	@Then("User should see the dropdown with list of cuisine types Indian,American,Continental,Mediterranean,Asian,Middle Eastern,Mexican")
	public void user_should_see_the_dropdown_with_list_of_cuisine_types_indian_american_continental_mediterranean_asian_middle_eastern_mexican() {
		Assert.assertTrue(freeDashboardPage.iscuisinePreferenceDropdownDisplayed(),
				" Cuisine Preferences dropdown is not displayed");
	}

	@When("User scrolls to the Stress Management section")
	public void user_scrolls_to_the_stress_management_section() {
		freeDashboardPage.scrolltoStressManagement();
	}

	@Then("User should see the Title Stress Management Techniques")
	public void user_should_see_the_title_stress_management_techniques() {
		Assert.assertTrue(freeDashboardPage.isStressManagementDisplayed(), " Stress Management is not displayed");
	}

//8888888888888888888888888888888888888888888888888888888888888
	@When("User scrolls to the navigation bar section")
	public void user_scrolls_to_the_navigation_bar_section() {
		freeDashboardPage.scrolltoStressManagement();
	}

	@Then("user should see tabs Meditation, Breathing, Movement and Mindfulness")
	public void user_should_see_tabs_meditation_breathing_movement_and_mindfulness() {
		Assert.assertTrue(freeDashboardPage.isNavigationBarTabDisplayed(), " Navigation Bar Tab is not displayed");
	}

///8888888888888888888888888888888888888888888888888888888888888	
	@When("User clicks Meditation tab")
	public void user_clicks_meditation_tab() {
		freeDashboardPage.meditationTabClick();
	}

	@Then("User should see buttons for {int} min, {int} min, and {int} min")
	public void user_should_see_buttons_for_min_min_and_min(Integer int1, Integer int2, Integer int3) {
		Assert.assertTrue(freeDashboardPage.isMeditationDurationDisplayed(), "Meditation Duration is not displayed");
	}

	@Then("User should see the content with title Guided Meditation")
	public void user_should_see_the_content_with_title_guided_meditation() {
		Assert.assertTrue(freeDashboardPage.isGuidedMeditationDisplayed(), "Meditation Tab is not displayed");
	}

	@Then("User should see a progress bar with time indicators {int}:{int} and {int}:{int} by default")
	public void user_should_see_a_progress_bar_with_time_indicators_and_by_default(Integer int1, Integer int2,
			Integer int3, Integer int4) {
		Assert.assertTrue(freeDashboardPage.isMeditationAudioBarDisplayed(), "Meditation Audio bar is not displayed");
	}

	@When("User clicks audio play button")
	public void user_clicks_audio_play_button() {
		freeDashboardPage.audioBtnClick();
	}

	@Then("User Should see meditation audio should start playing and the progress bar should update accordingly")
	public void user_should_see_meditation_audio_should_start_playing_and_the_progress_bar_should_update_accordingly()
			throws InterruptedException {
		int progressDiff = freeDashboardPage.getAudioPlaybackProgressInSecondsAfterWait(5000);
		Assert.assertTrue(progressDiff > 0, "Audio progress did not update as expected");
	}

	@When("User clicks Movement Tab")
	public void user_clicks_movement_tab() {
		freeDashboardPage.movementTabClick();
	}

	@Then("User should see title Gentle Movement")
	public void user_should_see_title_gentle_movement() {
		Assert.assertTrue(freeDashboardPage.isgentleMovementDisplayed(), " Gentle Movement is not displayed");
	}

	@Then("User should see the description simple stretches to release tension: with the bullet points, Neck rolls - 5 times each direction, Shoulder circles - 10 times, Wrist and ankle rotations, Gentle torso twists")
	public void user_should_see_movement_tab_description() {
		Assert.assertTrue(freeDashboardPage.ismomentDescriptionDisplayed(), "moment Description is not displayed");
		Assert.assertTrue(freeDashboardPage.ismomentDescriptionListDisplayed(),
				"moment Description List is not displayed");
	}

	@Then("User should see the description Focus on your senses:with the bullet points, Notice {int} things you can see,Listen for {int} different sounds,Find {int} things you can smell,Observe {int} thing you can taste")
	public void user_should_see_the_description_focus_on_your_senses_with_the_bullet_points_notice_things_you_can_see_listen_for_different_sounds_find_things_you_can_smell_observe_thing_you_can_taste(
			Integer int1, Integer int2, Integer int3, Integer int4) {
		Assert.assertTrue(freeDashboardPage.isMindfulnessDescriptionDisplayed(),
				"Mindfulness Description is not displayed");
		Assert.assertTrue(freeDashboardPage.isMindfulnessDescriptionListDisplayed(),
				"Mindfulness Description List is not displayed");
	}

	@When("User scroll to the end")
	public void user_scroll_to_the_end() {
		freeDashboardPage.diabetesManagementSectionView();
	}

	@Then("User should see the list of benefits Reduces Stress Hormones, with explanation Lowers cortisol that can increase blood glucose,Improves Sleep, with explanation Better sleep leads to better glucose control,Reduces Diabetes Distress with explanation Helps manage overwhelm from diabetes care")
	public void user_should_see_the_list_of_benefits_reduces_stress_hormones_with_explanation_lowers_cortisol_that_can_increase_blood_glucose_improves_sleep_with_explanation_better_sleep_leads_to_better_glucose_control_reduces_diabetes_distress_with_explanation_helps_manage_overwhelm_from_diabetes_care() {
		Assert.assertTrue(freeDashboardPage.isdiabetesManagementSectionListDisplayed(),
				"Diabetes Management Section List is not displayed");
	}

	@Then("User should see the heading {int}-{int}-{int} Breathing Technique  with the description A natural tranquilizer for the nervous system")
	public void user_should_see_the_heading_breathing_technique_with_the_description_a_natural_tranquilizer_for_the_nervous_system(
			Integer int1, Integer int2, Integer int3) {
		Assert.assertTrue(freeDashboardPage.isBreathingTabDTechniqueDisplayed(),
				"Breathing Technique Section is not displayed");
	}

	@When("User clicks Mindfulness tab")
	public void user_clicks_mindfulness_tab() {
		freeDashboardPage.mindfulnessTabClick();
	}

	@Then("User should see title Present Moment Awareness")
	public void user_should_see_title_present_moment_awareness() {
		Assert.assertTrue(freeDashboardPage.ismomentAwarenessDisplayed(), " Gentle Movement is not displayed");
	}

	@When("User clicks breathing tab under stress management techniques")
	public void user_clicks_breathing_tab_under_stress_management_techniques() {
		freeDashboardPage.breathingTabClick();
	}

	@Then("User should see the Start Breathing Exercise button")
	public void user_should_see_the_start_breathing_exercise_button() {
		Assert.assertTrue(freeDashboardPage.isstartBreathingExerciseDisplayed(),
				"Start Breathing Exercise is not displayed");
	}

	@Then("User should see the Cycles completed counter text and value starting at {int}")
	public void user_should_see_the_cycles_completed_counter_text_and_value_starting_at(Integer int1) {
		Assert.assertTrue(freeDashboardPage.iscyclesCompletedTextDisplayed(), "Cycles Completed Text is not displayed");
	}

	@Then("User should see the label Current phase with a hyphen \\(-) as its current value.")
	public void user_should_see_the_label_current_phase_with_a_hyphen_as_its_current_value() {
		Assert.assertTrue(freeDashboardPage.iscurrentPhaseTextDisplayed(), "Current Phase Text is not displayed");
	}

	@Then("User should see the steps Inhale {int} seconds, Hold {int} seconds, Exhale {int} seconds")
	public void user_should_see_the_steps_inhale_seconds_hold_seconds_exhale_seconds(Integer int1, Integer int2,
			Integer int3) {
		Assert.assertTrue(freeDashboardPage.isBreathingStepsListDisplayed(), "Breathing Steps is not displayed");
	}

	@When("User clicks the Start Breathing Exercise button during the breathing exercise")
	public void user_clicks_the_start_breathing_exercise_button_during_the_breathing_exercise() {
		freeDashboardPage.breathingTabClick();
		freeDashboardPage.clickStartBreathingExerciseButton();
	}

	@Then("User should see the breathing cycles begin")
	public void user_should_see_the_breathing_cycles_begin() {
		Assert.assertTrue(freeDashboardPage.hasCycleStarted(),
				"Breathing cycles did not begin (counter did not increment)");
	}

	@When("User clicks the dropdown of Food Allergies")
	public void user_clicks_the_dropdown_of_food_allergies() {
		freeDashboardPage.allergiesDropdownClick();
	}

	@Then("User should see the dropdown list of common allergy options None,Dairy,Gluten,Shellfish,Soy,Eggs,Nuts,Other")
	public void user_should_see_the_dropdown_list_of_common_allergy_options_none_dairy_gluten_shellfish_soy_eggs_nuts_other() {
		Assert.assertTrue(freeDashboardPage.isAllergiesDropdownDisplayed(), "Allergies option list is not displaed");
	}

	@When("User edit with invalid data and click save changes")
	public void user_edit_with_invalid_data_and_click_save_changes() throws InterruptedException {
		freeDashboardPage.enterInvalid();

	}
//#################################333
//	@Then("User should see Error message DashboardAccountDetails")
//	public void user_should_see_error_message_DashboardAccountDetails() {
//		Assert.assertTrue(false, " NO Error Message is Visible");
//	}
//
//	@When("User edit all fields and click Save Changes")
//	public void user_edit_all_fields_and_click_save_changes() {
//		
//	}
//
//	@Then("User should see messages Changes Saved Your profile has been updated successfully!")
//	public void user_should_see_messages_changes_saved_your_profile_has_been_updated_successfully() {
//		
//	}

	@Then("User should see the breathing cycle displays Inhale which last for {int} seconds")
	public void user_should_see_the_breathing_cycle_displays_inhale_which_last_for_seconds(Integer int1) {

	}

	@Given("User started Breathing cycle")
	public void user_started_breathing_cycle() {

	}

	@When("User view the current phase begins")
	public void user_view_the_current_phase_begins() {

	}

	@Then("User should see the breathing cycle displays hold which last for {int} seconds")
	public void user_should_see_the_breathing_cycle_displays_hold_which_last_for_seconds(Integer int1) {

	}

	@Given("User see the inhale phase is completed")
	public void user_see_the_inhale_phase_is_completed() {

	}

	@When("User view the next phase begins")
	public void user_view_the_next_phase_begins() {

	}

	@Then("User should see the breathing cycle displays Exhale which last for {int} seconds")
	public void user_should_see_the_breathing_cycle_displays_exhale_which_last_for_seconds(Integer int1) {

	}

	@Given("User completed one full cycle")
	public void user_completed_one_full_cycle() {

	}

	@When("User completes full breathing cycle")
	public void user_completes_full_breathing_cycle() {

	}

	@Then("User should see Cycles completed counter should increased by {int}")
	public void user_should_see_cycles_completed_counter_should_increased_by(Integer int1) {

	}

	@When("User see next phase begins")
	public void user_see_next_phase_begins() {

	}

	@Then("User should see breathing cycle displays {string} which last for {int} seconds")
	public void user_should_see_breathing_cycle_displays_which_last_for_seconds(String string, Integer int1) {

	}

	@When("User clicks the Stop button during the breathing exercise")
	public void user_clicks_the_stop_button_during_the_breathing_exercise() {

	}

	@Then("User should see breathing exercise stops")
	public void user_should_see_breathing_exercise_stops() {

	}

}
