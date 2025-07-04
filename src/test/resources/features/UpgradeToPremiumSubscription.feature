@sweet @UpgradeToPremiumSubscription
Feature: Validate the Upgrade To Premium Subscription Page functionality on the sweet Balance Portal

  Background: 
    Given User is on login page
    When Registered user clicks sign in after entering password
    When User should be navigted to Home page
    Given User should clicks Dashboard menu
    When User should clicks Upgrade to Premium button
    Given User is in upgrade page
    When User clicks the "Upgrade to Premium" button

  @PremiumSubscriptiontest_001
  Scenario: Verify User able to do payment with empty fields
    Given User is in upgrade to premium page
    When User clicks the "Pay $9.99 USD" button without entering any card details
    Then User should see validation messages for all required fields

  @PremiumSubscriptiontest_002
  Scenario: Verify User able to do payment with invalid card number
    Given User is in upgrade to premium page
    When User clicks the "Pay $9.99 USD" button with invalid card number
    Then error message should be displayed

  @PremiumSubscriptiontest_003
  Scenario: Verify User able to do payment with expired card
    Given User is in upgrade to premium page
    When User clicks the "Pay $9.99 USD" button with expired card
    Then error message should be displayed condition for expired card
    
    
############## Valid Card Number,Expire Date, Cvv scenarios ############

  #@PremiumSubscriptiontest_004
  #Scenario: Verify User able to do payment with valid payment details
    #Given User is in upgrade to premium page
    #When User clicks the "Pay $9.99 USD" button with valid payment details
    #Then User should be redirected to the confirmation or home page with premium access enabled
