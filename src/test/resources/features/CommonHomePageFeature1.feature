#Author: npatni25@gmail.com

Feature: Validation for home page - Registered user

Background:
Given User calculates risk by entering values in all fields from "launch" and "launch_02" after clicking on Check Your Risk button
When User continue with email button after entering a email as in "login" and "login_06" on Create Account Page 
And User checks the Terms & conditions box after filling all fields as in "login" and "login_06"
And 
Then User is in password auth page

      
@commonHOmePageFeature
Scenario Outline: Verify <Scenario>
  Given User is in password auth page
  When Registered user clicks sign in after entering password
  Then User should see <Expected>

  Examples:
    | Scenario                                                   | Expected                                                           |
    | App name after sign in                                     | SweetBalance text on the left side of the page                    |
    #| user name in home page                                     | name displayed at the top-right corner of the home page           |
    #| the presence of logout link                                | Logout link in the top-right corner                               |
    #| the presence of top navigation bar                         | top navigation bar on the page                                    |
    #| the presence of Home text in navigation bar                | "Home" tab in the top navigation bar                              |
    #| the presence of Dashboard text in navigation bar           | "Dashboard" tab in the top navigation bar                         |
    #| the presence of Education text in navigation bar           | "Education" tab in the top navigation bar                         |
    #| the text Current status in home page                       | "Current Status" section heading on the home page                 |
    #| the text Last updated in home page                         | "Last updated" label below Current Status                         |
    #| the time for last update in home page                      | timestamp displayed next to the "Last updated" label              |
    #| the time format for last update                            | last updated timestamp in 12-hour format or "x min ago" format    |
    #| 12-hour clock indicator is visible                         | 12-hour clock indicator with AM/PM                                |
    #| Latest HbA1C label is visible                              | "Latest HbA1C" label                                              |
    #| BMI label is visible                                       | "BMI" label                                                       |
    #| Average Blood Sugar label is visible                       | "Average Blood Sugar" label                                       |
    #| HbA1C value is visible                                     | Latest HbA1C value                                                |
    #| BMI value is visible                                       | BMI value                                                         |
    #| Average Blood Sugar is visible                             | Average Blood Sugar value                                         |
    #| condition text for HbA1C value less than 5.7               | "Normal" as the condition text                                    |
    #| condition text for HbA1C between 5.7 and 6.4               | "Pre-Diabetic" as the condition text                              |
    #| condition text for HbA1C greater than or equal 6.5         | "Diabetic" as the condition text                                  |
    #| BMI text for value less than 18.5                          | "Underweight" as the BMI category                                 |
    #| BMI text for value between 18.5 and 24.9                   | "Normal" as the BMI category                                      |
    #| BMI text for value between 25.0 and 29.9                   | "Overweight" as the BMI category                                  |
    #| BMI text for value 30.0 or above                           | "Obese" as the BMI category                                       |
    #| units for average blood sugar                              | mg/dL unit below Average Blood Sugar                              |
    #| title in flex container                                    | "Today's Meal Plan" title                                         |
    #| Today’s Meal Plan section is visible                       | "Today's Meal Plan" section                                       |
    #| Breakfast tab is selected by default                       | "Breakfast" tab should be selected by default                     |
    #| the presence of side tab in flex container                 | sidebar tab container within the flex layout                      |
    #| the text Meal plan in flex container                       | "Meal Plan" label in the sidebar section                          |
    #| the text Exercise in flex container                        | "Exercise" label in the sidebar section                           |
    #| the symbol utensil cross in Meal plan                      | utensil icon in the Meal Plan tab                                 |
    #| the symbol dumbbell in Exercise                            | dumbbell icon in the Exercise tab                                 |
    #| View Full Plan button is visible                           | "View Full Plan" button in the Meal Plan section                  |
    
