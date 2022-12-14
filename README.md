# :checkered_flag: AutoService :checkered_flag:

## Description

It a simple web application buildet on SpringBoot, to simplify auto-service accounting work. Program can calculate a salary of mechanics :mechanic: ,
save the history of orders, make a discontto returning costumers. Also program easy to expend and update.

## Technologies

- SpringBoot 3.0.0
- Java 18
- Maven
- Postgresql 42.5.1
- Junit 5
- Mockito 4.9.0
- Lombok
- Swagger.core 2.2.7
- Swagger 1.6.8
- SpringDoc 1.6.13

## Project structure

``` 
Controller layer
Service layer
```

## Features

- Calculate a mechanic salary :moneybag:
- Get list of orders :orange_book:
- Save cars, orders, costumers to db :briefcase:
- Add a new products and services :toolbox:
- Calculate a order cost :dollar:

## Quickstart
1. Copy link of project
2. Create new project from Version Control 
3. Edit resources/application.properties - set the necessary parameters
``` java
    spring.datasource.driver-class-name=YOUR_DRIVER
    spring.datasource.url=YOUR_URL
    spring.datasource.username=YOUR_USERNAME
    spring.datasource.password=YOUR_PASSWORD
```
4. Do not forget set this param on "create" for first run of the project. Like this: 
``` java
    spring.jpa.hibernate.ddl-auto=create
```
5. Create the necessary name of DB
6. Run project
7. Enjoy

## :car:

