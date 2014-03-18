#!/bin/bash
set -e
cd src
javac -cp ../lib/google-gson-2.2.4/gson-2.2.4.jar im/antoine/bombjava/*.java
jar cf ../dist/bombjava.jar im/antoine/bombjava/*.class
echo "Done."
