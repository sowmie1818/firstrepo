Feature: Search and Place the Order for products
@SearchOrder
Scenario Outline: Search Experience for product search in both home and offers page

Given User is On GreenCart Landing Page 
When User searched with shortname <Name> and extract actual name of product
Then User searched for short name <Name> in offers page 
And validate product name matches with offer page and landing page

Examples:
|Name|
|Tom|
|Broc|