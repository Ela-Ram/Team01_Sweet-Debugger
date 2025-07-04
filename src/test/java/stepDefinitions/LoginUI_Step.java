package stepDefinitions;


import java.util.List;
import org.testng.Assert;

import common.LoggerLoad;
import common.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LoginUI_Page;

public class LoginUI_Step {
	
	private TestContext context;
	private  LoginUI_Page loginUI_page;
	
	public LoginUI_Step(TestContext context) {
	this.context = context;
    this.loginUI_page = context.getLoginUI_Page();
	}
	
	@Given("User is on SweetBalance homepage")
	public void user_is_on_sweet_balance_homepage() {
		context.getDriver().get(context.getBaseUrl());
	}

	@When("User clicks on Login link")
	public void user_clicks_on_login_link() {
		loginUI_page.clickLoginGutton();
	   
	}
	@Then("User should see {string} heading")
	public void user_should_see_heading(String expected) {
		
		List<String> actual = loginUI_page.getTextsList();
		boolean isPresent = actual.stream()
                .anyMatch(text -> text.toLowerCase().contains(expected.toLowerCase().trim()));
		Assert.assertTrue(isPresent, 
		        "Expected text not found: '" + expected + "'\nActual: " + actual);
	}
	
	
	@Then("User should verify {string} with {string}")
	public void user_should_verify_with(String scenario, String expected) {
		  switch (scenario.toLowerCase().trim()) {
	        case "presence of close button":
	        	boolean isVisible = loginUI_page.isCloseButtonVisible();
	    	    Assert.assertTrue(isVisible, " Close button is not visible");
	    	    break;
	        case "email input field":
	        	 Assert.assertTrue(loginUI_page.isEmailFieldVisible());
	             break;
	        case "placeholder text in email field":
	        	 String actual = loginUI_page.getEmailText();
	        	 Assert.assertEquals(actual.trim(), expected.trim(), "Text mismatch:\nExpected: " + expected + "\nActual: " + actual);
	             break;
	        case "Continue with Email is enabled ":
	        	 Assert.assertTrue(loginUI_page.isContinueWithEmailButtonEnabled());
	             break;
	             
	             
	    
	}
	}
	
	
	
	
	
	
	
	
	
	
	


}
