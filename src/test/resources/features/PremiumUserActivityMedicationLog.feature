@sweet @premiumActivityMedicalLog @premiumChristy
Feature: Premium User Logbook page - Physical Activity and Medication Dosage Tracker

	Background: Premium User is in home page after logged in
		Given The user is in the Home page and clicks Sign In of premium account
    When The user enters valid credentials as in "premiumUser" and "PremiumUser" and logs in of premium account
    
	@logBookSection 
  Scenario Outline: Verify presence of "<Scenario>" section
    Given User is in the homepage of premium account
    When User clicks Logbook button of premium account
    Then User should see "<Scenario>" section of premium account
    
    Examples:
    |Scenario|
    |Physical Activity|
    |Medication Dosage|
 
   @logBookScetionTitle 
   Scenario Outline: Verify title of "<Scenario>" section
    Given User is in the homepage of premium account
    When User clicks Logbook button of premium account
    Then User should see title "<Scenario>" of premium account
    
    Examples:
    |Scenario|
    |Physical Activity|
    |Medication Dosage|
    |Log Review|
    
	@iconInTitle 
 	Scenario Outline: Verify the presence of icons beside title "<Scenario>"
    Given User is in the homepage of premium account
    When User clicks Logbook button of premium account
    Then User should see the icons on left side of "<Scenario>" title of premium account
    
    Examples:
    |Scenario|
    |Physical Activity Icon|
    |Medication Dosage Icon|
  
  @xAxisValidation
  Scenario Outline: Verify last seven days are displayed on X-axis in "<Scenario>"
    Given User is in the homepage of premium account
    When User clicks Logbook button of premium account
    Then User should see the X-axis display the last seven days ending today for "<Scenario>" of premium account
    
    Examples:
    |Scenario|
    |Physical Activity|

	@alignment
	Scenario: Verify the alignment of statistic card "Total calories","Daily Average","Peak day"
	  Given User is in the homepage of premium account
    When User clicks Logbook button of premium account
    Then User should see exactly three statistic cards displayed horizontally of premium account
   
   @activityColor
   Scenario Outline: Verify text color of "<Scenario>" in Physical Activity section
    Given User is in the homepage of premium account
    When User clicks Logbook button of premium account
    Then User should see "<Scenario>" text colour "<Rgba>" of premium account
    
    Examples:
    |Scenario|Color|Rgba|
    |Total Calories|purple|rgba(91, 33, 182, 1)|
    |Daily Average|orange|rgba(146, 64, 14, 1)|
    |Peak Day|red|rgba(159, 18, 57, 1)|    
   
   @yAxisCalories 
	Scenario: Verify Y-axis has text calories
	  Given User is in the homepage of premium account
    When User clicks Logbook button of premium account
    Then User should see y-axis  clearly labeled with the text "Calories" of premium account
    
  #Skipfornow  
  #@barChartActivity 
	#Scenario: Verify the display of bars if there is activity log in home page 
	 # Given User is in the homepage of premium account
   # When User clicks Logbook button of premium account
   # Then user should see the bars displayed only for days with logged activities of premium account
    
    @yAxisNoOfDose
	Scenario: Verify the Y-axis has text "Number of Doses"
	  Given User is in the homepage of premium account
    When User clicks Logbook button of premium account
    Then User should see the text Number of Doses on Y-axis of premium account
    
	@colorbarChart
 	Scenario Outline: Verify "<Color>" colour bar is displayed for "<Scenario>" on one week schedule
	  Given User is in the homepage of premium account
    When User clicks Logbook button of premium account
    Then User should see "<Rgba>" colour bar for "<Scenario>" of premium account 
    
    Examples:
    |Scenario|Color|Rgba|
    |Doses Taken|green|#22c55e|
    |Doses Missed|red|#ef4444|
    
    @logReviewHeader
	Scenario Outline: Verify table header in log review section 
	  Given User is in the homepage of premium account
    When User clicks Logbook button of premium account
    Then User should see table header "<Scenario>" of premium account
    
    Examples:
    |Scenario|
    |Date|
    |Blood Glucose|
    |Nutrition|
    |Activity|
    |Medication|
 
 @7daysLogReview
	Scenario: Verify log review displays last 7 days of date entries including today
	  Given User is in the homepage of premium account
    When User clicks Logbook button of premium account
    Then User should see date of last seven days including today of premium account
    
@logReviewDateFormat
	Scenario: Verify the display of date format
	  Given User is in the homepage of premium account
    When User clicks Logbook button of premium account
    Then User should see the date format as "MMM dd, yyyy" of premium account
   
  @orderOfDateLog
 	Scenario: Verify the order of date 
	  Given User is in the homepage of premium account 
    When User clicks Logbook button of premium account
    Then User should see the date ordered in descending order for last seven days including today of premium account
    
   
   #@glucoseLogReview
 	#Scenario: Verify the blood glucose entries in log review section if there is log
	 # Given User log blood glucose value in Home page of premium account
   # When User clicks Logbook button of premium account
   # Then User should see logged value for those days under Blood glucose of premium account
    
    
    #@nutrientLogReview
 	#Scenario: Verify the nutrient value entries in log review section if there is log
	 # Given User log Nutrient value in Home page of premium account
   # When User clicks Logbook button of premium account
   # Then User should see logged value for those days under Nutrient value of premium account
    
    
   # @activityLogReview
 	#Scenario: Verify the physical activity entries in log review section if there is log
	  #Given User log Physical Activity in home page of premium account
    #When User clicks Logbook button of premium account
    #Then User should see logged value for those days under physical activity of premium account
    
    #@medicationLogReview
# 	Scenario: Verify the medication value in log review section if there is log 
	#  Given User log Medication dosage in Home page of premium account
  #  When User clicks Logbook button of premium account
  #  Then User should see logged value for those under Medication Dosage of premium account