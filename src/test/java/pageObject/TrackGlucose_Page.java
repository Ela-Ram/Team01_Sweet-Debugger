package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import common.Helper;
import common.TestContext;

public class TrackGlucose_Page {
	
	private WebDriver driver;
	private Helper helper;
	
	//locator
	@FindBy(xpath = "//button[contains(., 'Blood Glucose')]")
	private WebElement bloodGlucoseButton;
	
	@FindBy(xpath = "//h1[contains(text(),'Track Glucose')]") 
    private WebElement trackGlucoseHeading;
   
    @FindBy(xpath = "//p[contains(text(),'Keep your health in check')]")
    private WebElement subText;

    @FindBy(xpath = "//label[contains(text(),'Blood Glucose Level')]")
    private WebElement bloodGlucoseLabel;

    @FindBy(xpath = "//label[contains(text(),'Reading Type')]")
    private WebElement readingTypeLabel;

    @FindBy(xpath = "//label[contains(text(),'Date')]")
    private WebElement dateLabel;

    @FindBy(xpath = "//input[@placeholder='Enter blood glucose level']")
    private WebElement bloodGlucoseInput;

    @FindBy(xpath = "//span[contains(text(),'mg/dL')]")
    private WebElement mgdlText;

    //@FindBy(xpath = "//div[contains(text(),'Low')]")
    @FindBy(xpath="//div[@class='flex-1 text-center py-2 rounded-xl text-sm font-semibold transition-all shadow-sm bg-red-100/80 text-red-600']")
    private WebElement lowStatus;

   // @FindBy(xpath = "//div[contains(text(),'Normal')]")
    @FindBy(xpath="//div[@class='flex-1 text-center py-2 rounded-xl text-sm font-semibold transition-all bg-green-100/80 text-green-600 transform scale-105 shadow-md']")
    private WebElement normalStatus;

   // @FindBy(xpath = "//div[contains(text(),'High')]")
    @FindBy(xpath="//div[@class='flex-1 text-center py-2 rounded-xl text-sm font-semibold transition-all shadow-sm bg-amber-100/80 text-amber-600']")
    private WebElement highStatus;

    @FindBy(xpath = "//button[text()='Fasting']")
    private WebElement fastingBtn;

    @FindBy(xpath = "//button[text()='Pre-meal']")
    private WebElement preMealBtn;

    @FindBy(xpath = "//button[text()='Post-meal']")
    private WebElement postMealBtn;

    @FindBy(xpath = "//button[text()='Bedtime']")
    private WebElement bedtimeBtn;

    @FindBy(xpath = "//button[contains(text(),'July')]")
    private WebElement datePickerBtn;

    @FindBy(xpath = "//div[contains(text(),'Last reading')]")
    private WebElement lastReadingDetails;

    @FindBy(xpath = "//button[contains(text(),'Record Reading')]")
    private WebElement recordReadingBtn;
    
    
    
  
	//constructor
		 public TrackGlucose_Page(TestContext context) {
			
			 {
		        this.driver = context.getDriver();
		        this.helper = context.getHelper(); 
		        PageFactory.initElements(driver, this);
		    }
			 
		 }
		 
		//Methods
		 
		 public void premiumUserHomePage() {
			 
			 driver.getCurrentUrl();
			 
		 }
		 
		 public void clickGlucoseBtn() {
			 
			 helper.waitForVisibleOf(bloodGlucoseButton); 
			 bloodGlucoseButton.click();
		 }
		  public boolean headingTrackGlucose() {               
		
			helper.waitForVisibleOf(trackGlucoseHeading);
			return helper.checkElementDisplayed(trackGlucoseHeading);
			
		  }
		 
		  public boolean verifySubtext() {
			  
				helper.waitForVisibleOf(subText);
				return helper.checkElementDisplayed(subText);	
				
		   }
		   
		   public boolean verifyFieldLabels() {
			  	     
		     
		 	helper.waitForVisibleOf(bloodGlucoseLabel);
			return helper.checkElementDisplayed(bloodGlucoseLabel)&& 
					helper.checkElementDisplayed(readingTypeLabel)&&
					helper.checkElementDisplayed(dateLabel);
		     
		    }
		    
		   public boolean verifyTextFieldBloodGlcose() {
			   
			  
			   helper.waitForVisibleOf(bloodGlucoseInput);
				return helper.checkElementDisplayed(bloodGlucoseInput);	
				
		   }
		  
		   public String verifyPlaceholderBloodGulcose()
		   {
			    return bloodGlucoseInput.getAttribute("placeholder");
		   }		  
		   
		   public boolean verifymgdl() {
			   
			   
			   helper.waitForVisibleOf(mgdlText);
				return helper.checkElementDisplayed(mgdlText);	
			   
		   }
		 
		   public boolean verifyTextTransitionDetails() {
			  
			  helper.waitForVisibleOf(lowStatus);
			  return helper.checkElementDisplayed(lowStatus)
					  &&helper.checkElementDisplayed(normalStatus)
					  &&helper.checkElementDisplayed(highStatus);
		   }
		   public String getLowStatusColorHex() {
			   
			    helper.waitForVisibleOf(lowStatus);
			    String rgba = lowStatus.getCssValue("color");
			    return Color.fromString(rgba).asHex(); 
			}
			
		   public String getNormalStatusColorHex() {
			   
			    helper.waitForVisibleOf(normalStatus);
			    String rgba = normalStatus.getCssValue("color");
			    return Color.fromString(rgba).asHex(); 
			}

		   public String getHighStatusColorHex() {
			    helper.waitForVisibleOf(highStatus);
			    String rgba = highStatus.getCssValue("color");
			    return Color.fromString(rgba).asHex(); 
			}

		   
		   public boolean areAllReadingTypeButtonsVisible() {
			    try {
			        helper.waitForVisibleOf(fastingBtn);
			        helper.waitForVisibleOf(preMealBtn);
			        helper.waitForVisibleOf(postMealBtn);
			        helper.waitForVisibleOf(bedtimeBtn);

			        return helper.checkElementDisplayed(fastingBtn)&&helper.checkElementDisplayed(preMealBtn)&&
			        		helper.checkElementDisplayed(postMealBtn)&&
			        		helper.checkElementDisplayed(bedtimeBtn);	 
			        
			    } catch (Exception e) {
			        System.out.println("One or more buttons not visible: " + e.getMessage());
			        return false;
			    }
			}
		   
		   public boolean isDatePickerVisible() {
			   
			        helper.waitForVisibleOf(datePickerBtn);
			        return datePickerBtn.isDisplayed();
			   
			}
		   
		   public boolean isLastReadingDetailsVisible() {
			   
			        helper.waitForVisibleOf(lastReadingDetails);
			        return lastReadingDetails.isDisplayed();
			   
			}
		   public boolean isRecordReadingButtonVisible() {
			   
			        helper.waitForVisibleOf(recordReadingBtn);
			        return recordReadingBtn.isDisplayed();
			    
			}

}
