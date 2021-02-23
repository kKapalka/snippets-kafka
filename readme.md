# Code Snippets - Kafka

In order for this to work, you need to:
- install Apache Kafka on your machine (https://kafka.apache.org/downloads)
- start the environment (https://kafka.apache.org/quickstart) (If you're using Windows, use paths to .bat files instead of .sh files)
- create topics: message-in, message-out

This project consists of:
- Kafka producer, which pushes messages into message-in using input provided via POST, under address localhost:1337
- Kafka processor, which takes in the message, adds a key to the KStream, and reverses the string message before sending it onwards to message-out topic
- Kafka consumr, which just displays the received message