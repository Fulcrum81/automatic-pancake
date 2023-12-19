Feature: Login

  Scenario: Login with incorrect credentials
    Given user is on application page
    When user enters "Vadim" in username field
    And user enters "Super-secure-password1234!@#" in password field
    And user clicks login button
    Then Error message saying "Wrong password or the account is disabled, or does not exist" appears
    And in 15 seconds the error message disappears

  Scenario: Login with correct credentials
    Given user is on application page
    When user enters "correctUsername" in username field
    And user enters "Test1234!" in password field
    And user clicks login button
    Then welcome message appears


  Scenario Outline: login with different creds
    Given user is on application page
    When user enters "<username>" in username field
    And user enters "<password>" in password field
    And user clicks login button

    Examples:
    | username   | password      |
    | Vadim      | pw            |
    | username 1 | password 1    |
    | askdjfh    | askljdvnklsjh |