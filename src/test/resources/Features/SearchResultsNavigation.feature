Feature: navigate through search results


Scenario: redirecting to educator's profile page
Given user is on learning goal's homepage
When user searches for query "jatin" in search bar
And user clicks on profile under Educator category
Then user is redirected to educator's profile page


Scenario: redirecting to course subscription page
Given user is on learning goal's homepage
When user searches for query in search bar
 | narendra |
And user clicks on search results under Courses category
Then user is redirected to course subscription page


Scenario: redirecting to search result from profile page
Given user is on learning goal's homepage
When user searches for query "jatin" in search bar
And user clicks on profile under Educator category
Then user is redirected to educator's profile page
When user presses back button
Then user is redirected back to search results


Scenario: redirecting to search result from course subscription page
Given user is on learning goal's homepage
When user searches for query in search bar
 | narendra |
And user clicks on search results under Courses category
Then user is redirected to course subscription page
When user presses back button
Then user is redirected back to search results