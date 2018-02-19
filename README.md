# send-message
This project consists in a simple rest application to send messages. We have EmailMessageSender and SmsMessageSender
In order to implement a new message type do the following:
1. Create another Entity extending the abstract class Message
2. Create a MessageSender by creating a class that implements Sender interface with @Component.

## Building and Test (unit and integration)
To execute the build and the tests (both unit and integration) execute the following command in the root folder of the project:
    gradle build

## Running
To run the project execute the following command in the root folder of the project:
    gradle bootRun

## Calling services

/send message operation:
* http://localhost:8080/send
** method: Post
** sample sms payload:
{
	"entityType": "sms",
    "from": {
    	"country": 55,
    	"number": "515151"
    },
    "to": {
    	"country": 48,
    	"number": "48484"
    },
    "text": "xcccc"
}
** sample email payload:
{
    "entityType": "email",
    "from": "eduardo@gmail.com",
    "to": "silaine@gmail.com",
    "title": "ttt",
    "body": "bbbb"
}

/list message operation:
* http://localhost:8080/list
** method: Get