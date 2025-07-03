#Author: npatni25@gmail.com
@Tag
Feature: Create Account 

Background:
Given User clicks Check Your Risk button 
When User enters values in all fields from "launch" and "launch_01"
And User clicks Calculate Risk button after entering valid values in all fields

Scenario: user enters email Id

Given User clicks Calculate Risk button after entering valid values in all fields
When Enter Email Id from "launch" and "launch_01"
Then User is in complete your profile page

Scenario: user completes profile

Given User is in complete your profile page
When  User enters First Name
And Select Terms and Condition box 
Then User is in password auth page


