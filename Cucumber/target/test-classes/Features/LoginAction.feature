Feature: Login Action
    Description: This feature will test a LogIn and LogOut functionality

Scenario Outline: Login with valid and Invalid Credentials
    Given User is on Home Page
    When User navigate to Login Page
    Then User enters "<username>" and "<password>" keeping case as "<Case>"
    Then User should get logged in if "<Case>" is Valid
    And Message displayed Login Successfully if "<Case>" is Valid
    Then user will be asked to go back to login page if "<Case>" is Invalid
    And Provide correct credentials if "<Case>" is Invalid

Examples:
    | username               | password         | Case    |
    | standard_user          | secret_sauce     | Valid   |
    | locked_out_user        | secret_sauce     | Valid   |
    | problem_user           | secret_sauce     | Valid   |
    | performance_glitch_user| secret_sauce     | Valid   |
    | error_user             | secret_sauce     | Valid   |
    | visual_user            | secret_sauce     | Valid   |
    | invalid_username       | secret_sauce     | Invalid |  # Invalid username
    | standard_user          | invalid_password | Invalid |  # Invalid password
    | invalid_username       | invalid_password | Invalid |  # Invalid username and password
