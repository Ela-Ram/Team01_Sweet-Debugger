package stepDefinitions;

import org.testng.Assert;

import common.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pageObject.DiabetesRiskAnalyzer_Page;
import pageObject.LaunchPage_Page;

public class DiabetesRiskAnalyzer_Step {

	private TestContext context;
	DiabetesRiskAnalyzer_Page diaRiskAnalyzerPageObj;
	LaunchPage_Page launch_pageObj;

	public DiabetesRiskAnalyzer_Step(TestContext context) {
		this.context = context;
		this.diaRiskAnalyzerPageObj = context.getDiaRiskAnalyzerPageObj();
		this.launch_pageObj = context.getLaunch_PageObj();

	}

	@When("User clicks Check Your Risk button")
	public void user_clicks_check_your_risk_button() {
		launch_pageObj.clickCheckYrRiskButton();

	}

	@Then("User should see User see  {string} text")
	public void user_should_see_user_see_text(String expectedInstruction) {
		diaRiskAnalyzerPageObj.isInstructionDisplayed(expectedInstruction);

	}

	@Then("User should see User should see Cancel button")
	public void user_should_see_user_should_see_cancel_button() {
		diaRiskAnalyzerPageObj.isCancelButtonPresent();

	}

	@Then("User should see User should see Calculate Risk button")
	public void user_should_see_user_should_see_calculate_risk_button() {
		diaRiskAnalyzerPageObj.isCalRiskButtonPresent();

	}

	@Then("User should see User should see Calculate Risk button disabled")
	public void user_should_see_user_should_see_calculate_risk_button_disabled() {
		diaRiskAnalyzerPageObj.isCalRiskButtonDisabled();

	}

	@Then("User should see User should see Age input field to have stepper controls")
	public void user_should_see_user_should_see_age_input_field_to_have_stepper_controls() {

		diaRiskAnalyzerPageObj.isAgefiledwithStepperControl();
	}

	@Then("User should see User should see weight input field to have stepper controls")
	public void user_should_see_user_should_see_weight_input_field_to_have_stepper_controls() {
		diaRiskAnalyzerPageObj.isWeightfiledwithStepperControl();

	}

	@Then("User should see User should see check box for Family history of diabetes field")
	public void user_should_see_user_should_see_check_box_for_family_history_of_diabetes_field() {
		diaRiskAnalyzerPageObj.isFamilyHisCheckboxDispalyed();

	}

	@Then("User should see User should be able to view the placeholder {string} in the age field")
	public void user_should_see_user_should_be_able_to_view_the_placeholder_in_the_age_field(
			String expectedPlaceHolderVal) {
		diaRiskAnalyzerPageObj.placeholderAgeField(expectedPlaceHolderVal);

	}

	@Then("User should see User should see {string}")
	public void user_should_see_user_should_see(String expectedPlaceHolderVal) {
		diaRiskAnalyzerPageObj.placeholderWeightField(expectedPlaceHolderVal);

	}

	@Then("User should see User should see  dropdown for Physical Activity Level")
	public void user_should_see_user_should_see_dropdown_for_physical_activity_level() {
		diaRiskAnalyzerPageObj.isPhyActivityLeveldropboxpresent();

	}

	@Then("User should see User should see dropdown for Blood Pressure")
	public void user_should_see_user_should_see_dropdown_for_blood_pressure() {
		diaRiskAnalyzerPageObj.isBloodPressuredropboxpresent();

	}

	@Then("User should see User should see dropdown for Diet Quality")
	public void user_should_see_user_should_see_dropdown_for_diet_quality() {
		diaRiskAnalyzerPageObj.isDietQualdropboxpresent();

	}

	@Then("User should see Physical Activity - Level User should see {string} as the default option")
	public void user_should_see_physical_activity_level_user_should_see_as_the_default_option(String defaultval1) {
		diaRiskAnalyzerPageObj.defaultPhyActLevValue(defaultval1);
	}

	@Then("User should see Blood Pressure - User should see {string} as the default option")
	public void user_should_see_blood_pressure_user_should_see_as_the_default_option(String defaultval2) {
		diaRiskAnalyzerPageObj.defaultBloodPressureValue(defaultval2);
	}

	@Then("User should see Diet Quality - User should see {string} as the default option")
	public void user_should_see_diet_quality_user_should_see_as_the_default_option(String defaultval3) {
		diaRiskAnalyzerPageObj.defaultDietQualityValue(defaultval3);
	}

	@Then("User should see the following options in the activity level dropdown:")
	public void user_should_see_the_following_options_in_the_activity_level_dropdown(DataTable dataTable) {
		diaRiskAnalyzerPageObj.physicalActivityDropDownOption(dataTable);
	}

	@Then("User should see the following options in the Blood Pressure dropdown:")
	public void user_should_see_the_following_options_in_the_blood_pressure_dropdown(DataTable dataTable) {
		diaRiskAnalyzerPageObj.bloodPressureDropDownOptions(dataTable);
	}

	@Then("User should see the following options in the Diet Quality dropdown:")
	public void user_should_see_the_following_options_in_the_diet_quality_dropdown(DataTable dataTable) {
		diaRiskAnalyzerPageObj.dietQualityDropDownOptions(dataTable);
	}

/// Feature- Verification on Diabetes Risk Analyzer functional ////////////////////////

	@Given("User is in diabetes risk analyzer")
	public void user_is_in_diabetes_risk_analyzer() {
		boolean expectedpage = diaRiskAnalyzerPageObj.naviagtedToRiskAnalyzer();
		Assert.assertEquals(expectedpage, true);
	}

	@When("User clicks Cancel button")
	public void user_clicks_cancel_button() {
		diaRiskAnalyzerPageObj.clickCancel();
	}

	@Then("User should be returned to the {string}")
	public void user_should_be_returned_to_the(String homepage) {
		diaRiskAnalyzerPageObj.homePage(homepage);
	}

	@When("User enters values in all fields from {string} and {string}")
	public void user_enters_values_in_all_fields_from_and(String Sheet, String TestCaseId) {
		diaRiskAnalyzerPageObj.fillRiskAnalyzerForm(Sheet, TestCaseId);
	}

	@Then("User should see Calculate Risk button is  enabled")
	public void user_should_see_calculate_risk_button_is_enabled() {
		boolean expected = diaRiskAnalyzerPageObj.isCalRiskButtonEnabled();
		Assert.assertEquals(expected, true);
	}

	@When("User clicks Calculate Risk button after entering valid values in all fields")
	public void user_clicks_calculate_risk_button_after_entering_valid_values_in_all_fields() {
		diaRiskAnalyzerPageObj.clickCalRiskAnalyzerbtn();
	}

	@Then("User should see {string} dialog box")
	public void user_should_see_dialog_box(String assessmentResult) {
		diaRiskAnalyzerPageObj.isAssessmentReultPageDispalyed(assessmentResult);

	}

}
