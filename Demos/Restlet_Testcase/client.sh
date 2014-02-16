#!/bin/bash
curl --header "content-type: application/xml" --header "Accept: application/xml" --data @${2} -X POST  "http://localhost:8180/${1}"
