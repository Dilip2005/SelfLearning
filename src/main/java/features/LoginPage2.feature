Feature: Login for Leaftap Application

Scenario: Login with positive data
When Enter the Username as 'Demosalesmanager'
And Enter the Password as 'crmsfa'
And Click on LoginButton
Then Verify login is Successful

@smoke
Scenario Outline:
When Enter the Username as <username>
And Enter the Password as <password>
And Click on LoginButton
Then Verify login is Successful

Examples:
|username|password|
|'DemoCsr'|'crmsfa'|
|'DemoSalesManager'|'crmsfa'|