Feature: BasicExample

    @Test
  Scenario: type on search box
      Given I go to sodimac main page https:\\www.sodimac.cl\sodimac-cl
      And I load document with information SodimacMainPage.json
      And I close the window


  @Test
  Scenario: Click searchBar
      Given I go to sodimac main page https:\\www.sodimac.cl\sodimac-cl
      And I load document with information SodimacMainPage.json
      And I click in element Search Bar
      And I close the window

  @Test
  Scenario: whrite on search bar
      Given I go to sodimac main page https:\\www.sodimac.cl\sodimac-cl
      And I load document with information SodimacMainPage.json
      And I click in element Search Bar
      And I set Search Bar with text pintura blanca
      Then I wait 3 seconds
      And I close the window

  @Test
  Scenario: press enter
    Given I go to sodimac main page https:\\www.sodimac.cl\sodimac-cl
    And I load document with information SodimacMainPage.json
    And I click in element Search Bar
    And I set Search Bar with text pintura blanca
    Then I wait 3 seconds
    And I press enter on Search Bar
    Then I wait 7 seconds
    And I close the window

   @Test
   Scenario: Compare prices
     Given I go to sodimac main page https:\\www.sodimac.cl\sodimac-cl
     And I load document with information SodimacMainPage.json
     And I click in element Search Bar
     And I set Search Bar with text pintura blanca
     Then I wait 3 seconds
     And I press enter on Search Bar
     Then I wait 3 seconds
     ##The comparison is here, and from here fails
     And print price of the "main page price"
     Then click on the main page price
     And I wait 3 seconds
     Then print price of the "product page price"

     Then The test is successfull
     And I close the window
