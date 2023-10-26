@regression @dashboard
Feature: Sauce Demo Dashboard automated tests

  Background: User is logged in
    Given User is on Dashboard page with "standard_user"

    Scenario: User is able to see Swag Labs application Logo, Cart icon and Burger menu
      Then User will be able to see application Logo
      And User will be able to see Cart icon
      And User will be able to see Burger menu

    Scenario: User is able to see Burger menu options when clicking on Burger menu
      When User clicks on Burger menu
      Then User will be presented with Burger menu options

    Scenario: User will be able to add to Cart Sauce Lab Backpack
      When User clicks on Sauce Lab Backpack Add to cart button
      Then User will be able to see counter on cart icon

    Scenario: User is able to filter the Products by price increasing
      When User clicks on filter dropdown
      And User clicks on option Price low to high
      Then User will be able to see filtered Products by Price low to high

    Scenario: User is able to filter the Products by price decreasing
      When User clicks on filter dropdown
      And User clicks on option Price high to low
      Then User will be able to see filtered Products by Price high to low

