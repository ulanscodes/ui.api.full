Feature: Profile POST service 

Scenario: Status code test for profile GET service 
	When user hits Profile GET request with "http://localhost:3000/profile" 
	Then user should get "200" status code 

@test	
Scenario: Attribute verification for profile object 
	When user hits Profile GET request with "http://localhost:3000/profile" 
	Then user verifies mandatory attributes for profile 

Scenario: Attribute verification for profile Books title field 
	When user hits Profile GET request with "http://localhost:3000/profile" 
	Then user verifies mandatory attributes for profile book title field 
Scenario Outline: Status code test for profile POST service 
	When user hits Profile POST request with "http://localhost:3000/profile" "<name>" "<location>" "<age>" 
	Then user should get "201" status code 
	
	Examples: 
		|name      | |location |  |age|
		|James Bond| |New York |  |34 |
		|John Wick | |Wisconsin|  |26 |
		|Ronaldo   | |Porto    |  |32 |
		

Scenario Outline: Profile data verification 
	When user hits Profile POST request with "http://localhost:3000/profile"     "<name>" "<location>" "<age>" 
	And user hits Profile GET request with "http://localhost:3000/profile" 
	Then user validates the data in the profile response with the requested data "<name>" "<location>" "<age>" 
	Examples: 
		|name      | |location |  |age|
		|James Bond| |New York |  |34 |
		|John Wick | |Wisconsin|  |26 |
		|Ronaldo   | |Porto    |  |32 |
		
		
		
		
		
		
		
		
		
		