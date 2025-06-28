package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.Helper;
import common.TestContext;

public class LoginUI_Page {
	
	
	 private WebDriver driver;
	 private Helper helper;
	 
	 
	 @FindBy(xpath = "//div[@class='flex space-x-4']") WebElement loginButton;
	 @FindBy(xpath = "//div[@class='space-y-6']/*") List<WebElement> loginTexts;
	 @FindBy(xpath = "//div[@id='root']/div/div/button") WebElement closeButton;
	 @FindBy(id= ":r0:-form-item")WebElement emailField;
	 @FindBy(xpath = "//button[@type='submit']") WebElement continueWithEmailButton;
	
	
	 
	 
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
}
