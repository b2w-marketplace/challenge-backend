#!/bin/bash

orderURL=http://www.mocky.io/v2/5817803a1000007d01cc7fc9

start="mvn spring-boot:run -DorderURL=$orderURL"

echo "Executando: $start"
eval $start
