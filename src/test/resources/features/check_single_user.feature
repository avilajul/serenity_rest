#author: Julián Ávila

  Feature: check single user
    Scenario Outline: verify that the unique user exists and that the information is as expected
      Given julian enters the reqres api
      When julian searches for a user by his id
      |user_id  |
      |<user_id>|
      Then julian receives information about the user
      |id  |email  |first_name  |last_name  |avatar  |
      |<id>|<email>|<first_name>|<last_name>|<avatar>|
      Examples:
        |user_id|id|email                 |first_name|last_name|avatar                                 |
        |2      |2 |janet.weaver@reqres.in|Janet     |Weaver   |https://reqres.in/img/faces/2-image.jpg|
