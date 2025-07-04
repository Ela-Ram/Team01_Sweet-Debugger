package common;

import org.openqa.selenium.WebDriver;
import driverFactory.DriverConfig;
import pageObject.LoginUI_Page;
import pageObject.PhysicalActivity_Page;
import pageObject.SubscriptionPage_page;
import pageObject.TrackGlucose_Page;
import pageObject.UpgradePage_page;
import pageObject.UpgradeToPremiumSubscription_Page;


public class TestContext {
    private WebDriver driver;
    private DriverConfig factory;
    private Helper helper;
    private ExcelReader excelReader;
    private String baseUrl;
    private LoginUI_Page loginUI_page;  
    private SubscriptionPage_page Subscriptionpage;    
    private UpgradePage_page  UpgradePage;
    private UpgradeToPremiumSubscription_Page premiumSubscription;
    private TrackGlucose_Page trackGlucose;
    private PhysicalActivity_Page physicalActivity;

    public TestContext() {
        factory = new DriverConfig();
        excelReader = new ExcelReader(); 
        baseUrl = ConfigReader.getProperty("URL");
    }

    public WebDriver getDriver() {
        if (driver == null) {
            String browser = ConfigReader.getProperty("Browser");
            driver = factory.initializeDriver(browser);
        }
        return driver;
    }

    public Helper getHelper() {
        if (helper == null) {
            helper = new Helper(getDriver());
        }
        return helper;
    }

    public ExcelReader getExcelReader() {
        return excelReader;
    }

    public String getBaseUrl() {
        return baseUrl;
    }
    
    public LoginUI_Page getLoginUI_Page() {
        if (loginUI_page == null) {
        	loginUI_page = new LoginUI_Page(this);
        }
        return loginUI_page;
    }
    
    public SubscriptionPage_page getSubscriptionpage() {
    	if (Subscriptionpage== null) {
    		Subscriptionpage = new SubscriptionPage_page(this);
    	}
		return Subscriptionpage;
    }
    
    public UpgradePage_page getUpgradepage() {
    	if (UpgradePage== null) {
    		
    		UpgradePage = new UpgradePage_page(this);
    	}
		return UpgradePage;
    }
    
    public UpgradeToPremiumSubscription_Page getpremiumSubscription() {
    	
    	if (premiumSubscription == null) {
    		
    		premiumSubscription= new UpgradeToPremiumSubscription_Page(this);
    	}
    	
    	return premiumSubscription;
    	
    }
    
    public TrackGlucose_Page getTrackGlucose() {
    	
    	if(trackGlucose == null) {
    		
    		trackGlucose= new TrackGlucose_Page(this);
    	}
    	
    	return trackGlucose;
    }
    
    public PhysicalActivity_Page getPhysicalActivity() {
    	
    	if(physicalActivity == null) {
    	
    	  physicalActivity= new PhysicalActivity_Page(this);
    	
    	}
    	
    	return physicalActivity;
    }
    
    
    public void resetPages() {
    	loginUI_page = null;
    
	    // Add other page objects here as you create them
	}
}