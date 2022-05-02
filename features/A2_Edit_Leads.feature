Feature: Edit Leads functionality of TestLeaf Application

Background: 
Given open the Chrome Browser
Given Enter the username 'demoCSR'
Given Enter the password 'crmsfa'
When Click the Login Button
And Click the CRM/SFA Link

Scenario Outline: TC002_Editing the Leads
When Click the Leads
And Click the find leads
Given Enter the first name <fname>
When Click the find leads button
And Click the first result
And Click on the edit button
Given Change the company name <new_company_name>
When Click the submit button
When Confirm the change is done <new_company_name>

Examples:
|fname|new_company_name|
|'HP'|'LLS'|