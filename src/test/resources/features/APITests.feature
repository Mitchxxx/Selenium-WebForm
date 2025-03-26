@apiTests
Feature: Validate Attack on Titan API endpoints

  Scenario: Validate GET request for episodes
    Given the endpoint is set to "/episodes"
    When I send a GET request
    Then the status code should be 200
    And the response should contain at least 10 result


  Scenario: Validate GET request for characters
    Given the endpoint is set to "/characters"
    When I send a GET request
    Then the status code should be 200
    And the response should contain at least 10 result


  Scenario: Validate GET request for titans
    Given the endpoint is set to "/titans"
    When I send a GET request
    Then the status code should be 200
    And the response should contain at least 9 result

  Scenario: Validate GET request for locations
    Given the endpoint is set to "/locations"
    When I send a GET request
    Then the status code should be 200
    And the response should contain at least 10 result

  Scenario: Validate GET request for locations
    Given the endpoint is set to "/organizations"
    When I send a GET request
    Then the status code should be 200
    And the response should contain at least 17 result


  Scenario Outline: Validate GET request for characters
    Given the endpoint is set to "/characters"
    When I send a GET request
    Then the status code should be 200
    And the response should include "<name>" as a character in the list

    Examples:
    | name             |
    | Armin Arlelt     |
    | Mikasa Ackermann |
    | Levi Ackermann   |
    | Buchwald         |
    | Lima             |