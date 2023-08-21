#author: Julián Ávila

Feature: update user information via put method
  Scenario Outline: updated user information
    Given julian who wants to update the information of a specific user
    When julian updates the information for a specific user
      |user_id  |name  |job  |
      |<user_id>|<name>|<job>|
    Then julian receives a response that the user was updated
    Examples:
      |user_id|name |job          |
      |2      |Janet|zion resident|