@ui
Feature: As a user, I should be able to access the Files module
#(Pre-condition: there should be at least 1 folder is created on the filers page)
  Background:
    Given user is on the login page


  Scenario Outline: verify users can create a folder
    When user enter valid "<username>" and "<password>" and user click login button
    And user clicks on the Files module on top
    And user clicks the + icon
    And user select New Folder from dropdown
    And user write a new folder name
    Then verify the new folder is displayed on the page
    Examples:
      | username | password    |
      | User10   | Userpass123 |
      | User40   | Userpass123 |
      | User70   | Userpass123 |
      | User100  | Userpass123 |


  Scenario Outline: verify users can upload a file inside a folder
    When user enter valid "<username>" and "<password>" and user click login button
    And user clicks on the Files module on top
    And user clicks the + icon
    And user select Upload File from dropdown
    And choose file and click Open
    Then verify the file is displayed on the page
    Examples:
      | username | password    |
      | User10   | Userpass123 |
      | User40   | Userpass123 |
      | User70   | Userpass123 |
      | User100  | Userpass123 |

