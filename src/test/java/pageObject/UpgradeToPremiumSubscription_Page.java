package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.Helper;
import common.TestContext;


public class UpgradeToPremiumSubscription_Page {

	private WebDriver driver;
	private Helper helper;
	
	//locators
	
	    @FindBy(xpath="//button[normalize-space()='Pay $9.99 USD']")private WebElement payBtn;
	
	    @FindBy(xpath="//p[normalize-space()='Your card number is incomplete.']")
	    private WebElement cardNumberError;
 
	    @FindBy(xpath="//p[contains(text(),'Your card’s expiration date is incomplete.')]")
	    private WebElement expirationDateError;

	    @FindBy(xpath="//p[contains(text(),'Your card’s expiration year is invalid.')]")
	    private WebElement expirationDateErrorMessage;
	    
	    @FindBy(xpath="//p[contains(text(),'Your card’s security code is incomplete.')]")
	    private WebElement cvcError;

	    @FindBy(xpath="//div[@class='flex items-center text-red-500 text-sm mt-2']")
	    private WebElement generalPaymentError;

	
	    @FindBy(xpath="//div[@id='card-cvc']")private WebElement cvcField;
	    
	    @FindBy(xpath="//button[normalize-space()='Go to Homepage']") private WebElement goToHomePagebtn;
	
	//constructor
	 public UpgradeToPremiumSubscription_Page(TestContext context) {
	        this.driver = context.getDriver();
	        this.helper = context.getHelper(); 
	        PageFactory.initElements(driver, this);
	    }
	//Methods
	 
	 public void navigateToPremiumPage() {
		 
		 driver.get("https://sweet-balance-test-env-3-numpyninjadiabe.replit.app/Premium");
	 }
	 
	 public void isClickPayBtn()  {
		 
		// Scroll to the Card Number field
			helper.scrollToElement(payBtn);  //javascriptexecutor
		    
			payBtn.click();
		 
	 }
	 
	 public boolean areAllPaymentErrorsDisplayed() {
		 
	
	//    helper.waitForVisibleOf(cardNumberError); 
	    

        return helper.checkElementDisplayed(cardNumberError)
				  &&helper.checkElementDisplayed(expirationDateError)
				  &&helper.checkElementDisplayed(cvcError)
		  &&helper.checkElementDisplayed(generalPaymentError);	
		 
		}
	 
	 
	 public void invalidCardNumberInput() {
		 
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card number input frame']")));

		 WebElement cardNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("cardnumber")));

		 cardNumberField.sendKeys("4242 4242 42");
		 
		 driver.switchTo().defaultContent();
		 	 
	 }
	 
	 public boolean cardNumberErrorDisplayed() {
		 
		 return cardNumberError.isDisplayed() && generalPaymentError.isDisplayed();
	 }
	 
	 public void expiredDateInput() {
		 
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure expiration date input frame']")));

		 WebElement expireDateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("exp-date")));
		 
		 expireDateField.sendKeys("1/90");
		 
		 driver.switchTo().defaultContent();
		 
		 
	 }
	 
	 public boolean expirationDateErrorDisplayed() {
		 
		 return expirationDateErrorMessage.isDisplayed() && generalPaymentError.isDisplayed();
	 }
	 
	 public void validPaymentDetails() {

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    // Switch to Card Number iframe
		    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
		        By.cssSelector("iframe[title='Secure card number input frame']")));
		    WebElement cardNumberField = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.name("cardnumber")));
		    cardNumberField.sendKeys("4242 4242 4242 4242");

		    // Switch back to default before going to next iframe
		    driver.switchTo().defaultContent();

		    //  Switch to Expiration Date iframe
		    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
		        By.cssSelector("iframe[title='Secure expiration date input frame']")));
		    WebElement expireDateField = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.name("exp-date")));
		    expireDateField.sendKeys("07/26");

		    // Switch back to default before going to next iframe
		    driver.switchTo().defaultContent();

		    //  Switch to CVC iframe
		    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
		        By.cssSelector("iframe[title='Secure CVC input frame']")));  
		    WebElement cvcField = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.name("cvc")));
		    cvcField.sendKeys("973");

		    // Final switch back To DOM
		    driver.switchTo().defaultContent();
		      

		    // Click the payment button 
		    wait.until(ExpectedConditions.elementToBeClickable(
		        By.xpath("//button[contains(., 'Pay $9.99 USD')]"))).click();  
		    
		}

	 
	 public void navigateToPremiumAccessOfHomePage(){
		 
		 driver.get("https://sweet-balance-test-env-3-numpyninjadiabe.replit.app/");
		 
		 
	 }
	 
	 public void clickHomePageBtn() {
		 
		 goToHomePagebtn.click();
	 }
	 
}
