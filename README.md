# Selenium-WebForm
Automation test with Selenium Web form

## How to run the tests

* Clean Test 
```
mvn clean test
```
* To run scenarios tagged
```
mvn test -Dcucumber.filter.tags="@tags
```
* - To run scenarios tagged with both `@webForm` and `@apiTests`:
```
mvn test -Dcucumber.filter.tags="@webForm or @apiTests"
```
* To - exclude scenarios tagged with 
```
mvn test -Dcucumber.filter.tags="not @ignore"
```

* To run the test in Github Actions, click on Actions, select the test job and click on Re-Run all Jobs.