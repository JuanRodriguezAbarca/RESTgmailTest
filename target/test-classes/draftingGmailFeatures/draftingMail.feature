Feature: This feature tests the drafts in Gmail

  @prueba
  Scenario Outline: this scenario tests how user logs in gmail, navigates to drafts and verifies draft stored mail
    Given the user '<userName>' loggs in using his password '<password>'
#    And starts composing a new email providing recipient '<recipient>' and topic '<topic>'
#    When user mail coposing is interrupted
#    Then verify email is stored in draft's folder

  Examples:
    | userName  | password     | recipient | topic         |
    | Juan.Epam | Password123$ | Juan.Epam | Test Drafting |