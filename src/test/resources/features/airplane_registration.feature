#language: en
# Author: Luis Felipe Cadavid y Sharid Samantha Madrid

Feature: Airplane Registration Form Validation

  Background:
    Given I am on the airplane registration page

  Scenario Outline: Validate airplane type field constraints
    When I enter "<input>" as the airplane type
    Then I should see an error message "<errorMessage>" for the field "airplaneType"

    Examples:
      | input                                                   | errorMessage |
      | A                                                       | El tipo de avión debe tener entre 2 y 50 caracteres |
      |                                                         | El tipo de avión debe tener entre 2 y 50 caracteres |
      | qwertyuiopasdfghjklñzxcvbnmqwertyuiopasdfghjklñzxcvgra  | El tipo de avión debe tener entre 2 y 50 caracteres |

  Scenario Outline: Validate seat capacity field constraints
    When I enter "<input>" as the seat capacity
    Then I should see an error message "<errorMessage>" for the field "seatCapacity"

    Examples:
      | input | errorMessage |
      | 20    | La capacidad debe ser un número entre 50 y 800 |
      | 900   | La capacidad debe ser un número entre 50 y 800 |
      | abc   | La capacidad debe ser un número entre 50 y 800 |

  Scenario Outline: Validate seat distribution selection
    When I select "<distribution>" as the seat distribution
    Then the option "<distribution>" should be selected

    Examples:
      | distribution |
      | 2-4-2       |
      | 3-3-3       |
      | 2-2-2       |

  Scenario Outline: Validate airplane ID field constraints
    When I enter "<input>" as the airplane ID
    Then I should see an error message "<errorMessage>" for the field "airplaneId"

    Examples:
      | input | errorMessage |
      | ID            | El ID de avión debe tener entre 5 y 10 caracteres |
      | ID12345678900 | El ID de avión debe tener entre 5 y 10 caracteres |

  Scenario: Successful airplane registration with valid data
    When I enter "Boeing 737" as the airplane type
    And I enter "180" as the seat capacity
    And I select "3-3-3" as the seat distribution
    And I enter "BOE737MAX" as the airplane ID
    And I press the register button
    Then I should see a success message "El avión ha sido registrado correctamente."
