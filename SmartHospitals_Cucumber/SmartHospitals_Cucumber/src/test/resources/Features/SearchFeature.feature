Feature: Search Patient by Name In Smart Hospital
Background:
    Given Doctor is logged in to the Smart Hospital system
  Scenario Outline: Verify the Search of patient
    When the Doctor enters "<patientName>" in the search bar
    And clicks the search button
    Then the system should Show the "<expectedResult>"

    Examples:
      | patientName | expectedResult            |
      | Dharani     | Dharani                   |
      | TestXYZ123  | No data available in table|
