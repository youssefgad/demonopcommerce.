@smoke
Feature:F05_hoverCategories | users could hover on one of main categories then click on
  sub category
  Scenario:guest user could hover main categories then click on
    Given user hover on random category
    And user select random subcategory
    Then assert the page title is same like subcategory or category