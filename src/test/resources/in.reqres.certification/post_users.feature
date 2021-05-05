## Language: en
  # Author: giovannig.gomez@sqasa.co - Giovanni G R

Feature: As a Product Owner
  I want to post user successful
  To validate response

  Background:
    Given the user "userAutomation" calls an api

  @Case1
  Scenario: Create user successful
    When the user creates single user
    Then must be validate response status 201