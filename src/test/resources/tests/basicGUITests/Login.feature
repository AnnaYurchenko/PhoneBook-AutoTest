Feature: User Login

  @login
#  Scenario: Login unauthorised user test
#    Given I am on the Login page
#    When I enter the valid data
#    And I click on the Login button
#    Then I see activation error message
#    """
#    Please check your activation or Login + Password combination
#    """
#
#  Scenario: Login button is enabled with entered valid data
#    Given I am on the Login page
#    When I enter the valid data
#    And I see Login button is enabled
#
#  Scenario: Login button is disabled with no entered data
#    Given I am on the Login page
#    When Login fields are not filled out
#    And I see Login button is disabled

  Scenario: Empty email field test
    Given I am on the Login page
    When I click on the empty fields
    Then I see empty fields error message
    """
    Email is required.
    """
#    """
#    Password is required.
#    """
