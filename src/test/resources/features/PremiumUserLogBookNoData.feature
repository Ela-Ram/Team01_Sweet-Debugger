@sweet @premiumLogNoData 
Feature: Premium User Logbook page with no data

	Background: Premium User is in home page after logged in
		Given The user is in the Home page and clicks Sign In of premium account
    When The user enters valid credentials as in "premiumUser" and "PremiumUserNoData" and logs in of premium account
    
  @dailyNoBars 
Scenario: Verify bar chart behavior when user has not logged any meals
	Given User is in the homepage of premium account
  When User clicks Logbook button of premium account
  Then User should see no bars in Daily Nutrition breakdown section of premium account

@noPieChart
Scenario: Verify pie chart is hidden when user has not logged any meals
	Given User is in the homepage of premium account
  When User clicks Logbook button of premium account
  Then User should not see any pie chart in seven day aggregate Nutrition section of premium account
  
  @nutritionNodata
    Scenario Outline: Verify "<Scenario>" displays 0g and 0%  in Daily nutrition breakdown section when there is no logs
    Given User is in the homepage of premium account
    When User clicks Logbook button of premium account 
    Then User should see the "<Scenario>" displayed "0g (0%)" in Daily nutrition
    
    Examples:
    |Scenario|
    |CarbsCard|
    |ProteinCard|
    |FatsCard|
    
    @EmptyChart
Scenario Outline: Verify display of empty chart for "<Scenario>" log
	Given User is in the homepage of premium account
  When User clicks Logbook button of premium account
  Then User should see no bars in the chart for "<Scenario>" logs
  
  Examples:
    |Scenario|
    |No Activity|
    |No Medication|
  
  @activityNoValue
Scenario Outline: verify the "<Scenario>" value for no activity log
	Given User is in the homepage of premium account
  When User clicks Logbook button of premium account
  Then User should see "<Scenario>" has "0 cal" value for no activity
  
   Examples:
    |Scenario|
    |total calories|
    |daily average|
  
  @noPeakDayValue
Scenario: Verify the peak day value for no activity log
	Given User is in the homepage of premium account
  When User clicks Logbook button of premium account
  Then User should see no value for no activity
  
  @medicationNodata
    Scenario Outline: Verify "<Scenario>" will display 0 doses, if no medication is scheduled
    Given User is in the homepage of premium account
    When User clicks Logbook button of premium account 
    Then User should see "0 doses"  value in the "<Scenario>" medication statistics
    
    Examples:
    |Scenario|
    |Total scheduled|
    |Doses Taken|
    |Doses Missed|
    
    @medicationColor
  Scenario Outline: Verify text color of "<Scenario>" text in Medication Dosage section
    Given User is in the homepage of premium account
    When User clicks Logbook button of premium account 
    Then User should see "<Rgb>" colour "<Scenario>" text in Medication Dosage section
    
    Examples:
    |Scenario|Color|Rgb|
    |Total Sceduled Color|purple|91, 33, 182|
    |Doses Taken Color|green|6, 95, 70|
    |Doses Missed Color|yellow|255, 255, 0|
    
    @noValueLogReview
    Scenario Outline: Verify the "<Scenario>" value in log review section if there is no log 
    Given User is in the homepage of premium account
    When User clicks Logbook button of premium account 
    Then User should see hyphen - for all the days under "<Scenario>" in log review section
    
    Examples:
    |Scenario|
    |blood glucose|
    |nutrient|
    |activity|
    |Medication|
