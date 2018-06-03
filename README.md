# Glee
Glee is a simple social networking application.

### Basic Functionality
 - Add new post
 - Follow friends
 - Recommend friends
 - View friends'posts in reverse chronological order
 - View all posts in reverse chronological order
 - View user's own posts in reverse chronological order

### Technologies
 - Bootstrap
 - jQuery
 - Spring Boot
 - Thymeleaf
 - Redis
 - H2

 ### Screenshot

 Index page
  ![index](https://github.com/qingfei1994/glee/blob/master/images/index.JPG)
 User's home page
  ![home](https://github.com/qingfei1994/glee/blob/master/images/greeting1.jpg)
Message List
  ![message](https://github.com/qingfei1994/glee/blob/master/images/message.JPG)

### Deployment Guide

1.Make sure Maven and Redis is installed on your system.

2.Go into the project directory and run ```mvn clean package```.When it is finished, you will see a glee-0.0.1-SNAPSHOT.jar is generated in target folder

3.Run command ```java -jar target/glee-0.0.1-SNAPSHOT.jar ``` and wait for the application start.

4.Point your browser to http://localhost:8080. Wish you have fun in Glee.

 

