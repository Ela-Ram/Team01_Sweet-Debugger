#Author: npatni25@gmail.com
@sweet
Feature: Validation for home page - Registered user

  Background: 
    Given User is on login page
    When Registered user clicks Continue with Email after enetering email ID
    Then User is in password auth page

  @sweet
  Scenario Outline: Verify <Scenario>
    Given User is in password auth page
    When Registered user clicks the signin after entering password
    Then User should see <Expected>

    Examples: 
      | Scenario                                         | Expected                                                                          |
      | App name after sign in                           | "SweetBalance" text on the left side of the page                                  |
      | user name in home page                           | name displayed at the top-right corner of the home page  "launch" and "launch_04" |
      | the presence of logout link                      | Logout link in the top-right corner                                               |
      | the presence of top navigation bar               | top navigation bar on the page                                                    |
      | the presence of Home text in navigation bar      | "Home" tab1 in the top navigation bar                                             |
      | the presence of Dashboard text in navigation bar | "Dashboard" tab2 in the top navigation bar                                        |
      | the presence of Education text in navigation bar | "Education" tab3 in the top navigation bar                                        |
      | the text Current status in home page             | "Current Status" section heading on the home page                                 |
      | the text Last updated in home page               | "Last updated:" label below Current Status                                        |
      | the time for last update in home page            | timestamp displayed next to the Last updated label                                |
      | the time format for last update                  | last updated timestamp in 12-hour format or "x min ago" format                    |
      | 12-hour clock indicator is visible               | 12-hour clock indicator with AM/PM                                                |
      | Latest HbA1C label is visible                    | "Latest HbA1c" label1                                                             |
      | BMI label is visible                             | "BMI" label2                                                                      |
      | Average Blood Sugar label is visible             | "Avg Blood Sugar" label3                                                          |
      | HbA1C value is visible                           | Latest HbA1C value                                                                |
      | BMI value is visible                             | BMI value                                                                         |
      | Average Blood Sugar is visible                   | Average Blood Sugar value                                                         |
      | units for average blood sugar                    | mg/dL unit below Average Blood Sugar                                              |
      | title in flex container                          | "Today's Meal Plan" title                                                         |
      | Today’s Meal Plan section is visible             | "Today's Meal Plan" section                                                       |
      | Breakfast tab is selected by default             | "Breakfast" tab should be selected by default                                     |
      | the presence of side tab in flex container       | sidebar tab container within the flex layout                                      |
      | the text Meal plan in flex container             | "Meal Plan" label in the sidebar section                                          |
      | the text Exercise in flex container              | "Exercise" label2 in the sidebar section                                          |
      | View Full Plan button is visible                 | "View Full Plan" button in the Meal Plan section                                  |
