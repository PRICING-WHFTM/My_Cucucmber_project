$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/loginPageElements.feature");
formatter.feature({
  "name": "Login page elements",
  "description": "  As a team lead when I login to the application I should be able to see the homepage",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Log-in as team lead",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User is on the HomePage",
  "keyword": "Given "
});
formatter.match({
  "location": "com.company.step_definitions.LoginPageElements_step.user_is_on_the_HomePage()"
});
formatter.result({
  "error_message": "io.cucumber.java.PendingException: TODO: implement me\r\n\tat com.company.step_definitions.LoginPageElements_step.user_is_on_the_HomePage(LoginPageElements_step.java:13)\r\n\tat ✽.User is on the HomePage(file:///C:/Users/salma/IdeaProjects/Cucumber-project/src/test/resources/features/loginPageElements.feature:5)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "User logs in as team lead",
  "keyword": "When "
});
formatter.match({
  "location": "com.company.step_definitions.LoginPageElements_step.user_logs_in_as_team_lead()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Homepage elements should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.company.step_definitions.LoginPageElements_step.homepage_elements_should_be_displayed()"
});
formatter.result({
  "status": "skipped"
});
});