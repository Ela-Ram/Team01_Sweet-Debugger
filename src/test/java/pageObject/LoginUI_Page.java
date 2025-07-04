package pageObject;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import common.Helper;
import common.TestContext;

public class LoginUI_Page {
	
	 private JavascriptExecutor jsExecutor;
	 private WebDriver driver;
	 private Helper helper;
	 WebDriverWait wait;
	 
	 
	 @FindBy(xpath = "//div[@class='flex space-x-4']") WebElement loginButton;
	 @FindBy(xpath = "//div[@class='space-y-6']/*") List<WebElement> loginTexts;
	 @FindBy(xpath = "//div[@id='root']/div/div/button") WebElement closeButton;
	 @FindBy(id= ":r0:-form-item")WebElement emailField;
	 @FindBy(xpath = "//button[@type='submit']") WebElement continueWithEmailButton;
	 @FindBy(xpath = "//div[@class='space-y-2']/h2") WebElement completeYourProfileText;
	 @FindBy(id= ":r0:-form-item-message")WebElement emailErrorText;
	 @FindBy(xpath = "//input[@name='password']") WebElement passwordField;
	 @FindBy(xpath = "//div[@class='text-center space-y-2']/p[2]") WebElement emailSubText;
	 @FindBy(xpath = "//button[@type='button']") WebElement forgotPasswordlink;
	 @FindBy(xpath = "//div[@class='flex flex-col space-y-1.5 p-6']/h3") WebElement homePageText;
	 @FindBy(id= ":r7:-form-item")WebElement fullNameField; 
	 @FindBy(id= ":r8:-form-item")WebElement userNameField;
	 @FindBy(id= "terms")WebElement checkBox;
	 @FindBy(xpath = "//div[@class='space-y-6']/form/button") WebElement createAccountButton;
	 @FindBy(id= ":r8:-form-item-message")WebElement fullNmaeError;
	 @FindBy(id= ":r9:-form-item-message")WebElement userNameError;
	 @FindBy(xpath = "//button[text()='Upload Blood Report']") WebElement uploadBloodReportButton;
	 @FindBy(xpath = "//button[text()='Step Through Onboarding']") WebElement stepThroughOnboardingButton;
	 @FindBy(xpath = "//div[@class='text-center']/h1") WebElement bloodReportModalPage;
	 @FindBy(xpath = "//div[@class='space-y-6']/div/div") WebElement uploadBox;
	 @FindBy(xpath = "//input[@type='file']") WebElement fileInput;
	 @FindBy(xpath = "//div[@class='flex space-x-3']/button[2]") WebElement uploadAndProcessButton;
	 @FindBy(xpath = "//div[@class='flex items-center text-red-500 text-sm mt-2']") WebElement uploadAndProcessError;
	 @FindBy(xpath = "//div[@role='progressbar']") WebElement progressBarLocator;
	 @FindBy(xpath = "//input[@name='age' or @name='height' or @name='weight']") List<WebElement> textFieldsOnboard;
	 @FindBy(xpath = "//select[@name='gender']") WebElement genderDropBox;
	 @FindBy(xpath = "//div[@class='flex space-x-3']/button[1]") WebElement cancelUploadButton;
	 @FindBy(xpath = "//h2[text()='Report Analysis Results']") WebElement reportAnalysisReport;
	 @FindBy(xpath = "//button[text()='Continue to Onboarding']") WebElement contToOnboardingButton;
	 @FindBy(xpath = "//h3[text()='Blood Test Results']") WebElement bloodTestResults;
	 @FindBy(xpath = "//h3[text()='Complete Blood Count']") WebElement completeBloodCount;
	 @FindBy(xpath = "//div[@class='p-4 bg-purple-50/50 rounded-lg']/h3[text()='Medical Conditions']") WebElement medicalConditions;
	 @FindBy(xpath = "//h3[text()='Abnormal Values']") WebElement abnormalValues;
	 @FindBy(xpath = "//h3[text()='Recommendations']") WebElement recommendations;
	 @FindBy(xpath = "//select[@name='gender']/option") List<WebElement> genderOptions;
	 @FindBy(xpath = "//div[@class='bg-purple-600 h-3 rounded-full']") WebElement progressBarOnboard;
	 @FindBy(xpath = "//p[@class='text-xs text-purple-700 font-medium']") WebElement stepNum;
	 @FindBy(xpath = "//input[@name='age']") WebElement ageOnboardForm;
	 @FindBy(xpath = "//input[@name='height']") WebElement heightOnboardForm;
	 @FindBy(xpath = "//input[@name='weight']") WebElement weightOnboardForm; 
	 @FindBy(xpath = "//div[@class='text-sm opacity-90']") WebElement errorMessageOnboardForm;
	 @FindBy(xpath = "//div[@class='bg-white rounded-xl p-4 shadow-md space-y-2']//div[contains(@class, 'cursor-pointer')]")List<WebElement> options2and3OnboardForm;
	 @FindBy(xpath = "//span[text()='Easy 🦋']") WebElement easyIntensityOptionStep2Onboard;
	 @FindBy(xpath = "//h2[@class='text-2xl font-semibold text-center mb-1 text-purple-700']") WebElement currentHeadingOnboardForm;
	 @FindBy(xpath = "//p[@class='text-center text-sm text-purple-600 mb-6']") WebElement currentSubHeadingOnboardForm;
	 @FindBy(xpath = "//span[text()='Vegan 🥬🌱🌿']") WebElement veganDietaryOptionStep3Onboard;
	 @FindBy(xpath = "//div[@class='bg-white rounded-xl p-4 shadow-md space-y-2 max-h-80 overflow-y-auto']//div[contains(@class, 'cursor-pointer')]")List<WebElement> options4and5OnboardForm;
	 @FindBy(xpath = "//span[text()='Indian 🍛']") WebElement indianFoodStep4Onboard;
	 @FindBy(xpath = "//div[contains(@class, 'cursor-pointer')]//input[@type='checkbox']") List<WebElement> allergyCkeckBoxStep5Onboard;
	 @FindBy(xpath = "//input[@type='checkbox' and @value='Gluten']") WebElement glutenCheckBoxStep5Onboard;
	 @FindBy(xpath = "//input[@type='checkbox' and @value='Dairy']") WebElement dairyCheckBoxStep5Onboard;
	 @FindBy(xpath = "//div[@class='text-center mb-[30px]']//h1") WebElement subscriptionPageTitle;
	 @FindBy(xpath = "//p[@class='text-sm text-gray-600 text-right']") WebElement stepNumWithoutReport;
	 @FindBy(xpath = "//div[@class='space-y-2 text-center']/h1") WebElement currentHeadingOnboardFormWithoutReport;
	 @FindBy(xpath = "//div[@class='space-y-2 text-center']/p") WebElement currentSubHeadingOnboardFormWithoutReport;
	 @FindBy(xpath = "//div[@class='space-y-2']//button[contains(@class, 'inline-flex items-center ')]") List<WebElement> optionsOnboardFormWithoutReport;
	 @FindBy(xpath = "//span[text()='Type 2']") WebElement optionType2Step2WithoutReport;
	 @FindBy(xpath = "//div[@class='h-full w-full rounded-[inherit]']//button[2]//span") WebElement optionIDontKnowStep2WithoutReport;
	 @FindBy(xpath = "//div[@class='flex justify-start mt-6']//span") WebElement backButtonWithoutReport;
	 @FindBy(xpath = "//div[@class='h-full bg-gradient-to-r from-violet-500 to-fuchsia-500 transition-all duration-300']") WebElement progressBarWithoutReport;
	 @FindBy(xpath = "//div[@class='bg-purple-600 h-3 rounded-full']") WebElement progressBarWithReport;
	 @FindBy(xpath = "//span[text()='Male 👨‍🦱']") WebElement maleOptionWithoutReport;
	 @FindBy(xpath = "//span[text()='100']") WebElement hundredYearsOptionWithoutReport;
	 @FindBy(xpath = "//span[text()='18']") WebElement eighteenOptionWithoutReport;
	 @FindBy(xpath = "//span[text()='35']") WebElement thirtyFiveOptionWithoutReport;
	 @FindBy(xpath = "//button[text()='Centimeters']") WebElement centimeterTabWithoutReport;
	 @FindBy(xpath = "//button[text()='Feet & Inches']") WebElement feeAndInchesTabWithoutReport;
	 @FindBy(xpath = "//span[text()='185']") WebElement oneEightyFiveHeightOptionWithoutReport;
	 @FindBy(xpath = "//span[text()='150']") WebElement oneFiftyHeightOptionWithoutReport;
	 @FindBy(xpath = "//span[text()='165']") WebElement oneSixtyFiveHeightOptionWithoutReport;
	 @FindBy(xpath = "//div[@class='h-full w-full rounded-[inherit]']//button[1]") WebElement fourPointFiveInchesOptionWithoutReport;
	 @FindBy(xpath = "//button[text()='Kilograms']") WebElement kgTabWithoutReport;
	 @FindBy(xpath = "//button[text()='Pounds']") WebElement poundsTabWithoutReport;
	 @FindBy(xpath = "//div[@class='flex rounded-full bg-white/50 backdrop-blur-sm p-1 shadow-inner']") WebElement cmFeetKgPoundsTabWithoutReport;
	 @FindBy(xpath = "//span[text()='40']") WebElement fortyWeightOptionWithoutReport;
	 @FindBy(xpath = "//span[text()='70']") WebElement seventyWeightOptionWithoutReport;
	 @FindBy(xpath = "//span[text()='100']") WebElement hundredWeightOptionWithoutReport;
	 @FindBy(xpath = "//span[text()='Vegan 🥬🌱🌿']") WebElement veganDietaryOptionWithoutReport;
	 @FindBy(xpath = "//span[text()='Indian 🍛']") WebElement indianCuisineOptionWithoutReport;
	 @FindBy(xpath = "//span[text()='Yes ✅']") WebElement yesToAllergicOptionWithoutReport;
	 @FindBy(xpath = "//span[text()='No ❌']") WebElement noToAllergicOptionWithoutReport;
	 @FindBy(xpath = "//div[@class='space-y-4']//div[contains(@class,'font-medium')]")List<WebElement> allergyOptionsOnboardFormWithoutReport;
	 @FindBy(xpath = "//span[text()='Continue']") WebElement continueButtonWithoutReport;
	 @FindBy(id="shellfish") WebElement shellFishOptionWithoutReport;
	 @FindBy(xpath = "//div[@class='text-sm font-semibold']") WebElement errorMsgWithoutReport;
	 @FindBy(id="high-blood-pressure") WebElement highBPOptionWithoutReport;
	 @FindBy(xpath = "//div[@class='space-y-4']//input") WebElement HbA1cInputTextBoxWithoutReport;
	 @FindBy(xpath = "//p[@class='text-sm text-gray-500 mt-2']") WebElement textBelowHbA1cInputTextBoxWithoutReport;
	 @FindBy(xpath = "//div[@class='space-y-4']//button") WebElement step12ContinueButtonWithoutReport;
	 @FindBy(xpath = "//div[@class='mt-4 bg-white/50 backdrop-blur-sm rounded-lg p-4 shadow-inner']") WebElement step12DescWithoutReport;
	 @FindBy(xpath = "//div[@class='text-sm font-semibold']") WebElement messageLastStepWithoutReport;
	 @FindBy(xpath = "//div[@class='absolute inset-0 rounded-full border-4 border-purple-600 border-t-transparent animate-spin']") WebElement pogressBarWithoutReport;
	 @FindBy(className="text-gray-600") WebElement subscriptionPageSubTitle;
	 @FindBy(xpath = "//h2[@class='text-xl font-semibold text-purple-600 text-center']") WebElement messagePersonalizedScreenWithoutReport;
	 @FindBy(xpath = "//p[@class='text-sm text-purple-400 text-center']") WebElement subTitlePersonalizedScreenWithoutReport;
	 @FindBy(xpath = "//button[text()='Upgrade to Premium']") WebElement upgradeToPremiumButton;
	 @FindBy(xpath = "//button[@type='button']") WebElement closePopPupMessageOnboardngWithReport;
	 @FindBy(xpath = "//button[text()='Continue']") WebElement continueWithReport;
	 @FindBy(xpath = "//div[@class='mt-4']//button") WebElement backButtonWithReport;
	 @FindBy(xpath = "//div[@class='mt-4']//button") WebElement backStepNumWithReport;
	 
	
	
	 
	 
	 
	
	public LoginUI_Page(TestContext context) {
        this.driver = context.getDriver();
        this.helper = context.getHelper(); 
        PageFactory.initElements(driver, this);
        this.jsExecutor = (JavascriptExecutor) driver;
    }
	
	
	 public void clickLoginGutton() {
		 loginButton.click();
	 
	 }
	 
	 public List<String> getTextsList() {
	        return helper.getTexts(loginTexts);
	    }
	 
	 public boolean isCloseButtonVisible() {
		    return closeButton.isDisplayed();
		}
	 
	 public String getEmailText() {
		 return emailField.getDomAttribute("placeholder");
		}

	   public boolean isEmailFieldVisible() {
	        return emailField.isDisplayed();
	    }
	   
	   public boolean isContinueWithEmailButtonEnabled() {
	        return continueWithEmailButton.isEnabled();
	    }
	   
	   public void enterEmail(String email) {
		    emailField.sendKeys(email);      
		}
	   
	   public void enterPassword(String password) {
		   passwordField.sendKeys(password);      
		}
	   
	   public void clickContinueWithEmailButton() {
		   continueWithEmailButton.click();  
	   }
	   
	   public boolean isCompleteProfileFormDisplayed() {
		    return completeYourProfileText.isDisplayed();
		}
	   
	   public String getCompleteYourProfileText() {
		   return completeYourProfileText.getText();
	   }
	   
	   public String getEmailErrorText() {
		   return emailErrorText.getText();
	   }
	   
	   public boolean isPasswordFieldVisible() {
		    return passwordField.isDisplayed();
		}
	   
	   public String getPasswordText() {
			 return passwordField.getDomAttribute("placeholder");
			}
	   
	   public String getEmailSubText() {
			 return emailSubText.getText();
			}
	   
	   public boolean isEmailSubTextVisible() {
		    return emailSubText.isDisplayed();
		}
	   
	   public boolean isForgotPasswordlink() {
		    return forgotPasswordlink.isDisplayed();
		}
	   
	   public boolean isHomePageLoaded() {
			    return homePageText.isDisplayed(); 
		}
	   
	   public boolean isFullNameFieldVisible() {
		   return fullNameField.isDisplayed();
	   }
	   
	   public boolean isUserNameFieldVisible() {
		   return userNameField.isDisplayed();
	   }
	   
	   public boolean isCheckBoxVisible() {
		   return checkBox.isDisplayed();
	   }
	   
	   public void clickCheckbox() {
		   checkBox.click();
	   }
	   public boolean isCreateAccountButtonDisabled() {
		    wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		    return wait.until(driver -> createAccountButton.getDomAttribute("disabled") != null);
		}
	  
	   public boolean isCreateAccountButtonEnabled() {
		   
		   return createAccountButton.isEnabled();
		}
	   public void clickCreateAccountButton() {
		   createAccountButton.click();
		   
	   }

	   public void enterAllFieldsCompleteForm(String fullname, String username, String password) {
		   fullNameField.sendKeys(fullname);
		   userNameField.sendKeys(username);
		   passwordField.sendKeys(password);
		}
	   
	   public boolean isFullNameErrorVisible() {
		    return fullNmaeError.isDisplayed();
		}
	   public boolean isUserNameErrorVisible() {
		    return userNameError.isDisplayed();
		}
	   
	   public boolean isUploadBloodReportButtonVisible() {
		    return uploadBloodReportButton.isDisplayed();
		}
	   
	   public boolean isUploadBloodReportButtonVisibleEnabled() {
		   return uploadBloodReportButton.isEnabled();
	   }
	   
	   public boolean isStepThroughOnboardingButtonVisible() {
		    return stepThroughOnboardingButton.isDisplayed();
		}
	   
	   public void clickStepThroughOnboardingButton() {
		   stepThroughOnboardingButton.click();
	   }
	   
	   public WebElement clickUploadBloodReportButtonIndicatorElement() {
		    return uploadBloodReportButton; 
		}


	   public void clickUploadBloodReportButton() {
		   uploadBloodReportButton.click();
		}

	   
	   
	   
	   public boolean isBloodReportModalPageVisible() {
		    return bloodReportModalPage.isDisplayed();
		}
	   
	   public void hoverOverUploadBox() {
		    Actions actions = new Actions(driver);
		    actions.moveToElement(uploadBox).perform();
		}
	   
	   public void clickUploadBox() {
		   uploadBox.click();
	   }
	   
	   public boolean isDragDropTextVisible() {
		    return uploadBox.isDisplayed();
		}
	   
	   public void uploadFile(String filePath) {
		   fileInput.sendKeys(filePath);
		}
	   
	   public void clickUploadAndProcessButton() {
		   uploadAndProcessButton.click();
	   }
	   
	   public boolean isUploadAndProcessButtonEnabled() {
		   return uploadAndProcessButton.isEnabled();
	   }
	   
	   public WebElement uploadAndProcessButtonIndicatorElement() {
		   return uploadAndProcessButton;
	   }
	   
	   
	   
	   public String getUploadAndProcessErrorText() {
		    return uploadAndProcessError.getText();
		}
	   
	   public boolean isProgressBarVisible() {
		    try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		        wait.until(ExpectedConditions.visibilityOf(progressBarLocator));
		        return progressBarLocator.isDisplayed();
		    } catch (TimeoutException e) {
		        return false;
		    }
		}
	   
	   public boolean isUploadReaching100Percent() {
		    try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        return wait.until(ExpectedConditions.textToBePresentInElementLocated(
		            By.xpath("//span[contains(text(), '%')]"),
		            "100%"
		        ));
		    } catch (TimeoutException e) {
		        return false;
		    }
		}
	   	  
	   public List<String> getAllTextFieldPlaceholdersOrLabels() {
		    return textFieldsOnboard.stream()
		            .map(field -> field.getDomAttribute("placeholder") != null 
		                         ? field.getDomAttribute("placeholder") 
		                         : field.getDomAttribute("name"))
		            .collect(Collectors.toList());
		}
	   
	   public boolean isGenderDropBoxVisible() {
		    return genderDropBox.isDisplayed();
		}
	   
	   public List<String> getDropDownList() {
	        return helper.getTexts(genderOptions);
	    }
	   
	   public void clickCancelUploadButton() {
		   cancelUploadButton.click();
		}
	   
	   public boolean isReportAnalysisReportVisible() {
		    return reportAnalysisReport.isDisplayed();
		}  
	   
	   public boolean isContToOnboardingButtontVisible() {
		    return contToOnboardingButton.isDisplayed();
		}  
	   
	   public WebElement ContToOnboardingButtonIndicatoeElement() {
		   return contToOnboardingButton;
	   }
	   
	   public void clickContToOnboardingButton() {
		   contToOnboardingButton.click();
	   }
	   
	   public boolean isSectionVisible(String section) {
		   switch (section.trim().toLowerCase()) {
		   case "blood test results":
	            return bloodTestResults.isDisplayed();
		case "complete blood count":
	            return completeBloodCount.isDisplayed();
	        case "medical conditions":
	            return medicalConditions.isDisplayed();
	        case "abnormal values":
	            return abnormalValues.isDisplayed();
	        case "recommendations":
	            return recommendations.isDisplayed();
	        case "centimeters":
	        return centimeterTabWithoutReport.isDisplayed();	 
	        case "feet and inches":
		        return feeAndInchesTabWithoutReport.isDisplayed();
	        case "kilograms":
	        	return kgTabWithoutReport.isDisplayed();
	        case "pounds":
	        	return poundsTabWithoutReport.isDisplayed();
	        	
	        default:
	            throw new IllegalArgumentException("Unknown section: " + section);
	    }
	}
	   public boolean isProgressBarOnboardVisible() {
		    return progressBarOnboard.isDisplayed();
		} 
	   
	   
	   
	   
	   public boolean isStepNumVisible() {
		    return stepNum.isDisplayed();
		} 
	   
	   
	   
	   public String getTextStepNum(String expectedText) {
		   waitForTextInElement(stepNum, expectedText);
		    return stepNum.getText();
		}
	   
	   
	   public String getTextStepNum() {
		   return stepNum.getText();
		   
	   }
	   
//	   public String getBackTextStepNumWithReport(String expectedText) {
//		   waitForTextInElement(backStepNumWithReport, expectedText);
//		    return stepNum.getText();
//		}

	   
	   public WebElement getStepIndicatorElement() {
		    return stepNum;
		}
	   
	   public boolean isStepNumWithoutReportVisible() {
		    return stepNumWithoutReport.isDisplayed();
		} 
	   
	   public String getTextStepNumWithoutReport() {
		   return stepNumWithoutReport.getText();
	   }
	   
	   public WebElement getStepNumWithoutReportIndicatorElement() {
		    return stepNumWithoutReport;
		}
	   public WebElement getStepNumWithReportIndicatorElement() {
		    return backStepNumWithReport;
		}
	   
	   
	   
	   
	   
	   public WebElement getTitleIndicatorElement() {
		   
		    return currentHeadingOnboardForm;
		}
	   public WebElement getSubTitleIndicatorElement() {
		    return currentSubHeadingOnboardForm;
		}
	  
	   public WebElement getTitleWithoutReportIndicatorElement() {
		    return currentHeadingOnboardFormWithoutReport;
		}
	   public WebElement getSubTitleWithoutIndicatorElement() {
		    return currentSubHeadingOnboardFormWithoutReport;
		}
	   
	   public List<WebElement> getOptions2and3IndicatorElement() {
		    return options2and3OnboardForm;
		}
	   
	   public List<WebElement> getOptions4and5IndicatorElement() {
		    return options4and5OnboardForm;
		}
	   public List<WebElement> getOptionsOnboardFormWithoutReportIndicatorElement() {
		    return optionsOnboardFormWithoutReport;
		}
	   public List<WebElement> getAllergyOptionsOnboardFormWithoutReportIndicatorElement() {
		    return allergyOptionsOnboardFormWithoutReport;
		}
	   
	   public void enterFieldsOnboardWithRecordForm(String height,String weight){
		 
		   heightOnboardForm.sendKeys(height);
		   weightOnboardForm.sendKeys(weight);
		   
	   }
	   public void enterHeightandWeightFieldsOnboardWithRecordForm(String height, String weight) {

		   heightOnboardForm.clear();
		    heightOnboardForm.sendKeys(height);
		    weightOnboardForm.clear();
		    weightOnboardForm.sendKeys(weight);
		}

	   
	   public WebElement heightOnboardFormIndicatorElement() {
		   return heightOnboardForm;
	   }

	   
	   public void clickGenderDropBox() {
		   genderDropBox.click();
	   }
	   
	   public boolean isErrorMessageOnboardFormVisible() {
		    return errorMessageOnboardForm.isDisplayed();
		} 
	   	   
	   public void selectGender(String value) {
		    Select select = new Select(genderDropBox);
		    select.selectByVisibleText(value); 
		}
	   
	   
	   public String getCurrentHeadingOnboardForm(){
		   return currentHeadingOnboardForm.getText();
	   }
	   
	   
	   
	   
	   public String getCurrentSubHeadingOnboardForm() {
		   return currentSubHeadingOnboardForm.getText();
	   }
	   public String getCurrentHeadingOnboardFormWithoutReport(){
		   return currentHeadingOnboardFormWithoutReport.getText();
	   }
	   public String getCurrentSubHeadingOnboardFormWithoutReport() {
		   return currentSubHeadingOnboardFormWithoutReport.getText();
	   }
	   	     
	   public boolean isBackButtonOnboardFormVisible() {
		    return forgotPasswordlink.isDisplayed();
		} 
	   
	   public void clickBackButtonOnboardform() {
		   forgotPasswordlink.click();
		   
	   }
	   
	   public List<String> getOptions2and3OnboardFormTexts() {
		    return helper.getTexts(options2and3OnboardForm); 
		}
	   public List<String> getOptions4and5OnboardFormTexts() {
		    return helper.getTexts(options4and5OnboardForm); 
		}
	   public List<String> getOptionsOnboardFormWithoutReportTexts() {
		    return helper.getTexts(optionsOnboardFormWithoutReport); 
		}
	   public List<String> getAllergyOptionsOnboardFormWithoutReportTexts() {
		    return helper.getTexts(allergyOptionsOnboardFormWithoutReport); 
		}
	   
	 
	   
	   public void clickEasyasyIntensityOptionStep2Onboard() {
		   easyIntensityOptionStep2Onboard.click();
	   }
	   public void clickVeganDietaryOptionStep3Onboard() {
		   veganDietaryOptionStep3Onboard.click();
	   }
	   public void clickIndianFoodStep4OnboardStep3Onboard() {
		   indianFoodStep4Onboard.click();
	   }
	   
	   public List<WebElement> getOptions4and5OnboardForm() {
		    return options4and5OnboardForm;
		}
	   public void clickGlutenCheckBoxStep5Onboard() {
		   glutenCheckBoxStep5Onboard.click();   
	   }
	   public void clickDairyCheckBoxStep5Onboard() {
		   dairyCheckBoxStep5Onboard.click();   
	   }
	   public boolean isSubscriptionPageTitleDisplayed() {
		    return subscriptionPageTitle.isDisplayed();
		} 
	   public WebElement getSubscriptionPageTitleDisplayedIndicatorElement() {
		    return subscriptionPageTitle; 
		}
	  
	   public void clickClosePopPupMessageOnboardngWithReport() {
			 closePopPupMessageOnboardngWithReport.click();
		 }
		 public WebElement clickClosePopPupMessageOnboardngWithReportIndicatorElement() {
			 return closePopPupMessageOnboardngWithReport;
		 }
		 

		 public void clickContinueWithReport() {
			 continueWithReport.click();
		 }
		 
		 public void clickBackButtonWithReport() {
			 backButtonWithReport.click();
		 }
		
	//----------------------------------------------------------------------------------------------------------------------------------------------------
	   
	   
	   public void clickOptionType2Step2WithoutReport() {
		   optionType2Step2WithoutReport.click();   ;
	   }
	   public void clickOptionIDontKnowStep2WithoutReport() {
		   optionIDontKnowStep2WithoutReport.click();   
	   }
	   public void clickBackButtonWithoutReport() {
		   backButtonWithoutReport.click();   
	   }
	   public boolean isBackButtonWithoutReportVisible() {
		    return backButtonWithoutReport.isDisplayed();
		} 
	   public String getDomMessage() {
		   String bodyText = driver.findElement(By.tagName("body")).getText();
		   return bodyText;
	   }
	   
	   public boolean isProgressBarWithoutReportHighlighted() {
		    return progressBarWithoutReport.isEnabled();
		}
	   public boolean isProgressBarWithReportHighlighted() {
		    return progressBarWithReport.isEnabled();
		}
	   public void clickMaleOptionWithoutReport() {
		   maleOptionWithoutReport.click();   
	   }
	   
	   public boolean scrollToLastOptionAndVerify() {
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].scrollIntoView(true);", hundredYearsOptionWithoutReport);

		    return hundredYearsOptionWithoutReport.isDisplayed();
		}
	   public void clickEighteenOptionWithoutReport() {
		   eighteenOptionWithoutReport.click();   
	   }
	   public void clickThirtyFiveOptionWithoutReport() {
		   thirtyFiveOptionWithoutReport.click();   
	   }
	   
	   public void clickHundredOptionWithoutReport() {
		   hundredYearsOptionWithoutReport.click();   
	   }
	   
	   public List<String> validateRange(String range, String suffix) {
		    String[] parts = range.split("to");
		    int start = Integer.parseInt(parts[0].trim());
		    int end = Integer.parseInt(parts[1].trim());

		    return IntStream.rangeClosed(start, end)
		        .mapToObj(i -> i + " " + suffix.trim())
		        .collect(Collectors.toList());
		}

	   public void clickFeeAndInchesTabWithoutReportt() {
		   feeAndInchesTabWithoutReport.click();   
	   }
	   public void clickCentimeterTabWithoutReport() {
		   centimeterTabWithoutReport.click();   
	   }
		 public void clickOneEightyFiveHeightOptionWithoutReport() {
			 oneEightyFiveHeightOptionWithoutReport.click();   
		   }
		 public void clickOneFiftyHeightOptionWithoutReport() {
			 oneFiftyHeightOptionWithoutReport.click();   
		   }
		 public void clickOneSixtyFiveOptionWithoutReport() {
			 oneSixtyFiveHeightOptionWithoutReport.click();   
		   }
		 public void clickFourPointFiveInchesOptionWithoutReport() {
			 fourPointFiveInchesOptionWithoutReport.click();   
		   }
		 
		 public String getCmFeetKgPoundsTabWithoutReportText() {
			   return cmFeetKgPoundsTabWithoutReport.getText();
		   }
		 public void clickPoundsTabWithoutReport() {
			 poundsTabWithoutReport.click();   
		   }
		 
		 public void clickKgTabWithoutReport() {
			 kgTabWithoutReport.click();   
		   }
		 
		 public void clickFortyWeightOptionWithoutReport() {
			 fortyWeightOptionWithoutReport.click();   
		   }
		 public void clickSeventyWeightOptionWithoutReport() {
			 seventyWeightOptionWithoutReport.click();   
		   }
		 public void clickHundredWeightOptionWithoutReport() {
			 hundredWeightOptionWithoutReport.click();   
		   }
		 public void clickVeganDietaryOptionWithoutReport() {
			 veganDietaryOptionWithoutReport.click();   
		   }
		 public void clickIndianCuisineOptionWithoutReport() {
			 indianCuisineOptionWithoutReport.click();   
		   }
		 
		 public void clickYesToAllergicOptionWithoutReport() {
			 yesToAllergicOptionWithoutReport.click();   
		   }
		 public void clickNoToAllergicOptionWithoutReport() {
			 noToAllergicOptionWithoutReport.click();   
		   }
		 public void clickcontinueButtonWithoutReport() {
			 continueButtonWithoutReport.click();   
		   }
		 public void clickShellFishOptionWithoutReport() {
			 shellFishOptionWithoutReport.click();   
		   }
		 
		 public String getErrorMsgWithoutReportWithoutReportText() {
			   return errorMsgWithoutReport.getText();
		   }
		 public void clickHighBPOptionWithoutReport() {
			    highBPOptionWithoutReport.click();;
		   }
		
		 public WebElement getCheckboxById(String id) {
			    return driver.findElement(By.id(id));
			}

		

		 public WebElement getOptionByText(String labelText) {
		     String xpath = "//span[contains(normalize-space(),\"" + labelText + "\")]";
		     WebElement element = driver.findElement(By.xpath(xpath));
		     return helper.waitForVisibleElement(element);
		 }
		 
		 public WebElement getOptionById(String elementId) {
				    WebElement element = driver.findElement(By.id(elementId));
				    return helper.waitForVisibleElement(element);
				}

			




		 public String getHbA1cInputTextBoxWithoutReportText() {
			   return HbA1cInputTextBoxWithoutReport.getDomAttribute("placeholder");
		   }
		 public String getTextBelowHbA1cInputTextBoxWithoutReport() {
			   return textBelowHbA1cInputTextBoxWithoutReport.getText();
		   }
		 
		 public boolean isStep12ContinueButtonWithoutReportVisible() {
			    return step12ContinueButtonWithoutReport.isDisplayed();
			} 
		 public void clickStep12ContinueButtonWithoutReport() {
			 step12ContinueButtonWithoutReport.click();;      
			}
		 public String getStep12DescWithoutReport() {
			   return step12DescWithoutReport.getDomAttribute("placeholder");
		   }
		 public WebElement getStep12DescWithoutReportIndicatorElement() {
			    return step12DescWithoutReport; 
			}
		 
		 public void enterHbA1cInputTextBoxWithoutReport(String HbA1c) {
			 HbA1cInputTextBoxWithoutReport.sendKeys(HbA1c);      
			}
		 
		 public WebElement getHbA1cInputFieldIndicatorElement() {
			    return HbA1cInputTextBoxWithoutReport; 
			}
		 public void clickTextBelowHbA1cInputTextBoxWithoutReport() {
			 textBelowHbA1cInputTextBoxWithoutReport.click(); 
			}
		 public String getMessageLastStepWithoutReport() {
			   return messageLastStepWithoutReport.getText();
		   }
		 
		 public boolean isPogressBarWithoutReportVisible() {
			    return pogressBarWithoutReport.isDisplayed();
			}
		 public String getSubscriptionPageTitle() {
			    return subscriptionPageTitle.getText();
			} 
		 public String getSubscriptionPageSubTitle() {
			    return subscriptionPageSubTitle.getText();
			} 
		 public String getMessagePersonalizedScreenWithoutReport() {
			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			    WebElement element = wait.until(ExpectedConditions.visibilityOf(messagePersonalizedScreenWithoutReport));
			    return element.getText();
			}
		 
		 public String getSubTitlePersonalizedScreenWithoutReport() {
			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			    WebElement element = wait.until(ExpectedConditions.visibilityOf(subTitlePersonalizedScreenWithoutReport));
			    return element.getText();
			}
		 public boolean isUpgradeToPremiumButtonVisible() {
			    return upgradeToPremiumButton.isDisplayed();
			} 
		 
		 public WebElement getPpgradeToPremiumButtonIndicatorElement() {
			 return upgradeToPremiumButton ;
			}
		 
		 public void clickFeeAndInchesTabWithoutReport() {
			 feeAndInchesTabWithoutReport.click();
		 }
		 
		
		 public void pressEscapeKey() {
			 Actions actions = new Actions(driver);
			    actions.sendKeys(Keys.ESCAPE).perform();
			}
		 
		 public void scrollToAndClickContinueOnboardingButton() {
			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			    By continueButtonLocator = By.xpath("//button[text()='Continue to Onboarding']");
			    WebElement continueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(continueButtonLocator));
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", continueButton);
			    wait.until(ExpectedConditions.elementToBeClickable(continueButton));
			    continueButton.click();
			}

		 public void assertExpectedItemsPresent(List<String> actualList, String expectedOptionList, String contextDescription) {
			    List<String> expectedList = Arrays.stream(expectedOptionList.split(","))
			        .map(String::trim)
			        .collect(Collectors.toList());

			    boolean allPresent = expectedList.stream()
			        .allMatch(expectedItem -> actualList.stream()
			            .anyMatch(actualItem -> actualItem.toLowerCase().contains(expectedItem.toLowerCase()))
			        );
			    Assert.assertTrue(allPresent,
			    	    "Expected " + contextDescription + " not found.\nExpected: " + expectedList + "\nActual: " + actualList);

			}


		 public void waitForTextInElement(WebElement element, String expectedText) {
			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			    wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
			}
		 
//		 public String getCurrentHeadingOnboardForm(String expectedText) {
//			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//			    wait.until(ExpectedConditions.textToBePresentInElement(currentHeadingOnboardForm, expectedText));
//			    return currentHeadingOnboardForm.getText();
//			}
//
//		 public void waitForAllExpectedTextsInElements(List<WebElement> elements, String expectedTexts) {
//			    List<String> expectedList = Arrays.stream(expectedTexts.split(","))
//			                                      .map(String::trim)
//			                                      .collect(Collectors.toList());
//
//			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//			    wait.until(driver -> {
//			        List<String> actualTexts = elements.stream()
//			                                           .map(el -> el.getText().trim().toLowerCase())
//			                                           .collect(Collectors.toList());
//
//			        return expectedList.stream()
//			                           .allMatch(expected -> actualTexts.stream()
//			                                                            .anyMatch(actual -> actual.contains(expected.toLowerCase())));
//			    });
//			}

		 public WebElement fluentWaitForAnyVisibleElement(List<WebElement> elements) {
			    Wait<WebDriver> wait = new FluentWait<>(driver)
			        .withTimeout(Duration.ofSeconds(20))
			        .pollingEvery(Duration.ofMillis(500))
			        .ignoring(NoSuchElementException.class)
			        .ignoring(StaleElementReferenceException.class);

			    return wait.until(driver -> {
			        for (WebElement el : elements) {
			            try {
			                if (el.isDisplayed()) {
			                    return el;
			                }
			            } catch (Exception ignored) {}
			        }
			        return null;
			    });
			}
		 
		 public WebElement fluentWaitForVisibleElement(WebElement element) {
			    Wait<WebDriver> wait = new FluentWait<>(driver)
			        .withTimeout(Duration.ofSeconds(20))
			        .pollingEvery(Duration.ofMillis(500))
			        .ignoring(NoSuchElementException.class)
			        .ignoring(StaleElementReferenceException.class);

			    return wait.until(driver -> {
			        try {
			            return element.isDisplayed() ? element : null;
			        } catch (Exception ignored) {
			            return null;
			        }
			    });
			}







	   
}