Feature: Testing Booking room flow


  Scenario Outline: Verify the user can book a room with valid information
    When the user enters valid "<check-in-date>" and "<check-out-date>"
    And the user clicks on check availability button
    And the user selects the room and clicks on Book now button
    And the user clicks on the Reserve now button
    And the user enters the "<first-name>", the "<last-name>", the "<email>" and the "<phone>"
    And the user clicks on the Reserve now button
    Then the user should see a booking confirmation message "Booking Confirmed"
    Examples:
      | check-in-date | check-out-date | first-name | last-name | email           | phone       |
      | 18            | 21             | Sarah      | Sam       | sarah@gmail.com | 01234567891 |



  Scenario Outline: Verify the price of the room per night
    When the user enters valid "<check-in-date>" and "<check-out-date>"
    When the user clicks on check availability button
    And the user selects the room and clicks on Book now button
    Then the user should the the same price for the room
    And the user should see the total price
    Examples:
      | check-in-date | check-out-date |
      | 15            | 17             |



  Scenario Outline: Verify the Booking Form – Required Field Validation

    When the user enters valid "<check-in-date>" and "<check-out-date>"
    When the user clicks on check availability button
    And the user selects the room and clicks on Book now button
    And the user clicks on the Reserve now button
    And the user enters the "<first-name>", the "<last-name>", the "<email>" and the "<phone>"
    And the user clicks on the Reserve now button
    Then the user should see an "<error>" message
    Examples:
      | check-in-date | check-out-date | first-name | last-name | email          | phone       | error                               |
      | 15            | 17             | Sa         | Sam       | sara@gmail.com | 01234567891 | size must be between 3 and 18       |
      | 15            | 17             | Sara       | Sa        | sara@gmail.com | 01234567891 | size must be between 3 and 30       |
      | 15            | 17             | Sara       | Sam       | sara           | 01234567890 | must be a well-formed email address |
      | 15            | 17             | Sara       | Sam       | sara@gmail.com | 012345678   | size must be between 11 and 21      |
      | 15            | 17             |            | Sam       | sara@gmail.com | 01234567890 | Firstname should not be blank       |
      | 15            | 17             | Sara       |           | sara@gmail.com | 01234567890 | Lastname should not be blank        |
      | 15            | 17             | Sara       | Sam       |                | 01234567890 | must not be empty                   |
      | 15            | 17             | Sara       | Sam       | sara@gmail.com |             | must not be empty                   |


