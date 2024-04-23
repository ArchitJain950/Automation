
@tag
Feature: purchase the order from ecommerce
  I want to use this template for my feature file

  Background:
  Given I landed on ecommerce page

  @Regression
  Scenario Outline: positive test for submitting the order
  
    Given logged  in using the <username> and <password>
    When add <product> to the cart
    And checkout <product> and submit the order
    Then "THANKYOU FOR THE ORDER." is displayed on the confirmation page

    Examples: 
      | username             | password   |  product    |
      | Architjain@gmail.com |  Archit@123|  ZARA COAT 3|
      
      
