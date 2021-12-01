#!/bin/sh
mvn clean package && docker build -t tarleton/DAFinalProject .
docker rm -f DAFinalProject || true && docker run -d -p 9080:9080 -p 9443:9443 --name DAFinalProject tarleton/DAFinalProject