@sweet @PhysicalActivity
Feature: Validate the Physical Activity functionality in the premium user record data

  Background: Premium User is in Home Page after logged in
    Given User is on SweetBalance homepage
    When User clicks on Login link
    When User enter Premium User credential

  @PhysicalActivitytest_001
  Scenario: Verify title in physical activity form
    Given Premium User is in Home Page
    When Premium User clicks physical activity
    Then User should see title "Physical Activity" Physical Activity

  @PhysicalActivitytest_002
  Scenario: Verify subtext in form
    Given Premium User is in Home Page
    When Premium User clicks physical activity
    Then User should see subtext "Track your fitness journey" in physical activity

  @PhysicalActivitytest_003
  Scenario: Verify fields in track glucose
    Given Premium User is in Home Page
    When Premium User clicks physical activity
    Then User should see field for Activity Type, Duration,Date,Intensity in physical activity

  @PhysicalActivitytest_004
  Scenario: Verify the presence of dropdown for Activity Type
    Given Premium User is in Home Page
    When Premium User clicks physical activity
    Then User should see  dropdown for activity type

  @PhysicalActivitytest_005
  Scenario: Verify the dropdown options for activity type
    Given Premium User is in Home Page
    When Premium User clicks physical activity
    Then User should see  "Walking,Running,Cycling,Weight Training,Yoga,HIIT,Other" in physical activity option

  @PhysicalActivitytest_006
  Scenario: Verify the presence input for Duration
    Given Premium User is in Home Page
    When Premium User clicks physical activity
    Then User should see  input field for duration

  @PhysicalActivitytest_007
  Scenario: Verify the placeholder text for Duration
    Given Premium User is in Home Page
    When Premium User clicks physical activity
    Then User should see "30" in placeholder field

  @PhysicalActivitytest_008
  Scenario: Verify dropdown for duration options
    Given Premium User is in Home Page
    When Premium User clicks physical activity
    Then User should see drop down duration

  @PhysicalActivitytest_009
  Scenario: Verify droption option in duration
    Given Premium User is in Home Page
    When Premium User clicks physical activity
    Then User should see "minutes, hours" minutes and hours in physical activity

  @PhysicalActivitytest_010
  Scenario: Verify the date picker option
    Given Premium User is in Home Page
    When Premium User clicks physical activity
    Then User should see date picker in physical activity

  @PhysicalActivitytest_011
  Scenario: Verify the presence of intensity
    Given Premium User is in Home Page
    When Premium User clicks physical activity
    Then User should see intensity field in physical activity

  @PhysicalActivitytest_012
  Scenario: Verify buttons for intensity
    Given Premium User is in Home Page
    When Premium User clicks physical activity
    Then User should see "Light, Moderate,Vigorous" in physical activity

  @PhysicalActivitytest_013
  Scenario: Verify the save activity button
    Given Premium User is in Home Page
    When Premium User clicks physical activity
    Then User should see save activity button in physical activity
