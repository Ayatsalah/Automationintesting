Feature: Contact Test

  Background:
    Given the user clicks on the contact link

  Scenario Outline: Verify a valid contact form submission by checking that the correct confirmation messages are displayed.
    When the user fills the following information "<name>","<email>","<phone>","<subject>" and "<message>"
    And the user clicks on the Submit button
    Then the user should see this message "Thanks for getting in touch" on the first line
    And the user should see this message "We'll get back to you about" on the second line
    And the user should see "<subject>" on the third line
    And the user should see this message "as soon as possible." on the last line


    Examples:
      | name  | email           | phone       | subject                 | message                                         |
      | Sarah | sarah@gmail.com | 01234567890 | You have a new booking! | You have a new booking. They have booked a room |


  Scenario Outline: Verify the error messages for invalid or missing contact form inputs.
    When the user fills the following information "<name>","<email>","<phone>","<subject>" and "<message>"
    And the user clicks on the Submit button
    Then the user should see this message "<final-message>"
    Examples:
      | name  | email           | phone       | subject                    | message                                             | final-message                                   |
      |       | sarah@gmail.com | 01234567890 | Query about my reservation | I have query about my reservation, can i cancel it? | Name may not be blank                           |
      | Sarah | sara            | 01234567890 | Query about my reservation | I have query about my reservation, can i cancel it? | must be a well-formed email address             |
      | Sarah |                 | 01234567890 | Query about my reservation | I have query about my reservation, can i cancel it? | Email may not be blank                          |
      | Sarah | sarah@gmail.com | 01234567    | Query about my reservation | I have query about my reservation, can i cancel it? | Phone must be between 11 and 21 characters.     |
      | Sarah | sarah@gmail.com |             | Query about my reservation | I have query about my reservation, can i cancel it? | Phone may not be blank                          |
      | Sarah | sarah@gmail.com | 01234567890 | Hi                      | I have query about my reservation, can i cancel it? | Subject must be between 5 and 100 characters.   |
      | Sarah | sarah@gmail.com | 01234567890 |                            | I have query about my reservation, can i cancel it? | Subject may not be blank                        |
      | Sarah | sarah@gmail.com | 01234567890 | Query about my reservation | I have                                              | Message must be between 20 and 2000 characters. |
      | Sarah | sarah@gmail.com | 01234567890 | Query about my reservation |                                                     | Message may not be blank                        |


  Scenario Outline: Verify that the admin can see the message
    When the user fills the following information "<name>","<email>","<phone>","<subject>" and "<message>"
    And the user clicks on the Submit button
    And the user clicks on Admin Link
    And the user enters valid "username" and valid "password" and clicks on Login Button
    And the user clicks on the Messages link
    Then the user should see the Name "<name>" and Subject "<subject>"

    Examples:
      | name  | email           | phone       | subject                 | message                                         |
      | Sarah | sarah@gmail.com | 01234567890 | You have a new booking! | You have a new booking. They have booked a room |


