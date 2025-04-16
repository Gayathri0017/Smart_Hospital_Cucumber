Feature: Change the Patient from OPD to IPD Section
  Background:
   Given Doctor is logged in to the Smart Hospital system
  Scenario Outline: Verify that a patient can be moved from OPD to IPD
    When the doctor clicks on the OPD - Out Patient section
    And the doctor searches for the patient by name <"Ellie Groves">
    And the doctor clicks on Move to IPD
    And the doctor enter the <"Bed id"> and <"Bed number">
    Then the doctor can the see the <"Message">
		
		Examples:
		|Bed id                   |Bed number|
		|VIP Ward - Ground  Floor	|GF - 124  |