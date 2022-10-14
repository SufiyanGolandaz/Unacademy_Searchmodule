
Feature: Working of autosuggestion functionality


Scenario: prompting user with suggestions based on query
Given user is on learning goal's homepage
When user types query in search bar from properties file
Then user is prompted with valid suggestions


Scenario: redirecting to search results from suggestions
Given user is on learning goal's homepage
When user types query "jagdish" in search bar
And user clicks on suggested query
Then user is redirected to search results


Scenario: navigation through suggestions
Given user is on learning goal's homepage
When user types query "bhagat" in search bar
And user clicks on down arrow key
Then user is redirected to next suggestion from the list

