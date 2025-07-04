@sweet @login_OnboargingScenarioswithreport @ela3
Feature: Onboarding Scenarios with blood report

  Background: 
    Given User successfully completed profile setup

  #Feature1: Blood Report Upload Modal  navigation
  @navbloodreportmodal
  Scenario: Verify navigation of blood report modal
    Given User is in upload blood report page after entering values
    When User clicks on Upload Blood Report button
    Then User should navigate to blood report modal

  @uploadbox
  Scenario: Verify upload box supports drag & drop
    Given User is in upload blood report page after entering values
    When User hovers over the upload box
    Then Upload box should show drag & drop interaction

  #-----------------------------------------------------------------------------------------------------------------------------------------------
  #Feature2: Blood Report Upload Modal  navigation
  @pdfupload
  Scenario Outline: Verify "<Scenario>"
    Given User is in upload blood report page after entering values with Blood Report
    When user uploads "<Valid/Invalid>" file
    Then User should see "<Expected>" in blood report upload modal

    Examples: 
      | Scenario                   | Valid/Invalid              | Expected                     |
      | supported file types (PDF) | Invalid file Text or Excel | Only PDF files are supported |
      | file size limit (10MB)     | Invalid pdf over 10mb      | File exceeds 10MB            |
      | valid PDF file upload      | Valid pdf file             | processing percentage bar    |

  @uploadandprocessbuttonenabled
  Scenario: Verify Upload & Process button is enabled after valid upload
    Given User is in upload blood report page after entering values with Blood Report
    When user just uploads Valid pdf file file
    Then User should see "Upload & Process button enabled" in blood report upload modal

  @uploadboxcancel
  Scenario: Verify valid PDF file upload
    Given User is in upload blood report page after entering values with Blood Report
    When User clicks Cancel in upload blood report page
    Then Modal should be closed and user returned to previous screen

  @bloodreportuploadmodal
  Scenario Outline: Verify "<Scenario>"
    Given User is in upload blood report page after entering values with Blood Report
    When user uploads "Valid pdf file" file
    Then User should see "<Expected>" in blood report upload modal

    Examples: 
      | Scenario                             | Expected          |
      | Upload & Process processes the file  | Report analysis   |
      | onboarding button in report analysis | onboarding button |

  Scenario: Upload report and verify all sections are visible
    Given User is in upload blood report page after entering values with Blood Report
    When user uploads "Valid pdf file" file
    Then User should see the following sections:
      | Blood Test Results   |
      | Complete Blood Count |
      | Medical Conditions   |
      | Abnormal Values      |
      | Recommendations      |

  #-----------------------------------------------------------------------------------------------------------------------------------------------
  #Feature3: Onboarding Form Validation
  @Onboardingformvalidation1
  Scenario Outline: Verify "<Scenario>"
    Given User is on report analysis
    When User clicks Onboarding button
    Then User should see "<Expected>" for step for onboarding with Blood report "<Scenario>"

    Examples: 
      | Scenario                       | Expected                                                              |
      | presence of text field         | Enter your age,Enter height in cm (1-300), Enter weight in kg (1-500) |
      | presence of dropdown           | dropdown option for Gender field                                      |
      | dropdown text for gender       | Male , female, prefer not to say                                      |
      | progress shows 1 of 5 steps    | Step 1 of 5                                                           |
      | progress bar is visible        | Progress Bar                                                          |
      | presence of continue button    | enabled Continue button                                               |
      | step 1 progress is highlighted | Step 1 indicator highlighted                                          |

  @Onboardingformvalidation2
  Scenario Outline: Verify "<Scenario>"
    Given User is on report analysis page in onboarding scenarios with report Login
    When User enters all "<valid/invalid>" values with "login" and "<TestCaseID>" and clickd continue Login
    Then User should see "<Expected>" for step for onboarding with Blood report "<Scenario>"

    Examples: 
      | TestCaseID | Scenario                         | Expected                                  | valid/invalid |
      | login_18   | navigation for step 1 onboarding | Step 2 of 5                               | valid         |
      | login_19   | error message for invalid input  | error message if form have invalid values | invalid       |

  #-----------------------------------------------------------------------------------------------------------------------------------------------
  #Feature4: Onboarding Step 1 UI
  @Onboardingformvalidation1
  Scenario Outline: Verify "<Scenario>"
    Given User is in step1 for onboarding process "login" and "login_18" for login module
    When User clicks continue after filling form for login module
    Then User should see "<Expected>" for step for onboarding with Blood report "<Scenario>"

    Examples: 
      | Scenario                            | Expected                                       |
      | Step 2 heading is visible           | Pick your pace: chill stroll or marathon magic |
      | Step 2 subtitle is visible          | Select your preferred exercise intensity level |
      | Back button is visible              | Back button                                    |
      | presence of all 3 intensity options | Easy , Medium , Hard                           |
      | Step 2 progress bar is filled       | Step 2 indicator highlighted                   |

  #-----------------------------------------------------------------------------------------------------------------------------------------------
  #Feature5:Onboarding Step 2 UI
  @Onboardingformvalidation2
  Scenario Outline: Verify "<Scenario>"
    Given User is in step2 for onboarding process "login" and "login_18" for login module
    When User clicks "<option>" from the preferred intensity level
    Then User should see "<Expected>" for step for onboarding with Blood report "<Scenario>"

    Examples: 
      | Scenario                              | Expected                               | option    |
      | option selection in step 2            | Step 3 of 5                            | Easy 🦋   |
      | Step 3 heading is visible             | Your taste buds—what team are they on? | Easy 🦋   |
      | Step 3 subtitle is visible            | Select your dietary preference         | Medium 💪 |
      | Progress bar reflects Step 3 of 5     | Step 3 of 5                            | Medium 💪 |
      | Verify options is displayed in step 2 | All-inclusive diet,Vegetarian,Vegan    | Medium 💪 |
      | Back button is visible                | Back button                            | Medium 💪 |

  @verifybackbuttonstepfromstep2tostep1
  Scenario Outline: Verify "<Scenario>"
    Given User is in step2 for onboarding process "login" and "login_18" for login module

    When User clicks back button in step
    Then User should see "<Expected>" for step for onboarding with Blood report "<Scenario>"

    Examples: 
      | Scenario       | Expected    |
      | Nav back step2 | Step 1 of 5 |

  #-----------------------------------------------------------------------------------------------------------------------------------------------
  #Feature6:Onboarding Step 3 UI
  @Onboardingformvalidation3
  Scenario Outline: Verify "<Scenario>"
    Given User is in step3 for onboarding process "login" and "login_18" for login module
    When User selects from "<available>"  in step6
    Then User should see "<Expected>" for step for onboarding with Blood report "<Scenario>"

    Examples: 
      | Scenario                              | Expected                                                                                          | available                 |
      | option selection in step 3            | Step 4 of 5                                                                                       | All-inclusive diet 🍴🍖🍎 |
      | Step 4 heading is visible             | What's your go-to food passport?                                                                  | Vegan 🥬🌱🌿              |
      | Step 4 subtitle is visible            | To create a meal plan you'll enjoy, please select your preferred cuisines!                        | Vegan 🥬🌱🌿              |
      | Progress bar reflects Step 4 of 5     | Step 4 of 5                                                                                       | Vegan 🥬🌱🌿              |
      | Verify options is displayed in step 3 | Indian 🍛, American 🍔, Continental 🥖, Mediterranean 🥙, Asian 🍜, Middle Eastern 🥙, Mexican 🌮 | Vegetarian 🥗🍆🥕         |
      | Back button is visible                | Back button                                                                                       | Vegetarian 🥗🍆🥕         |

  @verifybackbuttonstepfromstep3tostep2
  Scenario Outline: Verify "<Scenario>"
    Given User is in step3 for onboarding process "login" and "login_18" for login module
    When User clicks back button in step in with blood report
    Then User should see "<Expected>" for step for onboarding with Blood report "<Scenario>"

    Examples: 
      | Scenario       | Expected    |
      | Nav back step3 | Step 2 of 5 |

  #-----------------------------------------------------------------------------------------------------------------------------------------------
  #Feature7 :Onboarding Step 4 UI
  
  @Onboardingformvalidation3
  Scenario Outline: Verify "<Scenario>"
    Given User is in step4 for onboarding process "login" and "login_18" for login module
    When User selects from one of the "<cuisine>" options in step7
    Then User should see "<Expected>" for step for onboarding with Blood report "<Scenario>"

    Examples: 
      | Scenario                              | Expected                                            | cuisine   |
      | option selection in step 4            | Step 5 of 5                                         | Indian 🍛 |
      | Step 5 heading is visible             | Allergic to any foods?                              | Indian 🍛 |
      | Step 5 subtitle is visible            | Select all that apply                               | Indian 🍛 |
      | Progress bar reflects Step 5 of 5     | Step 5 of 5                                         | Indian 🍛 |
      | Verify options is displayed in step 4 | Gluten, Eggs,Soy,Nuts, Dairy,Shellfish , Other,None | Indian 🍛 |
      | Back button is visible                | Back button                                         | Indian 🍛 |

  @verifybackbuttonstepfromstep4tostep3
  Scenario Outline: Verify "<Scenario>"
    Given User is in step4 for onboarding process "login" and "login_18" for login module
    When User clicks back button in step in with blood report
    Then User should see "<Expected>" for step for onboarding with Blood report "<Scenario>"

    Examples: 
      | Scenario       | Expected    |
      | Nav back step4 | Step 3 of 5 |

  @OnboardingStep4submitvisible
  Scenario: Verify Submit button visible
    Given User is in step4 for onboarding process "login" and "login_18" for login module
    When User selects from one of the "Indian 🍛" options in step7
    Then User should see Submit button

  @OnboardingStep4checkbos
  Scenario: VVerify checkbox for options
    Given User is in step4 for onboarding process "login" and "login_18" for login module
    When User selects from one of the "Indian 🍛" options in step7
    Then User should see check box in all options

  #-----------------------------------------------------------------------------------------------------------------------------------------------
  #Feature8 :Onboarding Step 5 UI
  @singleselectionstep5
  Scenario: Verify single selection in allergy
    Given User is in step5 for onboarding process "login" and "login_18" for login module
    When User selects single allergy and clicks submit
    Then User should navigate to subscription details

  @multiselectionstep5
  Scenario: Verify multiple selection in allergy
    Given User is in step5 for onboarding process "login" and "login_18" for login module
    When User selects multipleple allergy and clicks submit
    Then User should navigate to subscription details

  @verifybackbuttonstepfromstep4tostep3
  Scenario Outline: Verify "<Scenario>"
    Given User is in step5 for onboarding process "login" and "login_18" for login module
    When User clicks back button in step in with blood report
    Then User should see "<Expected>" for step for onboarding with Blood report "<Scenario>"

    Examples: 
      | Scenario       | Expected    |
      | Nav back step5 | Step 4 of 5 |
