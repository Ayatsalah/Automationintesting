Feature: Room Management testing

  Background:
    Given the user on the home page
    When the user clicks on Admin Link

  Scenario Outline: Verify the Admin can add a new room
    When the user enters valid "username" and valid "password" and clicks on Login Button
    And the user enters the room "<number>", "<type>", "<accessible>", "<price>", "<WiFi>", "<TV>", "<Radio>", "<Refreshments>", "<Safe>" and "<Views>"
    And the clicks Create button
    Then the user should see the new room "<number>" appears in the room list

    Examples:
      | number | type   | accessible | price | WiFi | TV  | Radio | Refreshments | Safe | Views |
      | 107    | Single | true       | 100   | Yes  | Yes | Yes   | Yes          | Yes  | Yes   |
      | 108    | Single | true       | 100   | No   | No  | No    | No           | No   | No    |


  Scenario Outline: Verify the Admin should have add the room number and price
    When the user enters valid "username" and valid "password" and clicks on Login Button
    And the user enters the room "<number>", "<type>", "<accessible>", "<price>", "<WiFi>", "<TV>", "<Radio>", "<Refreshments>", "<Safe>" and "<Views>"
    And the clicks Create button
    Then the user should see this "<message>"


    Examples:
      | number | type   | accessible | price | WiFi | TV  | Radio | Refreshments | Safe | Views | message                            |
      |        | Single | true       | 100   | Yes  | Yes | Yes   | Yes          | Yes  | Yes   | Room name must be set              |
      | 109    | Single | true       |       | Yes  | Yes | Yes   | Yes          | Yes  | Yes   | must be greater than or equal to 1 |








