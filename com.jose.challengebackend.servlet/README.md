# Description
Was created a Java servlet project.

The project "com.jose.challengebackend.servlet" is  the servlet, a project that provides the API to consumption, this API realizes the call on the methods on the model project.

# How to run
To run this project you just need to download or clone the servlet project and run with a tomcat 8 or higher, or any other servlet you configure.

# Examples
As example of endpoints:

- To filter the items running the project you just need to call it as GET as the given example, just adding the name of the servlet, wich is explicit on the web.xml file, as example:

**GET http://localhost:8080/com.jose.challengebackend.servlet/challenge-backend/item?begindate=05-10-2016&finaldate=10-10-2016**

- You can also filter any other data in any combination you want, like:

**GET http://localhost:8080/com.jose.challengebackend.servlet/challenge-backend/item?name=Notebook**

**GET http://localhost:8080/com.jose.challengebackend.servlet/challenge-backend/item?width=10.5&name=Notebook&code=7&begindate=05-10-2016&finaldate=07-10-2016&height=10.5**

Obs.: On date filter the begin date and final date are required, or the date filter will be ignored. And the name is comparing using **contains**.

# Testing Environment
There is a Testing Environment running in: http://138.197.129.20:8080/com.jose.challengebackend.servlet/challenge-backend/
To use it just add the method you want, the correct call (GET) and the necessary parameters, as the given examples.
For example:

**http://138.197.129.20:8080/com.jose.challengebackend.servlet/challenge-backend/item?begindate=05-10-2016&finaldate=10-10-2016**
