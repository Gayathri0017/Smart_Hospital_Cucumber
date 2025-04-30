Feature: Gayathri_28APR2025_Messaging Feature Verification in Smart Hospital
  Background:
    Given Doctor is logged in to the Smart Hospital system
  @Verify_Search
  Scenario: Add message in notice board in messaging section.
  When the doctor navigates to the Messaging section
  And the doctor clicks the Post New Message
  And the doctor fills the required fields:
    | Title              | Message                                | Notice Date   | Publish On   |PostAction               |
    | Appointment Notice | New changes to appointment timings     |23/09/2025     |23/09/2025    |Record Saved Successfully|
  And the doctor clicks the Send button
  Then the message should be added to the Notice Board and displayed

