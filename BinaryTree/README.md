Compile in Unix
==============

javac -cp .:junit-4.11.jar:hamcrest-core-1.3.jar ./*.java

Run Tests in Unix
================

java -cp .:jars/junit-4.11.jar:jars/hamcrest-core-1.3.jar:bin org.junit.runner.JUnitCore BinaryTreeTest
