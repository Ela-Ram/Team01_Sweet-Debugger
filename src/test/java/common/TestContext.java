package common;

import org.openqa.selenium.WebDriver;
import driverFactory.DriverConfig;
import pageObject.LoginUI_Page;



public class TestContext {
    public WebDriver driver;
    private DriverConfig factory;
    private Helper helper;
    private ExcelReader excelReader;
    private String baseUrl;
    private LoginUI_Page loginUI_page;
    private String uniqueEmail;
    private String uniqueUsername;
    private String uniquePassword;
    private String uniqueFullName;
    

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
    
    
    
    public void resetPages() {
    	loginUI_page = null;
    
	    // Add other page objects here as you create them
	}
    
    public String getUniqueEmail() {
        return uniqueEmail;
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
}