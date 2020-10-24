#!/usr/bin/env bash

# If your regular Java version is below 12, uncomment the line with "export" and
# set JAVA_HOME to the path of a Java executable with version 12 or higher.

#export JAVA_HOME=/usr/lib/jvm/java-12-oracle

if [ ! -z "$JAVA_HOME" ];
then
    export PATH="$JAVA_HOME/bin:$PATH"
fi
