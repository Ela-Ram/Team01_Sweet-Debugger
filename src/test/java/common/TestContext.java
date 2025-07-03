package common;

import org.openqa.selenium.WebDriver;
import driverFactory.DriverConfig;
import pageObject.FreeDashboard_Page;
import pageObject.HomeFreeUser_page;
import pageObject.LoginUI_Page;
import pageObject.PremiumUserHome_Page;



public class TestContext {
    private WebDriver driver;
    private DriverConfig factory;
    private Helper helper;
    private ExcelReader excelReader;
    private String baseUrl;
    private LoginUI_Page loginUI_page;
    private String uniqueEmail;
    private String uniqueUsername;
    private String uniquePassword;
    private String uniqueFullName;
    
//    private PremiumUserExercise_Page premiumUserEx_page;
//    private PremiumUserLogbook_Page premiumUserLogbook_Page;
//    private Launch_PageObj launch_pageObj;
    private HomeFreeUser_page freeUser_page;
    private FreeDashboard_Page freeDashboard_page;
    private PremiumUserHome_Page premiumUserHome_page;
    

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
    
//  public PremiumUserExercise_Page getPremiumUserEx_page() {
//        if (premiumUserEx_page == null) {
//        	premiumUserEx_page = new PremiumUserExercise_Page(this);
//        }
//        return premiumUserEx_page;
//    }
    
    
     public void resetPages() {
    	loginUI_page = null;
    	
    	 
	}    

  public void setUniqueEmail(String uniqueEmail) {
        this.uniqueEmail = uniqueEmail;
    }

    public String getUniqueUsername() {
        return uniqueUsername;
    }

    public void setUniqueUsername(String uniqueUsername) {
        this.uniqueUsername = uniqueUsername;
    }

    public String getUniquePassword() {
        return uniquePassword;
    }

    public void setUniquePassword(String uniquePassword) {
        this.uniquePassword = uniquePassword;
    }

    public String getUniqueFullName() {
        return uniqueFullName;
    }

    public void setUniqueFullName(String uniqueFullName) {
        this.uniqueFullName = uniqueFullName;
    }

  public String getUniqueEmail() {
        return uniqueEmail;
    }
    
    public HomeFreeUser_page getHomeFreeUser_page() {
        if (freeUser_page == null) {
        	freeUser_page = new HomeFreeUser_page(this);
        }
        return freeUser_page;
    }
    
    public FreeDashboard_Page freeDashboard_page() {
        if (freeDashboard_page == null) {
        	freeDashboard_page = new FreeDashboard_Page(this);
        }
        return freeDashboard_page;
    }
    public PremiumUserHome_Page premiumUserHome_page() {
    	if (premiumUserHome_page == null) {
    		premiumUserHome_page = new PremiumUserHome_Page(this);
    	}
    	return premiumUserHome_page;
    }
    
}