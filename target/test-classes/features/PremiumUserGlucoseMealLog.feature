@sweet @premiumGlucoseMealLog
Feature: Premium User Logbook page - Glucose and Meal Tracker

	Background: Premium User is in home page after logged in
		Given The user is in the Home page and clicks Sign In
    When The user enters valid credentials and logs in

	@logBookSection
  Scenario Outline: Verify presence of "<Scenario>" section
    Given User is in the homepage
    When User clicks Logbook button
    Then User should see "<Scenario>"
    
    Examples:
    |Scenario|
    |Blood Glucose Tracker|
    |Meal & Nutrition|
 
   @logBookScetionTitle 
   Scenario Outline: Verify title of "<Scenario>" section
     Given User is in the homepage
    When User clicks Logbook button
    Then User should see title "<Scenario>"
    
    Examples:
    |Scenario|
    |Blood Glucose Tracker|
    |Meal & Nutrition|

	@colorCodeGlucose
   Scenario Outline: Verify colour codes for "<Scenario>" 
     Given User is in the homepage
    When User clicks Logbook button
    Then User should see "<Scenario>" displayed in "<Rgba>"
    
    Examples:
    |Scenario|Color|Rgba|
    |Fasting|purple|rgba(91, 33, 182, 1)|
    |Pre-Meal|green|rgba(6, 95, 70, 1)|
    |Post-Meal|yellow|rgba(2, 8, 23, 1)|
    |Bedtime|red|rgba(159, 18, 57, 1)|
    
	@rangeGlucose
   Scenario Outline: Verify "<Scenario>" glucose type range displayed
     Given User is in the homepage
    When User clicks Logbook button
    Then User should see the range for "<Scenario>" be "<Range>"
    
    Examples:
    |Scenario|Range|
    |Fasting|70-100 mg/dL|
    |Pre-Meal|70-130 mg/dL|
    |Post-Meal|<180 mg/dL|
    |Bedtime|100-140 mg/dL|
    
 # Scenario Outline: Verify last seven days are displayed on X-axis in "<Scenario>"
  #   Given User is in the homepage
   # When User clicks Logbook button
    #Then User should see the X-axis display the last seven days ending today for "<Scenario>"
    
    #Examples:
    #|Scenario|
    #|Blood Glucose Tracker|
    #|Daily Nutrition Breakdown|
    
  @yAxisGlucose
  Scenario: Verify Y-axis starts at 70 in glucose chart
     Given User is in the homepage
    When User clicks Logbook button
    Then User should see Y-axis minimum value  70
    
    @yAxisGlucose
  Scenario: Verify Y-axis ends at 180 in glucose chart
    Given User is in the homepage
    When User clicks Logbook button
    Then User should see Y-axis Maximum value 180
    
	@mealSectionIcon
 Scenario: Verify icon for Meal & Nutrition section is displayed
    Given User is in the homepage
    When User clicks Logbook button
    Then User should see Icon  on the left side of Meal & Nutrition title

	@sevenDayMeal
   Scenario: Verify the presence of 7-day aggregate nutrition section in Meal & Nutrition section
    Given User is in the homepage
    When User clicks Logbook button 
    Then User should see the section "7-Day Aggregate Nutrition"
    
   @DailyMealSection
   Scenario: Verify the presence of Daily Nutrition breakdown in Meal & Nutrition section
    Given User is in the homepage
    When User clicks Logbook button  
    Then User should see the section "Daily Nutrition breakdown"
    
    @colorSevenDayMeal
   Scenario Outline: Verify text color of "<Scenario>" in 7-day aggregate nutrition section
    Given User is in the homepage
    When User clicks Logbook button 
    Then User should see "<Scenario>" text colour "<Rgba>"
    
    Examples:
    |Scenario|Color|Rgba|
    |Carbs|pink|rgba(255, 99, 132, 1)|
    |Protein|blue|rgba(54, 162, 235, 1)|
    |Fats|yellow|rgba(255, 206, 86, 1)|

	@chartMealSection
   Scenario Outline: Verify "<Scenario>" chart behavior when user has logged meals
    Given User is in the homepage
    When User clicks Logbook button 
    Then User should see "<Scenario>" with nutrient distribution
    
    Examples:
    |Scenario|
    |Bar|
    |Pie|
    
    @valuesDailySection
    Scenario Outline: Verify "<Scenario>" displays correct value in Daily nutrition breakdown section when there is logs
    Given User is in the homepage
    When User clicks Logbook button 
    Then User should see the value in the "<Scenario>"
    
    Examples:
    |Scenario|
    |CarbsCard|
    |ProteinCard|
    |FatsCard|
    
    

  