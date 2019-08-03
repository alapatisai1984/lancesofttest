@Division
Feature: Division feature

  Scenario: Division of two numbers
    Given Open browser and enter URL for division
    When I have entered first number for division
    And I press division
    And I have entered second number for division
    Then should display correct result of division

  Scenario: Divide by zero
    Given Open browser and enter URL for division
    When I have entered first number for division
    And I press division
    And I have entered zero as second number for division
    Then should display correct result of divide zero

  Scenario: Division of zero by any number
    Given Open browser and enter URL for division
    When I have entered first number as zero for division
    And I press division for division of zero by any number
    And I have entered second number for division of zero by any number
    Then should display correct result of Division of zero by any number