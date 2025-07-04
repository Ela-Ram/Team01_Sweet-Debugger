@sweet @premiumGlucoseMealLog
Feature: Premium User Logbook page - Glucose and Meal Tracker

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
    |Blood Glucose Tracker|
    |Meal & Nutrition|
 
   @logBookScetionTitle 
   Scenario Outline: Verify title of "<Scenario>" section
     Given User is in the homepage of premium account
    When User clicks Logbook button of premium account
    Then User should see title "<Scenario>" of premium account
    
    Examples:
    |Scenario|
    |Blood Glucose Tracker|
    |Meal & Nutrition|

	@colorCodeGlucose
   Scenario Outline: Verify colour codes for "<Scenario>" 
     Given User is in the homepage of premium account
    When User clicks Logbook button of premium account
    Then User should see "<Scenario>" displayed in "<Rgb>" of premium account
    
    Examples:
    |Scenario|Color|Rgb|
    |Fasting|purple|91, 33, 182|
    |Pre-Meal|green|6, 95, 70|
    |Post-Meal|yellow|2, 8, 23|
    |Bedtime|red|159, 18, 57|
    
	@rangeGlucose
   Scenario Outline: Verify "<Scenario>" glucose type range displayed
     Given User is in the homepage of premium account
    When User clicks Logbook button of premium account
    Then User should see the range for "<Scenario>" be "<Range>" of premium account
    
    Examples:
    |Scenario|Range|
    |Fasting|70-100 mg/dL|
    |Pre-Meal|70-130 mg/dL|
    |Post-Meal|<180 mg/dL|
    |Bedtime|100-140 mg/dL|
    
    @xAxisSevenDays
  Scenario Outline: Verify last seven days are displayed on X-axis in "<Scenario>"
   Given User is in the homepage of premium account
   When User clicks Logbook button of premium account
   Then User should see the X-axis display the last seven days ending today for "<Scenario>" of premium account
    
   Examples:
   |Scenario|
   |Blood Glucose Tracker|
   |Daily Nutrition Breakdown|
    
  @yAxisGlucose
  Scenario: Verify Y-axis starts at 70 in glucose chart
     Given User is in the homepage of premium account
    When User clicks Logbook button of premium account
    Then User should see Y-axis minimum value  70 in glucose chart
    
    @yAxisGlucose
  Scenario: Verify Y-axis ends at 180 in glucose chart
    Given User is in the homepage of premium account
    When User clicks Logbook button of premium account
    Then User should see Y-axis Maximum value 180 in glucose chart
    
	@mealSectionIcon
 Scenario: Verify icon for Meal & Nutrition section is displayed
    Given User is in the homepage of premium account
    When User clicks Logbook button of premium account
    Then User should see Icon  on the left side of Meal & Nutrition title of premium account

	@sevenDayMeal
   Scenario: Verify the presence of 7-day aggregate nutrition section in Meal & Nutrition section
    Given User is in the homepage of premium account
    When User clicks Logbook button of premium account
    Then User should see the section "7-Day Aggregate Nutrition" of premium account
    
   @DailyMealSection
   Scenario: Verify the presence of Daily Nutrition breakdown in Meal & Nutrition section
    Given User is in the homepage of premium account
    When User clicks Logbook button of premium account
    Then User should see the section "Daily Nutrition breakdown" of premium account
    
    @colorSevenDayMeal
   Scenario Outline: Verify text color of "<Scenario>" in 7-day aggregate nutrition section
    Given User is in the homepage of premium account
    When User clicks Logbook button of premium account
    Then User should see "<Scenario>" text colour "<Rgb>" of premium account
    
    Examples:
    |Scenario|Color|Rgb|
    |Carbs|pink|255, 99, 132|
    |Protein|blue|54, 162, 235|
    |Fats|yellow|255, 206, 86|

	@chartMealSection
   Scenario Outline: Verify "<Scenario>" chart behavior when user has logged meals
    Given User is in the homepage of premium account
    When User clicks Logbook button of premium account
    Then User should see "<Scenario>" with nutrient distribution for premium account
    
    Examples:
    |Scenario|
    |Bar|
    |Pie|
    
    @valuesDailySection
    Scenario Outline: Verify "<Scenario>" displays correct value in Daily nutrition breakdown section when there is logs
    Given User is in the homepage of premium account
    When User clicks Logbook button of premium account
    Then User should see the value in the "<Scenario>" Daily nutrition breakdown section
    
    Examples:
    |Scenario|
    |CarbsCard|
    |ProteinCard|
    |FatsCard|