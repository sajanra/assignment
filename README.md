Test cases for Car
------------------- 

/creat-car
-----------

Success :

	This test checks if the car is created successfully, We expect a status of 201 (Created) and verify the returned JSON fields.

Failure :

	This test checks if the API returns a 400 Bad Request status when required fields like year are missing in the POST request body.

/get-car/{id}
-------------

Success :

	This test checks if the /get-car endpoint returns the car details when the car is found by ID.

Failure :

	This test checks if the API returns 500 Internal Server Error with Car Not Found Exception when trying to retrieve a non-existing car.

/update-car/{id}
----------------

Success :

	This test checks if the /update-car endpoint returns the updated car details when the car is found and successfully updated.

Failure :

	This test checks if the API returns a 404 Not Found status when trying to update a non-existing car.

/delete-car/{id}
-----------------

Success :

	This test checks if the /delete-car endpoint returns a 204 No Content status when the car is deleted successfully.

Failure :

	This test checks if the API returns a 404 Not Found status when trying to delete a non-existing car.


Test cases for Bike
--------------------

/creat-bike
------------

Success :

	This test checks if the bike is created successfully, We expect a status of 201 (Created) and verify the returned JSON fields.

Failure : 

	This test checks if the API returns a 400 Bad Request status when required fields like year are missing in the POST request body.

/get-bike/{id}
--------------

Success :

	This test checks if the /get-bike endpoint returns the bike details when the bike is found by ID.

Failure :

	This test checks if the API returns 500 Internal Server Error with Car Not Found Exception when trying to retrieve a non-existing bike.

/update-bike/{id}
------------------

Success :

	This test checks if the /update-bike endpoint returns the updated bike details when the bike is found and successfully updated.

Failure :

	This test checks if the API returns a 404 Not Found status when trying to update a non-existing bike.

/delete-bike/{id}
------------------

Success :

	This test checks if the /delete-bike endpoint returns a 204 No Content status when the bike is deleted successfully.

Failure :

	This test checks if the API returns a 404 Not Found status when trying to delete a non-existing bike.




For Running steps : 

If you run localaly :
----------------------

	Then right click on project and then click on Run as then a prompt open and select Spring boot App

	After then your project starting and when project started :

	Then first you need to Hit /register-user  Post Api of UserController class with all details
	in Postman for register user with his role.

	When you want to access any api Of VehicleController then first you need to Hit /authenticate Api of JWTController

	for Token based authentication after hitting above api with right username and password then a Bearer token will be create.

	And when you want create car details then first you need to enter generated bearer token in header with Authorization key. 


If you run on server :
----------------------

`   First i build the application by right clicking on project run as -> maven build  after build the project a jar or war file come
	into the target folder and then upload this jar on a folder of specific server then copy then open the putty for specific server

	and first in this we copy the jar file in specific location and then execute supervisorctl command and after then write command for
	restart the project like restart and project name and then 
	we see the current log that application start or not or any exception come or not by tail -f log folder name and log file name.
	
	cp /home/development/agent-services.jar 
	supervisorctl
	restart agent-services
	tail -f /var/log/trace/agent-services.log


 
