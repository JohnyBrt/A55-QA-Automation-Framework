Feature: All Songs Feature

  Scenario:  Play a song
    Given I am logged in to Koel
    When I go to All Songs List
    When I context click First Song
    And Choose Play option
    Then Song should be playing

