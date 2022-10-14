Feature: obtaining search results for various types of data


Scenario Outline: obtaining search results for alphabet characters
Given user is on learning goal's homepage
When user enters query as "<query>" in search bar
Then user obtains search results same as "<queryc>"
Examples:
| query | queryc |
| dan | dan |
| narendra | narendra |


Scenario Outline: obtaining search results for alphanumeric characters
Given user is on learning goal's homepage
When user enters query as "<query>" in search bar
Then user obtains search results same as "<queryc>" 
Examples:
| query | queryc |
| 10cbse | 10cbse |
| narendra3 | narendra3 |




Scenario: obtaining search results for numeric characters
Given user is on learning goal's homepage
When user enters query as "<query>" in search bar
Then user obtains search results same as "<queryc>"
Examples:
| query | queryc |
| 10 | 10 |
| 12 | 12 |
| 30 | 30 |

@Prompt
Scenario Outline: not obtaining search results for special characters
Given user is on learning goal's homepage
When user enters query in search bar from sheet from rownumbers <rownum>
Then user does not get results
Examples:
| rownum |
| 1 |
| 2 |
| 3 |
| 4 |
