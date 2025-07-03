package common;

import org.openqa.selenium.WebDriver;
import driverFactory.DriverConfig;
import pageObject.CommomHomePageFeature_Page;
import pageObject.DiabetesRiskAnalyzer_Page;
import pageObject.LaunchPage_Page;
import pageObject.LoginUI_Page;
import pageObject.PremiumUserExercise_Page;
import pageObject.PremiumUserLogbook_Page;
import stepDefinitions.PremiumUserGlucoseMealLog_Step;



public class TestContext {
    public WebDriver driver;
    private DriverConfig factory;
    private Helper helper;
    private ExcelReader excelReader;
    private String baseUrl;
    private LoginUI_Page loginUI_page;

    private PremiumUserExercise_Page premiunUserEx_page;
    private LaunchPage_Page launch_pageObj;
    private DiabetesRiskAnalyzer_Page diaRiskAnalyzerPageObj;
    private CommomHomePageFeature_Page commonHomeFeaturesPageObj;

    private String uniqueEmail;
    private String uniqueUsername;
    private String uniquePassword;
    private String uniqueFullName;
    
    private PremiumUserExercise_Page premiumUserEx_page;
    private PremiumUserLogbook_Page premiumUserLogbook_Page;
    //private Launch_PageObj launch_pageObj;





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
    
    public PremiumUserExercise_Page getPremiumUserEx_page() {
        if (premiumUserEx_page == null) {
        	premiumUserEx_page = new PremiumUserExercise_Page(this);
        }
        return premiumUserEx_page;
    }
    
    public void resetPages() {
    	loginUI_page = null;
    	
    	 
	}


	//public LaunchPage_Page getLaunch_PageObj() {

    
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


	public LaunchPage_Page getLaunch_PageObj() {

		if (launch_pageObj == null)
    	{
    		launch_pageObj = new LaunchPage_Page(this);
    	}
		return launch_pageObj;
	}

	
	public DiabetesRiskAnalyzer_Page getDiaRiskAnalyzerPageObj() {
		if (diaRiskAnalyzerPageObj == null)
    	{
			diaRiskAnalyzerPageObj = new DiabetesRiskAnalyzer_Page(this);
    	}
		return diaRiskAnalyzerPageObj;
	}
	public CommomHomePageFeature_Page  getcommonHomeFeaturesPageObj() {
		if (commonHomeFeaturesPageObj == null)
    	{
			commonHomeFeaturesPageObj = new CommomHomePageFeature_Page(this);
    	}
		return commonHomeFeaturesPageObj;
	}

    
    public PremiumUserLogbook_Page getPremiumUserLogbook_page() {
	     if (premiumUserLogbook_Page == null) {
	    	premiumUserLogbook_Page = new PremiumUserLogbook_Page(this);
	     }
	     return premiumUserLogbook_Page;
   }


}