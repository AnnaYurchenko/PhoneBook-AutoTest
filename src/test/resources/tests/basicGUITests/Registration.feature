Feature: User Registration

  @positive_registration
  Scenario: Positive Registration Test
    Given I am on the Registration page
    When I create a user with the valid data
    And I click SignUp button
    Then I see confirmation message
  """
    Please, check your email and activate your account.
  """

  Scenario: SignUp Button is enabled with the entered valid data
    Given I am on the Registration page
    When I create a user with the valid data
    And I see SignUp button is enabled

  Scenario: SignUp Button is disabled with no entered data
    Given I am on the Registration page
    When Registration fields are not filled out
    And I see SignUp button is disabled

  @negative_registration
  Scenario: Negative Registration Test
    Given I am on the Registration page
    When I create a user with the wrong password
    Then I see error message
    """
    Password must be no longer than 20 characters.
    """

  Scenario: SignUp Button is disabled with the entered non-valid data
    Given I am on the Registration page
    When I create a user with the wrong password
    And I see SignUp button is disabled
