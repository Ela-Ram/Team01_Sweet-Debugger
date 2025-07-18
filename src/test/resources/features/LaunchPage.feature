#Author: npatni25@gmail.com
#28 scenarios

@sweet
Feature: Verify Homepage UI components

@sweet
  Scenario Outline: Verify <Scenario>
    Given User launches the browser
    When User enters the SweetBalance url
    Then User should see <Expected>

    Examples: 
      | Scenario                                                                                    | Expected                                                                                                                                                           |  |
      | Validate the presence of App Name on the home page                                          | SweetBalance                                                                                                                                                       |  |
      | presence of policy details                                                                  | Our Terms of Service and Privacy Policy have recently been updated                                                                                                 |  |
      | Verify the homepage heading is visible                                                      | Smart Diabetes Tracking Powered by AI                                                                                                                              |  |
      | Verify the Start Today input button is visible                                              | User should see a Start Today input button                                                                                                                         |  |
      | Verify the diabetes management tools section is visible                                     | User should see the text "Comprehensive Diabetes Management Tools"                                                                                                 |  |
      | Verify the Health Tracking card is visible                                                  | User should see a first card with title "Health Tracking"                                                                                                          |  |
      | Verify the Nutrition & Exercise card is visible                                             | User should see a second card with title "Nutrition & Exercise"                                                                                                    |  |
      | Verify the Smart Insights card is visible                                                   | User should see a third card with title "Smart Insights"                                                                                                           |  |
      | Validate description in Health Tracking feature card                                        | User should see text1 Monitor glucose levels, medication, and vital statistics, Easy logging of daily readings,Visualize trends over time,Set personalized targets |  |
      | Validate description in Nutrition & Exercise card                                           | User should see the text  "Carb counting tools,Customized exercise plans,Meal suggestions based on readings"                                                       |  |
      | Validate description in Smart Insights card                                                 | User should see the smartInsights text  "Pattern detection algorithms,Early warning notifications,Actionable recommendations"                                      |  |
      | Validate icon in Health tracking feature card                                               | User should see heart icon                                                                                                                                         |  |
      | Validate icon in Nutrition & Exercise card                                                  | User should see activity inside square icon                                                                                                                        |  |
      | Validate icon in Smart Insights card                                                        | User should see clock icon                                                                                                                                         |  |
      | Verify testimonial from James D. is visible                                                 | User should see a testimonial from user "James D."                                                                                                                 |  |
      | Verify testimonial from Maria L. is visible                                                 | User should see a secon testimonial from user "Maria L."                                                                                                           |  |
      | Verify testimonial from Robert T. is visible                                                | User should see a third testimonial from user "Robert T."                                                                                                          |  |
      | Validate Join our community of successful members text is visible above testimonial section | User should see "Join our community of successful members" text is visible above testimonial section                                                               |  |
      | Validate presence of yellow stars above Join our community of successful members text       | User should see 5 yellow stars above Join our community of successful members text                                                                                 |  |
      | Validate rating for James D testimonial                                                     | User should see 5 stars under first tetsimonial of James D.                                                                                                        |  |
      | Validate rating for Maria L testimonial                                                     | User should see 5 stars under second tetsimonial of Maria L.                                                                                                       |  |
      | Validate rating for Robert T testimonial                                                    | User should see 5 stars under third tetsimonial of Robert T                                                                                                        |  |
      | Validate presence of bottom section heading in home page                                    | User should see a section with heading "Take control of your diabetes today"                                                                                       |  |
      | Validate the presence of button Check your Risk                                             | User should see a button labeled "Check Your Risk"                                                                                                                 |  |

 #------------------------------------------------------------------------------
 #Feature: Verify Homepage navigation components

@sweet
  Scenario: Verify redirection from Start Today button
    Given User is on SweetBalance homepage
    When User click the Start Today button
    Then User should be redirected to the Login page

@sweet
  Scenario: Validate Login link visibility
    Given User is on SweetBalance homepage
    When User look at the top right corner
    Then User  should see a link labeled "Login"

@sweet
  Scenario: Validate Login link redirection
    Given User is on SweetBalance homepage
    When User click on the Login link
    Then User should be redirected to the Login page

@sweet
  Scenario: Verify redirection from Check Your Risk button
    Given User is on SweetBalance homepage
    When User click on Check Your Risk button
    Then User should be redirected to the assessment modal dialog

