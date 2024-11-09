
@tag
Feature: Purchase the order from Ecommerce Website //What exactly feature file is doing ,description here
  I want to use this template for my feature file
Background:
Given I landed on Ecommerce page
  @tag1
  Scenario: Title of your scenario//Exactly define the requirement
    Given I want to write a step with precondition
    And some other precondition
    When I complete action
    And some other action
    And yet another action
    Then I validate the outcomes
    And check more outcomes
 
  @tag2
  Scenario Outline: Positive Test of Submitting the order
    Given Logged in with username<name> and password<password>
    When I add product <productName> to cart
    And Checkout<productName> and submit the order
    Then "Thankyou for the order."message is displayed on ConfirmationPage 

    Examples: 
      | name              |password        |productName |
      |  rishab@gmail.com | Akanksha@11     | ZARA COAT 3 |
      						 
