@sweet @FreeDashboard

Feature: Dashboard page validation for Registered Free account user

Background: User is in First page 
Given User is on login page
When Registered user clicks sign in after entering password

@WelcomeMessage 
Scenario: Verify the Welcome Message is displayed with name
Given User is landed on free page
When User clicks the Dashboard on the navigation bar
Then User should see the Welcome Back,full name message

@DashboardDispalyed
Scenario Outline: Verify "<Scenario>" the presence of dashboard 
Given User is landed on free page
When User clicks the Dashboard on the navigation bar
Then The "<Scenario>" should be displayed

Examples:
  | Scenario |
  | Displayed Message |
  | Upgrade Premium |
  | Account Information |
  | Save Changes |
  | Account Information All Fields |
  
@DashboardAge
Scenario: Verify age should accept only Numeric Value
Given User is in FreeDashboard Page 
When User edit age field with valid data
Then User should see that entered age is displayed in that field

@DashboardHeight
Scenario: Verify height should accept only Numeric Value
Given User is in FreeDashboard Page  
When User edit height field with valid data
Then User should see that entered height is displayed in height field

@DashboardWeight
Scenario: Verify Weight should accept only Numeric Value
Given User is in FreeDashboard Page 
When User edit weight field with valid data
Then User should see that entered weight is displayed in weight field

@DashboardWeight
Scenario: Verify Exercise Routine Level dropdown is displayed with options
Given User is in FreeDashboard Page 
When User clicks the dropdown of Exercise Routine Level
Then User should see the dropdown with options Easy,Medium,Hard

@DashboardCuisinePreferences
Scenario: Verify Cuisine Preferences dropdown is displayed with options
Given User is in FreeDashboard Page 
When User clicks the dropdown of Cuisine Preferences
Then User should see the dropdown with list of cuisine types Indian,American,Continental,Mediterranean,Asian,Middle Eastern,Mexican

@DashboardFoodAllergies
Scenario: Verify Food Allergies dropdown is displayed with options
Given User is in FreeDashboard Page 
When User clicks the dropdown of Food Allergies	
Then User should see the dropdown list of common allergy options None,Dairy,Gluten,Shellfish,Soy,Eggs,Nuts,Other

#Doubt
#@DashboardAccountDetailsUpdateInvalid
#Scenario: Verify account details cannot be updated with invalid data
#Given User is in FreeDashboard Page 
#When User edit with invalid data and click save changes
#Then User should see Error message DashboardAccountDetails
#Doubt
#@DashboardAccountDetailsUpdateVvalid
#Scenario: Verify account details  can be updated with valid data
#Given User is in FreeDashboard Page 
#When User edit all fields and click Save Changes
#Then User should see messages Changes Saved Your profile has been updated successfully!

@DashboardStressManagement
Scenario: Verify the header Stress Management Techniques
Given User is in FreeDashboard Page 
When User scrolls to the Stress Management section
Then User should see the Title Stress Management Techniques

@DashboardNavigationBar
Scenario: Verify the navigation bar order 
Given User is in FreeDashboard Page 
When User scrolls to the navigation bar section
Then user should see tabs Meditation, Breathing, Movement and Mindfulness

@DashboardGuidedMeditation
Scenario: Verify Guided Meditation section is visible
Given User is in FreeDashboard Page 
When User clicks Meditation tab
Then User should see the content with title Guided Meditation

@DashboardMeditationDurationButtons
Scenario: Verify meditation duration options are displayed
Given User is in FreeDashboard Page 
When User clicks Meditation tab
Then User should see buttons for 5 min, 10 min, and 15 min

@DashboardAudioIndicator
Scenario: Verify audio player progress bar and time indicators
Given User is in FreeDashboard Page 
When User clicks Meditation tab
Then User should see a progress bar with time indicators 0:00 and 5:00 by default

@DashboardAudioPlayback
Scenario: Verify audio playback functionality
Given User is in FreeDashboard Page 
When User clicks audio play button 
Then User Should see meditation audio should start playing and the progress bar should update accordingly

@DashboardGentleMovement
Scenario: Verify the Title displayed under Movement tab
Given User is in FreeDashboard Page 
When User clicks Movement Tab
Then User should see title Gentle Movement

@DashboardMovementDescription
Scenario: Verify the content displayed under Movement tab
Given User is in FreeDashboard Page 
When User clicks Movement Tab
Then User should see the description simple stretches to release tension: with the bullet points, Neck rolls - 5 times each direction, Shoulder circles - 10 times, Wrist and ankle rotations, Gentle torso twists
  
  
@DashboardMindfulness
Scenario: Verify the title under Mindfulness tab
Given User is in FreeDashboard Page 
When  User clicks Mindfulness tab
Then User should see title Present Moment Awareness

@DashboardMindfulnessDescription
Scenario: Verify the content displayed under Mindfulness tab
Given User is in FreeDashboard Page 
When  User clicks Mindfulness tab
Then User should see the description Focus on your senses:with the bullet points, Notice 5 things you can see,Listen for 3 different sounds,Find 2 things you can smell,Observe 1 thing you can taste

@DashboardDiabetesManagementSection
Scenario: Verify Benefits for Diabetes Management section is visible
Given User is in FreeDashboard Page 
When User scroll to the end 
Then User should see the list of benefits Reduces Stress Hormones, with explanation Lowers cortisol that can increase blood glucose,Improves Sleep, with explanation Better sleep leads to better glucose control,Reduces Diabetes Distress with explanation Helps manage overwhelm from diabetes care
   
@DashboardBreathingDescription
Scenario: Verify heading and description is displayed under Breathing tab
Given User is in FreeDashboard Page 
When User clicks breathing tab under stress management techniques
Then User should see the heading 4-7-8 Breathing Technique  with the description A natural tranquilizer for the nervous system

@DashboardBreathingTab
Scenario: Verify Start button is displayed under Breathing tab
Given User is in FreeDashboard Page 
When User clicks breathing tab under stress management techniques
Then User should see the Start Breathing Exercise button


@DashboardCycleCompleted
Scenario: Verify Cycle completed counter is displayed
Given User is in FreeDashboard Page 
When User clicks breathing tab under stress management techniques
Then User should see the Cycles completed counter text and value starting at 0

@DashboardCurrentPhase
Scenario: Verify current phase counter is displayed
Given User is in FreeDashboard Page 
When User clicks breathing tab under stress management techniques
Then User should see the label Current phase with a hyphen (-) as its current value.

@DashboardBreathingSteps
Scenario: verify breathing steps are displayed
Given User is in FreeDashboard Page 
When User clicks breathing tab under stress management techniques
Then User should see the steps Inhale 4 seconds, Hold 7 seconds, Exhale 8 seconds

@DashboardBreathinStartButton
Scenario: Verify start button functionality
Given User is in FreeDashboard Page 
When User clicks the Start Breathing Exercise button during the breathing exercise
Then User should see the breathing cycles begin 






#@Dashboard
#Scenario: Verify start button functionality
#Given User is in FreeDashboard Page 
#When User clicks the Start Breathing Exercise button during the breathing exercise
#Then User should see the breathing cycle displays Inhale which last for 4 seconds
#
#@Dashboard
#Scenario: Verify the inhale phase in breathing cycle
#Given User started Breathing cycle
#When User view the current phase begins
#Then User should see the breathing cycle displays hold which last for 7 seconds
#
#@Dashboard
#Scenario: Verify the hold phase in breathing cycle
#Given User see the inhale phase is completed
#When User view the next phase begins
#Then User should see the breathing cycle displays Exhale which last for 8 seconds
#
#@Dashboard
#Scenario: Verify the count of cycle completed
#Given User completed one full cycle
#When User completes full breathing cycle
#Then User should see Cycles completed counter should increased by 1
#
#@Dashboard
#Scenario: Verify the pause phase in breathing cycle
#Given User completed one full cycle
#When User see next phase begins
#Then User should see breathing cycle displays "pause" which last for 4 seconds
#
#@Dashboard
#Scenario: Verify stop button of breathing exercise
#Given User completed one full cycle
#When  User clicks the Stop button during the breathing exercise
#Then User should see breathing exercise stops
#
#
