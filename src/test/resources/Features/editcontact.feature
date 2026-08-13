Feature: feature to validate Edit Contact
  Scenario Outline: validate user can edit first name of the contact
    Given user access the site and login
    And user navigates to Contact List page
    And click on a cell with <fullname>
    Then user was navigated to Contact Details page
    And user click Edit Contact button
    Then user was navigated to Edit Contact page
    And user updated first name
    And user clicks edit-submit button
    Then user was navigated back to Contact Details page
    Examples:
      |fullname |
      |test777 Doelast02|

