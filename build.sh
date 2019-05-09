#!/usr/bin/env bash

./gradlew clean build -x test
docker build -t zhanhonglai/form-management-service .
docker push zhanhonglai/form-management-service
kubectl delete pods -l app=form-management-service