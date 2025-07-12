Feature: Testing Login functionality

  Background:
    Given the user on the home page
    When the user clicks on Admin Link

  Scenario: Verify the user (Admin) can login successfully with valid credentials
    When the user enters valid "username" and valid "password" and clicks on Login Button
    Then the user login successfully

  Scenario Outline: Verify the user (Admin) can not login successfully with invalid credentials
    When the user enters the "<username>" and the "<password>" and clicks on Login Button
    Then the user should see "Invalid credentials" message
    Examples:
      | username        | password        |
      | username        | invalidPassword |
      | invalidUserName | Password        |
      | invalidUsername | invalidPassword |
      |                 | Password        |
      |                 | invalidPassword |
      | username        |                 |
      | invalidUsername |                 |
      |                 |                 |
