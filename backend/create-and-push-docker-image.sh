#!/bin/bash
# just for testing purposes, will add a github action later
mvn clean package
docker build -t gcr.io/jovial-syntax-292308/haubzit-backend:latest .
docker push gcr.io/jovial-syntax-292308/haubzit-backend:latest