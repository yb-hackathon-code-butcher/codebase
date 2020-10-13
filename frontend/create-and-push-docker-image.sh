#!/bin/bash
# just for testing purposes, will add a github action later
docker build -t gcr.io/haubzit/haubzit-frontend:latest .
docker push gcr.io/haubzit/haubzit-frontend:latest
