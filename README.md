
# Points Demo Service

HTTP endpoint that displays the points earned during the previous three months


## Technologies
- Spring Boot
- Spring Data JPA
- RDBMS (MySQL)
- Apache Commons - Date calcs
- Maven
- Java 21

## Project Structure

## API Endpoints

- `GET  /points' Gets the rewards for the past three months with start and end dates

## API Output
<pre>
  {
    "body": {
        "monthlyPoints": [
            {
                "startDate": "2024-09-07T01:54:03.627+00:00",
                "endDate": "2024-09-07T01:54:03.627+00:00",
                "points": 10
            },
            {
                "startDate": "2024-08-07T01:54:03.627+00:00",
                "endDate": "2024-08-07T01:54:03.627+00:00",
                "points": 18
            },
            {
                "startDate": "2024-07-07T01:54:03.627+00:00",
                "endDate": "2024-07-07T01:54:03.627+00:00",
                "points": 0
            }
        ]
    }
}
</pre>
