@sweet @login
Feature: Login Page Verification

  Background: 
    Given User is on SweetBalance homepage

# Feature 2: Login page field and functional Validation - Total:8
  #@skipLaunch @loginpgfield
  #Scenario Outline: Verify <Scenario>
    #Given User is on login page
    #When User clicks continue with email button after entering a email as in "<Sheet>" and "<TestcaseID>"
    #Then User should see <Expected>
#
    #Examples: 
      #| TestcaseID | Scenario                            | Expected              | Sheet |
      #| login_01   | email input accepts valid new email | Complete your profile | login |
      #| login_02   | enters an invalid email             | validation error      | login |

  #@skipLaunch @reguserloginpgfield
  #Scenario Outline: Verify <Scenario>
    #Given User is on login page
    #When Registered user clicks continue with email button after entering valid email
    #Then User should see <Expected>
#
    #Examples: 
      #| Scenario                                 | Expected              |
      #| email input accepts valid existing email | password field        |
      #| password field in login page             | Sign in button        |
      #| sub text                                 | email id  in sub text |
      #| presence of forgot password link         | Forgot password link  |
#
  @skipLaunch @pwdplaceholder
  Scenario: Verify presence of placeholder in password field
    Given User is on login page
    When Registered user clicks continue with email button after entering valid email
    Then User should see expected Text as in "login" and "login_04"

  @skipLaunch @navhome
  Scenario: Verify password input accepts valid existing user
    Given User is on login page
    When Registered user clicks sign in after entering password
    Then User should be navigted to Home page
#----------------------------------------------------------------------------------------------------------------------------------------------------------
#Feature 3: Complete Profile Form validation for new user- Total: 5
  #@skipLaunch @completeprofileform
  #Scenario Outline: Verify <Scenario> is visible
    #Given User is on login page
    #When User clicks continue with email button after entering a email as in "login" and "login_01"
    #Then User should see <Expected>
#
    #Examples: 
      #| Scenario                    | Expected                       |
      #| Full Name field             | Full Name input field          |
      #| Username field              | Username input field           |
      #| Password field              | Password input field           |
      #| Terms & Conditions checkbox | Terms & Conditions checkbox    |
      #| Create Account button       | Disabled Create Account button |
      #
#----------------------------------------------------------------------------------------------------------------------------------------------------------      
#Feature 4: Profile form verification - Total:6
  #@skipLaunch @createaccountenabled
  #Scenario: Verify Create Account button is enabled after valid input
    #Given User is on complete profile form page after entering email as in "login" and "login_01"
    #When User checks the Terms & conditions box after filling all fields as in "login" and "login_06"
    #Then Create Account button should be enabled

  #@skipLaunch @completeprofileform
  #Scenario Outline: Verify <Scenario>
    #Given User is on complete profile form page after entering email as in "login" and "<TestCaseID>"
    #When User clicks create account button after filling all fields as in "login" and "<TestCaseID>"
    #Then User should see "<Expected>" login

    #Examples: 
      #| TestCaseID | Scenario                                   | Expected                       |
      #| login_07   | Create account form with invalid Fullname  | Fullname error message         |
      #| login_08   | Create account form with invalid UserNmae  | Username error message         |
      #| login_09   | Create account form  with valid data       | upload blood report            |
      #| login_10   | presence of Upload Blood Report button     | upload blood report            |
      #| login_11   | presence of Step Through Onboarding button | Step Through Onboarding button |
