@sweet @login_OnboargingScenarioswithoutreport @ela4
Feature: Onboarding Scenarios without blood report

  Background: 
    Given User successfully completed profile setup

  # Onboarding Scenarios without blood report
  # Feature 1: Onboarding Step 1 UI validation
  @OnboardingStepwithoutbloodreportstep1UI
  Scenario Outline: Verify <Scenario>
    Given User is in upload blood report page after entering values
    When User clicks on step for onboarding button
    Then User should see "<Expected>" for step for onboarding without report "<Scenario>"

    Examples: 
      | Scenario                           | Expected                                             |
      | navigation to step for onboarding  | Step 1 of 12                                         |
      | Step1 heading is visible           | So, Which sugar rebellion are we dealing with?       |
      | Step1 sub text                     | This will help us tailor your plan to your condition |
      | Progress bar reflects Step 1 of 12 | Step 1 of 12                                         |
      | options are displayed              | Type 2,I don't know                                  |
      | step 1 progress is highlighted     | Step 1 indicator highlighted                         |

  #-------------------------------------------------------------------------------------------------------------------------------------------------------------
  # Feature 2: Functional scenarios for Step and non functional scenarios for  Step 2
  @OnboardingStepwithoutbloodreportstep1Functional
  Scenario Outline: Verify <Scenario> for step onboarding without blood report
    Given User is in step1 Onboarding form without blood report
    When User selects the "<condition>" in step1 onboarding
    Then User should see "<Expected>" for step for onboarding without report "<Scenario>"

    Examples: 
      | Scenario                           | Expected                            | condition   |
      | option is selectable               | Step 2 of 12                        | I dont know |
      | presence of back button in step 2  | back button in step 2               | I dont know |
      | Step 2 heading is visible          | Which fabulous label fits you best? | I dont know |
      | step 2 sub text                    | Choose your gender                  | I dont know |
      | Progress bar reflects Step 2 of 12 | Step 2 of 12                        | I dont know |
      | gender options                     | Male 👨‍🦱,Female 👩‍🦰,Other ⚧️    | I dont know |
      | step 2 progress is highlighted     | Step 2 indicator highlighted        | I dont know |

  @OnboardingStepwithoutbloodreportstep1CaptureMsg
  Scenario Outline: Verify message selecting condition in step1
    Given User is in step1 Onboarding form without blood report
    When User selects the "<condition>" in step1 onboarding
    Then User should see "<Expected>" in step onboarding

    Examples: 
      | Expected                                             | condition   |
      | No worries, we're here to figure it out together! 🔍 | I dont know |

  #-------------------------------------------------------------------------------------------------------------------------------------------------------------
  # Feature 3: Functional test for Onboarding Step 2 and non functional scenarios for Step 3
  @OnboardingStepwithoutbloodreportstep2Fnlstep3NonFnl
  Scenario Outline: Verify <Scenario> for step onboarding without blood report
    Given User is in step2 Onboarding form without blood report
    When User selects a "<gender>" in step3
    Then User should see "<Expected>" for step for onboarding without report "<Scenario>"

    Examples: 
      | Scenario                           | Expected                       | gender     |
      | option is selectable               | Step 3 of 12                   | Male 👨‍🦱 |
      | Step 3 heading is visible          | Age: own it, pick your number. | Male 👨‍🦱 |
      | step 3 sub text                    | Please select your age         | Male 👨‍🦱 |
      | Progress bar reflects Step 3 of 12 | Step 3 of 12                   | Male 👨‍🦱 |
      | Back button is visible in step 3   | Back button                    | Male 👨‍🦱 |

  @OnboardingStepwithoutbloodreportstep2Fnlstep3NonFnl2
  Scenario Outline: Verify <Scenario> for step onboarding without blood report
    Given User is in step2 Onboarding form without blood report
    When User selects a "<gender>" in step3
    Then User should see "<Expected>" for step for onboarding without report "<Scenario>" and "<Suffix>"

    Examples: 
      | Scenario                       | Expected  | Suffix | gender  |
      | options is displayed in step 3 | 18 to 100 | years  | Male 👨 |

  @iframescrollable
  Scenario: Verify user should able to scroll the iframe to see options
    Given User is in step2 Onboarding form without blood report
    When User selects a "Male 👨" in step3
    Then iframe options should have scroll option

  @verifybackbuttonstep2
  Scenario Outline: Verify back button function in step2
    Given User is in step2 Onboarding form without blood report
    When User clicks back button in step
    Then User should see "<Expected>" for step for onboarding without report "<Scenario>"

    Examples: 
      | Scenario       | Expected     |
      | Nav back step2 | Step 1 of 12 |

  #-------------------------------------------------------------------------------------------------------------------------------------------------------------
  # Feature 4: Functional test for Onboarding Step 3 and non functional scenarios for Step 4
  @Onboardingstep3functional1
  Scenario Outline: Validate notification message for <Scenario>
    Given User is in step3 Onboarding form without blood report
    When User selects age between "<Scenario>" in step3 "<age>"
    Then User should see "<Expected>" in step onboarding

    Examples: 
      | Scenario | Expected                                               | age |
      | 18-29    | Young and ready to conquer! 🚀                         |  25 |
      | 30-49    | In your prime and crushing it! 💫                      |  35 |
      | above 50 | Age is just a number, and you're numbering it well! 🎯 |  70 |

  @Onboardingstep3functional2
  Scenario Outline: Verify <Scenario> for step onboarding without blood report
    Given User is in step3 Onboarding form without blood report
    When User selects age between "<Scenario>" in step3 "<age>"
    Then User should see "<Expected>" for step for onboarding without report "<Scenario>"

    Examples: 
      | Scenario                           | Expected                                | age |
      | option is selectable               | Step 4 of 12                            |  25 |
      | Step 4 heading is visible          | How close are you to the clouds?        |  45 |
      | step 4 sub text                    | Please enter your height                |  45 |
      | Progress bar reflects Step 4 of 12 | Step 4 of 12                            |  45 |
      | Back button is visible in step 4   | Back button should be visible in step 4 |  77 |

  @2tabstoselectheight
  Scenario: Verify step 4 has 2 tabs to select height
    Given User is in step3 Onboarding form without blood report
    When User selects age between "<Scenario>" in step3 "25"
    Then following scetions should be visible
      | centimeters     |
      | feet and inches |

  @Onboardingstep3functional3
  Scenario Outline: Verify <Scenario> in step4
    Given User is in step3 Onboarding form without blood report
    When User selects age between "<Scenario>" in step3 "<age>"
    Then User should see "<Expected>" for step for onboarding without reports "<Scenario>"

    Examples: 
      | Scenario          | Expected      | age |
      | first tab height  | Centimeters   |  45 |
      | second tab height | Feet & Inches |  45 |

  @Onboardingstepvaluescm
  Scenario Outline: Validate <Scenario> values
    Given User is in step3 Onboarding form without blood report
    When User selects age between "<Scenario>" in step3 "<age>"
    Then User should see "<Expected>" for step for onboarding without report "<Scenario>" and "<Suffix>"

    Examples: 
      | Scenario    | Expected   | Suffix | age |
      | centimeters | 120 to 220 | cm     |  55 |

  @Onboardingstepvaluesinches
  Scenario: Validate feet and inches values
    Given User is in step3 Onboarding form without blood report
    When User selects age between "<Scenario>" in step3 "55"
    Then User should see options have "4'5 to 7'3"

  @verifybackbuttonstep3
  Scenario Outline: Verify back button function in step3
    Given User is in step3 Onboarding form without blood report
    When User clicks back button in step
    Then User should see "<Expected>" for step for onboarding without report "<Scenario>"

    Examples: 
      | Scenario            | Expected     |
      | Nav back from step3 | Step 2 of 12 |

  #-------------------------------------------------------------------------------------------------------------------------------------------------------------
  # Feature 5: Functional test for Onboarding Step 4 and non functional scenarios for Step 5
  @Onboardingstep4functional1
  Scenario Outline: Validate notification message for <Scenario>
    Given User is in step4 Onboarding form without blood report
    When User selects "<height>" in cm between "<Scenario>"  in step4
    Then User should see "<Expected>" in step onboarding

    Examples: 
      | Scenario    | height | Expected                                                                  |
      | above 180cm |    200 | How's the weather up there? (Sorry, we had to do it once) 🌤️             |
      | below 159cm |    120 | Good things come in smaller packages! 📦                                  |
      | 160-179cm   |    165 | Right in the middle - you can reach shelves AND fit in airplane seats! ✈️ |

  @Onboardingstep4functional2
  Scenario Outline: Validate <Scenario>
    Given User is in step4 Onboarding form without blood report
    When User selects from "<options>" available in step4
    Then User should see "<Expected>" for step for onboarding without report "<Scenario>"

    Examples: 
      | Scenario                                         | Expected                                                                 | options         |
      | user able to select from option in centimeters   | Step 5 of 12                                                             | centimeters     |
      | user able to select from option in feet & inches | Step 5 of 12                                                             | feet and inches |
      | heading for Step5 is visible                     | How much awesome do you weigh?                                           | feet and inches |
      | subtext displayed in Step5                       | We will personalize your nutrition plan to guide you towards your goals! | feet and inches |
      | progress bar displays Step 5 of 12               | Step 5 of 12                                                             | feet and inches |
      | Back button is visible in Step 5                 | Back button                                                              | feet and inches |

  @2tabstoselectweight
  Scenario: Verify step 5 has 2 tabs to select height
    Given User is in step4 Onboarding form without blood report
    When User selects from "feet and inches" available in step4
    Then following scetions should be visible
      | kilograms |
      | pounds    |

  @Onboardingstep4functional3
  Scenario Outline: Verify <Scenario> in step5
    Given User is in step4 Onboarding form without blood report
    When User selects from "feet and inches" available in step4
    Then User should see "<Expected>" for step for onboarding without reports "<Scenario>"

    Examples: 
      | Scenario          | Expected  |
      | first tab weight  | Kilograms |
      | second tab weight | Pounds    |

  @OnboardingstepvalueskgAndlbs
  Scenario Outline: Validate <Scenario> values
    Given User is in step4 Onboarding form without blood report
    When User selects from "feet and inches" available in step4
    Then User should see "<Expected>" for step for onboarding without report "<Scenario>" and "<Suffix>"

    Examples: 
      | Scenario  | Expected  | Suffix |
      | kilograms | 40 to 190 | kg     |
      | pounds    | 90 to 550 | lbs    |

  @navbackfrom4to3
  Scenario Outline: Verify back button function in step2
    Given User is in step4 Onboarding form without blood report
    When User clicks back button in step
    Then User should see "<Expected>" for step for onboarding without report "<Scenario>"

    Examples: 
      | Scenario            | Expected     |
      | Nav back from step4 | Step 3 of 12 |

  #-------------------------------------------------------------------------------------------------------------------------------------------------------------
  # Feature 6: Functional test for Onboarding Step 5 and non functional scenarios for Step 6
  @Onboardingstep5functional1
  Scenario Outline: Validate notification message for weight option <Scenario>
    Given User is in step5 Onboarding form without blood report
    When User selects "<weight>" in kg between "<Scenario>" in step5
    Then User should see "<Expected>" in step onboarding

    Examples: 
      | Scenario        | weight | Expected                                                                    |
      | less than 59    |     50 | Light as a feather! But don't worry, our recipes will keep you grounded. 🪶 |
      | between 60 -84  |     80 | Perfectly balanced, as all things should be! ⚖️                             |
      | greater than 85 |     95 | More of you to love! And more energy to power those workouts. 💪            |

  @Onboardingstep4functional2
  Scenario Outline: Validate <Scenario>
    Given User is in step5 Onboarding form without blood report
    When User selects from "<options>" available in step5
    Then User should see "<Expected>" for step for onboarding without report "<Scenario>"

    Examples: 
      | Scenario                                             | Expected                                                 | options  |
      | user able to select from option in kilogram          | Step 6 of 12                                             | kilogram |
      | user able to select from option in pound             | Step 6 of 12                                             | pound    |
      | heading for Step6 is visible                         | Your taste buds—what team are they on?                   | pound    |
      | subtext displayed in Step6                           | Select your dietary preference                           | pound    |
      | progress bar displays Step 6 of 12                   | Step 6 of 12                                             | pound    |
      | Back button is visible in Step 6                     | Back button                                              | pound    |
      | Step 6 contains options to select dietary preference | All-inclusive diet 🍴🍖🍎,Vegetarian 🥗🍆🥕,Vegan 🥬🌱🌿 | pound    |

  @navbackfrom5to4
  Scenario Outline: Verify the functionality of the Back button in Step5
    Given User is in step5 Onboarding form without blood report
    When User clicks back button in step
    Then User should see "<Expected>" for step for onboarding without report "<Scenario>"

    Examples: 
      | Scenario            | Expected     |
      | Nav back from step5 | Step 4 of 12 |

  #
  #-------------------------------------------------------------------------------------------------------------------------------------------------------------
  # Feature 7: Functional test for onboarding step 6 and non functional scenarios for step 7
  @Onboardingstep6functional1
  Scenario Outline: Validate <Scenario>
    Given User is in step6 Onboarding form without blood report
    When User selects from "<available>"  in step6
    Then User should see "<Expected>" for step for onboarding without report "<Scenario>"

    Examples: 
      | Scenario                                   | available                 | Expected                                                                                |
      | Verify dietary options selectable in step6 | All-inclusive diet 🍴🍖🍎 | Step 7 of 12                                                                            |
      | heading for Step7 is visible               | All-inclusive diet 🍴🍖🍎 | What's your go-to food passport?                                                        |
      | subtext displayed in Step7                 | Vegan 🥬🌱🌿              | To create a meal plan you'll enjoy, please select your preferred cuisines!              |
      | progress bar displays Step 7 of 12         | All-inclusive diet 🍴🍖🍎 | Step 7 of 12                                                                            |
      | Back button is visible in Step 7           | Vegan 🥬🌱🌿              | Back button                                                                             |
      | Step 7 contains cuisine options            | Vegan 🥬🌱🌿              | Indian 🍛,American🍔,Continental🥖,Mediterranean🥙,Asian🍜,Middle Eastern🥙,Mexican🌮🌿 |

  @navbackfrom6to5
  Scenario Outline: Verify the functionality of the Back button in Step6
    Given User is in step6 Onboarding form without blood report
    When User clicks back button in step
    Then User should see "<Expected>" for step for onboarding without report "<Scenario>"

    Examples: 
      | Scenario            | Expected     |
      | Nav back from step6 | Step 5 of 12 |

  #-------------------------------------------------------------------------------------------------------------------------------------------------------------
  # Feature 8: Validation for onboarding step 8
  @Onboardingstep7functional1
  Scenario Outline: Validate <Scenario>
    Given User is in step7 Onboarding form without blood report
    When User selects from one of the "<cuisine>" options in step7
    Then User should see "<Expected>" for step for onboarding without report "<Scenario>"

    Examples: 
      | Scenario                                | cuisine   | Expected                                  |
      | cuisine options are selectable in step7 | Indian 🍛 | Step 8 of 12                              |
      | heading for Step8 is visible            | Indian 🍛 | Allergic to any foods?                    |
      | subtext displayed in Step8              | Indian 🍛 | Select yes if you have any food allergies |
      | progress bar displays Step 8 of 12      | Indian 🍛 | Step 8 of 12                              |
      | Back button is visible in Step 8        | Indian 🍛 | Back button                               |
      | yes,no options are displayed in step 8  | Indian 🍛 | Yes ✅, No ❌                               |

  @navbackfrom7to6
  Scenario Outline: Verify the functionality of the Back button in Step7
    Given User is in step7 Onboarding form without blood report
    When User clicks back button in step
    Then User should see "<Expected>" for step for onboarding without report "<Scenario>"

    Examples: 
      | Scenario            | Expected     |
      | Nav back from step7 | Step 6 of 12 |

  #-------------------------------------------------------------------------------------------------------------------------------------------------------------
  # Feature 9: Validation for onboarding step 9
  @Onboardingstep8functional1
  Scenario Outline: Validate <Scenario>
    Given User is in step8 Onboarding form without blood report
    When User selects "<Yes/No>" option in step8
    Then User should see "<Expected>" for step for onboarding without report "<Scenario>"

    Examples: 
      | Scenario                           | Expected                  | Yes/No |
      | heading for Step 9 is visible      | Tap foods your body hates | yes    |
      | subtext displayed in Step 9        | Select all that apply     | yes    |
      | progress bar displays Step 9 of 12 | Step 9 of 12              | yes    |
      | Back button is visible in Step 9   | Back button               | yes    |
      | user goes to step 10 if choose no  | Step 10 of 12             | no     |

  @Onboardingstep8functional2
  Scenario Outline: Validate <Scenario>
    Given User is in step8 Onboarding form without blood report
    When User selects "<Yes/No>" option in step8
    Then User should see "<Expected>" for step for onboarding without report in step 9 checkbox  "<Scenario>"

    Examples: 
      | Scenario                                        | Expected                                         | Yes/No |
      | allergy options are displayed for yes in step 8 | Dairy, Gluten,Nuts,Shellfish,Soy,Eggs,Other,None | yes    |

  #-------------------------------------------------------------------------------------------------------------------------------------------------------------
  #Feature 10: validation for onboarding step 10
  @Onboardingstep9functional1
  Scenario Outline: Validate <Scenario>
    Given User is in step9 Onboarding form without blood report
    When User selects continue after checking any "<option>" from allergy check box
    Then User should see "<Expected>" for step for onboarding without report "<Scenario>"

    Examples: 
      | Scenario                            | Expected                                  | option |
      | heading for Step 10 is visible      | Any medical quirks worth mentioning?      | dairy  |
      | subtext displayed in Step 10        | Do you have any other medical conditions? | dairy  |
      | progress bar displays Step 10 of 12 | Step 10 of 12                             | dairy  |
      | Back button is visible in Step 10   | Back button                               | dairy  |

  @Onboardingstep9functional2
  Scenario Outline: Validate <Scenario>
    Given User is in step9 Onboarding form without blood report
    When User selects continue after checking any "dairy" from allergy check box
    Then User should see "<Expected>" for step for onboarding without report in step 10 checkbox  "<Scenario>"

    Examples: 
      | Scenario                                             | option | Expected                                                                                                                                                                                           | Yes/No |
      | step 10 contains the list of other medical condition | option | High Blood Pressure, High Cholesterol,Heart Disease,PCOS(Polycystic Ovary Syndrome),Chronic kidney disease,Gastroesophageal reflux disease,Anemia,Hypothyroidism,Hyperthyroidism,None of the above | yes    |

  Scenario: Validate error message is shown if the user proceeds without selecting any checkbox option in step10
    Given User is in step9 Onboarding form without blood report
    When User clicks continue in step
    Then User receives error message as "Please select at least one allergy.".

  #-------------------------------------------------------------------------------------------------------------------------------------------------------------
  #Feature 11: validation for onboarding step 11
  @Onboardingstep10functional1
  Scenario Outline: Validate <Scenario>
    Given User is in step10 Onboarding form without blood report
    When User clicks continue in step
    Then User should see "<Expected>" for step for onboarding without report "<Scenario>"

    Examples: 
      | Scenario                            | Expected                                        |
      | heading for Step 11 is visible      | Pick your pace: chill stroll or marathon magic? |
      | subtext displayed in Step 11        | Select your preferred exercise intensity level  |
      | progress bar displays Step 11 of 12 | Step 11 of 12                                   |
      | Back button is visible in Step 11   | Back button                                     |
      | step 11 contain options to choose   | Easy 🦋,Medium 💪,Hard 🔥                       |

  @multiplecheckboxselected
  Scenario: Verify user able to select multiple checkbox
    Given User is in step10 Onboarding form without blood report
    When User selects the following allergy options:
      | high-cholesterol |
      | heart-disease    |
    Then User should see the following options selected:
      | high-cholesterol |
      | heart-disease    |

  #-------------------------------------------------------------------------------------------------------------------------------------------------------------
  #Feature 12: Validation for onboarding step 12
  @Onboardingstep11functional1
  Scenario Outline: Validate <Scenario>
    Given User is in step11 Onboarding form without blood report
    When User clicks "<option>" from the preferred intensity level
    Then User should see "<Expected>" for step for onboarding without report "<Scenario>"

    Examples: 
      | Scenario                            | Expected                                      | option    |
      | heading for Step 12 is visible      | Final Step- What’s your latest HbA1c number?! | Easy 🦋   |
      | progress bar displays Step 12 of 12 | Step 12 of 12                                 | Medium 💪 |
      | Back button is visible in Step 12   | Back button                                   | Easy 🦋   |

  @Onboardingstep11functional2
  Scenario Outline: Validate <Scenario>
    Given User is in step11 Onboarding form without blood report
    When User clicks "<option>" from the preferred intensity level
    Then User should see "<Expected>" for step for onboarding without report in step 11 "<Scenario>"

    Examples: 
      | Scenario                            | Expected                                  | option    |
      | input field is displayed in step 12 | Enter your HbA1c value (e.g., 7.0)        | Easy 🦋   |
      | the text below the input field      | Please enter a value between 4.0 and 15.0 | Medium 💪 |
      | step 12 has continue button         | continue button                           | Hard 🔥   |

  @verifydescription
  Scenario: Verify the description in step 12
    Given User is in step11 Onboarding form without blood report
    When User clicks "Easy 🦋" from the preferred intensity level
    Then User should see description as in "login" and "login_26"

  #-------------------------------------------------------------------------------------------------------------------------------------------------------------
  #Feature 13: Validation for non functional features in step 12 and personalised screen
  @Onboardingstep12nonfunctional2
  Scenario Outline: Validate <Scenario>
    Given User is in step12 Onboarding form without blood report
    When User enters valid/invalid HbA1c value in the input field as in "<Sheet>" and "<TestCaseID>"
    Then User should see <Expected>

    Examples: 
      | TestCaseID | Scenario                              | Expected                                     | Sheet |
      | login_27   | user cannot enter invalid HbA1c value | see the input field does not accept value    | login |
      | login_28   | user cannot enter valid HbA1c value   | User should see input field accept the value | login |

  @Onboardingstep12nonfunctional2
  Scenario Outline: Validate <Scenario>
    Given User is in step12 Onboarding form without blood report
    When User enters valid HbA1c value in the input field as in "login" and "login_28" and clicks continue
    Then User should see "<Expected>" for  "<Scenario>" for login

    Examples: 
      | Scenario                                                          | Expected                                              |
      | user can proceed after entering a valid HbA1c value               | success                                               |
      | personalization screen appears after clicking Continue            | loading indicator                                     |
      | message in personalised screen                                    | Getting you all set—like a VIP pass to better health! |
      | subtext in personalised screen                                    | Just a moment while we personalize your experience    |
      | Upgrade to Plus screen is displayed after personalization loading | Upgrade to Plus screen                                |
