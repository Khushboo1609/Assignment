# Assignment
Saving User and their Insurances and Claim details


Steps to run:
1. Clone the repo in your local
2. Run the application, here I'm using h2-console db. So on running you will be able to see the url and username and password you can update in application.properties file.
3. If needed the port on which application will run can be updated in application.properties file.

You can access all the endpoints and try to save, fetch and delete users, claims and Insurance details

Structure of the Appliction:
1. For ORM we have data classes. We have defined relationships here. OnetoOne relationship for client and its insurance and manytoone for claims and insurance.
2. We are communicating and perform database related functionality using Repository classes
3. Controller classes have Rest endpoints
