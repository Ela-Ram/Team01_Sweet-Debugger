@sweet @PremiumExercise
Feature: Premium user Exercise Module on Homepage

	Background: Premium User is in home page after logged in
		Given The user is in the Home page and clicks Sign In
    When The user enters valid credentials as in "premiumUser" and "PremiumUser" and logs in
	
  @ExercisePage
  Scenario Outline: Verify "<Scenario>" in Excercise page details
    Given User is in the homepage
    When User clicks the Exercise option from the side panel
    Then "<Scenario>" is displayed
    
    Examples:
    	|Scenario|
    	|ViewFullSchedule|
    	|WarmUp|
    	|MainWorkout|
    	|CoolDown|
    
   @WarmUp
  Scenario Outline: Verify "<Scenario>" in Warm Up tab details are displayed
    Given User is in the homepage
    When User clicks the Exercise option from the side panel
    Then "<Scenario>" is displayed
    
    Examples:
    	|Scenario|
    	|ExerciseName|
    	|Description|
    	|Duration|
    	|Calories|
    	|IntensityLevel|
    	|MarkAsCompleted|
    	
   @MainWorkout	
  Scenario Outline: Verify "<Scenario>" in Main Workout tab details are displayed
    Given User is in the Exercise section
    When User clicks the Main Workout Tab
    Then "<Scenario>" is displayed
    
    Examples:
    	|Scenario|
    	|ExerciseName|
    	|Description|
    	|Duration|
    	|Calories|
    	|IntensityLevel|
    	|MarkAsCompleted|
    	
   	@CoolDown
  Scenario Outline: Verify "<Scenario>" in Cool Down tab details are displayed
    Given User is in the Exercise section
    When User clicks the Cool Down Tab
    Then "<Scenario>" is displayed
    
    Examples:
    	|Scenario|
    	|ExerciseName|
    	|Description|
    	|Duration|
    	|Calories|
    	|IntensityLevel|
    	|MarkAsCompleted|
    	
  @MarkAsCompleted
  Scenario Outline: Verify "<Scenario>" is displayed when clicking Mark As Completed button
    Given User is in the Exercise section
    When User clicks the Mark As Completed button
    Then "<Scenario>" is displayed
    
    Examples:
    	|Scenario|
    	|SuccessDialog|
    	|Completed|
    	|UndoOption|
    	
	@UndoCompleted
  Scenario: Verify button reverts back after undo
    Given User is in the Exercise section after completing exercise
    When User clicks Undo after marking Exercise as completed
    Then Button changes back to Mark As Completed
 
    @TodaysExerciseScedule
  Scenario: Verify navigation to View full schedule
    Given User is in the Exercise section
    When User clicks the View Full Schedule button
    Then User should redirect to Exercise schedule
    	
   @TodaysExerciseScedule
  Scenario Outline: Verify "<Scenario>" is dispalyed in Todays Exercise Schedule page
    Given User is in the Exercise section
    When User clicks the View Full Schedule button
    Then "<Scenario>" is displayed
    
    Examples:
    	|Scenario|
    	|TodaysExerciseSchedule|
    	|BacktoHome|
    	|WarmUpToday|
    	|WarmUpExerciseName|
    	|WarmUpDescription|
    	|WarmUpDuration|
    	|WarmUpCalories|
    	|WarmUpIntensityLevel|
    	|MainWorkoutToday|
    	|MainExerciseName|
    	|MainDescription|
    	|MainDuration|
    	|MainCalories|
    	|MainIntensityLevel|
    	|CoolDownToday|
    	|CoolDownExerciseName|
    	|CoolDownDescription|
    	|CoolDownDuration|
    	|CoolDownCalories|
    	|CoolDownIntensityLevel|
    	|TotalDuration|
    	
  @ExerciseIntensity	
  Scenario: Verify the intensity value
    Given User is in the Exercise section
    When User clicks the View Full Schedule button
    Then Exercise intensity should low/medium/hard
    
   @WorkourDuration 
  Scenario: Verify total duration matches the sum of individual workout durations
    Given User is in the Exercise section
    When User clicks the View Full Schedule button
    Then total duration should equal the sum of all individual durations
    
   @WorkoutCalories
   Scenario: Verify total calories matches the sum of individual workout calories
    Given User is in the Exercise section
    When User clicks the View Full Schedule button
    Then total calories should equal the sum of all individual calories
