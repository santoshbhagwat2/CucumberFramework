Feature: Login

  Scenario: Valid login
    Given user is on login page
    When user enters "tomsmith" and "SuperSecretPassword!"
    Then user should see success message