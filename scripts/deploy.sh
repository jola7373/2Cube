#!/bin/bash

REPOSITORY=/home/ec2-user/app/step2/zip

echo">check running pid"

echo "$CURRENT_PID"

if [ -z $CURRENT_PID ]; then
    echo "> There is no pid running currently."
else
    echo "> kill -15 $CURRENT_PID"
    kill -15 $CURRENT_PID
    sleep 5
fi

echo "> deploy new application"

echo "> copy build file"

cp $REPOSITORY/*.jar $REPOSITORY/jar/

JAR_NAME=$(ls -tr $REPOSITORY/jar/*.jar | tail -n 1)

echo "> JAR Name: $JAR_NAME"

echo "> give authority to $JAR_NAME"

chmod +x $JAR_NAME

nohup java -jar $JAR_NAME > $REPOSITORY/nohup.out 2>&1 &
