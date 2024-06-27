Feature: Login feature

  Scenario: Positive Login Scenario
    Given  I open Koel Login Page
    When I enter email "sviatlana.rysiavets@testpro.io"
    And I enter password "nTtAZKUq"
    And I click submit
    Then I should be logged in
