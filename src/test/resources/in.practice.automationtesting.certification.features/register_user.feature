# Language: en
  ## Author: Giovanni Gomez Restrepo - giovannig.gomez@sqasa.co

  Feature: As a product owner
    I want to create a new user
    To validate successful creation

  @Case1
  Scenario: Register user successfully
    Given the user "userAutomation" opens navigator
    When the user enters data for register user
    Then validate creation user