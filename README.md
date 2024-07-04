# java api

## Technologies

* Java 17
* Maven 3.9.0

## Setup

### Prerequisites

- openjdk: 17
- gitbash (for windows machines)

### Installation
To install dependency

1) open project with IntelliJ Idea or any other IDE
2) Install dependencies

```shell
mvn clean install
```

3) create .env file with next data:
```shell
TOKEN={yout token}
BASE_URL=https://api.clickup.com/api/v2
```
4) replace the space id {90******75} by yours in the files:
```shell
clickup/api/steps/TagsSteps.java
clickup/api/rest/TagsRestClient.java
```
5) run tests with the commands:

```shell
mvn failsafe:integration-test
mvn failsafe:integration-test -Dcucumber.filter.tags="@homework"
```

## To Generate report
```shell
mvn serenity:aggregate
```

