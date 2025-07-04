@sweet @login_OnboargingScenarioswithreport
Feature: Onboarding Scenarios with blood report

  @navbloodreportmodal
  Scenario: Verify navigation of blood report modal
    Given User is in upload blood report page
    When User clicks on Upload Blood Report button
   Then User should navigate to blood report modal
  
  @uploadbox
  Scenario: Verify upload box supports drag & drop
    Given User is in upload blood report page
    When User hovers over the upload box
    Then Upload box should show drag & drop interaction
    
 
 #------------------------------------------
 #@uploadboxinvalidfile
  #Scenario: Verify supported file types (PDF)
   #Given User is in upload blood report page with "login" and "login_12"
   # When User tries to upload a non-PDF file
   # Then User should see "Only PDF files are supported" error
    
    #@uploadboxvalidover10MB
  #Scenario: Verify supported file types (PDF)
  # Given User is in upload blood report page with "login" and "login_13"
   # When User uploads a PDF file over 10MB
    #Then User should see "File exceeds 10MB" error
    
    @uploadboxvalidPDF
  Scenario: Verify valid PDF file upload 
   Given User is in upload blood report page with "login" and "login_14"
    When User uploads valid PDF file
    Then User should see processing percentage bar
    
     #@uploadboxcancel
  #Scenario: Verify valid PDF file upload 
  # Given User is in upload blood report page
   # When User clicks Cancel
    #Then Modal should be closed and user returned to previous screen
    
   # @uploadboxprocessthefile
  #Scenario: Verify valid PDF file upload 
   #Given User is in upload blood report page with "login" and "login_15"
    #When User uploads valid PDF file
    #Then User should see Report analysis 
    
    #@uploadboxreportanalysis
  #Scenario: Verify valid PDF file upload 
   #Given User is in upload blood report page with "login" and "login_16"
    #When User uploads valid PDF file
    #Then User should see onboarding button 
    
   #Scenario: Upload report and verify all sections are visible
 # Given User is in upload blood report page with "login" and "login_17"
  #When User uploads valid PDF file
  #Then User should see the following sections:
   # | Blood Test Results     |
    #| Complete Blood Count   |
    #| Medical Conditions     |
    #| Abnormal Values        |
    #| Recommendations        |

 #---------------------------------------------
 
  #@skipLaunch @Onboardingformvalidation1
  #Scenario Outline: Verify <Scenario>
    #Given User is in Onboarding Process after clicking Onboarding button
    #Then User should see <Expected>
#
    #Examples: 
      #| Scenario                    | Expected                       |
      #| presence of text field             | text field for Age, height , weight          |
      #| presence of dropdown            | dropdown option for Gender field         |
     # | dropdown text for gender              | Male , female, prefer not to say  options in dropdown          |
    # | progress shows 1 of 5 steps              | Step 1 of 5           |
    #|progress bar is visible| Progress Bar |
    #	| presence of continue button     | enabled Continue button |
    
    
   # @skipLaunch @Onboardingformvalidation2
 # Scenario Outline: Verify <Scenario>
  #  Given User is in Onboarding Process after clicking Onboarding button
    #When User enters all "<valid/invalid>" values with "login" and "<TestCaseID>" and clickd continue
    #Then User should see <Expected> as

   # Examples: 
    #|TestCaseID  | Scenario                    | Expected                       |valid/invalid|
     #|login_18 | navigation for step 1 onboarding             | User should move to "Step 2 of 5"       |valid|
     #|login_19 | error message for invalid input            | error message if form have invalid values      |invalid|
     
    #@skipLaunch @Onboardingstep1UI
  #Scenario Outline: Verify <Scenario>
    #Given User is in step1 for Onboarding process
    #When User enters all "<valid/invalid>" values with "login" and "login_18" and clickd continue
    #Then User should see "<Expected>" as "<Case>"
#
    #Examples: 
    #| Scenario                    | Expected                       |Case|
    
    #| Step2 heading is visible    | Pick your pace: chill stroll or marathon magic       |Display Title|
    #|subtitle is visible					|Select your preferred exercise intensity level|    Sub Title|
   # |Back button is visible|		Back button is visible| Back button|
   	#	|Step 2 progress bar is filled| Step 2 of 5|step2of5|
   #	|presence of all 3 intensity options|Easy , Medium , Hard|Intensity Options|
   
     
      #@skipLaunch @Onboardingstep2UI
  #Scenario Outline: Verify <Scenario>
   #Given User is in step2 for onboarding process after entering values with "login" and "login_18" 
    #When User selects oneoption from intensity
    #Then User should see "<Expected>" to verify "<Scenario>"
#
    #Examples: 
    #| Scenario                    | Expected                       |step|
    
   #| option selection in step2     | Step 3 of 5      |	 step2|
 		#|Step3 heading is visible| Your taste buds—what team are they on?|step2|
 		#|Step3 sub text |Select your dietary preference|step2|
 		#|Progress bar reflects Step 3 of 5|Step 3 of 5|step2|
 		#|Back button is visible|Back button is visible|step2|
 		#|options is displayed|All-inclusive,Vegetarian,Vegan|step2|
 		
 	
 #	 @skipLaunch @Navbackto1
 #	 Scenario: Verify navigation to Step 1
 #	 Given User is in step2 for onboarding process after entering values with "login" and "login_18" 
 #	 When clicks back button
 #	 Then User Should navigate back to previous step "Step 1 of 5" 
  
 #@skipLaunch @OnboardingStep3UI1
  #Scenario Outline: Verify <Scenario>
    #Given User is in step3 for onboarding process after entering values with "login" and "login_18"  
    #When User selects dietary preference
    #Then User should see "<Expected>" to verify "<Scenario>"

    #Examples: 
    #| Scenario                    | Expected                       |step|
    #
   #|  option is selectable     | Step 4 of 5      |	 step3|
    #|Step 4 heading is visible|What's your go-to food passport?|step3|
   #|Verify step 4 sub text| To create a meal plan you'll enjoy, please select your preferred cuisines!|step3|
 #		|Progress bar reflects Step 4 of 5|Step 4 of 5|step3|	
 #		|Back button is visible|Back button is visible|step3|
 #	
 #	@skipLaunch @OnboardingStepUI2
  #Scenario Outline: Verify <Scenario>
   #Given User is in step3 for onboarding process after entering values with "login" and "login_18" 
    #When User selects dietary preference
    #Then User should see "<Expected>" options 
#
    #Examples: 
    #| Scenario                    | Expected                       |step|
 	#|options is displayed in step4|Indian ,American, Continental, Mediterranean, Asian, Middle, Mexican|step4|
 	
 #	@skipLaunch @Navbackto2
 #	 Scenario: Verify navigation to Step 2
 #	Given User is in step3 for onboarding process after entering values with "login" and "login_18" 
  #	 When clicks back button
 #	 Then User Should navigate back to previous step "Step 2 of 5" 
 
 
 #@skipLaunch @OnboardingStep4UI1
  #Scenario Outline: Verify <Scenario>
   #Given User is in step4 for onboarding process after entering values with "login" and "login_18"
    #When User selects food passport
    #Then User should see "<Expected>" to verify "<Scenario>"
#
    #Examples: 
    #| Scenario                    | Expected                       |step|
    
 # |  option is selectable     | Step 5 of 5      |	 step4|
  
   # |Step 5 heading is visible|Allergic to any foods?|step4|
   #|Verify step 5 sub text|Select all that apply|step4|
 	#|Progress bar reflects Step 5 of 5|Step 5 of 5|step4|	
 	#|Back button is visible|Back button is visible|step4|	
 
 #	@skipLaunch @OnboardingStep4submitvisible
 #	Scenario: Verify Submit button visible
 #	Given User is in step4 for onboarding process after entering values with "login" and "login_18"
    #When User selects food passport
    #Then User should see Submit button
 	
 #	@skipLaunch @OnboardingStep4submitvisible
 #	Scenario: VVerify checkbox for options
 #	Given User is in step4 for onboarding process after entering values with "login" and "login_18"
    #When User selects food passport
    #Then User should see check box in all options
 	
  #@skipLaunch @OnboardingStep4UIverifyoptions
  #Scenario Outline: Verify <Scenario>
   #Given User is in step4 for onboarding process after entering values with "login" and "login_18" 
    #When User selects food passport
    #Then User should see "<Expected>" options 
#
    #Examples: 
    #| Scenario                    | Expected                       |
 #		|options is displayed in step5|Gluten, Eggs, Soy,Nuts, Dairy,Shellfish , Other,None|
 	
    #	@skipLaunch @Navbackto3
 #	 Scenario: Verify navigation to Step 3
 #	Given User is in step4 for onboarding process after entering values with "login" and "login_18" 
 #	 When clicks back button 
 #	 Then User Should navigate back to previous step "Step 3 of 5"
    
    #@skipLaunch @Navbackto4
 #	 Scenario: Verify navigation to Step 4
 #	Given User is in step5 for onboarding process after entering values with "login" and "login_18" 
 #	 When clicks back button 
  #Then User Should navigate back to previous step "Step 4 of 5"
 	 
 #	 @singleselectionstep5
 #	 Scenario: Verify single selection in allergy
 #	Given User is in step5 for onboarding process after entering values with "login" and "login_18" 
 #	 When User selects single allergy and clicks submit
 #	 Then User should navigate to subscription details
 	 
 #	  @multiselectionstep5
 #	 Scenario: Verify multiple selection in allergy
 #	Given User is in step5 for onboarding process after entering values with "login" and "login_20" 
 #	 When User selects multipleple allergy and clicks submit
 #	 Then User should navigate to subscription details

#-------------------------------------------------------------------------------------------------------------------------------------------------------------
 

    
    
    
    
    
    
    
    
    
    
    