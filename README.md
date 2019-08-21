# Songr

## Running and Testing
* Clone repo to machine
* run `psql` in your terminal
* run `CREATE DATABASE albums;`
* CD into directory songr
* For testing run ./gradlew test
* For running run ./gradlew bootRun
    * open localhost:8080/hello
    * localhost:8080/capitalize/Anthing you want
    * localhost:8080/reverse?sentence=Any sentance you want to be reversed
O    * localhost:8080/albums
        *This will show you all albums in the db and there is a form to add albums.  This will not display any until you add the first album to your local db. When you click submit to add a new album it will refresh the page and your new album should be listed and stored in your local database.
        