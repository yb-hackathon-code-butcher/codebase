#!/bin/bash
# just for testing purposes, will add a github action later
docker build -t gcr.io/jovial-syntax-292308/haubzit-frontend:latest .
docker push gcr.io/jovial-syntax-292308/haubzit-frontend:latest
