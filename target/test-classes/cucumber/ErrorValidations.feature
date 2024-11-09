
@tag
Feature: Error validation


  @tag2
  Scenario Outline: Title of your scenario outline
    Given I landed on Ecommerce page
    When Logged in with username<name> and <password>
    Then "Incorrect email or password" message is displayed

    
    Examples: 
      | name              |password        |
      |  rishab@gmail.com | Akanksha@1111    |
      						 
