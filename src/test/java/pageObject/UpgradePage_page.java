package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.Helper;
import common.TestContext;

public class UpgradePage_page {

	private WebDriver driver;
	private Helper helper;
	
	//locators
	 
	 @FindBy(xpath = "//button[normalize-space()='Upgrade to Premium']")WebElement upgradeToPremiumButton;
	 @FindBy(xpath="//h1[normalize-space()='Upgrade to Premium']")private WebElement upgradeHeading;
	 @FindBy(xpath = "//*[contains(text(),'Get personalized insights and advanced features')]")private WebElement upgradeMessage;
	 @FindBy(xpath="//h3[normalize-space()='Premium Features']")private WebElement premiumFeaturesText;
	 @FindBy(xpath = "//li[contains(text(),'Personalized meal plans')]")private WebElement personalizedMealPlans;
     @FindBy(xpath = "//*[contains(text(),'Advanced analytics')]")private WebElement advancedAnalytics;
     @FindBy(xpath = "//*[contains(text(),'Priority support')]")private WebElement prioritySupport;
     @FindBy(xpath="//p[@class='text-2xl font-bold text-purple-600 mb-2']")private WebElement premiumPriceText;
     @FindBy(xpath="//p[@class='text-sm text-gray-500 mb-4']")private WebElement cancelAnytimeText;
     @FindBy(xpath="//label[normalize-space()='Card Number']")private WebElement cardNumberHeading;
     @FindBy(xpath="//button[normalize-space()='Pay $9.99 USD']")private WebElement payButton;
     @FindBy(xpath = "//p[contains(text(),'agree to our Terms of Service') and contains(text(),'automatically renew')]")
     private WebElement termsAndAutoRenewalNotice;
     @FindBy(xpath = "//p[contains(text(),'By completing this purchase')]")
     private WebElement termsAndRenewalText;
     @FindBy(xpath="//button[normalize-space()='Continue Free']")private WebElement continueFreeBtn;
     @FindBy(xpath="//button[normalize-space()='Home']")private WebElement homePageHeader;
     
	//constructor
		 public UpgradePage_page(TestContext context) {
		        this.driver = context.getDriver();
		        this.helper = context.getHelper(); 
		        PageFactory.initElements(driver, this);
		    }
	
	//Methods
	public void navigateToUpgradePage() {
	   
		driver.get("https://sweet-balance-test-env-3-numpyninjadiabe.replit.app/upgrade");
    
	}		 
   public void clickUpgradeToPremiumBtn() {
		 
		 upgradeToPremiumButton.click();
	 }
   public boolean isPaymentScreenVisible() {
	   
	    return upgradeHeading.isDisplayed();
	}
	
   public boolean isUpgradeHeadingVisible() {
	    return upgradeHeading.isDisplayed();
	}
  
   public boolean isUpgradeMessageVisible() {
	    return upgradeMessage.isDisplayed();
	}

	public String getUpgradeMessageText() {
	    return upgradeMessage.getText();
	}
	
	public boolean isPremiumFeaturesTextVisible() {
	    return premiumFeaturesText.isDisplayed();
	}
	
	public boolean areAllFeaturesVisible() {
	    return personalizedMealPlans.isDisplayed() && advancedAnalytics.isDisplayed() && prioritySupport.isDisplayed();
	}
	
	public boolean isPremiumPriceTextVisible() {
	    return premiumPriceText.isDisplayed();
	}
	
	public boolean isCancelAnytimeTextVisible() {
	    return cancelAnytimeText.isDisplayed();
	}
	public boolean isCancelAnytimeTextBelowPrice() {
	    
	    Point priceLocation = premiumPriceText.getLocation();
	    Point cancelLocation = cancelAnytimeText.getLocation();

	    // y coordinate greater
	    return cancelLocation.getY() > priceLocation.getY();
	}
	
	public String getHeadingText() {
	    return cardNumberHeading.getText().trim();  
	}
	
	public boolean areCardFieldsVisible() {
	    try {
	        // Wait a  iframes are loaded
	        Thread.sleep(2000);
	  
	        // Card number field
	        driver.switchTo().frame(0);  
	        WebElement cardNumberIframeBody = driver.findElement(By.cssSelector("input[name='cardnumber']"));
	        driver.switchTo().defaultContent();

	        // Expiration date
	        driver.switchTo().frame(1);  
	        WebElement expiryIframe = driver.findElement(By.tagName("body")); 
	        driver.switchTo().defaultContent();

	        // CVV
	        driver.switchTo().frame(2);  
	        WebElement cvvIframe = driver.findElement(By.tagName("body"));
	        driver.switchTo().defaultContent();

	        return true;
	    } catch (Exception e) {
	        driver.switchTo().defaultContent(); 
	        return false;
	    }
	}

	public boolean isPayButtonVisible() {
	    
		return payButton.isDisplayed();
	}
	
	public boolean isTermsAndAutoRenewalNoticeVisible() {
		
	    return termsAndAutoRenewalNotice.isDisplayed();
	}
	
	public String getTermsAndRenewalText() {
	    return termsAndRenewalText.getText().trim();
	}
	public void clickContinueFreeBtn() {
		continueFreeBtn.click();
	}
	public boolean isHomePageDisplayed() {
	    return homePageHeader.isDisplayed();
	}
}
