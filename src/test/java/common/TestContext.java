package common;

import org.openqa.selenium.WebDriver;
import driverFactory.DriverConfig;
import pageObject.FreeDashboard_Page;
import pageObject.HomeFreeUser_page;
import pageObject.CommomHomePageFeature_Page;
import pageObject.DiabetesRiskAnalyzer_Page;
import pageObject.LaunchPage_Page;
import pageObject.LoginUI_Page;
import pageObject.PremiumUserExercise_Page;
import pageObject.PremiumUserHome_Page;
import pageObject.PremiumUserLogbook_Page;

import pageObject.PhysicalActivity_Page;
import pageObject.SubscriptionPage_page;
import pageObject.TrackGlucose_Page;
import pageObject.UpgradePage_page;
import pageObject.UpgradeToPremiumSubscription_Page;



public class TestContext {
	public WebDriver driver;
	private DriverConfig factory;
	private Helper helper;
	private ExcelReader excelReader;
	private String baseUrl;
	private LoginUI_Page loginUI_page;

	private LaunchPage_Page launch_pageObj;
	private DiabetesRiskAnalyzer_Page diaRiskAnalyzerPageObj;
	private CommomHomePageFeature_Page commonHomeFeaturesPageObj;

	private String uniqueEmail;
	private String uniqueUsername;
	private String uniquePassword;
	private String uniqueFullName;
	private HomeFreeUser_page freeUser_page;
	private FreeDashboard_Page freeDashboard_page;
	private PremiumUserHome_Page premiumUserHome_page;

	private PremiumUserExercise_Page premiumUserEx_page;
	private PremiumUserLogbook_Page premiumUserLogbook_Page;
	
	private SubscriptionPage_page Subscriptionpage;    
    private UpgradePage_page  UpgradePage;
    private UpgradeToPremiumSubscription_Page premiumSubscription;
    private TrackGlucose_Page trackGlucose;
    private PhysicalActivity_Page physicalActivity;
	
	
	// private Launch_PageObj launch_pageObj;

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
	
	// public LaunchPage_Page getLaunch_PageObj() {

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

	public LaunchPage_Page getLaunch_PageObj() {

		if (launch_pageObj == null) {
			launch_pageObj = new LaunchPage_Page(this);
		}
		return launch_pageObj;
	}

	public DiabetesRiskAnalyzer_Page getDiaRiskAnalyzerPageObj() {
		if (diaRiskAnalyzerPageObj == null) {
			diaRiskAnalyzerPageObj = new DiabetesRiskAnalyzer_Page(this);
		}
		return diaRiskAnalyzerPageObj;
	}

	public CommomHomePageFeature_Page getcommonHomeFeaturesPageObj() {
		if (commonHomeFeaturesPageObj == null) {
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
		freeUser_page = null;
		freeDashboard_page = null;
		premiumUserHome_page = null;
		premiumUserEx_page = null;
		premiumUserLogbook_Page = null;
		Subscriptionpage = null;
		UpgradePage =null;
		premiumSubscription=null;
		trackGlucose = null;
		physicalActivity=null;
	}

}