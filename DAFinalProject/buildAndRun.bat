@echo off
call mvn clean package
call docker build -t tarleton/DAFinalProject .
call docker rm -f DAFinalProject
call docker run -d -p 9080:9080 -p 9443:9443 --name DAFinalProject tarleton/DAFinalProject