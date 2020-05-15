#!/usr/bin/env bash

. ../utils.sh

print_info "Starting docker containers"
docker-compose up -d

print_info "Sleeping 3 seconds before initiating replica sets"
sleep 3

print_info "Initiate replica sets"
echo 'rs.initiate({
    _id : "replica_set1",
    members: [
        {_id:0, host:"mdb_replica_set1_node1:27017"},
        {_id:1, host:"mdb_replica_set1_node2:27017"},
        {_id:2, host:"mdb_replica_set1_node3:27017"},
    ]
})' | docker-compose exec -T mdb_replica_set1_node1 mongo

print_info "Sleeping 3 seconds before connecting replica sets"
sleep 3

print_info "Connect mongo replica sets"
docker-compose exec mdb_replica_set1_node3 mongo --host replica_set1/mdb_replica_set1_node1,mdb_replica_set1_node2,mdb_replica_set1_node3

. ./cluster_status.sh

