#!/bin/bash
set -e	# as soon as there is a compile error, the script will exit

javac -d out/ src/TripFinderAlgorithm/*.java

java -cp ./out TripFinderAlgorithm.TripGenerator $1


