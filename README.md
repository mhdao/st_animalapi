# st_test
**Over View**
This is test exam, demostration the rest api application allow user to query animal base on spring boot. Eclipse is used to devloper this test

## Source Code Structure

Below is source code structure of application:
+ st_animalapi
	+ src/main
			+ Animal.java
			+ AnimalapiApplication.java
      + AnimalController.java
      + SwaggerConfig.java
      
	+ src/test
			+ BaseTest.java
      + AnimalControllerTest.java
      + AnimalapiApplicationTests.java
	+ release    
		+ animalapi-0.0.1-SNAPSHOT.jar
	+ README.md
  
## Source Code Detail

Source code stored in **src/main** folder includes 4 classes
1. **Animal.java** is domain class, it contain id and name for animal.
2. **AnimalapiApplication.java** is boot strap class to trigger application to run
3. **AnimalController.java** is main service class, allow user to query all, query by id, add more animal, delete animal
4. **SwaggerConfig.java** is Swagger config class, to documentation api

Test classes stored in **src/test** folder includes 3 classes
1. **BaseTest.java** the base class for unit test
2. **AnimalControllerTest.java** is for unit test all api in AnimalController.java
3. **AnimalapiApplicationTests.java** for unit test application context start success or not.

## How To Run Application
animalapi-0.0.1-SNAPSHOT.jar is located in release/ folder. to run it just type in console: **java -jar animalapi-0.0.1-SNAPSHOT.jar**.
animalapi application will start and run on port 8090.

To see api document detail: just type in browse: 
http://localhost:8090/swagger-ui.html#/animal-controller
