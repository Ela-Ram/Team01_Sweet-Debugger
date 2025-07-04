package stepDefinitions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import common.DataGenerator;
import common.ExcelReader;
import common.Helper;
import common.LoggerLoad;
import common.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LoginUI_Page;

public class LoginOnboardingScenariosWithoutBloodReport_Step {
	
	private TestContext context;
	private  LoginUI_Page loginUI_page;
	private Helper helper;
	
	public LoginOnboardingScenariosWithoutBloodReport_Step(TestContext context) {
		this.context = context;
	    this.loginUI_page = context.getLoginUI_Page();
	    this.helper = context.getHelper(); 
		}
	
	
	@Given("User successfully completed profile setup")
	public void user_successfully_completed_profile_setup() {
		String email = DataGenerator.generateUniqueEmail();
        String username = DataGenerator.generateUniqueUsername();
        String password = DataGenerator.generateSecurePassword();
        String fullname = DataGenerator.generateFullName();
		loginUI_page.clickLoginGutton();
		loginUI_page.enterEmail(email);
		loginUI_page.clickContinueWithEmailButton();
		loginUI_page.enterAllFieldsCompleteForm(fullname, username, password);
		loginUI_page.clickCheckbox();
		
	}
//--------------------------------------------------------------------------------------------------------------------------------------------

	@Given("User is in upload blood report page after entering values")
	public void user_is_in_upload_blood_report_page_after_entering_values() {
		loginUI_page.clickCreateAccountButton();
	}
	
	@When("User clicks on step for onboarding button")
	public void user_clicks_on_step_for_onboarding_button() {
		loginUI_page.clickStepThroughOnboardingButton();
	    
	}
	@Then("User should see {string} for step for onboarding without report {string}")
	public void user_should_see_for_step_for_onboarding_without_report(String expected, String scenario) {
		switch (scenario.trim()) {
		
        case "navigation to step for onboarding":
        case "Progress bar reflects Step 1 of 12":
        case "option is selectable":
        case "Progress bar reflects Step 2 of 12":
        case "Progress bar reflects Step 3 of 12":	
        case "Nav back step2":	
        case "Progress bar reflects Step 4 of 12":
        case "Nav back from step3":
        case "user able to select from option in centimeters":
        case "user able to select from option in feet & inches":
        case "progress bar displays Step 5 of 12":
        case "Nav back from step4":
        case "user able to select from option in kilogram":	
        case "user able to select from option in pound":
        case "progress bar displays Step 6 of 12":
        case "Nav back from step5":	
        case "Verify dietary options selectable in step6":	
        case "progress bar displays Step 7 of 12":
        case "Nav back from step6":	
        case "cuisine options are selectable in step7":
        case "progress bar displays Step 8 of 12":	
        case "Nav back from step7":	
        case "user goes to step 10 if choose no":
        case "progress bar displays Step 9 of 12":
        case "progress bar displays Step 10 of 12":	
        case "progress bar displays Step 11 of 12":	
        case "progress bar displays Step 12 of 12":	
        	
            helper.waitForVisibleElement(loginUI_page.getStepNumWithoutReportIndicatorElement());
            String actual = loginUI_page.getTextStepNumWithoutReport();
            Assert.assertEquals(actual.trim(), expected, "Mismatch in step transition");
            break;

        case "Step1 heading is visible":
        case "Step 2 heading is visible":	
        case "Step 3 heading is visible":
        case "Step 4 heading is visible":
        case "heading for Step5 is visible":
        case "heading for Step6 is visible":
        case "heading for Step7 is visible":
        case "heading for Step8 is visible":	
        case "heading for Step 9 is visible":
        case "heading for Step 10 is visible":
        case "heading for Step 11 is visible":	
        case "heading for Step 12 is visible":	
        
        	
        	helper.waitForVisibleElement(loginUI_page.getTitleWithoutReportIndicatorElement());
            String actualText = loginUI_page.getCurrentHeadingOnboardFormWithoutReport();
            Assert.assertEquals(actualText.trim(), expected, "Mismatch in step transition");
            break;

        case "Step1 sub text":
        case "step 2 sub text":	
        case "step 3 sub text":	
        case "step 4 sub text":	
        case "subtext displayed in Step5":	
        case "subtext displayed in Step6":
        case "subtext displayed in Step7":
        case "subtext displayed in Step8":
        case "subtext displayed in Step 9":
        case "subtext displayed in Step 10":
        case "subtext displayed in Step 11":	
        	
        	helper.waitForVisibleElement(loginUI_page.getSubTitleWithoutIndicatorElement());
            String actualSubText = loginUI_page.getCurrentSubHeadingOnboardFormWithoutReport();
            Assert.assertEquals(actualSubText.trim(), expected, "Mismatch in step transition");
            break;     
            
        case "presence of back button in step 2":
        case "Back button is visible in step 3":
        case "Back button is visible in step 4":
        case "Back button is visible in Step 5":
        case "Back button is visible in Step 6":
        case "Back button is visible in Step 7":
        case "Back button is visible in Step 8":
        case "Back button is visible in Step 9":
        case "Back button is visible in Step 10":
        case "Back button is visible in Step 11":
        case "Back button is visible in Step 12":	
        	
           	Assert.assertTrue(loginUI_page.isBackButtonWithoutReportVisible(),"Back button is  not visible ");     
               break;
               
        case "step 2 progress is highlighted":
        case "step 1 progress is highlighted":	
        	Assert.assertTrue(loginUI_page.isProgressBarWithoutReportHighlighted(),"Not Highlighted "); 
              break;
              
        case "options are displayed":
        case "gender options":	
        case "Step 6 contains options to select dietary preference":	
        case "Step 7 contains cuisine options":	
        case "yes,no options are displayed in step 8":	
        case "allergy options are displayed for yes in step 8":	
        case "step 11 contain options to choose":	
        	
        	
        	
		    List<String> actualOptionsList;
		    
		    helper.waitForAllVisibleElements(loginUI_page.getOptionsOnboardFormWithoutReportIndicatorElement());

	          actualOptionsList = loginUI_page.getOptionsOnboardFormWithoutReportTexts();
	            LoggerLoad.info("Actual: " + actualOptionsList);
	            loginUI_page.assertExpectedItemsPresent(actualOptionsList, expected, "option is not present");
	 
      
        		break;
        default:
            throw new IllegalArgumentException("Unexpected scenario: " + scenario);
    }
	}
	//this for range validation
	@Then("User should see {string} for step for onboarding without report {string} and {string}")
	public void user_should_see_for_step_for_onboarding_without_report_and(String expected, String scenario, String suffix) {
		
		switch(scenario.trim()) {
		
case "options is displayed in step 3":
case "centimeters":
case "kilograms":
case "pounds":
	if (scenario.equalsIgnoreCase("pounds")) {
        loginUI_page.clickPoundsTabWithoutReport();
    }
        	
        	helper.waitForAllVisibleElements(loginUI_page.getOptionsOnboardFormWithoutReportIndicatorElement());
        	List<String> actualOptionsList = loginUI_page.getOptionsOnboardFormWithoutReportTexts();
        	List<String> expectedRangeList = loginUI_page.validateRange(expected,suffix);
        	boolean allMatch = expectedRangeList.stream()
        	        .allMatch(expectedItem -> actualOptionsList.contains(expectedItem));

        	Assert.assertTrue(allMatch, "Values are missing within the range " +actualOptionsList );
        	break;
        default:
            throw new IllegalArgumentException("Unexpected scenario: " + scenario);
		
		
		}
	    
	}
	//--------------------------------------------------------------------------------------------------------------------------------------------

	
	@Given("User is in step1 Onboarding form without blood report")
	public void user_is_in_step1_onboarding_form_without_blood_report() {
		loginUI_page.clickCreateAccountButton();
		loginUI_page.clickStepThroughOnboardingButton();  
	    
	}
	@When("User selects the {string} in step1 onboarding")
	public void user_selects_the_condition_in_step1_onboarding(String condition) {
		switch(condition) {
		case "I dont know":
		loginUI_page.clickOptionIDontKnowStep2WithoutReport(); 
		break;
		case "Type 2":
			loginUI_page.clickOptionType2Step2WithoutReport();
			break;
	}
	}
	
	@Then("User should see {string} in step onboarding")
	public void user_should_see_in_step_onboarding(String expected) {
		
		String actual = loginUI_page.getDomMessage();
		Assert.assertTrue(actual.contains(expected),"Expected message not found.\nExpected: " + expected + "\nActual: " + actual);

	    
	}
	//--------------------------------------------------------------------------------------------------------------------------------------------

	@Given("User is in step2 Onboarding form without blood report")
	public void user_is_in_step2_onboarding_form_without_blood_report() {
		loginUI_page.clickCreateAccountButton();
		loginUI_page.clickStepThroughOnboardingButton();  
		loginUI_page.clickOptionIDontKnowStep2WithoutReport();
	}

	@When("User selects a {string} in step3")
	public void user_selects_a_gender_in_step3(String gender) {
		
		WebElement genderElement = loginUI_page.getOptionByText(gender);
		genderElement.click();
	   
	}
	
	@When("User clicks back button in step")
	public void user_clicks_back_button_in_step() {
		loginUI_page.clickBackButtonWithoutReport();
	}


	@Then("iframe options should have scroll option")
	public void iframe_options_should_have_scroll_option() {
		loginUI_page.scrollToLastOptionAndVerify();
	}
	
	@Given("User is in step3 Onboarding form without blood report")
	public void user_is_in_step3_onboarding_form_without_blood_report() {
		loginUI_page.clickCreateAccountButton();
		loginUI_page.clickStepThroughOnboardingButton();  
		loginUI_page.clickOptionIDontKnowStep2WithoutReport();
		loginUI_page.clickMaleOptionWithoutReport();  
	    
	}

	
	@When("User selects age between {string} in step3 {string}")
	public void user_selects_age_between_in_step3(String scenario, String age) {
		WebElement ageNumberElement = loginUI_page.getOptionByText(age);
		ageNumberElement.click();  
	}
	
	@Then("following scetions should be visible")
	public void following_scetions_should_be_visible(io.cucumber.datatable.DataTable dataTable) {
		List<String> sections = dataTable.asList();

	    for (String section : sections) {
	        boolean visible = loginUI_page.isSectionVisible(section);
	        Assert.assertTrue(visible);
	    }
	        }
	
	@Then("User should see {string} for step for onboarding without reports {string}")
	public void user_should_see_for_step_for_onboarding_without_reports(String expected,String scenario) {
		
		String actual = loginUI_page.getCmFeetKgPoundsTabWithoutReportText();
		Assert.assertTrue(actual.contains(expected),"Not Displayed");
	}
	
	@Then("User should see options have {string}")
	public void user_should_see_options_have_range(String range) {
	    
	    helper.waitForAllVisibleElements(loginUI_page.getOptionsOnboardFormWithoutReportIndicatorElement());
	    List<String> expectedOptions = DataGenerator.generateFeetInchRange(range);
	    loginUI_page.clickFeeAndInchesTabWithoutReportt();
	    List<String> actualOptions = loginUI_page.getOptionsOnboardFormWithoutReportTexts()
	    	    .stream()
	    	    .map(opt -> opt.replaceAll("'\\s+", "'")) 
	    	    .collect(Collectors.toList());

	   
	    boolean allPresent = expectedOptions.stream()
	        .allMatch(actualOptions::contains);

	
	    Assert.assertTrue(allPresent, "Mismatch in options.\nExpected: " + expectedOptions + "\nActual: " + actualOptions);
	}
	//--------------------------------------------------------------------------------------------------------------------------------------------

	
	@Given("User is in step4 Onboarding form without blood report")
	public void user_is_in_step4_onboarding_form_without_blood_report() {
		loginUI_page.clickCreateAccountButton();
		loginUI_page.clickStepThroughOnboardingButton();  
		loginUI_page.clickOptionIDontKnowStep2WithoutReport();
		loginUI_page.clickMaleOptionWithoutReport();
		loginUI_page.clickEighteenOptionWithoutReport();
	}

	
	
	@When("User selects {string} in cm between {string}  in step4")
	public void user_selects_in_cm_between_in_step4(String heightincm, String scenario) {
		WebElement heightInCmNumberElement = loginUI_page.getOptionByText(heightincm);
		heightInCmNumberElement.click();  
	    
	}
	
	@When("User selects {string} in pounds  between {string}  in step4")
	public void user_selects_in_pounds_between_in_step4(String heightininches, String scenario) {
		loginUI_page.clickFeeAndInchesTabWithoutReportt();
		WebElement heightInInchesNumberElement = loginUI_page.getOptionByText(heightininches);
		heightInInchesNumberElement.click(); 
		
	}

	@When("User selects from {string} available in step4")
	public void user_selects_from_available_in_step4(String option) {
		
		switch(option) {
		case "feet and inches":
	   loginUI_page.clickFeeAndInchesTabWithoutReportt();	
		loginUI_page.clickFourPointFiveInchesOptionWithoutReport();
			break ;	
		case "centimeters":
			loginUI_page.clickCentimeterTabWithoutReport();
			loginUI_page.clickOneSixtyFiveOptionWithoutReport();
			break ;		
		}
	   
	}
//-----------------------------------------------------------------------------------------------------------------------------------------
	@Given("User is in step5 Onboarding form without blood report")
	public void user_is_in_step5_onboarding_form_without_blood_report() {
		loginUI_page.clickCreateAccountButton();
		loginUI_page.clickStepThroughOnboardingButton();  
		loginUI_page.clickOptionIDontKnowStep2WithoutReport();
		loginUI_page.clickMaleOptionWithoutReport();
		loginUI_page.clickEighteenOptionWithoutReport();
		loginUI_page.clickOneEightyFiveHeightOptionWithoutReport();
	}
	
	
	@When("User selects {string} in kg between {string} in step5")
	public void user_selects_in_kg_between_in_step5(String weightinkg, String scenario) {
		WebElement weightInKgNumberElement = loginUI_page.getOptionByText(weightinkg);
		weightInKgNumberElement.click(); 
	   
	}


	@When("User selects from {string} available in step5")
	public void user_selects_from_available_in_step5(String option) {
		switch(option) {
		case "kilogram":
	   loginUI_page.clickKgTabWithoutReport();	
		loginUI_page.clickHundredWeightOptionWithoutReport();
			break ;	
		case "pound":
			loginUI_page.clickPoundsTabWithoutReport();
			loginUI_page.clickHundredWeightOptionWithoutReport();
			break ;		
		}
	   
	}
//-------------------------------------------------------------------------------------------------------------------------------------------
	@Given("User is in step6 Onboarding form without blood report")
	public void user_is_in_step6_onboarding_form_without_blood_report() {
		loginUI_page.clickCreateAccountButton();
		loginUI_page.clickStepThroughOnboardingButton();  
		loginUI_page.clickOptionIDontKnowStep2WithoutReport();
		loginUI_page.clickMaleOptionWithoutReport();
		loginUI_page.clickEighteenOptionWithoutReport();
		loginUI_page.clickOneEightyFiveHeightOptionWithoutReport();
		loginUI_page.clickFortyWeightOptionWithoutReport();
	   
	}

@When("User selects from {string}  in step6")
public void user_selects_from_in_step6(String dietaryoptions) {
	WebElement dietaryOptionsElement = loginUI_page.getOptionByText(dietaryoptions);
	dietaryOptionsElement.click(); 
    
}


//-------------------------------------------------------------------------------------------------------------------------------------------

@Given("User is in step7 Onboarding form without blood report")
public void user_is_in_step7_onboarding_form_without_blood_report() {
	loginUI_page.clickCreateAccountButton();
	loginUI_page.clickStepThroughOnboardingButton();  
	loginUI_page.clickOptionIDontKnowStep2WithoutReport();
	loginUI_page.clickMaleOptionWithoutReport();
	loginUI_page.clickEighteenOptionWithoutReport();
	loginUI_page.clickOneEightyFiveHeightOptionWithoutReport();
	loginUI_page.clickFortyWeightOptionWithoutReport();
	loginUI_page.clickVeganDietaryOptionWithoutReport();
}

@When("User selects from one of the {string} options in step7")
public void user_selects_from_one_of_the_options_in_step7(String cuisine) {
	WebElement cuisineOptionsElement = loginUI_page.getOptionByText(cuisine);
	cuisineOptionsElement.click(); 
    
}


//-------------------------------------------------------------------------------------------------------------------------------------------

@Given("User is in step8 Onboarding form without blood report")
public void user_is_in_step8_onboarding_form_without_blood_report() {
	loginUI_page.clickCreateAccountButton();
	loginUI_page.clickStepThroughOnboardingButton();  
	loginUI_page.clickOptionIDontKnowStep2WithoutReport();
	loginUI_page.clickMaleOptionWithoutReport();
	loginUI_page.clickEighteenOptionWithoutReport();
	loginUI_page.clickOneEightyFiveHeightOptionWithoutReport();
	loginUI_page.clickFortyWeightOptionWithoutReport();
	loginUI_page.clickVeganDietaryOptionWithoutReport();
	loginUI_page.clickIndianCuisineOptionWithoutReport();
    	
}

@When("User selects {string} option in step8")
public void user_selects_option_in_step7(String option) {
	switch(option) {
	case "yes":
	loginUI_page.clickYesToAllergicOptionWithoutReport();
		break ;	
	case "no":
		loginUI_page.clickNoToAllergicOptionWithoutReport();
		break ;		
	}
    
}

	
	@Then("User should see {string} for step for onboarding without report in step {int} checkbox  {string}")
	public void user_should_see_for_step_for_onboarding_without_report_in_step_checkbox(String expected, Integer int1, String scenario) {
		switch(scenario.trim()) {
		case "allergy options are displayed for yes in step 8":
		case "step 10 contains the list of other medical condition":
	        	
	        	helper.waitForAllVisibleElements(loginUI_page.getAllergyOptionsOnboardFormWithoutReportIndicatorElement());
	        	List<String> actualOptions = loginUI_page.getAllergyOptionsOnboardFormWithoutReportTexts();
	        	List<String> expectedList = Arrays.stream(expected.split(","))
	    	            .map(String::trim)
	    	            .collect(Collectors.toList());
	        	boolean allPresent = expectedList.stream()
	        		    .anyMatch(expectedText ->
	        		        actualOptions.stream()
	        		            .anyMatch(actualOption -> actualOption.toLowerCase().contains(expectedText.toLowerCase()))
	        		    );

	        		Assert.assertTrue(allPresent, "Expected text(s) not found: " + expectedList + "\nActual options: " + actualOptions);
	        		
	        break;		
	        		
	default:
	    throw new IllegalArgumentException("Unexpected scenario: " + scenario);
	}
}
//--------------------------------------------------------------------------------------------------------------------------------------------
@Given("User is in step9 Onboarding form without blood report")
public void user_is_in_step9_onboarding_form_without_blood_report() {
	loginUI_page.clickCreateAccountButton();
	loginUI_page.clickStepThroughOnboardingButton();  
	loginUI_page.clickOptionIDontKnowStep2WithoutReport();
	loginUI_page.clickMaleOptionWithoutReport();
	loginUI_page.clickEighteenOptionWithoutReport();
	loginUI_page.clickOneEightyFiveHeightOptionWithoutReport();
	loginUI_page.clickFortyWeightOptionWithoutReport();
	loginUI_page.clickVeganDietaryOptionWithoutReport();
	loginUI_page.clickIndianCuisineOptionWithoutReport();
	loginUI_page.clickYesToAllergicOptionWithoutReport();
	
    
}


@When("User selects continue after checking any {string} from allergy check box")
public void user_selects_continue_after_checking_any_from_allergy_check_box(String allergyoption) {
	
		
		WebElement allergyOptionsElement = loginUI_page.getOptionById(allergyoption);
		allergyOptionsElement.click(); 
		loginUI_page.clickcontinueButtonWithoutReport();
    
}


@When("User clicks continue in step")
public void user_clicks_continue_in_step() {
	loginUI_page.clickcontinueButtonWithoutReport();
    
}

@Then("User receives error message as {string}.")
public void user_receives_error_message_as(String expected) {
	
	String actual =loginUI_page.getErrorMsgWithoutReportWithoutReportText();
	Assert.assertEquals(actual.trim(), expected, "Error message not displayed");
    
}
//--------------------------------------------------------------------------------------------------------------------------------------------


@Given("User is in step10 Onboarding form without blood report")
public void user_is_in_step10_onboarding_form_without_blood_report() {
	loginUI_page.clickCreateAccountButton();
	loginUI_page.clickStepThroughOnboardingButton();  
	loginUI_page.clickOptionIDontKnowStep2WithoutReport();
	loginUI_page.clickMaleOptionWithoutReport();
	loginUI_page.clickEighteenOptionWithoutReport();
	loginUI_page.clickOneEightyFiveHeightOptionWithoutReport();
	loginUI_page.clickFortyWeightOptionWithoutReport();
	loginUI_page.clickVeganDietaryOptionWithoutReport();
	loginUI_page.clickIndianCuisineOptionWithoutReport();
	loginUI_page.clickYesToAllergicOptionWithoutReport();
	loginUI_page.clickShellFishOptionWithoutReport();
	loginUI_page.clickcontinueButtonWithoutReport();
	loginUI_page.clickHighBPOptionWithoutReport();
}

@When("User selects the following allergy options:")
public void user_selects_the_following_allergy_options(io.cucumber.datatable.DataTable dataTable) {
	List<String> optionIds = dataTable.asList();  

    for (String id : optionIds) {
        WebElement checkbox = loginUI_page.getCheckboxById(id);
        checkbox.click();
    }
}

@Then("User should see the following options selected:")
public void user_should_see_the_following_options_selected(io.cucumber.datatable.DataTable dataTable) {
	List<String> optionIds = dataTable.asList();
	for (String id : optionIds) {
        WebElement checkbox = loginUI_page.getCheckboxById(id);

        String state = checkbox.getDomAttribute("aria-checked");
        Assert.assertEquals(state, "true", "check box is not selected" +id);
	}
}
//--------------------------------------------------------------------------------------------------------------------------------------------
@Given("User is in step11 Onboarding form without blood report")
public void user_is_in_step11_onboarding_form_without_blood_report() {
	loginUI_page.clickCreateAccountButton();
	loginUI_page.clickStepThroughOnboardingButton();  
	loginUI_page.clickOptionIDontKnowStep2WithoutReport();
	loginUI_page.clickMaleOptionWithoutReport();
	loginUI_page.clickEighteenOptionWithoutReport();
	loginUI_page.clickOneEightyFiveHeightOptionWithoutReport();
	loginUI_page.clickFortyWeightOptionWithoutReport();
	loginUI_page.clickVeganDietaryOptionWithoutReport();
	loginUI_page.clickIndianCuisineOptionWithoutReport();
	loginUI_page.clickYesToAllergicOptionWithoutReport();
	loginUI_page.clickShellFishOptionWithoutReport();
	loginUI_page.clickcontinueButtonWithoutReport();
	loginUI_page.clickHighBPOptionWithoutReport();
	loginUI_page.clickcontinueButtonWithoutReport();
    
}

@When("User clicks {string} from the preferred intensity level")
public void user_clicks_from_the_preferred_intensity_level(String intensityLevel) {
	
	WebElement IntensityLevel = loginUI_page.getOptionByText(intensityLevel);
	IntensityLevel.click();
}

@Then("User should see {string} for step for onboarding without report in step {int} {string}")
public void user_should_see_for_step_for_onboarding_without_report_in_step(String expected, Integer int1, String scenario) {
    
	switch(scenario) {
	case "input field is displayed in step 12":
	String actual =loginUI_page.getHbA1cInputTextBoxWithoutReportText();
	 Assert.assertEquals(actual, expected, "Input field is not available with the expected text");
	 break;
	case "the text below the input field":
		String actualText =loginUI_page.getTextBelowHbA1cInputTextBoxWithoutReport();
		Assert.assertEquals(actualText, expected, "Input field is not available with the expected text");
		break;
	case "step 12 has continue button":
		Assert.assertTrue(loginUI_page.isStep12ContinueButtonWithoutReportVisible(),"Continue button is  not visible "); 
		break;		
}
}

@Then("User should see description as in {string} and {string}")
public void user_should_see_description_as_in_and(String Sheet, String TestCaseID) {
	Map<String, String> testData = ExcelReader.getTestData(Sheet, TestCaseID);
	String expected = testData.get("Expected").replaceAll("\\s+", " ").trim();
	String actual = helper.waitForVisibleElement(loginUI_page.getStep12DescWithoutReportIndicatorElement())
	                      .getText().replaceAll("\\s+", " ").trim();

	Assert.assertEquals(actual, expected, "Mismatch");
	    
}

//--------------------------------------------------------------------------------------------------------------------------------------------

@Given("User is in step12 Onboarding form without blood report")
public void user_is_in_step12_onboarding_form_without_blood_report() {
	loginUI_page.clickCreateAccountButton();
	loginUI_page.clickStepThroughOnboardingButton();  
	loginUI_page.clickOptionIDontKnowStep2WithoutReport();
	loginUI_page.clickMaleOptionWithoutReport();
	loginUI_page.clickEighteenOptionWithoutReport();
	loginUI_page.clickOneEightyFiveHeightOptionWithoutReport();
	loginUI_page.clickFortyWeightOptionWithoutReport();
	loginUI_page.clickVeganDietaryOptionWithoutReport();
	loginUI_page.clickIndianCuisineOptionWithoutReport();
	loginUI_page.clickYesToAllergicOptionWithoutReport();
	loginUI_page.clickShellFishOptionWithoutReport();
	loginUI_page.clickcontinueButtonWithoutReport();
	loginUI_page.clickHighBPOptionWithoutReport();
	loginUI_page.clickcontinueButtonWithoutReport();
	loginUI_page.clickEasyasyIntensityOptionStep2Onboard();
	
	
    
}

@When("User enters valid\\/invalid HbA1c value in the input field as in {string} and {string}")
public void user_enters_valid_invalid_hb_a1c_value_in_the_input_field_as_in_and(String Sheet, String TestCaseID) {
	Map<String, String> testData = ExcelReader.getTestData(Sheet, TestCaseID);
	String HbA1cValue = testData.get("HbA1c");
	loginUI_page.enterHbA1cInputTextBoxWithoutReport(HbA1cValue);
    
}

@Then("User should see see the input field does not accept value")
public void user_should_see_see_the_input_field_does_not_accept_value() {
	WebElement input = loginUI_page.getHbA1cInputFieldIndicatorElement(); 
	loginUI_page.clickTextBelowHbA1cInputTextBoxWithoutReport();
    String actualValue = input.getDomAttribute("value");
    Assert.assertTrue(actualValue.isEmpty(), " `input field rejects invalid value, but found: " + actualValue);
    
}
@Then("User should see User should see input field accept the value")
public void user_should_see_user_should_see_input_field_accept_the_value() {
	
	WebElement input = loginUI_page.getHbA1cInputFieldIndicatorElement();
	loginUI_page.clickTextBelowHbA1cInputTextBoxWithoutReport();
    String actualValue = input.getDomAttribute("value"); 
    Assert.assertNotNull(actualValue, "Input field value is null");
    Assert.assertFalse(actualValue.trim().isEmpty(), "Input field accepts valid value.");
    
}

@When("User enters valid HbA1c value in the input field as in {string} and {string} and clicks continue")
public void user_enters_valid_hb_a1c_value_in_the_input_field_as_in_and_and_clicks_continue(String Sheet, String TestCaseID) {
	Map<String, String> testData = ExcelReader.getTestData(Sheet, TestCaseID);
	String HbA1cValue = testData.get("HbA1c");
	loginUI_page.enterHbA1cInputTextBoxWithoutReport(HbA1cValue);
	loginUI_page.clickStep12ContinueButtonWithoutReport();
}



@Then("User should see {string} for  {string} for login")
public void user_should_see_for_for_login(String expected, String scenario) {
	
	switch(scenario) {
	case " user can proceed after entering a valid HbA1c value":
		String actual = loginUI_page.getMessageLastStepWithoutReport();
		Assert.assertEquals(actual,expected,"mismatch");
		break;
	case "personalization screen appears after clicking Continue":
		Assert.assertTrue(loginUI_page.isPogressBarWithoutReportVisible(),"Progress Bar is not visible "); 
		break;
	case "message in personalised screen":
		String actualTitle =loginUI_page.getMessagePersonalizedScreenWithoutReport();
		Assert.assertEquals(actualTitle,expected,"mismatch");
		break;
	case "subtext in personalised screen":
		String actualSubTitle =loginUI_page.getSubTitlePersonalizedScreenWithoutReport();
		Assert.assertEquals(actualSubTitle,expected,"mismatch");
		break;
	case "Upgrade to Plus screen is displayed after personalization loading":
		 helper.waitForVisibleElement(loginUI_page.getPpgradeToPremiumButtonIndicatorElement());
		Assert.assertTrue(loginUI_page.isUpgradeToPremiumButtonVisible(),"Upgrade to premium is not visible ");
	
	}
    
    
}







}












