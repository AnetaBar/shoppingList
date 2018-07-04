# Shopping List Project

A simple application that allows to store a shopping list. User can see the list, add an item to it (declaring its name and quantity) or remove items.
* Database - HSQL
* Backend - Java, Spring Boot, Mockito tests
* Frontend - HTML, CSS, Javascript

## Getting started

### The first step - starting the database layer:
```
cd shoppingListBackend/db
runHSQLDBServer.bat
runHSQLDBClient.bat
```

### The second step - starting the backend layer:
```
cd ..
mvn clean install
mvn spring-boot:run
```

### The third step - starting the frontend layer:
```
cd ../shoppingListFrontend
npm install http-server -g
http-server
```

At this application is available - the URL is visible in the command line.
