Feature: Verify E2E functionality for pet by using id

@sanity
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
    
 Scenario: Update pet name 
    Given set the request for "put" request
    When I send a put request to add the pet
    Then the response status code must contain 200
    And pet name should be updated correctly
  
   @sanity 
 Scenario: Verify pet name post update
    Given set the request type to "get"
    When I send a get request to get the updated pet data
    Then the response status code must be contain 200
    And pet status should be updated
   
   @sanity 
 Scenario: Delete the pet
    Given set the data for "delete" request
    When I send delete request to delete teh pet by id
    Then the status code should be 200
    



    
