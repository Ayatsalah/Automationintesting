Feature: Testing home page links and buttons

  Background:
    Given the user on the home page

  Scenario: Verify the links are visible
    Then the user should see the following links
      | Rooms     |
      | Booking   |
      | Amenities |
      | Location  |
      | Contact   |
      | Admin     |


  Scenario Outline: Verify that all the links are clickable
    When the user clicks on this "<link>"
    Then the "<link>" is clickable

    Examples:
      | link      |
      | Rooms     |
      | Booking   |
      | Amenities |
      | Location  |
      | Contact   |
      | Admin     |


  Scenario: Verify the Book Now button is visible and clickable
    Then the user should see Book Now Button
    And the Book Now button is enabled
    And the Book Now button is clickable

