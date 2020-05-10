#!/usr/bin/env bash

. ./shared.sh

echo "Stopping containers"
docker stop mdb_server1 mdb_replica_set2_node1 mdb_replica_set1_node1 mdb_config_node1;

echo "Removing containers"
docker rm mdb_server1 mdb_replica_set2_node1 mdb_replica_set1_node1 mdb_config_node1;