@sweet @login
Feature: Login Page Verification

  Background: 
    Given User is on SweetBalance homepage

  @skipLaunch @loginpgfield
  Scenario Outline: Verify <Scenario>
    Given User is on login page
    When User clicks continue with email button after entering a email as in "<Sheet>" and "<TestcaseID>"
    Then User should see <Expected>

    Examples: 
      | TestcaseID | Scenario                            | Expected              | Sheet |
      | login_01   | email input accepts valid new email | Complete your profile | login |
      | login_02   | enters an invalid email             | validation error      | login |

  @skipLaunch @reguserloginpgfield
  Scenario Outline: Verify <Scenario>
    Given User is on login page
    When Registered user clicks continue with email button after entering valid email
    Then User should see <Expected>

    Examples: 
      | Scenario                                 | Expected              |
      | email input accepts valid existing email | password field        |
      | password field in login page             | Sign in button        |
      | sub text                                 | email id  in sub text |
      | presence of forgot password link         | Forgot password link  |

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
