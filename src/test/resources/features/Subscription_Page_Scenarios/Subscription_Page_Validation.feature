@sweet @SubscriptionPageValidation
Feature: Validate the Subscription Page functionality on the Sweet Balance Portal

  Background: 
    Given User is on login page
    When Registered user clicks sign in after entering password
    When User should be navigted to Home page
    

  @SubscriptionPagetest_001
  Scenario: Verify Daily Meal Plan availability
    Given User should clicks Dashboard menu
    When User should clicks Upgrade to Premium button
    Then Both Free and Premium should show Daily Meal Plan as available

  @SubscriptionPagetest_002
  Scenario: Verify Weekly Meal Plan availability
    Given User should clicks Dashboard menu
    When User should clicks Upgrade to Premium button
    Then Weekly Meal Plan should be available only in Premium

  @SubscriptionPagetest_003
  Scenario: Verify Personalized Exercise Plan availability
  
    Given User should clicks Dashboard menu
    When User should clicks Upgrade to Premium button
    Then Personalized Exercise Plan should be available only in Premium

  @SubscriptionPagetest_004
  Scenario: Verify 10-Day Quick Reversal Plan availability
    Given User should clicks Dashboard menu
    When User should clicks Upgrade to Premium button
    Then 10-Day Quick Reversal Plan should be available only in Premium

  @SubscriptionPagetest_005
  Scenario: Verify 30-Day Blood Sugar Reduction Plan
    Given User should clicks Dashboard menu
    When User should clicks Upgrade to Premium button
    Then 30-Day Blood Sugar Reduction Plan should be available only in Premium

  @SubscriptionPagetest_006
  Scenario: Verify Glucose Level Graph availability
    Given User should clicks Dashboard menu
    When User should clicks Upgrade to Premium button
    Then Both Free and Premium should show Glucose Level Graph as available

  @SubscriptionPagetest_007
  Scenario: Verify BMI Calculation availability
    Given User should clicks Dashboard menu
    When User should clicks Upgrade to Premium button
    Then Both Free and Premium should show BMI Calculation as available

  @SubscriptionPagetest_008
  Scenario: Verify Downloadable Meal Plan PDF availability
    Given User should clicks Dashboard menu
    When User should clicks Upgrade to Premium button
    Then Downloadable Meal Plan PDF should be available only in Premium

  @SubscriptionPagetest_009
  Scenario: Verify Reminders availability
  
    Given User should clicks Dashboard menu
    When User should clicks Upgrade to Premium button
    Then Reminders should be available only in Premium

  @SubscriptionPagetest_010
  Scenario: Verify Go for free button is visible
    Given User should clicks Dashboard menu
    When User should clicks Upgrade to Premium button
    Then The "Go for free" button should be visible

  @SubscriptionPagetest_011
  Scenario: Verify Upgrade to Premium button is visible
    Given User should clicks Dashboard menu
    When User should clicks Upgrade to Premium button
    Then The "Upgrade to Premium" premium button should be visible

  @SubscriptionPagetest_012
  Scenario: Verify Free Account label and price
    Given User should clicks Dashboard menu
    When User should clicks Upgrade to Premium button
    Then It should display "Free Account" with "$0 /month" FreeAccount

  @SubscriptionPagetest_013
  Scenario: Verify Premium Account label and price
    Given User should clicks Dashboard menu
    When User should clicks Upgrade to Premium button
    Then It should display "Premium Account" with "$9.99 /month" PremiumAccount

  @SubscriptionPagetest_014
  Scenario: Verify unavailable features are marked with red X
    Given User should clicks Dashboard menu
    When User should clicks Upgrade to Premium button
    Then Features not included should have red X icons

  @SubscriptionPagetest_015
  Scenario: Verify available features are marked with green tick
    Given User should clicks Dashboard menu
    When User should clicks Upgrade to Premium button
    Then All included features should have green checkmarks

  @SubscriptionPagetest_016
  Scenario: Verify total number of features listed
    Given User should clicks Dashboard menu
    When User should clicks Upgrade to Premium button
    Then It should list exactly 9 features

  @SubscriptionPagetest_017
  Scenario: Verify position of Go for free button
    Given User should clicks Dashboard menu
    When User should clicks Upgrade to Premium button
    Then The "Go for free" button should appear under the Free column

  @SubscriptionPagetest_018
  Scenario: Verify position of Upgrade to Premium button
   Given User should clicks Dashboard menu
    When User should clicks Upgrade to Premium button
    Then The "Upgrade to Premium" button should appear under the Premium column

  @SubscriptionPagetest_019
  Scenario: Verify terms and conditions text is visible
   Given User should clicks Dashboard menu
    When User should clicks Upgrade to Premium button
    Then Terms & Conditions and Privacy Policy text should be visible

  @SubscriptionPagetest_020
  Scenario: Verify upgrade message header is displayed
    Given User should clicks Dashboard menu
    When User should clicks Upgrade to Premium button
    Then It should show the text “Upgrade to premium for complete diabetes management”

  @SubscriptionPagetest_021
  Scenario: Verify visual separation between Free and Premium plans
    Given User should clicks Dashboard menu
    When User should clicks Upgrade to Premium button
    Then The Free and Premium plans should be displayed side-by-side in clearly separated columns
