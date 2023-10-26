@regression @cart
Feature: Sauce Demo Shopping Cart automated tests

  Background: User is logged in
    Given User is on Dashboard page with "standard_user"

    Scenario: User is able to access Shopping cart page and see all necessary elements
      When User clicks on Shopping cart icon
      Then User will be presented with Cart elements

    Scenario: User is able to add to Cart an item and then go through the checkout process
      When User clicks on Sauce Lab Backpack Add to cart button
      And User clicks on Shopping cart icon
      And User clicks on Checkout button
      And User populates Your Information input fields
      And User clicks on Continue button
      And User clicks on Finish button
      Then User will be presented with text "Thank you for your order!"

