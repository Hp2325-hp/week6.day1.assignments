Feature: Create Leads functionality of TestLeaf Application

Background: 
Given open the Chrome Browser
Given Enter the username 'demoCSR'
Given Enter the password 'crmsfa'
When Click the Login Button
And Click the CRM/SFA Link

Scenario Outline: TC001_Creating new Leads
When Click the Leads
And Click the create leads
Given Enter the company name <companyname>
And Enter the first name and last name <fname> <lname>
And Enter the fnamelocal, department, desc and mail_id <fnamelocal> <depart> <desc> <mail>
And Select the country <country>
When Click Submit button

Examples:
|companyname|fname|lname|fnamelocal|depart|desc|mail|country|
|'TCS'|'Hari'|'Prak'|'hp'|'EEE'|'Hi this is hari'|'hp@mail.co'|'New York'|
|'CTS'|'Karthi'|'keyan'|'kk'|'EEE'|'Hi this is kk'|'kk@mail.co'|'New York'|
