#Author: npatni25@gmail.com
@Neha
Feature: Validation on meal section

  Background: 
    Given Registered user clicks sign in after entering password

  Scenario: Verify each meal section is clickable to show details
    Given User should be navigted to Home page
    When User clicks on the Breakfast section
    Then Breakfast details  become visible

  Scenario: Verify each meal section is clickable to show details
    Given User should be navigted to Home page
    When User clicks on the Lunch section
    Then Lunch details  become visible

  Scenario: Verify each meal section is clickable to show details
    Given User should be navigted to Home page
    When User clicks on the Dinner section
    Then Dinner details  become visible

  Scenario: Verify each meal section is clickable to show details
    Given User should be navigted to Home page
    When User clicks on the Sancks section
    Then Snacks details  become visible

  Scenario Outline: Verify <Scenario>
    Given User should be navigted to Home page
    When User clicks meal section
    Then User should see <Expected>

    Examples: 
      | Scenario                                               | Expected                                                            |
      | Verify meal section contains dish title                | User should see dish title                                          |
      | Verify meal section contains dish description          | User should see description for the dish                            |
      | Verify pre-meal item is shown for each meal            | User should see the pre-meal item name                              |
      | Verify calories for pre-meal is shown for each meal    | User should see the pre-meal calorie value                          |
      | Validate the indicator for breakfast pre-meal          | User should see indicator "AM" for breakfast pre-meal               |
      | Validate the indicator for lunch pre-meal              | User should see indicator "PM" for lunch  pre-meal                  |
      | Validate the indicator for dinner pre-meal             | User should see indicator "PM" for dinner  pre-meal                 |
      | Verify the time format in each pre-meal                | User should see  "hh:mm" based time in pre-meal (eg : 1:00)         |
      | Verify the time in pre-breakfast                       | User should see "7'o clock"                                           |
      | Verify the time in pre-lunch                           | User should see "12 o'clock"                                          |
      | Verify the time in pre-dinner                          | User should see "7'o clock"                                           |
      | Verify Carbs bar color for each meal                   | User should see green color for Carbs                               |
      | Verify Fat bar color                                   | User should see purple color for Fat                                |
      | Verify Protein bar color                               | User should see pink color for Protein                              |
      | Verify unit of measurement for Carbs is in grams       | It should display the unit as "g"                                   |
      | Verify unit of measurement for Protein is in grams (g) | It should display the unit as "g"                                   |
      | Verify unit of measurement for Fat is in grams (g)     | It should display the unit as "g"                                   |
      | Validate the text  calories in pre-meal                | User should see text "calories" after the calorie value in pre meal |
