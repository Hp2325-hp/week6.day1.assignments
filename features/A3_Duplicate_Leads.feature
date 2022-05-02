Feature: Duplicate Leads functionality of TestLeaf Application

Background: 
Given open the Chrome Browser
Given Enter the username 'demoCSR'
Given Enter the password 'crmsfa'
When Click the Login Button
And Click the CRM/SFA Link

Scenario Outline: TC003_Duplicate the Leads
When Click the Leads
And Click the find leads
Given Enter the mail id <mail>
When Click the find leads button
And Click the first result
And Click the duplicate button
And Click create Lead button



Examples:
|mail|
|'hari@gmail.com'|