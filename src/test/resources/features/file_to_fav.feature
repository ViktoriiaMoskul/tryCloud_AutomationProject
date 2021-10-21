#Story: As a user, I should be able to access to Files module.
#AC #1 - users can add a file to favorites.
#1. Login as a user
#2. Click action-icon from any file on the page
#3. Choose “Add to Favorites” option
#4. Click “Favorites” sub-module on the lest side
#5. Verify the chosen file is listed on the table
#(Pre-condition: there should be at least 1 file is uploaded)
 @ui
Feature: add file to favorites functionality

    Background:
      Given user is on the login page

  Scenario Outline: user is able to add files to favorites
    When user enter valid "<username>" and "<password>" and user click login button
    Then Verify user launched to the dashboard
    When user clicks on the Files module on top
    And user clicks on Actions icon of "NAME" file
    And user chooses "Add to favorites"
    And user clicks on favorites sub-module
    Then "NAME" file is listed on the table of favorites
    Examples:
      | username | password    |
      | User10   | Userpass123 |





