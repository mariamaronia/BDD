Feature: Validate Api requests

  Background:
    Given  Base URI is "https://jsonplaceholder.typicode.com"

    @Smoke
Scenario: Validate Retrieve all posts
  When I send a GET request to "/posts"
  Then the response should contains exactly 100 posts

@Regression @Smoke
  Scenario Outline: Validate the status code of various endpoints
    When I send a GET request to "<endpoint>"
    Then the response status code should be <statusCode>
    Examples:
    | endpoint | statusCode|
    | /posts/1 | 200 |
    | /posts/ 9999 | 404|
    | /invalid-url | 404 |
    | /comments | 200 |
    | /noExist | 404 |


  @Negative
    Scenario Outline: Validate posts contains specific user IDs
      When I send a GET request to "/posts"
      Then response should contain posts with "userId" equals to <userId>
      Examples:
        |userId |
        |    1   |
        |    2   |
        |    3   |


#    Scenario Outline: Validate retrieving a single post contains specific fields
#      When I send a GET request to "<endpoint>"
#      Then the response should contains posts with "user ID"