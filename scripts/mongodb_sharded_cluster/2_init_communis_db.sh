#!/usr/bin/env bash

. ../utils.sh

print_info "Create sharded Communis DB and collections"
echo 'db.createCollection("communis.address")' | docker-compose exec -T mdb_server1 mongo
echo 'db.createCollection("communis.person")' | docker-compose exec -T mdb_server1 mongo
echo 'sh.shardCollection("communis.address", {_id: "hashed"})' | docker-compose exec -T mdb_server1 mongo
echo 'sh.shardCollection("communis.person", {_id: "hashed"})' | docker-compose exec -T mdb_server1 mongo

echo 'sh.enableSharding("communis")' | docker-compose exec -T mdb_server1 mongo