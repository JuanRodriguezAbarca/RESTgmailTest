Feature: This feature tests the drafts in Gmail

  @TestingUI
  Scenario Outline: this scenario tests how user logs in gmail, navigates to drafts and verifies draft stored mail
    Given the user '<userName>' loggs in using his password '<password>'
    And starts composing a new email providing recipient '<recipient>' and topic '<topic>'
    When user during mail composing navigates to drafts
    Then verify email with title '<topic>' is stored in draft's folder

    Examples:
      | userName  | password     | recipient           | topic         |
      | juan.epam | Password123$ | juan.epam@gmail.com | Test Drafting |
