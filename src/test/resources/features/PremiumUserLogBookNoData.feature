@sweet @premiumLogNoData
Feature: Premium User Logbook page with no data

	Background: Premium User is in home page after logged in
		Given The user is in the Home page and clicks Sign In
    When The user enters valid credentials as in "premiumUser" and "PremiumUserNoData" and logs in
  
  @dailyNoBars 
Scenario: Verify bar chart behavior when user has not logged any meals
	Given User is in the homepage
  When User clicks Logbook button
  Then User should see no bars in Daily Nutrition breakdown section

@noPieChart
Scenario: Verify pie chart is hidden when user has not logged any meals
	Given User is in the homepage
  When User clicks Logbook button
  Then User should not see any pie chart in seven day aggregate Nutrition section
  
  @nutritionNodata
    Scenario Outline: Verify "<Scenario>" displays 0g and 0%  in Daily nutrition breakdown section when there is no logs
    Given User is in the homepage
    When User clicks Logbook button 
    Then User should see the "<Scenario>" displayed "0g (0%)"
    
    Examples:
    |Scenario|
    |CarbsCard|
    |ProteinCard|
    |FatsCard|
    
    @activityEmptyChart
Scenario: Verify display of empty chart for no activity log
	Given User is in the homepage
  When User clicks Logbook button
  Then User should see no bars in the chart
  
  @activityNoValue
Scenario Outline: verify the "<Scenario>" value for no activity log
	Given User is in the homepage
  When User clicks Logbook button
  Then User should see "<Scenario>" has "0 cal" value
  
   Examples:
    |Scenario|
    |total calories|
    |daily average|
  
  @noPeakDayValue
Scenario: Verify the peak day value for no activity log
	Given User is in the homepage
  When User clicks Logbook button
  Then User should see no value 
  
  @medicationEmptyChart
Scenario: Verify display empty chart when no medication is scheduled
	Given User is in the homepage
  When User clicks Logbook button
  Then User should see no bars in the chart
  
  @medicationNodata
    Scenario Outline: Verify "<Scenario>" will display 0 doses, if no medication is scheduled
    Given User is in the homepage
    When User clicks Logbook button 
    Then User should see "0 doses"  value in the "<Scenario>" statistics
    
    Examples:
    |Scenario|
    |Total scheduled|
    |Doses Taken|
    |Doses Missed|
    
    @medicationColor
  Scenario Outline: Verify text color of "<Scenario>" text in Medication Dosage section
    Given User is in the homepage
    When User clicks Logbook button 
    Then User should see "<Rgba>" colour "<Scenario>" text 
    
    Examples:
    |Scenario|Color|Rgba|
    |Total Sceduled Color|purple|rgba(91, 33, 182, 1)|
    |Doses Taken Color|green|rgba(6, 95, 70, 1)|
    |Doses Missed Color|yellow|rgba(255, 255, 0, 1)|
    
    @noValueLogReview
    Scenario Outline: Verify the "<Scenario>" value in log review section if there is no log 
    Given User is in the homepage
    When User clicks Logbook button 
    Then User should see hyphen - for all the days under "<Scenario>"
    
    Examples:
    |Scenario|
    |blood glucose|
    |nutrient|
    |activity|
    |Medication|
