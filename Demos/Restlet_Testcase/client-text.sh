#!/bin/bash
curl --header "content-type: plain/text" --header "Accept: plain/text" --data @${2} -X POST  "http://localhost:8180/${1}"
