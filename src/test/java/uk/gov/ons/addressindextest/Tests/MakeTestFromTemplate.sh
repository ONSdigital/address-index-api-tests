#!/bin/bash
if [ "$#" -ne 3 ]; then
    echo "Please pass parameters (3) for test case number, UPRN and address"
    exit 1
fi

filename="AddressIndexTestSearch${1}Test.java"
echo $filename
if [ -f $filename ]; then
    echo "Filename already exists"
    exit 2
fi

sed "s/<NO>/${1}/g" AddressIndexTestSearchTestTemplate.template > $filename
sed -i "s/<UPRN>/${2}/g" $filename
sed -i "s/<ADDRESS>/${3}/g" $filename

