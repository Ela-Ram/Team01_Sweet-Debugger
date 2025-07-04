package pageObject;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.Helper;
import common.TestContext;

public class PhysicalActivity_Page {

	private WebDriver driver;
	private Helper helper;
	
	//locator
	
	@FindBy(xpath = "//button[contains(., 'Physical Activity')]")
	private WebElement physicalActivityButton;
	
	@FindBy(xpath = "//h1[text()='Physical Activity']")
	private WebElement titlePhysicalActivity;

	@FindBy(xpath = "//p[contains(text(),'Track your fitness journey')]")
	private WebElement subtextTrackJourney;
	
	@FindBy(xpath="//label[normalize-space()='Activity Type']")//1
	private WebElement activityTypeHeading;
	
	@FindBy(xpath="//label[normalize-space()='Duration']")//2
	private WebElement DurationHeading;
	
	@FindBy(xpath="//label[normalize-space()='Date']")//3
	private WebElement dateHeading;
	
	@FindBy(xpath="//label[normalize-space()='Intensity']")//4
	private WebElement intensityHeading;
	
	@FindBy(xpath="//option[@value='minutes']")
	private WebElement Dropdownminutes;
	
	@FindBy(xpath="//option[@value='hours']")
	private WebElement Dropdownhours;
	
	@FindBy(xpath="//div[@class='rdp p-3']")   //later use
	private WebElement datepicker;
	
	@FindBy(xpath="//div[@class='grid grid-cols-3 gap-3']")
	private WebElement intensityFields;
	
	@FindBy(xpath = "//button[.='Save Activity']")
	private WebElement saveActivityButton;

	@FindBy(xpath="//input[@id='duration']")
	private WebElement durationInput;

	@FindBy(xpath="//select[@name='durationUnit']")
	private WebElement durationUnitDropdown;

	@FindBy(xpath="//select[@id='activityType']")
	private WebElement activityTypeDropdown;

	@FindBy(xpath = "//button[contains(text(),'July') or contains(@aria-haspopup,'dialog')]")
	private WebElement datePickerButton;
	
	@FindBy(xpath="//button[text()='Light']")
	public WebElement lightIntensity;

	@FindBy(xpath="//button[text()='Moderate']")
	public WebElement moderateIntensity;

	@FindBy(xpath="//button[text()='Vigorous']")
	public WebElement vigorousIntensity;
	
	
	
	//constructor
	 public PhysicalActivity_Page(TestContext context) {
		
		 {
	        this.driver = context.getDriver();
	        this.helper = context.getHelper(); 
	        PageFactory.initElements(driver, this);
	    }
		 
	 }
	
	//Methods
	 
	 public void clickphysicalActivity() {
		 
		 physicalActivityButton.click();
	 }
	 
	 public boolean headingPhysicalActivity() {
		 
		 helper.waitForVisibleOf(titlePhysicalActivity);
		 return helper.checkElementDisplayed(titlePhysicalActivity);
	 }
	 
	 
	 public boolean verifysubtextTrackJourney() {
		  
			helper.waitForVisibleOf(subtextTrackJourney);
			return helper.checkElementDisplayed(subtextTrackJourney);	
			
	   }
	 public boolean verifyFieldLabels() {
		 
		 try {
				helper.waitForVisibleOf(activityTypeHeading);
				helper.waitForVisibleOf(DurationHeading);
				helper.waitForVisibleOf(dateHeading);
				helper.waitForVisibleOf(intensityHeading);

				return activityTypeHeading.isDisplayed() &&
				       DurationHeading.isDisplayed() &&
				       dateHeading.isDisplayed() &&
				       intensityHeading.isDisplayed();

			} catch (Exception e) {
				System.out.println("Label missing or not visible: " + e.getMessage());
				return false;
			}
		}
	 
	
	 
	 public boolean verifyActivityOptions(String expectedOptions) {
		 
			List<String> expectedList = Arrays.asList(expectedOptions.split(","));
			List<WebElement> options = activityTypeDropdown.findElements(By.tagName("option"));
			List<String> actualList = options.stream().map(WebElement::getText).collect(Collectors.toList());
			return actualList.containsAll(expectedList);
		}
	 
	 
	 public boolean isDurationInputVisible() {
		 
		    helper.waitForVisibleOf(durationInput);
			return helper.checkElementDisplayed(durationInput);
		}
	 
		public String getDurationPlaceholder() {
			
			 return durationInput.getAttribute("placeholder");
		}
		
	 public boolean isActivityDropdownVisible() {
		 
		 helper.waitForVisibleOf(activityTypeDropdown);
			return helper.checkElementDisplayed(activityTypeDropdown);
		}
	 
	 
		public boolean isDurationUnitDropdownVisible() {
			
			 helper.waitForVisibleOf(durationUnitDropdown);
			return helper.checkElementDisplayed(durationUnitDropdown);
		}

		public boolean verifyDurationUnits(String expectedUnits) {
			
			List<String> expectedList = Arrays.stream(expectedUnits.split(","))
			                    .map(String::trim)
			                    .map(String::toLowerCase)
			                    .collect(Collectors.toList());
			
			List<WebElement> options = durationUnitDropdown.findElements(By.tagName("option"));
			List<String> actualList = options.stream()
			                   .map(e -> e.getText().trim().toLowerCase())
			                   .collect(Collectors.toList());
			
			System.out.println("Expected: " + expectedList);
			System.out.println("Actual: " + actualList);
			
			return actualList.containsAll(expectedList);
		}
		
		
		public boolean verifyIntensityOptions(String expected) {
		    // Wait for all three intensity buttons
		    helper.waitForVisibleOf(lightIntensity);
		    helper.waitForVisibleOf(moderateIntensity);
		    helper.waitForVisibleOf(vigorousIntensity);

		    // Build expected list from input string
		    List<String> expectedList = Arrays.stream(expected.split(","))
		                                      .map(String::trim)
		                                      .map(String::toLowerCase)
		                                      .collect(Collectors.toList());

		    // Get actual button texts
		    List<String> actualList = Arrays.asList(lightIntensity, moderateIntensity, vigorousIntensity)
		                                    .stream()
		                                    .map(e -> e.getText().trim().toLowerCase())
		                                    .collect(Collectors.toList());

		    boolean match = actualList.containsAll(expectedList) && expectedList.containsAll(actualList);

		    if (!match) {
		        System.out.println("Expected list: " + expectedList);
		        System.out.println("Actual list: " + actualList);
		    }

		    return match;
		}

		public boolean verifyDurationUnitOptions(String expected) {
		    helper.waitForVisibleOf(Dropdownminutes);
		    helper.waitForVisibleOf(Dropdownhours);

		    List<String> expectedList = Arrays.stream(expected.split(","))
		                                      .map(String::trim)
		                                      .map(String::toLowerCase)
		                                      .collect(Collectors.toList());

		    List<String> actualList = Arrays.asList(
		        Dropdownminutes.getText().trim().toLowerCase(),
		        Dropdownhours.getText().trim().toLowerCase()
		    );

		    boolean match = actualList.containsAll(expectedList) && expectedList.containsAll(actualList);

		    if (!match) {
		        System.out.println("Expected list: " + expectedList);
		        System.out.println("Actual list: " + actualList);
		    }

		    return match;
		}
		
		public boolean isDatePickerButtonVisible() {
			
		    helper.waitForVisibleOf(datePickerButton);
		    return datePickerButton.isDisplayed();
		}
		
		public boolean isIntensityOptionsVisible() {
			try {
				helper.waitForVisibleOf(lightIntensity);
				helper.waitForVisibleOf(moderateIntensity);
				helper.waitForVisibleOf(vigorousIntensity);

				return lightIntensity.isDisplayed() &&
				       moderateIntensity.isDisplayed() &&
				       vigorousIntensity.isDisplayed();
			} catch (Exception e) {
				System.out.println("Missing intensity button: " + e.getMessage());
				return false;
			}
		}

	
		public boolean isSaveButtonVisible() {

			helper.waitForVisibleOf(saveActivityButton);
			return helper.checkElementDisplayed(saveActivityButton);
		}
		
		
}

