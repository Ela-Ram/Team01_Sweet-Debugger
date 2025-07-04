@sweet @UpgradePage
Feature: Validate the Upgrade to Premium Page functionality on the Sweet Balance Portal

  Background: 
    Given User is on login page
    When Registered user clicks sign in after entering password
    When User should be navigted to Home page
    Given User should clicks Dashboard menu
    When User should clicks Upgrade to Premium button

  @UpgradePagetest_001
  Scenario: Verify user able to go to subscription payment screen
    Given User is in upgrade page
    When User clicks the "Upgrade to Premium" button
    Then User should be redirected to the subscription payment screen

  @UpgradePagetest_002
  Scenario: Verify title of Upgrade screen
    Given User is in upgrade page
    When User clicks the "Upgrade to Premium" button
    Then Page title should be "Upgrade to Premium"

  @UpgradePagetest_003
  Scenario: Verify sub text 
    Given User is in upgrade page
    When User clicks the "Upgrade to Premium" button
    Then User should see "Get personalized insights and advanced features to better manage your diabetes."

  @UpgradePagetest_004
  Scenario: Verify the presence of "premium features" 
    Given User is in upgrade page
    When User clicks the "Upgrade to Premium" button
    Then User should see text "premium features"

  @UpgradePagetest_005
  Scenario: verify the description for premium feature 
    Given User is in upgrade page
    When User clicks the "Upgrade to Premium" button
    Then User should see text list of"✓Personalized meal plans,✓Advanced analytics,✓Priority support"

  @UpgradePagetest_006
  Scenario: verify the presence of subscription price
    Given User is in upgrade page
    When User clicks the "Upgrade to Premium" button
    Then User should see monthly price "$9.99/month"

  @UpgradePagetest_007
  Scenario: verify the presence of cancel anytime text
    Given User is in upgrade page
    When User clicks the "Upgrade to Premium" button
    Then User should see cancel anytime text below the pricing details

  @UpgradePagetest_008
  Scenario: Verify the presence of "Card Number"
    Given User is in upgrade page
    When User clicks the "Upgrade to Premium" button
    Then User should see heading "Card Number"

  @UpgradePagetest_009
  Scenario: Verify the presence of fields in payment
    Given User is in upgrade page
    When User clicks the "Upgrade to Premium" button
    Then User should see card number, expiration , cvv field

  @UpgradePagetest_010
  Scenario: Verify  presence of payment button
    Given User is in upgrade page
    When User clicks the "Upgrade to Premium" button
    Then User should see "Pay $9.99 USD" button

  @UpgradePagetest_011
  Scenario: Verify  terms and renewal message
    Given User is in upgrade page
    When User clicks the "Upgrade to Premium" button
    Then User should see terms of service and auto-renewal notice 

  @UpgradePagetest_012
  Scenario: Verify the presence of terms and auto-renewal note
    Given User is in upgrade page
    When User clicks the "Upgrade to Premium" button
    Then User should see presence of terms "By completing this purchase, you agree to our Terms of Service and Privacy Policy. Your subscription will automatically renew each month until cancelled."

  @UpgradePagetest_013
  Scenario: Verify user able to go to home page
    Given User is in upgrade page
    When user clicks the "Go for free" free button
    Then User should be redirected to the home page

