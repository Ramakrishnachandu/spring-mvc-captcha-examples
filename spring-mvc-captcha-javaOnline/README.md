spring-mvc-captcha-javaOnline
------------------------------
App URL:
-------
http://localhost:8080/spring-mvc-captcha-javaOnline/loadLoginPg


Reference URL:
-------
http://javaonlineguide.net/2015/04/implementing-captcha-in-spring-mvc-web-application-example.html


In this tutorial, let us see that how to implement simple Captcha in Spring MVC web application. In this example, let us implement captcha by creating a login page in Spring. CAPTCHA is a image of letters and numbers used to prevent automated use of pages. The acronym of CAPTCHA is  “Completely Automated Public Turing test to tell Computers and Human Apart”.  Login page that include captcha ensures that human can only login. Now let us see the steps to implement captcha in login page.

Brief Steps:
------------
1. Create login page with captcha
2. Write server side code for generating captcha image and puting in the response.
3. Code to verify whether the captcha string entered by user and stored in the session matches or not.


Jars Used:
---------
Spring 4.2.x jars, jstl-1.2.jar and java 1.8

Steps in Detail:
----------------
Step 1: Design a web page having the following fields
1. login id
2. password
3. image tag to display captcha
4. input box to accept captcha string
5. refresh button to send request to regenerate the captcha