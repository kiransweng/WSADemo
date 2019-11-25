@demo
Feature: Demo REST Services Testing
  Test if the script is able to connect to Database & the API is able to respond


  Scenario: Verify that two of the given elements have values in API response
   When Hit the GeoPlugin Service to get response in XML format
   Then Verify that the given elements have values in API response


  Scenario: Verify API response matches against database records - Negative scenario
    Given Database has the required data
    When Hit the GeoPlugin Service to get response in XML format
    Then Compare the API response with Database records


  Scenario: Verify API response matches against database records- Positive scenario
    Given Database has the required data
    When Hit the GeoPlugin Service to get response in XML format
    Then Compare the API response with Database records in XML formats

  Scenario: Verify API response matches against database records- Negative scenario
    Given Database has the required data
    When Hit the GeoPlugin Service to get response in XML format
    Then Compare the API response with Database records in XML formats - Negative

