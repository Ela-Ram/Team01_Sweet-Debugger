package pageObject;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.Helper;
import common.TestContext;

public class LoginUI_Page {
	
	
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
	 @FindBy(xpath = "//div[@class='flex flex-col space-y-4 mt-8']/button[1]") WebElement uploadBloodReportButton;
	 @FindBy(xpath = "//div[@class='flex flex-col space-y-4 mt-8']/button[2]") WebElement stepThroughOnboardingButton;
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
	 @FindBy(xpath = "//button[text()='Continue to Onboarding']") WebElement continueOnboargingButton;
	 @FindBy(xpath = "//div[@class='text-center mb-[30px]']//h1") WebElement subscriptionPageTitle;
	 
	
	
	
	
	public LoginUI_Page(TestContext context) {
        this.driver = context.getDriver();
        this.helper = context.getHelper(); 
        PageFactory.initElements(driver, this);
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
		    wait = new WebDriverWait(driver, Duration.ofSeconds(5));
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
	   
	   public boolean isStepThroughOnboardingButtonVisible() {
		    return stepThroughOnboardingButton.isDisplayed();
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
	   
	   public String getTextStepNum() {
		   return stepNum.getText();
	   }
	   
	   public WebElement getStepIndicatorElement() {
		    return stepNum;
		}
	   
	   public WebElement getTitleIndicatorElement() {
		    return currentHeadingOnboardForm;
		}
	   public WebElement getSubTitleIndicatorElement() {
		    return currentSubHeadingOnboardForm;
		}
	   
	   public List<WebElement> getOptions2and3IndicatorElement() {
		    return options2and3OnboardForm;
		}
	   
	   public List<WebElement> getOptions4and5IndicatorElement() {
		    return options4and5OnboardForm;
		}
	   public void enterAllFieldsOnboardWithRecordForm(String age,String height,String weight){
		   ageOnboardForm.sendKeys(age);
		   heightOnboardForm.sendKeys(height);
		   weightOnboardForm.sendKeys(weight);
		   
	   }
	   public void enterHeightandWeightFieldsOnboardWithRecordForm(String height, String weight) {
		    helper.waitForVisibleElement(heightOnboardForm);
		    helper.waitForVisibleElement(weightOnboardForm);

		    heightOnboardForm.clear();
		    heightOnboardForm.sendKeys(height);

		    weightOnboardForm.clear();
		    weightOnboardForm.sendKeys(weight);
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
	   public void clickContinueOnboargingButton() {
		   continueOnboargingButton.click();   
	   }
	   public boolean isSubscriptionPageTitleDisplayed() {
		    return subscriptionPageTitle.isDisplayed();
		} 
	
	   
	   
	   
}
