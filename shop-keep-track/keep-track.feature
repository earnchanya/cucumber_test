Feature: Keep track of inventory
    As a employee 
    I want to know the quantity remain of product

Background:
    Given a product Shampoo with ID number 0001

Scenario: Check product
    When I search the product by ID number
    Then Show the quantity remain of product

