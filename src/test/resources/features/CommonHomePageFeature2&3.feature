#Author: npatni25@gmail.com

@sweet
Feature: Validation on meal section

  Background:
Given User is on login page
When Registered user clicks Continue with Email after enetering email ID 
Then Registered user clicks the signin after entering password

@sweet
  Scenario: Verify each meal section is clickable to show details
    Given User should be navigted to Home page
    When User clicks on the Breakfast section
    Then Breakfast details  become visible
@sweet
  Scenario: Verify each meal section is clickable to show details
    Given User should be navigted to Home page
    When User clicks on the Lunch section
    Then Lunch details  become visible
@sweet
  Scenario: Verify each meal section is clickable to show details
    Given User should be navigted to Home page
    When User clicks on the Dinner section
    Then Dinner details  become visible
@sweet
  Scenario: Verify each meal section is clickable to show details
    Given User should be navigted to Home page
    When User clicks on the Sancks section
    Then Snacks details  become visible
@sweet
  Scenario Outline: Verify <Scenario>
    Given User should be navigted to Home page
    When User clicks meal section
    Then User should see <Expected>

    Examples: 
      | Scenario                                               | Expected                                                            |
      | Verify meal section contains dish title                | User should see dish title                                          |
      | Verify pre-meal item is shown for each meal            | User should see the pre-meal item name                              |
      | Verify calories for pre-meal is shown for each meal    | User should see the pre-meal calorie value                          |
      | Validate the indicator for breakfast pre-meal          | User should see indicator "AM" for breakfast pre-meal               |
      | Validate the indicator for lunch pre-meal              | User should see indicator "PM" for lunch  pre-meal                  |
      | Validate the indicator for dinner pre-meal             | User should see indicator "PM" for dinner  pre-meal                 |
      