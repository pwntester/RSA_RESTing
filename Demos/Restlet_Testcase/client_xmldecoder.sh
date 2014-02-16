#!/bin/bash
curl --header "content-type: application/x-java-serialized-object" --header "Accept: application/x-java-serialized-object" --data @${2} -X PUT  "http://localhost:8180/${1}"
