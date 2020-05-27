#!/usr/bin/env bash

. ../utils.sh

print_info "Check cluster status"
echo 'db.adminCommand( { replSetGetStatus: 1 } )' | docker-compose exec -T mdb_replica_set1_node3 mongo