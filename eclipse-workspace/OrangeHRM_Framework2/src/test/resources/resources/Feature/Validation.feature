@ValidationTest
Feature: Validation of HomePage
Scenario:OrangeHRM Validating the Homepage
Given Launch the Browser and url
When Validate weather DateDropBox isvalid
And Validate the AddTimesheetDates
And Validate the ProjectNameBox
And Validate the Project ActivityBox
And Validate the Employee name box is valid
And Validate the CommentBox
Then Take Screenshot of ValidationPage