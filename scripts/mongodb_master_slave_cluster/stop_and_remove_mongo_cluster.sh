#!/usr/bin/env bash

. ../utils.sh

echo "Stopping containers"
docker stop mdb_replica_set1_node1 mdb_replica_set1_node2 mdb_replica_set1_node3;

echo "Removing containers"
docker rm mdb_replica_set1_node1 mdb_replica_set1_node2 mdb_replica_set1_node3;