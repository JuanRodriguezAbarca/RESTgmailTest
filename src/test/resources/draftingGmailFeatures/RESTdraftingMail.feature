Feature: This feature tests the drafts in Gmail using REST

  @TestingREST
  Scenario Outline: this scenario tests the HTTP responses when user logs in gmail and stores a draft
    Given a get requests to the home page
    When post requests using '<userName>' and '<password>' for authentication
    Then response should be OK

    Examples:
      | userName  | password     | recipient           | topic         |
      | juan.epa | Password123$ | juan.epam@gmail.com | Test Drafting |