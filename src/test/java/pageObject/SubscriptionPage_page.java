package pageObject;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.Helper;
import common.TestContext;

public class SubscriptionPage_page {

	 private WebDriver driver;
	 private Helper helper;
	 
	 //locators
	
	 
	 @FindBy(xpath="//button[normalize-space()='Dashboard']")WebElement dashboardMenu;
	 @FindBy(xpath="//button[normalize-space()='Upgrade to Premium']")WebElement upgradeBtn;
	 @FindBy(xpath="//tbody/tr[1]") @CacheLookup private WebElement crossSymbol;
	 @FindBy(xpath="//tbody/tr[1]") @CacheLookup private WebElement tickDailymeal;
	 @FindBy(xpath="//tbody/tr[2]/td[3]")WebElement tickWeeklymeal;
	 @FindBy(xpath="//tbody/tr[3]/td[3]")WebElement tickPersonalExercise;
	 @FindBy(xpath="//tbody/tr[4]/td[3]")WebElement tick10Days;
	 @FindBy(xpath="//tbody/tr[5]/td[3]")WebElement tick30Days;
	 @FindBy(xpath="//tbody/tr[6]/td[2]")WebElement tickFreeUserOfGlucose;
	 @FindBy(xpath="//tbody/tr[6]/td[3]")WebElement tickPremiumUserOfGlucose;
	 @FindBy(xpath="//tbody/tr[7]/td[2]")WebElement tickFreeUserOfBMI;
	 @FindBy(xpath="//tbody/tr[7]/td[3]")WebElement tickPremiumUserOfBMI;
	 @FindBy(xpath="//tbody/tr[8]/td[3]")WebElement tickPremiumUserDownloadable;
	 @FindBy(xpath="//tbody/tr[9]/td[3]")WebElement tickPremiumUserRemainderMAH;
	 @FindBy(xpath="//button[normalize-space()='Continue Free']")WebElement continueFreeBtn;
	 @FindBy(xpath = "//button[normalize-space()='Upgrade to Premium']")WebElement upgradeToPremiumButton;
	 @FindBy(xpath = "//th[contains(., 'Free Account') and contains(., '$0') and contains(., '/month')]")WebElement freeAccountLabel;
	 @FindBy(xpath = "//th[contains(., 'Premium Account') and contains(., '$9.99') and contains(., '/month')]")WebElement premiumAccountLabel;
	 @FindBy(xpath = "//span[text()='✕' and contains(@class, 'text-red-500')]")private List<WebElement> redXIcons;
	 @FindBy(xpath = "//span[text()='✓' and contains(@class, 'text-emerald-500')]")private List<WebElement> greenTickIcons;
	 @FindBy(xpath = "//tr[contains(@class, 'hover:bg-purple-50/50')]")private List<WebElement> featureRows;
	 @FindBy(xpath = "//tr[contains(@class, 'cta-row')]/td[2]/button[normalize-space()='Continue Free']")private WebElement continueFreeButton;
	 @FindBy(xpath = "//tr[contains(@class, 'cta-row')]/td[3]/button[normalize-space()='Upgrade to Premium']")private WebElement upgradeToPremiumButton1;
	 @FindBy(xpath = "//*[contains(text(), 'Terms & Conditions')]")private WebElement termsAndConditionsText;
     @FindBy(xpath = "//*[contains(text(), 'Privacy Policy')]")private WebElement privacyPolicyText;
     @FindBy(xpath = "//*[contains(text(), 'Upgrade to premium for complete diabetes management')]")private WebElement upgradeMessageHeader;
     @FindBy(xpath = "//thead/tr/th[contains(text(),'Free Account')]")private WebElement freeAccountColumn;
     @FindBy(xpath = "//thead/tr/th[contains(text(),'Premium Account')]")private WebElement premiumAccountColumn;
 
	 //constructor
	 public SubscriptionPage_page(TestContext context) {
	        this.driver = context.getDriver();
	        this.helper = context.getHelper(); 
	        PageFactory.initElements(driver, this);
	    }
	//Methods
	 
	 public void clickDashboardMenu() {
		 dashboardMenu.click();
	 }
	 
	 public void clickUpgradeBtn() {
		// upgradeBtn.click();
		 helper.jsClick(upgradeBtn);  
	 }
	 public boolean redXIcons() {
		 
	     return crossSymbol.isDisplayed();
     }
	 public boolean greenTick() {
		 return tickDailymeal.isDisplayed();
	 } 
	 public boolean weeklyMealGreenTick() {
		 return tickWeeklymeal.isDisplayed();
	 }
	 public boolean PersonalizedExerciseGreenTick() {
		 return tickPersonalExercise.isDisplayed();
	 }
	 public boolean quickReversalGreenTick() {
		 return tick10Days.isDisplayed();
	 }
	 public boolean bloodSugarGreenTick() {
		 return tick30Days.isDisplayed();
	 }
	 public boolean gulcoseLevelFreeUser() {
		 return tickFreeUserOfGlucose.isDisplayed();
	 }
	 public boolean gulcoseLevelPremiumUser() {
		 return tickPremiumUserOfGlucose.isDisplayed();
	 }
	 public boolean BMIfreeUser() {
		 return tickFreeUserOfBMI.isDisplayed();
	 }
	 public boolean BMIpremiumUser() {
		 return tickPremiumUserOfBMI.isDisplayed();
	 }
	 public boolean downloadablePremiumUser() {
		 return tickPremiumUserDownloadable.isDisplayed();
	 }
	 public boolean remainderMAHpremiumUser() {
		 return tickPremiumUserRemainderMAH.isDisplayed();
	 }
	 public boolean goForFreeBtn() {
		 return continueFreeBtn.isDisplayed();
	 }
	 public boolean upgradeToPremiumBtn() {
		 
		 return upgradeToPremiumButton.isDisplayed();
	 }
	 
	 public boolean checkFreeAccountLabel() {
		 return freeAccountLabel.isDisplayed();
		 
	 }
	 public String getFreeAccountLabelText() {
		    return freeAccountLabel.getText();
	 }
	 
	 public boolean isPremiumAccountLabelDisplayed() {
		    return premiumAccountLabel.isDisplayed();
	 }
	 public String getPremiumAccountLabelText() {
		    return premiumAccountLabel.getText();
		}

	 public int getRedXIconCount() {
		    
		 return redXIcons.size();
	}

	 public boolean allRedXIconsAreDisplayed() {
		    for (WebElement icon : redXIcons) {
		        if (!icon.isDisplayed()) {
		            return false;
		        }
		    }
		    return true;
		}
	 public int getGreenTickCount() {
		    
		 return greenTickIcons.size();
		}

	public boolean areAllGreenTicksDisplayed() {
		    for (WebElement icon : greenTickIcons) {
		        if (!icon.isDisplayed()) {
		            return false;
		        }
		    }
		    return true;
		}
	
	public int getFeatureCount() {
	    return featureRows.size();
	}
	
	public boolean isContinueFreeButtonDisplayed() {
	    return continueFreeButton.isDisplayed();
	}
	
	public boolean isUpgradeToPremiumButtonDisplayed() {
	    return upgradeToPremiumButton1.isDisplayed();
	}
	public boolean isTermsAndConditionsVisible() {
	    return termsAndConditionsText.isDisplayed();
	}

	public boolean isPrivacyPolicyVisible() {
	    return privacyPolicyText.isDisplayed();
	}
	public boolean isUpgradeMessageDisplayed() {
	    return upgradeMessageHeader.isDisplayed();
	}

	public String getUpgradeMessageText() {
	    return upgradeMessageHeader.getText();
	}
	public boolean areBothPlanColumnsDisplayed() {
	    return freeAccountColumn.isDisplayed() && premiumAccountColumn.isDisplayed();
	}
}
