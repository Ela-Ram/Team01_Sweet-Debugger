@sweet @TrackGlucose
Feature: Validate the Track Glucose functionality in the premium user record data
  
 Background: Premium User is in Home Page after logged in
   Given User is on SweetBalance homepage
   When  User clicks on Login link
   When  User enter Premium User credential 

@TrackGlucosetest_001
 Scenario: Verify title in blood glucose form
   Given Premium User is in Home Page
   When  Premium User clicks Blood Glucose
   Then  Premium User should see "Track Glucose" Track Glucose Heading 

 @TrackGlucosetest_002
 Scenario: Verify subtext in form 
   Given Premium User is in Home Page
   When  Premium User clicks Blood Glucose
   Then  User should see subtext " Keep your health in check"
   
 @TrackGlucosetest_003
 Scenario: Verify fields in track glucose 
   Given Premium User is in Home Page
   When  Premium User clicks Blood Glucose
   Then  User should see field for Blood Glucose Level, Reading Type,Date
    
 @TrackGlucosetest_004
 Scenario: Verify input field 
   Given Premium User is in Home Page
   When  Premium User clicks Blood Glucose
   Then  User should see text field for blood glucose
   
 @TrackGlucosetest_005
 Scenario: Verify the placeholder input in blood glucose field 
   Given Premium User is in Home Page
   When  Premium User clicks Blood Glucose
   Then  User should see text "Enter blood glucose level" blood glucose
   
 @TrackGlucosetest_006
 Scenario:  Verify the text in the input field
   Given Premium User is in Home Page
   When  Premium User clicks Blood Glucose 
   Then  User should see "mg/dL" level
   
 @TrackGlucosetest_007
 Scenario: Verify the presence of transition field in track glucose  
   Given Premium User is in Home Page
   When  Premium User clicks Blood Glucose
   Then  User should see three transition details  with text "Low, normal, high"
   
 @TrackGlucosetest_008
 Scenario: Verify the color of transition in Low 
   Given Premium User is in Home Page
   When  Premium User clicks Blood Glucose
   Then  User should see Red color in low
   
 @TrackGlucosetest_009
 Scenario: Verify the color of transition in normal 
   Given Premium User is in Home Page
   When  Premium User clicks Blood Glucose
   Then  User should see green color in normal
   
 @TrackGlucosetest_010
 Scenario:  Verify the color of transition in height
   Given Premium User is in Home Page
   When  Premium User clicks Blood Glucose
   Then  User should see yellow color in high
   
 @TrackGlucosetest_011
 Scenario:  Verify the four button below reading type
   Given Premium User is in Home Page
   When  Premium User clicks Blood Glucose
   Then User should see button "Fasting,Pre-meal,Post-meal,Bedtime"
   
 @TrackGlucosetest_012
 Scenario:  Verify the date picker option
   Given Premium User is in Home Page
   When  Premium User clicks Blood Glucose
   Then  User should see date picker 
   
 @TrackGlucosetest_013
 Scenario: Verify the last reading time 
   Given Premium User is in Home Page
   When  Premium User clicks Blood Glucose
   Then User should see last ready details
   
 @TrackGlucosetest_014
 Scenario: Verify the record reading button 
   Given Premium User is in Home Page
   When  Premium User clicks Blood Glucose
   Then  User should see record reading button
   