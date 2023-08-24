#author: Julián Ávila

Feature: create a successful user
  Scenario Outline: create a user
    Given julian wants to create a user
    When julian creates a user
      |username  |email  |password  |
      |<username>|<email>|<password>|
    Then julian gets a response that he was created
    Examples:
      |username  |email             |password |
      |Eva Maria |eve.holt@reqres.in|prueba123|