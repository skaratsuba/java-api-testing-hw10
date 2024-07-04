@folders
Feature: Tags

  @homework
  Scenario: User send GET tags of a specific space
    When User send GET tags of valid_space
    Then Response status should be 200
    And Response contains tags

  @homework
  Scenario: User send GET tags of a wrong space
    When User send GET tags of not_valid_space
    Then Response status should be 401

  @homework
  Scenario: User send POST to create a tag with valid body
    When User send POST to create tag with valid_body
    Then Response status should be 200
    And User send GET tags of valid_space
    And Response contains test_tag

  @homework
  Scenario: User send POST to create a tag with invalid body
    When User send POST to create tag with not_valid_body
    Then Response status should be 400

  @homework
  Scenario: User send DELETE to delete tag of a specific space
    When User send DELETE to delete test_tag
    Then Response status should be 200
    And User send GET tags of valid_space
    And Response does not contain test_tag