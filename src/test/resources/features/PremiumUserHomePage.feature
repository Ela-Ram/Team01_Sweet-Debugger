@PremiumUserHomePage @sweet

Feature: Home Page Validation for Registered premium Account User
Background: Premium User is in Home Page after logged in
Given User is on SweetBalance homepage
When  User clicks on Login link
#When  User enter Premium User credential 

Scenario: Verify order of text in navigation bar
Given User landed on Premium page
When User click the home page
Then User should see the navigation bar displaying items in the order: "Home", "Logbook", "Dashboard", "Education"

@PremiumUserHomePageExcercise
Scenario Outline: Verify "<Scenario>" in the Premium UserExercise section
Given User landed on Premium page
When User click the home page
Then The "<Scenario>" in Premium User Excercise should be displayed
Examples:
  | Scenario |
 #	| Animation Challenge Yourself Is Flashing |  
  #| Duration of Animation Challenge Yourself  |  
  #| Challenge Yourself |  
  #| Gender Image  |  Error
  #| Emoji Image  |  
  #| Label under Image  |  
  #| log button |  
  #| Mood based on emoji |  error
  #| Weekly plan |  
  #| Record New Data |  
  #| Options Below Record New Data |  
#	| BloodGlucoseButton | 
#	| Physical Activity | 
#	| Food Intake  | 
#	| Medication |   

@PremiumUserMealSection
Scenario Outline: Verify "<Scenario>" in the Premium UserExercise PreMeal section
Given User landed on Premium page
When User clicks meal section Premium Home Page
Then The "<Scenario>" in Premium UserExcercise PreMeal should be displayed
Examples:
  | Scenario |
  #| Pre Meal In All Meal Section |
  #| Pre Meal Icon In All Meal Section |
  #| Pre Meal Icon First Place In All Meal Section | Error
  
  
 @PremiumUserSnacksSection
Scenario Outline: Verify "<Scenario>" in the Premium UserExercise Sancks section
Given User landed on Premium page
When User clicks snacks section Premium Home Page
Then The "<Scenario>" in Premium UserExcercise Snacks should be displayed
Examples:
  | Scenario |
  #| None PreMeal Snack By Default |
  #| None PreMeal Snack Calorie |
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  