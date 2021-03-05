#kafka-beginner

###Local setup:

- install kafka-cli
- start zookeeper and kafka server

`zookeeper-server-start <PATH>/kafka_2.13-2.6.0/config/zookeeper.properties`

`kafka-server-start <PATH>/kafka_2.13-2.6.0/config/server.properties`

- create a topic

`kafka-topics --bootstrap-server localhost:9092 --create --topic truck_location`

- create a consumer for the topic

`kafka-console-consumer --bootstrap-server localhost:9092 --topic truck_location`
