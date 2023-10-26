@regression @login
Feature: Sauce Demo Login automated tests

  Background: User is able to login on Sauce Demo web application
    Given User is on Sauce Demo Login page

  Scenario Outline: User is able to login as set of users on Sauce Demo web application
    And User types in "<userName>" into Username input field
    And User types in "<password>" into Password input field
    And User clicks on Login button
    Then User will be redirected to Dashboard page

    Examples:
    | userName                | password     |
    | standard_user           | secret_sauce |
    | locked_out_user         | secret_sauce |
    | problem_user            | secret_sauce |
    | performance_glitch_user | secret_sauce |
    | error_user              | secret_sauce |
    | visual_user             | secret_sauce |

  Scenario Outline: User is not able to login with Locked_User account
    And User types in "<userName>" into Username input field
    And User types in "<password>" into Password input field
    And User clicks on Login button
    Then User will be presented with login "<errorMessage>"

    Examples:
    | errorMessage                                                              | userName        | password     |
    | Epic sadface: Password is required                                        | Test            |              |
    | Epic sadface: Username is required                                        |                 | Test         |
    | Epic sadface: Username and password do not match any user in this service | Test            | Test         |
    | Epic sadface: Sorry, this user has been locked out.                       | locked_out_user | secret_sauce |


  Scenario: User is able to Login to Dashboard page
    Given User is on Dashboard page with "standard_user"
