Feature: Free CRM Login Feature

Scenario Outline: Free CRM Login Test Scenario

Given user is already on Login Page
When title of login page is Free CRM
Then user clicks on login button
Then user enters "<username>" and "<password>"
Then user is on home page
Then user moves to click contact page
Then user enters contact details "<firstname>" and "<lastname>" and "<company>"
Then Close the browser


Examples:
	| username               | password | firstname | lastname | company   |
	| mrkunal1996@gmail.com  | kunal12  | john      | garg     | microsoft |
	