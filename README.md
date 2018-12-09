Car Performance Service
======================

# Initial task

Implement web application with following capabilities:

1. show data form json on ui
2. in this form show data below
3. if button is pressed on form, store the data from the form again as if it was new data

# Requirements

Embedded servlet container, any database, spring framework, maven/gradle

# Used technologies

Backend:

1. Spring Boot 2.1.0
2. Postgres
3. Rest/Json controllers
4. Flywaydb
5. Maven
6. Embedded tomcat

Frontend:

1. Angular/TypeScript 7.0.6

# Test data 

```
{
	"tracks": [{
		"id": 1,
		"name": "Millbrook",
		"description": "Millbrook city course race track",
		"length": {
			"unit": "km",
			"value": 7.4
		},
		"cars": [{
			"id": "2",
			"code": "rdb1",
			"transmission": "automatic",
			"ai": "enabled",
			"max-speed": {
				"unit": "mps",
				"value": 110.12121212
			}
		}, {
			"id": "1",
			"code": "rdb3",
			"transmission": "automatic",
			"ai": "disabled",
			"max-speed": {
				"unit": "mps",
				"value": 120.967
			}
		}]
	}]
}

```