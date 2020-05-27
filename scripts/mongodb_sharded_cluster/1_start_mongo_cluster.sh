#!/usr/bin/env bash

. ../utils.sh

print_info "Starting docker containers"
docker-compose up -d

print_info "Sleeping 3 seconds before initiating replica sets"
sleep 3

print_info "Mark mongodb server as config server"
echo 'rs.initiate({
    _id: "config1", configsvr: true,
    members: [
        {_id: 0, host: "mdb_config_node1"}
    ]
})' | docker-compose exec -T mdb_config_node1 mongo


print_info "Mark mongodb server as replication servers"
echo 'rs.initiate({
    _id: "replica_set1", members: [
        {_id: 0, host: "mdb_replica_set1_node1"}
    ]
})' | docker-compose exec -T mdb_replica_set1_node1 mongo


echo 'rs.initiate({
    _id: "replica_set2", members: [
        {_id: 0, host: "mdb_replica_set2_node1"}
    ]
})' | docker-compose exec -T mdb_replica_set2_node1 mongo


print_info "Adding replica_set1 and replica_set2 as shards"
echo 'sh.addShard("replica_set1/mdb_replica_set1_node1:27017")' | docker-compose exec -T mdb_server1 mongo
echo 'sh.addShard("replica_set2/mdb_replica_set2_node1:27017")' | docker-compose exec -T mdb_server1 mongo

. ./cluster_status.sh
