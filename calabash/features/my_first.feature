Feature: Login feature
	As a developer
	I want to access to the application
	So I can manage the products

  Scenario: FB - Login with correct data
  	Given I wait for the "MainActivity" screen to appear
    When I enter "admin@upc.com" into input field number 1
    And I enter "admin" into input field number 2
    And I press "loginButton"
    Then I should see "Welcome to the system"
    And I wait for 5 seconds

  Scenario: FA1 - Login with no data
  	Given I wait for the "MainActivity" screen to appear
    When I enter "" into input field number 1
    And I enter "" into input field number 2
    And I press "loginButton"
    Then I should see "El campo email está vacío."
    And I should see "El campo password está vacío."
    And I wait for 5 seconds

  Scenario: FA2 - Login with incorrect data
  	Given I wait for the "MainActivity" screen to appear
    When I enter "admin@upc.com" into input field number 1
    And I enter "asd" into input field number 2
    And I press "loginButton"
    Then I should see "Correo o contraseña incorrecta"
    And I wait for 5 seconds

  Scenario: FA3 - Login with incorrect format email
  	Given I wait for the "MainActivity" screen to appear
    When I enter "admin" into input field number 1
    And I enter "admin" into input field number 2
    And I press "loginButton"
    Then I should see "El formato email es incorrecto."
    And I wait for 5 seconds