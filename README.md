# QAA-LoginTest
Positive and negative tests from the login form at https://www.saucedemo.com/


In this Test Case I decided to run two tests, one positive and one negative for the login form at saucedemo.com

I used TestNG annotations to organize my code.

Before the execution I added an argument due to some errors happening in the new chrome driver, this can be seen in line 26. I also added interactions to be used later.

The first test is the positive one. Username and Password elements are searched by ID, and the login button is clicked with an Action. I also added some waiting time between executions, because seeing the test run is the fun part ;). Finally I used Asserts to find the correct text in the next page to validate the login.

the second test is negative. It's the same as before, but completing the form with incorrect information. After clicking the login button I added a "contains" function to search for a shorter text in the incorrect login message.

