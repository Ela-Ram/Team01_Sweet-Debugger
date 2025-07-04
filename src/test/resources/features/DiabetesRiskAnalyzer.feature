#Author: npatni25@gmail.com
@sweet
Feature: Verification on Diabetes Risk Analyzer

  @sweet
  Scenario Outline: Verify <scenario>
    Given User is on SweetBalance homepage
    When User clicks Check Your Risk button
    Then User should see <expected>

    Examples: 
      | scenario                                                              | expected                                                                                |
      | Validate modal dialog sub text                                        | User see  "Answer a few questions to assess your risk of developing diabetes" text      |
      | Verify the presence of Cancel button                                  | User should see Cancel button                                                           |
      | Verify the presence of Calculate Risk button                          | User should see Calculate Risk button                                                   |
      | Validate Calculate Risk is disabled                                   | User should see Calculate Risk button disabled                                          |
      | Verify  age field with Stepper controls (up/down arrows) in dialog    | User should see Age input field to have stepper controls                                |
      | Verify  weight field with Stepper controls (up/down arrows) in dialog | User should see weight input field to have stepper controls                             |
      | Verify the presence of checkbox                                       | User should see check box for Family history of diabetes field                          |
      | Verify the placeholder text for Age field                             | User should be able to view the placeholder "Enter your age (1-150)" in the age field   |
      | Verify the placeholder text for weight                                | User should see "Enter your weight in kg (1-999)"                                       |
      | Verify the dropdown for Physical Activity Level                       | User should see  dropdown for Physical Activity Level                                   |
      | Verify the dropdown for Blood Pressure                                | User should see dropdown for Blood Pressure                                             |
      | Verify the dropdown for Diet Quality                                  | User should see dropdown for Diet Quality                                               |
      | Verify the presence of initial value for Physical Activity Level      | Physical Activity - Level User should see "Select activity level" as the default option |
      | Verify the presence of initial value dropdown for Blood Pressure      | Blood Pressure - User should see "Select blood pressure status" as the default option   |
      | Verify the presence of initial value dropdown for Diet Quality        | Diet Quality - User should see "Select diet quality" as the default option              |
@sweet
  Scenario Outline: Verify the values for Physical Activity Level
    Given User is on SweetBalance homepage
    When User clicks Check Your Risk button
    Then User should see the following options in the activity level dropdown:
      | Select activity level                |
      | Active (Exercise 3+ times a week)    |
      | Moderate (Exercise 1-2 times a week) |
      | Sedentary (Rarely exercise)          |
@sweet
  Scenario Outline: Verify the values for Blood Pressure
    Given User is on SweetBalance homepage
    When User clicks Check Your Risk button
    Then User should see the following options in the Blood Pressure dropdown:
      | Select blood pressure status |
      | Normal                       |
      | Elevated                     |
      | High                         |
@sweet
  Scenario Outline: Verify the values for Diet Quality
    Given User is on SweetBalance homepage
    When User clicks Check Your Risk button
    Then User should see the following options in the Diet Quality dropdown:
      | Select diet quality                             |
      | Excellent (Balanced, mostly whole foods)        |
      | Average (Mixed whole foods and processed foods) |
      | Poor (Mostly processed foods, high sugar)       |
