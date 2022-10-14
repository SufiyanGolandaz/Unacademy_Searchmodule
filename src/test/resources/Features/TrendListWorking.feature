
Feature: Check working of trending list under search bar

Scenario: trending list visibility when user is logged out
Given user is on learning goal's homepage
When user clicks on search icon
Then trending list of educators is visible


Scenario: redirecting to educator's profile page from trending list
Given user is on learning goal's homepage
When users clicks on search icon
And user clicks on trending educator from the list
Then user is redirected to appropriate search results