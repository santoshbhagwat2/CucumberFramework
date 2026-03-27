Feature: Login

  Scenario: Valid login
    Given user is on login page
    When user enters login username "tomsmith" and password "SuperSecretPassword!"
    Then Then user should see login success message