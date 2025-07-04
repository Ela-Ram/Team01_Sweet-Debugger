package stepDefinitions;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
	
//-----------------------------------------------------------------------------------------------------------------------------------------------
	
	@Given("User is in upload blood report page after entering values with Blood Report")
	public void user_is_in_upload_blood_report_page_after_entering_values_with_blood_report() {
		loginUI_page.clickCreateAccountButton();
	    
	}
	
	@When("user uploads {string} file")
	public void user_uploads_file(String validORInvalid) {
		
		helper.waitForVisibleElement(loginUI_page.clickUploadBloodReportButtonIndicatorElement());
		loginUI_page.clickUploadBloodReportButton();
		Path filePath = null;
		switch (validORInvalid) {
	    case "Invalid file Text or Excel":
	        filePath = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "testData", "TextFile.txt");
	        break;

	    case "Invalid pdf over 10mb":
	        filePath = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "testData", "PDFOver10MB.pdf");
	        break;

	    case "Valid pdf file":
	        filePath = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "testData", "ValidPdf.pdf");
	        break;

	    default:
	        throw new IllegalArgumentException("Unexpected value: " + validORInvalid);
	}

	loginUI_page.uploadFile(filePath.toAbsolutePath().toString());
	loginUI_page.clickUploadAndProcessButton();
	    
	}

	@Then("User should see {string} in blood report upload modal")
	public void user_should_see_in_blood_report_upload_modal(String expected) {
		
		switch(expected) {
		case "Only PDF files are supported":
		case "File exceeds 10MB":	
			String actual = loginUI_page.getUploadAndProcessErrorText();
			Assert.assertEquals(actual.trim(), expected.trim(), "Text mismatch:\nExpected: " + expected + "\nActual: " + actual);
			break;
		case "processing percentage bar":
			Assert.assertTrue(loginUI_page.isProgressBarVisible(), "ProgressBar is not Visible");
			break;
		case "Upload & Process button enabled":
			
		    Assert.assertTrue(loginUI_page.isUploadAndProcessButtonEnabled(), "Upload And Process Button is not Enabled");
		    break;	
		case "Report analysis":
			Assert.assertTrue(loginUI_page.isReportAnalysisReportVisible(),"Report Analysis Report is not visible");
			break;
		case "onboarding button":
			Assert.assertTrue(loginUI_page.isContToOnboardingButtontVisible(),"Continue To Onboarding Button is not visible");
			break;
			
		default:
	        throw new IllegalArgumentException("Unexpected value: " + expected);
			
		}
	    
	}

	@When("user just uploads Valid pdf file file")
	public void user_just_uploads_valid_pdf_file_file() {
		helper.waitForVisibleElement(loginUI_page.clickUploadBloodReportButtonIndicatorElement());
		loginUI_page.clickUploadBloodReportButton();
		loginUI_page.hoverOverUploadBox();
		Path filePath = null;
		 filePath = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "testData", "ValidPdf.pdf");
		 loginUI_page.uploadFile(filePath.toAbsolutePath().toString());
		
	    
	}

	@When("User clicks Cancel in upload blood report page")
	public void user_clicks_cancel_in_upload_report_page() {
		loginUI_page.clickUploadBloodReportButton();
		loginUI_page.clickCancelUploadButton();
	    
	}

	@Then("Modal should be closed and user returned to previous screen")
	public void modal_should_be_closed_and_user_returned_to_previous_screen() {
		Assert.assertTrue(loginUI_page.isUploadBloodReportButtonVisible(),"Page is not Navigated back");
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

	
	@Given("User is on report analysis")
	public void user_is_on_report_analysis() {
		loginUI_page.clickCreateAccountButton();
		helper.waitForVisibleElement(loginUI_page.clickUploadBloodReportButtonIndicatorElement());
		loginUI_page.clickUploadBloodReportButton();
		Path filePath = null;
		filePath = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "testData", "ValidPdf.pdf");
		 loginUI_page.uploadFile(filePath.toAbsolutePath().toString());
		 loginUI_page.clickUploadAndProcessButton();
		    
		
	    
	}

	@When("User clicks Onboarding button")
	public void user_clicks_onboarding_button() {
		
		loginUI_page.scrollToAndClickContinueOnboardingButton();
		
	    
	}
	
	
	@Given("User is on report analysis page in onboarding scenarios with report Login")
	public void user_is_on_report_analysis_page_in_onboarding_scenarios_with_report_login() {
		loginUI_page.clickCreateAccountButton();
		helper.waitForVisibleElement(loginUI_page.clickUploadBloodReportButtonIndicatorElement());
		loginUI_page.clickUploadBloodReportButton();
		Path filePath = null;
		filePath = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "testData", "ValidPdf.pdf");
		 loginUI_page.uploadFile(filePath.toAbsolutePath().toString());
		 loginUI_page.clickUploadAndProcessButton();
		 loginUI_page.scrollToAndClickContinueOnboardingButton();
	    
	}
	
	@When("User enters all {string} values with {string} and {string} and clickd continue Login")
	public void user_enters_all_values_with_and_and_clickd_continue_login(String validorinvalid, String Sheet, String TestCaseID) {
		Map<String, String> testData = ExcelReader.getTestData(Sheet, TestCaseID);
		String height = testData.get("Height");
		String weight = testData.get("Weight");
		loginUI_page.enterHeightandWeightFieldsOnboardWithRecordForm(height, weight);
		loginUI_page.clickContinueWithReport();
	  
	}
	

	
//--------------------------------------------------------------------------------------------------------------------------------------------	
//this methos is main
		

	@Then("User should see {string} for step for onboarding with Blood report {string}")
	public void user_should_see_for_step_for_onboarding_with_blood_report(String expected, String scenario)  {
		
		switch(scenario) {
		
		case "presence of text field":
		
			
			List<String> actualOptions = loginUI_page.getAllTextFieldPlaceholdersOrLabels();
			System.out.println("Actual: " + actualOptions);
			loginUI_page.assertExpectedItemsPresent(actualOptions, expected, "Teext field is not present");
            break;
	
        		
		case "presence of dropdown":
			Assert.assertTrue(loginUI_page.isGenderDropBoxVisible(), "Gender drop box is not visible ");
			break;
			
		case "dropdown text for gender":	
		
			List<String> actual = loginUI_page.getDropDownList(); 
			System.out.println("Actual: " + actual);
			loginUI_page.assertExpectedItemsPresent(actual, expected, "Gender Dropdown is not present");			
        		break;
        		
		case "presence of all 3 intensity options":
		case "Verify options is displayed in step 2":
		case "Verify options is displayed in step 3":
		case "Verify options is displayed in step 4":

		    WebElement headingElement;
		    List<String> actualOptionsList;

		    if (expected.equals("presence of all 3 intensity options") || expected.equals("Verify options is displayed in step 2")) {
		        headingElement = loginUI_page.fluentWaitForAnyVisibleElement(loginUI_page.getOptions2and3IndicatorElement());

		        if (headingElement != null) {
		            actualOptionsList = loginUI_page.getOptions2and3OnboardFormTexts();
		            System.out.println("Actual: " + actualOptionsList);
		            loginUI_page.assertExpectedItemsPresent(actualOptionsList, expected, "option is not present");
		        } else {
		            Assert.fail("No  option became visible within wait time");
		        }

		    } else {
		        headingElement = loginUI_page.fluentWaitForAnyVisibleElement(loginUI_page.getOptions4and5IndicatorElement());

		        if (headingElement != null) {
		            actualOptionsList = loginUI_page.getOptions4and5OnboardFormTexts();
		            System.out.println("Actual: " + actualOptionsList);
		            loginUI_page.assertExpectedItemsPresent(actualOptionsList, expected, "option is not present");
		        } else {
		            Assert.fail("No  option became visible within wait time");
		        }
		    }

		    break;
	
		case "progress shows 1 of 5 steps":
		case "navigation for step 1 onboarding":
		case "option selection in step 2":
		case "Progress bar reflects Step 3 of 5":
		case "option selection in step 3":
		case "Progress bar reflects Step 4 of 5":	
		case "option selection in step 4":
		case "Progress bar reflects Step 5 of 5":
		case "Nav back step3":
		case "Nav back step2":
		case "Nav back step4":
		case "Nav back step5":
		
			WebElement stepElement = loginUI_page.fluentWaitForVisibleElement(loginUI_page.getStepIndicatorElement());
			String actualStep = stepElement.getText();
			LoggerLoad.info(actualStep);
			 Assert.assertEquals(actualStep, expected, "Mismatch in step number");
			break;
						
			
		case "progress bar is visible":
			Assert.assertTrue(loginUI_page.isProgressBarOnboardVisible(),"Progress Bar is not visible ");
			break;
			
		case "presence of continue button":
			Assert.assertTrue(loginUI_page.isContinueWithEmailButtonEnabled(),"Continue button is not enabled ");
			break;
			
		case "step 1 progress is highlighted":
		case "Step 2 progress bar is filled":	
			
			
			Assert.assertTrue(loginUI_page.isProgressBarWithReportHighlighted(),"Not Highlighted "); 
            break;	
            
		case "error message for invalid input":
			WebElement input = loginUI_page.heightOnboardFormIndicatorElement();
			String actualValue = input.getDomAttribute("type");
		    Assert.assertEquals(actualValue,"number", " `input field rejects invalid value, but found: " + actualValue);
			break;
			
		case "Step 2 heading is visible":
		case "Step 3 heading is visible":
		case "Step 4 heading is visible":
		case "Step 5 heading is visible":
			
			
			loginUI_page.waitForTextInElement(loginUI_page.getTitleIndicatorElement(), expected);
			String actualTitle = loginUI_page.getCurrentHeadingOnboardForm();
			String actualHeading = loginUI_page.getCurrentHeadingOnboardForm();
			Assert.assertEquals(actualHeading.trim(), expected.trim(), "Mismatch in step heading");

		   Assert.assertEquals(actualTitle.trim(), expected.trim(), "Mismatch");
		    break;
            
		case "Step 2 subtitle is visible":
		case "Step 3 subtitle is visible":
		case "Step 4 subtitle is visible":	
		case "Step 5 subtitle is visible":
			
			loginUI_page.waitForTextInElement(loginUI_page.getSubTitleIndicatorElement(), expected);
			String actualSubTitle = loginUI_page.getCurrentSubHeadingOnboardForm();
            Assert.assertEquals(actualSubTitle.trim(), expected.trim(),"Mismatch");      
           break;
           
		case "Back button is visible":
			Assert.assertTrue(loginUI_page.isBackButtonOnboardFormVisible(),"Back button is  not visible ");     
	           break;
			
			
			
		default:
	        throw new IllegalArgumentException("Unexpected value: " + expected);
			
		}
	    
	}

//---------------------------------------------------------------------------------------------------------------------------------------------
	
	//Feature 4:
	
	@Given("User is in step1 for onboarding process {string} and {string} for login module")
	public void user_is_in_step1_for_onboarding_process_and_for_login_module(String Sheet, String TestCaseID) {
		
		loginUI_page.clickCreateAccountButton();
		helper.waitForVisibleElement(loginUI_page.clickUploadBloodReportButtonIndicatorElement());
		loginUI_page.clickUploadBloodReportButton();
		Path filePath = null;
		filePath = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "testData", "ValidPdf.pdf");
		 loginUI_page.uploadFile(filePath.toAbsolutePath().toString());
		 loginUI_page.clickUploadAndProcessButton();
		 loginUI_page.clickClosePopPupMessageOnboardngWithReport();
		 loginUI_page.scrollToAndClickContinueOnboardingButton();
		 Map<String, String> testData = ExcelReader.getTestData(Sheet, TestCaseID);
			String height = testData.get("Height");
			String weight = testData.get("Weight");
			loginUI_page.enterHeightandWeightFieldsOnboardWithRecordForm(height, weight);
			
	    
	}

	@When("User clicks continue after filling form for login module")
	public void user_clicks_continue_after_filling_form_for_login_module() {
		loginUI_page.clickContinueWithReport();
	}
	
//------------------------------------------------------------------------------------------------------------------------------------------------	

	@Given("User is in step2 for onboarding process {string} and {string} for login module")
	public void user_is_in_step2_for_onboarding_process_and_for_login_module(String Sheet, String TestCaseID) {
		loginUI_page.clickCreateAccountButton();
		helper.waitForVisibleElement(loginUI_page.clickUploadBloodReportButtonIndicatorElement());
		loginUI_page.clickUploadBloodReportButton();
		Path filePath = null;
		filePath = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "testData", "ValidPdf.pdf");
		 loginUI_page.uploadFile(filePath.toAbsolutePath().toString());
		 loginUI_page.clickUploadAndProcessButton();
		 loginUI_page.scrollToAndClickContinueOnboardingButton();
		 Map<String, String> testData = ExcelReader.getTestData(Sheet, TestCaseID);
			String height = testData.get("Height");
			String weight = testData.get("Weight");
			loginUI_page.enterHeightandWeightFieldsOnboardWithRecordForm(height, weight);
			loginUI_page.clickContinueWithReport();
	}
	
	
//---------------------------------------------------------------------------------------------------------------------------------------------
	@Given("User is in step3 for onboarding process {string} and {string} for login module")
	public void user_is_in_step3_for_onboarding_process_and_for_login_module(String Sheet, String TestCaseID) {
		loginUI_page.clickCreateAccountButton();
		helper.waitForVisibleElement(loginUI_page.clickUploadBloodReportButtonIndicatorElement());
		loginUI_page.clickUploadBloodReportButton();
		Path filePath = null;
		filePath = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "testData", "ValidPdf.pdf");
		 loginUI_page.uploadFile(filePath.toAbsolutePath().toString());
		 loginUI_page.clickUploadAndProcessButton();
		 loginUI_page.scrollToAndClickContinueOnboardingButton();
		 Map<String, String> testData = ExcelReader.getTestData(Sheet, TestCaseID);
			String height = testData.get("Height");
			String weight = testData.get("Weight");
			loginUI_page.enterHeightandWeightFieldsOnboardWithRecordForm(height, weight);
			loginUI_page.clickContinueWithReport();
			loginUI_page.clickEasyasyIntensityOptionStep2Onboard();
	}	

//------------------------------------------------------------------------------------------------------------------------------------------------	
	
	
	@Given("User is in step4 for onboarding process {string} and {string} for login module")
	public void user_is_in_step4_for_onboarding_process_and_for_login_module(String Sheet, String TestCaseID) {
		loginUI_page.clickCreateAccountButton();
		helper.waitForVisibleElement(loginUI_page.clickUploadBloodReportButtonIndicatorElement());
		loginUI_page.clickUploadBloodReportButton();
		Path filePath = null;
		filePath = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "testData", "ValidPdf.pdf");
		 loginUI_page.uploadFile(filePath.toAbsolutePath().toString());
		 loginUI_page.clickUploadAndProcessButton();
		 loginUI_page.scrollToAndClickContinueOnboardingButton();
		 Map<String, String> testData = ExcelReader.getTestData(Sheet, TestCaseID);
			String height = testData.get("Height");
			String weight = testData.get("Weight");
			loginUI_page.enterHeightandWeightFieldsOnboardWithRecordForm(height, weight);
			loginUI_page.clickContinueWithReport();
			loginUI_page.clickEasyasyIntensityOptionStep2Onboard();
			loginUI_page.clickVeganDietaryOptionStep3Onboard();
	    
	}
	    	
	@When("User clicks back button in step in with blood report")
	public void user_clicks_back_button_in_step_in_with_blood_report() {
		loginUI_page.clickBackButtonWithReport();
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
	
	
	@Given("User is in step5 for onboarding process {string} and {string} for login module")
	public void user_is_in_step5_for_onboarding_process_and_for_login_module(String Sheet, String TestCaseID) {
		loginUI_page.clickCreateAccountButton();
		helper.waitForVisibleElement(loginUI_page.clickUploadBloodReportButtonIndicatorElement());
		loginUI_page.clickUploadBloodReportButton();
		Path filePath = null;
		filePath = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "testData", "ValidPdf.pdf");
		 loginUI_page.uploadFile(filePath.toAbsolutePath().toString());
		 loginUI_page.clickUploadAndProcessButton();
		 loginUI_page.scrollToAndClickContinueOnboardingButton();
		 Map<String, String> testData = ExcelReader.getTestData(Sheet, TestCaseID);
			String height = testData.get("Height");
			String weight = testData.get("Weight");
			loginUI_page.enterHeightandWeightFieldsOnboardWithRecordForm(height, weight);
			loginUI_page.clickContinueWithReport();
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
		helper.waitForVisibleElement(loginUI_page.getSubscriptionPageTitleDisplayedIndicatorElement());
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
	    
	

	
	
	
