## Language: en
  # Author: giovannig.gomez@sqasa.co - Giovanni G R

Feature: As a Product Owner
  I want to get single user successful
  To validate response

  @Case1
  Scenario: Single user successful
    Given the user "userAutomation" calls an api
    When the user request to single user
    Then validate response status 200