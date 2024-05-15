# ePopis
`Baze podataka (2261)`

## Project Structure

The project is structured as follows:

- `src/main/java/epopis`: Contains the main application code.
  - `app`: Contains the main application entry point.
  - `db`: Contains database utilities and the connection pool.
  - `model`: Contains the data models.
  - `tests`: Contains test classes.
- `src/main/resources`: Contains resources like database properties.
- `pom.xml`: Maven project file, which includes project dependencies and build settings.

## Key Components

- [`ConnectionPool`](src/main/java/epopis/db/ConnectionPool.java): A singleton class that manages a pool of database connections.
- [`DBUtil`](src/main/java/epopis/db/DBUtil.java): A utility class for database operations.
- [`DriverGetAllTest`](src/main/java/epopis/tests/sqldriver/DriverGetAllTest.java): A test class for the SQL driver.

## Building the Project

This is a Maven project, and can be built using the following command:

```sh
mvn clean install
```

## Running the Project

The main entry point of the application is [`Main.java`](src/main/java/epopis/app/Main.java). You can run the application from your IDE, or from the command line with:

```sh
java -cp target/epopis-1.0-SNAPSHOT.jar epopis.app.Main
```

Please ensure that the database properties in `src/main/resources/db.properties` are correctly set up before running the application.
