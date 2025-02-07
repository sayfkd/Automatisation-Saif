#!/bin/bash

cd ../../../../../.. 

#classic tests...
mvn test 

# Cucumber tests
mvn test -Dcucumber.features="src/test/resources/com/logwire"

#Test by tag
# mvn test -Ducumber.filter.tags="@tagname" 

echo "All tests executed!"mvn test -Dcucumber.features="src/dossier/feature1.feature" 
