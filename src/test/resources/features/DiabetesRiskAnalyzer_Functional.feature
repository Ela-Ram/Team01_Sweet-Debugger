#Author: npatni25@gmail.com
@Neha
Feature: Verification on Diabetes Risk Analyzer functional

  Background: 
    When User clicks Check Your Risk button
	
@Neha
  Scenario: Validate Cancel button to return home page
    Given User is in diabetes risk analyzer
    When User clicks Cancel button
    Then User should be returned to the "firstPage"
@Neha
  Scenario Outline: Validation Calculate Risk button enabled
    Given User is in diabetes risk analyzer
    When User enters values in all fields from "<Sheet>" and "<TestcaseId>"
    Then User should see Calculate Risk button is  enabled

    Examples: 
      | TestcaseId | Sheet  |
      | launch_01  | launch |
@Neha
  Scenario Outline: Verify valid values in all field  dialog  form
    Given User is in diabetes risk analyzer
    When User enters values in all fields from "<Sheet>" and "<TestcaseId>"
    And User clicks Calculate Risk button after entering valid values in all fields
    Then User should see "Your Diabetes Risk Assessment" dialog box

    Examples: 
      | TestcaseId | Sheet  |
      | launch_01  | launch |
