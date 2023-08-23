#author: Julián Ávila

Feature: delete an existing user
  Scenario Outline: delete a user
    Given julian wants to delete a specific user
    When julian deletes a specific user
      |user_id  |
      |<user_id>|
    Then julian gets a response that he was deleted
    Examples:
      |user_id|
      |3      |