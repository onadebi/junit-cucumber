Feature: Test Google Search Results
We can search for various sites and make sure they are the first result.

Scenario Outline: Search For Fanshawe College
  Given I want to open a chrome browser
  And navigate to Google
  When I search for "<searchText>"
  And I click the search button
  And I click the first result
  Then I verify the title is "<expectedTitle>"
  And I verify the url is "<expectedUrl>"
  And I close the chrome browser

  Examples: 
    |searchText|expectedTitle|expectedUrl|
    |Fanshawe College|Fanshawe College|https://www.fanshawec.ca/|
    |Software and Information Systems Testing|Software and Information Systems Testing (Co-op) \| Fanshawe College|https://www.fanshawec.ca/programs/sst3-software-and-information-systems-testing-co-op/next|