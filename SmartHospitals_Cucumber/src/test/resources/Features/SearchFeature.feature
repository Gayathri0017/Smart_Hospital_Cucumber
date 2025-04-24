Feature: Gayathri_09APR2025_Search Patient by Name In Smart Hospital
Background:
  Given Doctor is logged in to the Smart Hospital system
  @Verify_Search
  Scenario Outline: Verify the Search of patient
    When the Doctor enters "<patientName>" in the search bar
    And clicks the search button
    Then the system should Show the "<expectedResult>"

    Examples:
      | patientName | expectedResult            |
      | Ellie Groves| Ellie Groves              |
      | TestXYZ123  | No data available in table|

  @Delete_patient
  Scenario Outline: Verify that a searched patient can be deleted
  When the Doctor enters "<patientName>" in the search bar
  And clicks the search button
  And selects the patient and clicks "Delete Selected"
  Then the patient should no longer appear in the searched list
	Examples:
      | patientName |
      | Ellie Groves| 
	   