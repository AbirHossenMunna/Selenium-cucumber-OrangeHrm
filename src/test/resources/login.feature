Feature: User Login

  Scenario Outline: User can login with valid username and invalid password
    Given User visited the site
    When User inputs valid "<username>" and invalid "<password>"
    Then User can see error message

    Examples:
      | username | password |
      | Admin    | 123      |

  Scenario Outline: User can login with invalid username and valid password
    Given User visited the site
    When User inputs invalid "<username>" and valid "<password>"
    Then User can see error message again

    Examples:
      | username | password |
      | a1234    | admin123 |

  Scenario Outline: User can login with blank username and blank password
    Given User visited the site
    When User inputs blank "<username>" and blank "<password>"
    Then User can see error message show again

    Examples:
      | username | password |
      |          |          |

  Scenario Outline: User can login with valid username and valid password
    Given User visited the site
    When User inputs valid "<username>" and valid "<password>"
    Then User can see dashboard page

    Examples:
      | username | password |
      | admin    | admin123 |

