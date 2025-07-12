Feature: Room Management testing

  # user=admin

  Background:
    Given the user on the home page
    When the user clicks on Admin Link
    When the user enters valid "username" and valid "password" and clicks on Login Button

  Scenario Outline: Verify the Admin can add a new room
    When the user enters the room "<number>", "<type>", "<accessible>", "<price>", "<WiFi>", "<TV>", "<Radio>", "<Refreshments>", "<Safe>" and "<Views>"
    And the clicks Create button
    Then the user should see the new room "<number>" appears in the room list

    Examples:
      | number | type   | accessible | price | WiFi | TV  | Radio | Refreshments | Safe | Views |
      | 107    | Single | true       | 100   | Yes  | Yes | Yes   | Yes          | Yes  | Yes   |
      | 108    | Double | false      | 200   | No   | No  | No    | No           | No   | No    |
      | 109    | Twin   | true       | 300   | Yes  | Yes | Yes   | Yes          | Yes  | Yes   |
      | 110    | Family | false      | 400   | No   | No  | No    | No           | No   | No    |
      | 111    | Suite  | true       | 500   | Yes  | Yes | Yes   | Yes          | Yes  | Yes   |


  Scenario Outline: Verify the Admin should have add the room number and price
    When the user enters the room "<number>", "<type>", "<accessible>", "<price>", "<WiFi>", "<TV>", "<Radio>", "<Refreshments>", "<Safe>" and "<Views>"
    And the clicks Create button
    Then the user should see this "<message>"

    Examples:
      | number | type   | accessible | price | WiFi | TV  | Radio | Refreshments | Safe | Views | message                            |
      |        | Single | true       | 100   | Yes  | Yes | Yes   | Yes          | Yes  | Yes   | Room name must be set              |
      | 109    | Double | false      |       | Yes  | Yes | Yes   | Yes          | Yes  | Yes   | must be greater than or equal to 1 |

  Scenario Outline: Verify the Admin can delete the existing room
    When the user enters the room "<number>", "<type>", "<accessible>", "<price>", "<WiFi>", "<TV>", "<Radio>", "<Refreshments>", "<Safe>" and "<Views>"
    And the clicks Create button
    When the user clicks on the x button for the room number "<number>"
    Then the room "<number>" will be deleted

    Examples:
      | number | type   | accessible | price | WiFi | TV  | Radio | Refreshments | Safe | Views |
      | 107    | Single | true       | 100   | Yes  | Yes | Yes   | Yes          | Yes  | Yes   |
      | 108    | Double | false      | 100   | No   | No  | No    | No           | No   | No    |

  Scenario Outline: Verify the Admin can update the existing room
    When the user enters the room "<number>", "<type>", "<accessible>", "<price>", "<WiFi>", "<TV>", "<Radio>", "<Refreshments>", "<Safe>" and "<Views>"
    And the clicks Create button
    And the user clicks on the room number "<number>"
    And the user clicks on Edit button
    And the user update the following fields "<number1>" and "<price1>"
    And the user update the "<description>"
    And the user clicks on Update button
    Then the user should see the updated information "<number1>" and "<price1>"
    And the user should see the updated description "<description>"


    Examples:
      | number | type   | accessible | price | WiFi | TV  | Radio | Refreshments | Safe | Views | number1 |  price1 |description|
      | 107    | Single | true       | 100   | Yes  | Yes | Yes   | Yes          | Yes  | Yes   | 333     |  300    | Pets allowed|
      | 108    | Single | true       | 100   | No   | No  | No    | No           | No   | No    | 555     |  200    | Pets not allowed |






