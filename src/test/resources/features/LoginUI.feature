@sweet @login
Feature: Login Page UI Verification

  @skipLaunch @uilogintext
  Scenario Outline: Verify <Scenario> is displayed
    Given User is on SweetBalance homepage
    When User clicks on Login link
    Then User should see "<Text>" heading

    Examples: 
      | Scenario                    | Text                                            |
      | login form header           | Welcome back                                    |
      | sub text of the header      | Sign in to your account or create a new one     |
      | Continue with Email button  | Continue with email                             |
      | Continue with Google button | Continue with Google                            |
      | OR separator                | OR                                              |
      | Terms and Privacy message   | By continuing you agree to our T&Cs and Privacy |

  @skipLaunch @uiverification
  Scenario Outline: Verify <Scenario>
    Given User is on SweetBalance homepage
    When User clicks on Login link
    Then User should verify "<Scenario>" with "<Expected>"

    Examples: 
      | Scenario                        | Expected                                 |
      | presence of close button        | close button at the right corner         |
      #| email input field               | input field to enter email               |
      | placeholder text in email field | Enter email                              |
      | Continue with Email is enabled  | Continue with email button to be enabled |
