Feature: Filtering

  @allure.id:10
  Scenario: Dog can be found with the size filter

#    As a user i want to search dogs with filtering by size to get relevant information
#  about dogs...

    Given unathorized user opened the site
    And opens the page "Собаки в добрые руки"
    When choose size filter option
    Then search results are updated
    And the filter by size is displayed in the list of the selected filters