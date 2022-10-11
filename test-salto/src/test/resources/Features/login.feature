@scenario1.feature
Feature: Feature to test login functionality
Scenario: check login is successful with valid credentials
Given user is on google search page
Given popup
When user enters a text in search box 
And hits enter
Then user is navigated to search results
Then scenario1
#Then scenario2