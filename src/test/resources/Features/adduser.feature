Feature: feature to validate user sign up function works

  Scenario: Validate user was able to sign up
    Given user is on browser
    And user access thingking-tester-contact-list site
    And user clicks sign up button
    Then user was navigated to Add User page
    Then user was able to input data on form
    And user clicks submit button
    Then user was navigated to Contact List page
