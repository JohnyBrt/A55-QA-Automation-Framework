Feature: Login feature

  Scenario: Login Success
    Given  I open Login Page
    When I enter email "ionut.burtoiu@testpro.io"
    And I enter password "Luca@20222"
    And I click on Login button
    Then I should be logged in


    Scenario Outline: Login Success
      Given  I open Login Page
      When I enter email "<email>"
      And I enter password "<password>"
      And I click on Login button
      Then I should be logged in
      Examples:
        |email                    | password   |
        |ionut.burtoiu@testpro.io | Luca@20222 |
        |ionut.burtoiutestpro.io  | Luca@20222 |
        |                         |            |
        |ionut.burtoiu@testpro.io |            |