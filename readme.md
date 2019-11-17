##About

This is web game based on the [**Gennady Gorin idea**](youtube.com/watch?v=aaD5MBueg6c). Goal of the game - guess the right axe.

## Requirements

**Java 8**

[**Maven**](https://maven.apache.org/)

**PostgreSQL 9.6+**

## Build and run jar

Create database `guess_axe_db` on you local PostgreSQL DB with login\password: `postgres` and 5432 port

In the project directory

    $ mvn clean package

In `target` folder
    
    $ java -jar beerasta-1.0-SNAPSHOT.jar
    
Open [http://localhost:8080](http://localhost:8080) and check the app
    
    
Now you can debug front on [http://localhost:3000](http://localhost:3000) with hot deploy 

## Heroku

Now the [**application is deployed at Heroku**](guessaxe.herokuapp.com/).

You can submit info about bug on repository issues page.