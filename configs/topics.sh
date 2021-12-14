#!/bin/sh

kafka-topics --bootstrap-server localhost:9092 --topic user-average-page-view-duration --replication-factor 1 --partitions 4 --create
kafka-topics --bootstrap-server localhost:9092 --topic page-average-view-duration --replication-factor 1 --partitions 4 --create
kafka-topics --bootstrap-server localhost:9092 --topic visited-pages --replication-factor 1 --partitions 4 --create
kafka-topics --bootstrap-server localhost:9092 --topic user-click-promotion --replication-factor 1 --partitions 4 --create
kafka-topics --bootstrap-server localhost:9092 --topic user-leave-page --replication-factor 1 --partitions 4 --create
kafka-topics --bootstrap-server localhost:9092 --topic user-open-page --replication-factor 1 --partitions 4 --create
