#!/usr/bin/env bash

. ../utils.sh

print_info "Check cluster status"
echo 'sh.status()' | docker-compose exec -T mdb_server1 mongo