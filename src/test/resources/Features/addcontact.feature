Feature: feature to validate if user can add contact
  Scenario Outline: validate user can add contact
    Given user is on the browser
    And user is logged in
    And user is on Contact List page
    And user clicks Add a New Contact button
    Then user was navigated to Add Contact page
    And user input <firstname> on firstname text field
    And user input <lastname> on lastname text field
    And user input <dateofBirth> on dateofbirth textfield
    And user input <email> on email textfield
    And user input <phone> on phone text field
    And user input <streetAddress1> on street1 text field
    And user input <streetAddress2> on street2 text field
    And user input <city> on city textfield
    And user input <stateOrProvince> on stateProvince textfield
    And user input <postalCode> on postalCode textfield
    And user input <country> on Country textfield
    Then user was navigated to Contact List page after submit
    And added contact <firstname> was added in contact list
    Examples:
      | firstname | lastname | dateofBirth | email | phone | streetAddress1 | streetAddress2 | city | stateOrProvince | postalCode | country |
      |John999 |Doelast02 |2000-09-23 |test01@herokuapp.com |096845895 |Test Address In City 1343442 |N/A |Kalbayog |Catanduanes |9435 |Philippines |



