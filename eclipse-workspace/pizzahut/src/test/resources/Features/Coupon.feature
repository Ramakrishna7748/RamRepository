Scenario Outline: Successfull Apply Coupon with valid Cart Criteria
Given User is on Home Page and Enters Address
When Validate Coupon for Single Product Cart Value Above 500
And Validate Coupon for Cart Value Below 500
And Validate Coupon for already existing deal
And Validate Coupon for Multiple Products Cart Value above 500
Then Take Screenshots of all the conditions Tested
