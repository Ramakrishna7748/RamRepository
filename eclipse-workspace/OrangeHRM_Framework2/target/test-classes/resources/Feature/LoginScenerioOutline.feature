Feature: OrangeHRM End to end Automated

@FunctionalTesting
Scenario Outline: Successfull Login with valid Credentials
Given User Navigate to Login Page
When User is on Home Page
And User enters "<username>" and "<password>"
Then User On Landing Page Successfully

Examples:
    | username	| password |
    | Admin     | admin123 |
    