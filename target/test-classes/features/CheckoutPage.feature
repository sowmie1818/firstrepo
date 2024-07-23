Feature:  Place the Order for products
@PlaceOrder
Scenario Outline: Checkout the desired number of items of product

Given User is On GreenCart Landing Page 
When User searched with shortname <Name> and extract actual name of product
And Added <quantity> items to the selected product to cart
Then User proceeds to Checkout and validate the <Name> items in checkout page 
And Verify user has ability to enter promo code and place the order


Examples:
|Name|quantity|
|Tom|3|
