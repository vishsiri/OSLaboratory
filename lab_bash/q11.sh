#!/bin/bash
for file in $(find . -type f -name "*.c" | sort)
do
    trimmedName=`ls $file | cut -d'/' -f2 | cut -d'.' -f1` 
    compile=$(gcc -o $trimmedName $file 2>/dev/null)
    result=$(./$trimmedName 2>/dev/null)
    # echo $result
    if [ $result -eq 20 ]
    then
        score=10
    elif [ $result -ne 20 ]
    then
        score=7
    else
        score=5
    fi
    file=`ls $file | cut -d'/' -f2`
    echo "$file     $score"
done