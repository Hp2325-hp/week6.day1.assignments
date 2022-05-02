Feature: Create contact Leads functionality of TestLeaf Application

Background: 
Given open the Chrome Browser
Given Enter the username 'demoCSR'
Given Enter the password 'crmsfa'
When Click the Login Button
And Click the CRM/SFA Link

Scenario: TC004_Create new Contact
When Click the Leads
And Click the find leads
Given Enter the phone number '8080808080' and Click find leads
When Click the first contact data
And Click the delete
And Check the data is deleted
