Feature: Reward Bing
  As a user,
  I want to be able to log in to my account using a username and password,
  So that I can access orange HRM Live website


  @BingReward3
  Scenario: Bing Reward
    Given user is on the login page
    And user input email "maryosina7129@gmail.com"
    And user input password "13Maret1999"
    And user input bing reward
    And user enters click
    Then bing reward success

  @BingReward3
  Scenario: Bing Reward
    Given user is on the login page
    And user input email "aembarkembar@gmail.com"
    And user input password "25April2011"
    And user input bing reward
    And user enters click
    Then bing reward success   
