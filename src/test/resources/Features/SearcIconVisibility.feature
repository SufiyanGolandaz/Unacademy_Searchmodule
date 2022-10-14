
Feature: Search icon visibility

Scenario: Search icon is visible 
Given user is on learning goal's home page
Then search icon should be visible


Scenario: Search tab is visible after clicking on search icon
Given user is on learning goal's home page
And user clicks on search icon
Then search tab is visible with placeholder

