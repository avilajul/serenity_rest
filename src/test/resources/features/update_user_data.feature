#author: Julián Ávila

Feature: update user data via patch method
  Scenario Outline: updated user data
    Given julián who wants to update the data of a specific user
    When julian updates the data of a specific user
      |user_id  |name  |
      |<user_id>|<name>|
    Then julian gets a response that he was updated
    Examples:
      |user_id|name   |
      |3      |Ricardo|