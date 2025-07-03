package stepDefinitions;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import common.ConfigReader;
import common.ExcelReader;
import common.Helper;
import common.LoggerLoad;
import common.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LoginUI_Page;

public class LoginOnboardingScenariosWithBloodReport_Step {
	
	
	private TestContext context;
	private  LoginUI_Page loginUI_page;
	private Helper helper;
	String url = "https://sweet-balance-test-env-3-numpyninjadiabe.replit.app/blood-report-question";
	String url_Onboard = "https://sweet-balance-test-env-3-numpyninjadiabe.replit.app/onboarding-upload";
	String url_OnboardWithoutReport = "https://sweet-balance-test-env-3-numpyninjadiabe.replit.app/onboarding";
	
	public LoginOnboardingScenariosWithBloodReport_Step(TestContext context) {
	this.context = context;
    this.loginUI_page = context.getLoginUI_Page();
    this.helper = context.getHelper(); 
	}
	
	@Given("User is in upload blood report page")
	public void user_is_in_upload_blood_report_page() {
		
		 context.getDriver().get(url);
	}

	@When("User clicks on Upload Blood Report button")
	public void user_clicks_on_upload_blood_report_button() {
		loginUI_page.clickUploadBloodReportButton();
	}

	@Then("User should navigate to blood report modal")
	public void user_should_navigate_to_blood_report_modal() {
		 Assert.assertTrue(loginUI_page.isBloodReportModalPageVisible(),"Blood Report Modal Page is not visible");
	   
	}
	
	@When("User hovers over the upload box")
	public void user_hovers_over_the_upload_box() {
		loginUI_page.clickUploadBloodReportButton();
		loginUI_page.hoverOverUploadBox();
		
	}

	@Then("Upload box should show drag & drop interaction")
	public void upload_box_should_show_drag_drop_interaction() {
		 Assert.assertTrue(loginUI_page.isDragDropTextVisible(),"DragDropText is not visible");
		   
    
	}
//---------------------------------------------------------------------------------------------------------------------------------------------	
	@Given("User is in upload blood report page with {string} and {string}")
	public void user_is_in_upload_blood_report_page_with_and(String Sheet, String TestCaseID) {
		Map<String, String> testData = ExcelReader.getTestData(Sheet, TestCaseID);
		loginUI_page.clickLoginGutton();
		String email = testData.get("Email");
		loginUI_page.enterEmail(email);
		loginUI_page.clickContinueWithEmailButton();
		String fullname= testData.get("Fullname");
		String username = testData.get("Username");
		String password = testData.get("Password");
		loginUI_page.enterAllFieldsCompleteForm(fullname, username, password);
		loginUI_page.clickCheckbox();
		loginUI_page.clickCreateAccountButton();
	}

	@When("User tries to upload a non-PDF file")
	public void user_tries_to_upload_a_non_pdf_file() {
		loginUI_page.clickUploadBloodReportButton();
		loginUI_page.hoverOverUploadBox();
		String InvalidFile =  "/src/test/resources/testData/TextFile.txt";
		loginUI_page.uploadFile(System.getProperty("user.dir") + InvalidFile);
		loginUI_page.clickUploadAndProcessButton();
	   
	}
	
	
	@Then("User should see {string} error")
	public void user_should_see_error(String expected) {
		String actual = loginUI_page.getUploadAndProcessErrorText();
		Assert.assertEquals(actual.trim(), expected.trim(), "Text mismatch:\nExpected: " + expected + "\nActual: " + actual);
	    
	}

	@When("User uploads a PDF file over 10MB")
	public void user_uploads_a_pdf_file_over_10mb() {
		loginUI_page.clickUploadBloodReportButton();
		loginUI_page.hoverOverUploadBox();
		String File =  "/src/test/resources/testData/PDFOver10MB.pdf";
		loginUI_page.uploadFile(System.getProperty("user.dir") + File);
		loginUI_page.clickUploadAndProcessButton();
	   
	}
	

	@When("User uploads valid PDF file")
	public void user_uploads_valid_pdf_file() {
		loginUI_page.clickUploadBloodReportButton();
		loginUI_page.hoverOverUploadBox();
		String File =  "/src/test/resources/testData/ValidPdf.pdf";
		loginUI_page.uploadFile(System.getProperty("user.dir") + File);
		loginUI_page.clickUploadAndProcessButton();
		System.out.println(context.driver.getPageSource());
	    
	}

	@Then("User should see processing percentage bar")
	public void user_should_see_processing_percentage_bar() {
		Assert.assertTrue(loginUI_page.isProgressBarVisible(), "ProgressBar is not Visible");
	   
	}
	
	@When("User clicks Cancel")
	public void user_clicks_cancel() {
		loginUI_page.clickUploadBloodReportButton();
		loginUI_page.clickCancelUploadButton();
	    
	}

	@Then("Modal should be closed and user returned to previous screen")
	public void modal_should_be_closed_and_user_returned_to_previous_screen() {
		Assert.assertTrue(loginUI_page.isUploadBloodReportButtonVisible(),"Page is not Navigated back");
	}
	
	@Then("User should see Report analysis")
	public void user_should_see_report_analysis() {
		Assert.assertTrue(loginUI_page.isReportAnalysisReportVisible(),"Report Analysis Report is not visible");
	}
	
	@Then("User should see onboarding button")
	public void user_should_see_onboarding_button() {
		Assert.assertTrue(loginUI_page.isContToOnboardingButtontVisible(),"Continue To Onboarding Button is not visible");	
	}
	
	@Then("User should see the following sections:")
	public void user_should_see_the_following_sections(io.cucumber.datatable.DataTable dataTable) {
		List<String> sections = dataTable.asList();

	    for (String section : sections) {
	        boolean visible = loginUI_page.isSectionVisible(section);
	        Assert.assertTrue(visible);
	    }
	}
	   
	

//--------------------------------------------------------------------------------------------------------------------------------------------------
	@Given("User is in Onboarding Process after clicking Onboarding button")
	public void user_is_in_onboarding_process_after_clicking_onboarding_button() {
		context.getDriver().get(url_Onboard);
	}

	@Then("User should see text field for Age, height , weight")
	public void user_should_see_text_field_for_age_height_weight() {
		List<String> expected = Arrays.asList("Enter your age", "Enter height in cm (1-300)", "Enter weight in kg (1-500)");
		List<String> actual = loginUI_page.getAllTextFieldPlaceholdersOrLabels();
		System.out.println("Actual: " + actual);

		boolean allPresent = expected.stream()
		        .allMatch(exp -> actual.stream()
		                .anyMatch(act -> act.equalsIgnoreCase(exp)));

		Assert.assertTrue(allPresent, 
		        "Expected fields not found, Expected: " + expected + "\nActual: " + actual);

	    
	}
	@Then("User should see dropdown option for Gender field")
	public void user_should_see_dropdown_option_for_gender_field() {
		Assert.assertTrue(loginUI_page.isGenderDropBoxVisible(), "Gender drop box is not visible ");
	   
	}
	
	@Then("User should see Male , female, prefer not to say  options in dropdown")
	public void user_should_see_male_female_prefer_not_to_say_options_in_dropdown() {
		List<String> expected = Arrays.asList("Male", "Female", "Prefer Not to Say");
		List<String> actual = loginUI_page.getDropDownList(); 

		boolean allPresent = expected.stream()
		        .allMatch(exp -> actual.stream()
		                .anyMatch(act -> act.equalsIgnoreCase(exp)));

		Assert.assertTrue(allPresent,"Expected gender options not found.\nExpected: " + expected + "\nActual: " + actual);

	}
	
	@Then("User should see Step {int} of {int}")
	public void user_should_see_step_of(Integer int1, Integer int2) {
		Assert.assertTrue(loginUI_page.isStepNumVisible(),"Step number is not visible ");
			
	}
	
	@Then("User should see Progress Bar")
	public void user_should_see_progress_bar() {
		Assert.assertTrue(loginUI_page.isProgressBarOnboardVisible(),"Progress Bar is not visible ");
	}
		

	@Then("User should see enabled Continue button")
	public void user_should_see_enabled_continue_button() {
		Assert.assertTrue(loginUI_page.isContinueWithEmailButtonEnabled(),"Continue button is not enabled ");	
	}
	
	@When("User enters all {string} values with {string} and {string} and clickd continue")
	public void user_enters_all_values_with_and_and_clickd_continue(String validorinvalid, String Sheet, String TestCaseID) {
		Map<String, String> testData = ExcelReader.getTestData(Sheet, TestCaseID);
		String age= testData.get("Age");
		String height = testData.get("Height");
		String weight = testData.get("Weight");
		String gender = testData.get("Gender");
		loginUI_page.enterAllFieldsOnboardWithRecordForm(age, height, weight);
		loginUI_page.clickGenderDropBox();
		loginUI_page.selectGender(gender);
		loginUI_page.clickContinueWithEmailButton();
	}
	

	@Then("User should see User should move to {string} as")
	public void user_should_see_user_should_move_to_as(String expected) {
		String actual = loginUI_page.getTextStepNum();
		LoggerLoad.info(actual);
		 Assert.assertEquals(actual, expected, "Mismatch");
	}
	
	@Then("User should see error message if form have invalid values as")
	public void user_should_see_error_message_if_form_have_invalid_values_as() {
		
		Assert.assertTrue(loginUI_page.isErrorMessageOnboardFormVisible(),"Error message is  not visible ");
	}
	
	
	@Given("User is in step1 for Onboarding process")
	public void user_is_in_step1_for_onboarding_process() {
		context.getDriver().get(url_Onboard);
		
	}
	
	@Then("User should see {string} as {string}")
	public void user_should_see_as(String expected, String Case) {
		 String actualText;
		switch (Case.trim()) {
        case "Display Title":
            actualText = loginUI_page.getCurrentHeadingOnboardForm();
            Assert.assertEquals(actualText.trim(), expected.trim(),"Mismatch");
            break;

        case "Sub Title":
        	 actualText = loginUI_page.getCurrentSubHeadingOnboardForm();
             Assert.assertEquals(actualText.trim(), expected.trim(),"Mismatch");      
            break;
        case "Back button":
       	Assert.assertTrue(loginUI_page.isBackButtonOnboardFormVisible(),"Back button is  not visible ");     
           break;
           
        case "step2of5":
        	String actual = loginUI_page.getTextStepNum();
    		 Assert.assertEquals(actual, expected, "Mismatch");     
               break;
               
        case "Intensity Options":
        	List<String> expectedList = Arrays.stream(expected.split(","))
            .map(String::trim)
            .collect(Collectors.toList());

        List<String> actualOptions = loginUI_page.getOptions2and3OnboardFormTexts()
            .stream()
            .map(text -> text.split(" ")[0].trim()) //this is to remove the symbol emoji for comparing 
            .collect(Collectors.toList());

        boolean allPresent = expectedList.stream()
            .allMatch(exp -> actualOptions.stream()
                .anyMatch(act -> act.equalsIgnoreCase(exp)));

        Assert.assertTrue(allPresent, "Expected: " + expectedList + "\nActual: " + actualOptions);
             break;                 

        default:
            throw new IllegalArgumentException("Unexpected expected text: " + expected);
    }
		
	}
	
	@Given("User is in step2 for onboarding process after entering values with {string} and {string}")
	public void user_is_in_step2_for_onboarding_process_after_entering_values_with_and(String Sheet, String TestCaseID) {
		context.getDriver().get(url_Onboard);
		Map<String, String> testData = ExcelReader.getTestData(Sheet, TestCaseID);
		String age= testData.get("Age");
		String height = testData.get("Height");
		String weight = testData.get("Weight");
		String gender = testData.get("Gender");
		loginUI_page.enterAllFieldsOnboardWithRecordForm(age, height, weight);
		loginUI_page.clickGenderDropBox();
		loginUI_page.selectGender(gender);
		loginUI_page.clickContinueWithEmailButton();
	}
	
	@When("User selects oneoption from intensity")
	public void user_selects_oneoption_from_intensity() {
		loginUI_page.clickEasyasyIntensityOptionStep2Onboard();
	 }

	@Then("User should see {string} to verify {string}")
	public void user_should_see_to_verify(String expected, String scenario) {
	    switch (scenario) {
	        case "option selection in step2":
	        case "option is selectable":
	        case "Progress bar reflects Step 3 of 5":
	        case "Progress bar reflects Step 4 of 5":
	        case "Progress bar reflects Step 5 of 5":
	        case "navigation to step for onboarding":	
	            helper.waitForVisibleElement(loginUI_page.getStepIndicatorElement());
	            String actual = loginUI_page.getTextStepNum();
	            Assert.assertEquals(actual.trim(), expected, "Mismatch in step transition");
	            break;

	        case "Step3 heading is visible":
	        case "Step 4 heading is visible":
	        case "Step 5 heading is visible":
	        	helper.waitForVisibleElement(loginUI_page.getTitleIndicatorElement());
	            String actualText = loginUI_page.getCurrentHeadingOnboardForm();
	            Assert.assertEquals(actualText.trim(), expected, "Mismatch in step transition");
	            break;

	        case "Step3 sub text":
	        case "Verify step 4 sub text":	
	        case "Verify step 5 sub text":
	        	helper.waitForVisibleElement(loginUI_page.getSubTitleIndicatorElement());
	            String actualSubText = loginUI_page.getCurrentSubHeadingOnboardForm();
	            Assert.assertEquals(actualSubText.trim(), expected, "Mismatch in step transition");
	            break;
	            	               
	        case "Back button is visible":
	           	Assert.assertTrue(loginUI_page.isBackButtonOnboardFormVisible(),"Back button is  not visible ");     
	               break;
	               
	        case "options is displayed":
	       	
	        	List<String> expectedList = Arrays.stream(expected.split(","))
	            .map(String::trim)
	            .collect(Collectors.toList());
	        	
	        	helper.waitForAllVisibleElements(loginUI_page.getOptions2and3IndicatorElement());
	        List<String> actualOptions = loginUI_page.getOptions2and3OnboardFormTexts()
	            .stream()
	            .map(text -> text.split(" ")[0].trim()) 
	            .collect(Collectors.toList());

	        boolean allPresent = expectedList.stream()
	            .allMatch(exp -> actualOptions.stream()
	                .anyMatch(act -> act.equalsIgnoreCase(exp)));

	        Assert.assertTrue(allPresent, "Expected: " + expectedList + "\nActual: " + actualOptions);
	             break;                

	        default:
	            throw new IllegalArgumentException("Unexpected scenario: " + scenario);
	    }
	}

	@When("clicks back button")
	public void clicks_back_button() {
		loginUI_page.clickBackButtonOnboardform();
	    
	}

	@Then("User Should navigate back to previous step {string}")
	public void user_should_navigate_back_to_previous_step(String expected) {
		String actual = loginUI_page.getTextStepNum();
        Assert.assertEquals(actual.trim(), expected, "Mismatch in step transition");
	}
	
	@Given("User is in step3 for onboarding process after entering values with {string} and {string}")
	public void user_is_in_step3_for_onboarding_process_after_entering_values_with_and(String Sheet, String TestCaseID) {
		context.getDriver().get(url_Onboard);
		Map<String, String> testData = ExcelReader.getTestData(Sheet, TestCaseID);
		String age= testData.get("Age");
		String height = testData.get("Height");
		String weight = testData.get("Weight");
		String gender = testData.get("Gender");
		loginUI_page.enterAllFieldsOnboardWithRecordForm(age, height, weight);
		loginUI_page.clickGenderDropBox();
		loginUI_page.selectGender(gender);
		loginUI_page.clickContinueWithEmailButton();
		loginUI_page.clickEasyasyIntensityOptionStep2Onboard();
	}

	@When("User selects dietary preference")
	public void user_selects_dietary_preference() {
		
		loginUI_page.clickVeganDietaryOptionStep3Onboard();
	    
	}
	    	
	@Then("User should see {string} options")
	public void user_should_see_options(String expected) {
		List<String> expectedList = Arrays.stream(expected.split(","))
	            .map(String::trim)
	            .collect(Collectors.toList());
	        	
	        	helper.waitForAllVisibleElements(loginUI_page.getOptions4and5IndicatorElement());
	        List<String> actualOptions = loginUI_page.getOptions4and5OnboardFormTexts()
	            .stream()
	            .map(text -> text.split(" ")[0].trim()) 
	            .collect(Collectors.toList());

	        boolean allPresent = expectedList.stream()
	            .allMatch(exp -> actualOptions.stream()
	                .anyMatch(act -> act.equalsIgnoreCase(exp)));

	        Assert.assertTrue(allPresent, "Expected: " + expectedList + "\nActual: " + actualOptions);
	                          
	    
	}
	        
	
	@Given("User is in step4 for onboarding process after entering values with {string} and {string}")
	public void user_is_in_step4_for_onboarding_process_after_entering_values_with_and(String Sheet, String TestCaseID) {
		context.getDriver().get(url_Onboard);
		Map<String, String> testData = ExcelReader.getTestData(Sheet, TestCaseID);
		String age= testData.get("Age");
		String height = testData.get("Height");
		String weight = testData.get("Weight");
		String gender = testData.get("Gender");
		loginUI_page.enterAllFieldsOnboardWithRecordForm(age, height, weight);
		loginUI_page.clickGenderDropBox();
		loginUI_page.selectGender(gender);
		loginUI_page.clickContinueWithEmailButton();
		loginUI_page.clickEasyasyIntensityOptionStep2Onboard();
		loginUI_page.clickVeganDietaryOptionStep3Onboard();
	}

	
	@When("User selects food passport")
	public void user_selects_food_passport() {
		loginUI_page.clickIndianFoodStep4OnboardStep3Onboard();
	    
	}
	@Then("User should see Submit button")
	public void user_should_see_submit_button() {
		Assert.assertTrue(loginUI_page.isContinueWithEmailButtonEnabled(),"Submit button is not visible ");
	    
	}
	@Then("User should see check box in all options")
	public void user_should_see_check_box_in_all_options() {
		List<WebElement> options = loginUI_page.getOptions4and5OnboardForm();

	    for (WebElement option : options) {
	        WebElement checkbox = option.findElement(By.xpath("//input[@type='checkbox']"));
	        Assert.assertTrue(checkbox.isDisplayed(), "Checkbox not visible for option: " + option.getText());
	        System.out.println("Checkbox is visible for option: " + option.getText());
	    }
	}
	
	@Given("User is in step5 for onboarding process after entering values with {string} and {string}")
	public void user_is_in_step5_for_onboarding_process_after_entering_values_with_and(String Sheet, String TestCaseID) {
		Map<String, String> testData = ExcelReader.getTestData(Sheet, TestCaseID);
		loginUI_page.clickLoginGutton();
		String email = testData.get("Email");
		loginUI_page.enterEmail(email);
		loginUI_page.clickContinueWithEmailButton();
		String fullname= testData.get("Fullname");
		String username = testData.get("Username");
		String password = testData.get("Password");
		loginUI_page.enterAllFieldsCompleteForm(fullname, username, password);
		loginUI_page.clickCheckbox();
		loginUI_page.clickCreateAccountButton();
		loginUI_page.clickUploadBloodReportButton();
		loginUI_page.hoverOverUploadBox();
		String filePath = Paths.get("src", "test", "resources", "testData", "ValidPdf.pdf")
                .toAbsolutePath()
                .toString();
		loginUI_page.uploadFile(filePath);
		loginUI_page.clickUploadAndProcessButton();
		loginUI_page.clickContinueOnboargingButton();
		String height = testData.get("Height");
		String weight = testData.get("Weight");
		loginUI_page.enterHeightandWeightFieldsOnboardWithRecordForm(height, weight);
		loginUI_page.clickContinueWithEmailButton();
		loginUI_page.clickEasyasyIntensityOptionStep2Onboard();
		loginUI_page.clickVeganDietaryOptionStep3Onboard();
		loginUI_page.clickIndianFoodStep4OnboardStep3Onboard();
	}
	
	@When("User selects single allergy and clicks submit")
	public void user_selects_single_allergy_and_clicks_submit() {
		loginUI_page.clickGlutenCheckBoxStep5Onboard();
		loginUI_page.clickContinueWithEmailButton();
	    
	}

	@Then("User should navigate to subscription details")
	public void user_should_navigate_to_subscription_details() {
		Assert.assertTrue(loginUI_page.isSubscriptionPageTitleDisplayed(),"Subscription Page is  not visible ");
			    
	}
	@When("User selects multipleple allergy and clicks submit")
	public void user_selects_multipleple_allergy_and_clicks_submit() {
		loginUI_page.clickGlutenCheckBoxStep5Onboard();
		loginUI_page.clickDairyCheckBoxStep5Onboard();
		loginUI_page.clickContinueWithEmailButton();
	    
	}
//--------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Onboarding Scenarios without blood report
	


	
	    
	
	
	
	
	
		
		}
	    
	

	
	
	
