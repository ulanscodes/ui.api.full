Feature: GitHub username repositories

@github	@smoke
Scenario: UI vs API verification for user repositories
	Given user goes to github account for "https://github.com/eniiazov"
	And   user hits github repos service with "https://api.github.com/users/eniiazov/repos"
	Then  user validates repositories data with UI and API

@regression	
Scenario Outline: UI vs API verification for user repositories
	Given user goes to github account for "<uiURL>"
	And   user hits github repos service with "<apiURL>"
	Then  user validates repositories data with UI and API
	
	Examples:
	|uiURL					    	|apiURL										|
	|https://github.com/eniiazov	|https://api.github.com/users/eniiazov/repos|
#	|https://github.com/james		|https://api.github.com/users/james/repos	|
#	|https://github.com/john		|https://api.github.com/users/john/repos	|
	|https://github.com/adam		|https://api.github.com/users/adam/repos	|
	