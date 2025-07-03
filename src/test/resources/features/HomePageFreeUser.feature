@sweet @FreeUser @HomePageFreeUser
Feature: Home Page Validation for Registered Free Account User

Background: User is in First page 
Given User is on login page
When Registered user clicks sign in after entering password
 
@HomePageTextNavigation @HPFreeUser
Scenario: Verify order of text in navigation bar
Given User is landed on free page
When User clicks meal section from FreeUser
Then User should see the navigation bar displaying items in the order: "Home", "Dashboard", "Education"

@HomePageToggle @ToggleIcon
Scenario: Verify the presence of collapse toggle 
Given User is landed on free page
When User clicks meal section from FreeUser
Then User should see a caret toggle icon next to the Today's Meal Plan title
 
@HomePageNutrientInsights @MealNutrientInsights
Scenario: Verify the presence of Nutrition Insights heading is shown for each meal
Given User is landed on free page
When User clicks meal section from FreeUser
Then User should see Nutrition Insights heading for each of the meal section 

@HomePageNutrientBar @HorizontalBar
Scenario: Verify nutrition bar is shown for each meal
Given User is landed on free page
When User clicks meal section from FreeUser
Then User should see horizontal bar for Carbs, Protein, and Fat

@HomePageNutrientValue 
Scenario Outline: Verify "<Scenario>" the presence of Carbs,Protein and Fat in Meals Section
Given User is landed on free page
When User clicks meal section from FreeUser
Then The "<Scenario>" value should be displayed HomePageNutrientValue

Examples:
  | Scenario |
  #| Pre-Meal |
  #| Carbs   |
  #| Protein |
  #| Fat     |
#	| Meal Time |
#	| Snacks PM |
#	| hh:mm Time |
	| snack Three Clock |
#	| Dot Indicator |
#	|View Full Plan |

@HomePageExcercise @ExcercisePlan
Scenario Outline: Verify "<Scenario>" in the Home page Exercise section
Given User is landed on free page
When User clicks exercise section from HomePage
Then The "<Scenario>" in Home page Excercise should be displayed

Examples:
  | Scenario |
  | Exercise Section | 
  | Two Exercise List |  
  | Time In Each Exercise  |
  | Title in Each ExercisePlan  | 
  | MorningExercise Time |
  | EveningExercise Time  |
  | Time Format  | 
  | Time Duration  | 
  | Time Duration Format |
  | Dot Indicator|
  | Intensity Level |
  |View Full Schedule |
  |View Full Schedule Subscription|




















