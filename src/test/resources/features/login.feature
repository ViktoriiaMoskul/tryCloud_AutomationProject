@ui
Feature: As a user, I should be able to login

  Background:
    Given user is on the login page

  Scenario Outline: verify user login successfully
    When user enter valid "<username>" and "<password>" and user click login button
    Then Verify user launched to the dashboard
    Examples:
      | username | password    |
      | User10   | Userpass123 |
      | User40   | Userpass123 |
      | User70   | Userpass123 |
      | User100  | Userpass123 |


  Scenario: verify user login fail with invalid credentials
    When user enters invalid credentials and user click login button
    Then “Wrong username or password.” message should be displayed