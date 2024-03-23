Feature: Login functionality on login page of Application				
Scenario Outline: Verification of login button with numbers of credential

Given Open the Chrome Bowser and launch the application				
When Enter the Username "<username>" and Password "<password>"				
Then Login the credential

    Examples: 
      | username       | password     |
      | standard_user  | secret_sauce |
      | problem_user   | secret_sauce |
      | tct            | test123      |     