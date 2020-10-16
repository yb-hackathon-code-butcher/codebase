#!/bin/bash
# just for testing purposes, will add a github action later
mvn clean package
mvn dockerfile:build
docker push gcr.io/haubzit/haubzit-backend:latest
