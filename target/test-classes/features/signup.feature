Feature: signup
  Scenario: signup
    Given user is on home page
    When user enters signup name "sanotsh" and email "santosh.bhagwat100@gmail.com"
    Then user should see signup success message
