## Language: en
  # Author: giovannig.gomez@sqasa.co - Giovanni G R

  Feature: As a Product Owner
    I want to login successful
    To validate principal page

  Background:
    Given the user "userAutomation" opens navigator

  Scenario: Login successful
    When the user enters data for login
    Then validate main page