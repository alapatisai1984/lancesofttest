@Subtraction
Feature: Subtraction feature

  Scenario: Subtract two numbers
    Given Open browser and enter URL
    When I have entered first number into the calculator
    And I press subtract
    And I have entered second number into the calculator
    Then should display correct result on the screen

  Scenario: Subtract two negative numbers
    Given Open browser and enter URL
    When I have entered first negative number into the calculator
    And I press subtract for two negative numbers case
    And I have entered second negative number into the calculator
    Then should display correct result on the screen for two negative numbers