$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("draftingGmailFeatures/draftingMail.feature");
formatter.feature({
  "line": 1,
  "name": "This feature tests the drafts in Gmail",
  "description": "",
  "id": "this-feature-tests-the-drafts-in-gmail",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "this scenario tests how user logs in gmail, navigates to drafts and verifies draft stored mail",
  "description": "",
  "id": "this-feature-tests-the-drafts-in-gmail;this-scenario-tests-how-user-logs-in-gmail,-navigates-to-drafts-and-verifies-draft-stored-mail",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@prueba"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "the user \u0027\u003cuserName\u003e\u0027 loggs in using his password \u0027\u003cpassword\u003e\u0027",
  "keyword": "Given "
});
formatter.examples({
  "comments": [
    {
      "line": 6,
      "value": "#    And starts composing a new email providing recipient \u0027\u003crecipient\u003e\u0027 and topic \u0027\u003ctopic\u003e\u0027"
    },
    {
      "line": 7,
      "value": "#    When user mail coposing is interrupted"
    },
    {
      "line": 8,
      "value": "#    Then verify email is stored in draft\u0027s folder"
    }
  ],
  "line": 10,
  "name": "",
  "description": "",
  "id": "this-feature-tests-the-drafts-in-gmail;this-scenario-tests-how-user-logs-in-gmail,-navigates-to-drafts-and-verifies-draft-stored-mail;",
  "rows": [
    {
      "cells": [
        "userName",
        "password",
        "recipient",
        "topic"
      ],
      "line": 11,
      "id": "this-feature-tests-the-drafts-in-gmail;this-scenario-tests-how-user-logs-in-gmail,-navigates-to-drafts-and-verifies-draft-stored-mail;;1"
    },
    {
      "cells": [
        "Juan.Epam",
        "Password123$",
        "Juan.Epam",
        "Test Drafting"
      ],
      "line": 12,
      "id": "this-feature-tests-the-drafts-in-gmail;this-scenario-tests-how-user-logs-in-gmail,-navigates-to-drafts-and-verifies-draft-stored-mail;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 12,
  "name": "this scenario tests how user logs in gmail, navigates to drafts and verifies draft stored mail",
  "description": "",
  "id": "this-feature-tests-the-drafts-in-gmail;this-scenario-tests-how-user-logs-in-gmail,-navigates-to-drafts-and-verifies-draft-stored-mail;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@prueba"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "the user \u0027Juan.Epam\u0027 loggs in using his password \u0027Password123$\u0027",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "Juan.Epam",
      "offset": 10
    },
    {
      "val": "Password123$",
      "offset": 50
    }
  ],
  "location": "GmailTest.theUserLoggsInUsingHisUserNameAndPassword(String,String)"
});
formatter.result({
  "duration": 15862451283,
  "error_message": "org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"id\",\"selector\":\"Email\"}\nCommand duration or timeout: 22 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.45.0\u0027, revision: \u00275017cb8e7ca8e37638dc3091b2440b90a1d8686f\u0027, time: \u00272015-02-27 09:10:26\u0027\nSystem info: host: \u0027EPPLKRAW0119\u0027, ip: \u002710.143.12.74\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_20\u0027\nDriver info: org.openqa.selenium.firefox.FirefoxDriver\nCapabilities [{applicationCacheEnabled\u003dtrue, rotatable\u003dfalse, handlesAlerts\u003dtrue, databaseEnabled\u003dtrue, version\u003d30.0, platform\u003dWINDOWS, browserConnectionEnabled\u003dtrue, nativeEvents\u003dfalse, acceptSslCerts\u003dtrue, webStorageEnabled\u003dtrue, locationContextEnabled\u003dtrue, browserName\u003dfirefox, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 2f5d0417-1186-4e26-868b-db435efa74d1\n*** Element info: {Using\u003did, value\u003dEmail}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:408)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:204)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:156)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:599)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:352)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementById(RemoteWebDriver.java:393)\r\n\tat org.openqa.selenium.By$ById.findElement(By.java:214)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:344)\r\n\tat utils.PageModel.waitForExpectedElement(PageModel.java:37)\r\n\tat GmailLoginPage.GmailLoginPage.loginUserNameTextBox(GmailLoginPage.java:15)\r\n\tat GmailLoginPage.GmailLoginPage.logInWithCredentials(GmailLoginPage.java:31)\r\n\tat GmailTest.GmailTest.theUserLoggsInUsingHisUserNameAndPassword(GmailTest.java:26)\r\n\tat ✽.Given the user \u0027Juan.Epam\u0027 loggs in using his password \u0027Password123$\u0027(draftingGmailFeatures/draftingMail.feature:5)\r\nCaused by: org.openqa.selenium.NoSuchElementException: Unable to locate element: {\"method\":\"id\",\"selector\":\"Email\"}\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.45.0\u0027, revision: \u00275017cb8e7ca8e37638dc3091b2440b90a1d8686f\u0027, time: \u00272015-02-27 09:10:26\u0027\nSystem info: host: \u0027EPPLKRAW0119\u0027, ip: \u002710.143.12.74\u0027, os.name: \u0027Windows 7\u0027, os.arch: \u0027amd64\u0027, os.version: \u00276.1\u0027, java.version: \u00271.8.0_20\u0027\nDriver info: driver.version: unknown\r\n\tat \u003canonymous class\u003e.FirefoxDriver.prototype.findElementInternal_(file:///C:/Users/Juan_Rodriguez/AppData/Local/Temp/anonymous6861107366074264474webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:10271)\r\n\tat \u003canonymous class\u003e.FirefoxDriver.prototype.findElement(file:///C:/Users/Juan_Rodriguez/AppData/Local/Temp/anonymous6861107366074264474webdriver-profile/extensions/fxdriver@googlecode.com/components/driver-component.js:10280)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.executeInternal_/h(file:///C:/Users/Juan_Rodriguez/AppData/Local/Temp/anonymous6861107366074264474webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12274)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.executeInternal_(file:///C:/Users/Juan_Rodriguez/AppData/Local/Temp/anonymous6861107366074264474webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12279)\r\n\tat \u003canonymous class\u003e.DelayedCommand.prototype.execute/\u003c(file:///C:/Users/Juan_Rodriguez/AppData/Local/Temp/anonymous6861107366074264474webdriver-profile/extensions/fxdriver@googlecode.com/components/command-processor.js:12221)\r\n",
  "status": "failed"
});
});