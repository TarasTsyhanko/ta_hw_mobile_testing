# Gmail test project
created by Taras Tsyhanko

# Description
created to test case : login to gmail account and send letter.

testing Gmail app, mobile and desktop version,

Using Page Factory Model ,maven and Allure Reporting.

# Getting started
mvn clean test -Dstrategy=native|web

# Generate report 
mvn allure:report ,
 report wil be available in target/site/allureReport/index.html
 & mvn allure:serve