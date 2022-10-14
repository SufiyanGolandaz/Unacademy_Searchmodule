@SmokeTest
Feature: verify that search results are obtained for various categories


Scenario: obtaining search results under Educators, Courses, Lessons category
Given user is on learning goal's homepage
When user searches for query "jatin" in search bar
Then search results are available under Educators, Courses or Lessons category


Scenario: visibility of See All button
Given user is on learning goal's homepage
When user searches for query "narendra" in search bar
Then See All button is visible 


Scenario: visibility of expanded search results when user clicks on See All button
Given user is on learning goal's homepage
When user searches for query "jatin" in search bar
And user clicks on See All button
Then user is able to see expanded search results
