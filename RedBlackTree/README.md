Compile in Unix
==============

javac -d bin -cp .:jars/junit-4.11.jar:jars/hamcrest-core-1.3.jar tests/*.java src/*.java

Run Tests in Unix
================

java -cp .:jars/junit-4.11.jar:jars/hamcrest-core-1.3.jar:bin org.junit.runner.JUnitCore BinaryTreeTest
