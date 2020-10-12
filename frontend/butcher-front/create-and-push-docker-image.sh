#!/bin/bash
# just for testing purposes, will add a github action later
docker build --no-cache --pull -t gcr.io/jovial-syntax-292308/haubzit-frontend:latest -f Dockerfile .
docker push gcr.io/jovial-syntax-292308/haubzit-frontend:latest
