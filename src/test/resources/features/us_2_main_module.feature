@ui
Feature: As a user, I should be access all the main modules of the app
  Background:
    Given user is on the login page
  Scenario Outline: verify user login successfully
    When user enter valid "<username>" and "<password>" and user click login button
    Then Verify user launched to the dashboard
    And verify the user see the following modules
      | Dashboard |
      | Files     |
      | Photos    |
      | Activity  |
      | Talk      |
      | Mail      |
      | Contacts  |
      | Circles   |
      | Calendar  |
      | Deck      |
    Examples:
      | username | password    |
      | User10   | Userpass123 |
      | User40   | Userpass123 |
      | User70   | Userpass123 |
      | User100  | Userpass123 |