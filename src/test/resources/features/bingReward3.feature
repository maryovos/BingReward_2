Feature: Reward Bing
  As a user,
  I want to be able to log in to my account using a username and password,
  So that I can access orange HRM Live website

  Background:
    Given user is on the login page
    And user input email "donboskokian787@gmail.com"
    And user input password "15Juli1962"

  @BingReward2
  Scenario: Bing Reward 2
    And user input bing reward
    And user enters click
    Then bing reward success



