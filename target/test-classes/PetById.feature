Feature: Verify E2E functionality for pet by using id
Scenario: Add pet into the store
    Given the pet store API is available
    When I send a "post" request to add the pet
    Then the response status code should be 200
    And the response should contain the pet details

    Scenario: Get pet data by id
    Given set request for "get" request
    When I send a get request to get the pet data
    Then the response status code should contain 200
    And pet status should be "available"
    
