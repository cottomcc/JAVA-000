#!/bin/bash

memories=(128m 512m 1g 2g 4g)

gcTypes=(UseSerialGC UseParallelGC UseConcMarkSweepGC UseG1GC)

for memory in "${memories[@]}"
    do
        for type in "${gcTypes[@]}"
            do
                echo 
                echo -----------[start]       memory=$memory type=$type        --------------

                `java GCLogAnalysis -XX:+$type -Xms$memory -Xmx$memory  -Xloggc:gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps  GCLogAnalysis`

                echo -----------[end]         memory=$memory type=$type          --------------
                echo 
            done
    done