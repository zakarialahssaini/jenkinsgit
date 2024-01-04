@google @search

@severity=blocker

@issue=6

@tmsLink=45678

Feature: Test the login functionality

  Scenario: Check login invalid with invalid information
   Given the user is on the login page
   When the user enters invalid information "<email>" and "<password>"
   And the user clicks the login button
   Then the user should not navigate to the home page

 Examples:
 |         email                     | password |
 | zakarialahssaini22@gmail.com      | 123456   |
 | zakaria.lahssaini@uit.ac.ma       | 678901   |
 
   Scenario: Check login valid with valid information
    Given the user is on the login page for login
    When the user enters valid information "<email_correcte>" and "<password_correcte>"
    And the user clicks the login button for login
    Then the user should navigated to the home page
    
 Examples:
 |         email_correcte            | password_correcte    |
 | zakarialahssaini2@gmail.com       | Zakaria-@3           |
 | zakarialahssaini3@gmail.com       | Zakaria-@2           |