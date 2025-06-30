package common;

import org.openqa.selenium.WebDriver;
import driverFactory.DriverConfig;
import pageObject.LoginUI_Page;
import pageObject.PremiumUserExercise_Page;


public class TestContext {
    private WebDriver driver;
    private DriverConfig factory;
    private Helper helper;
    private ExcelReader excelReader;
    private String baseUrl;
    private LoginUI_Page loginUI_page;
    private PremiumUserExercise_Page premiunUserEx_page;

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
    
    public PremiumUserExercise_Page getPremiunUserEx_page() {
        if (premiunUserEx_page == null) {
        	premiunUserEx_page = new PremiumUserExercise_Page(this);
        }
        return premiunUserEx_page;
    }
    
    public void resetPages() {
    	loginUI_page = null;
	    // Add other page objects here as you create them
	}
}