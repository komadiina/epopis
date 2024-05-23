# ePopis

### About (EN)
Project from Database (2261), '23/24. ePopis is an application that provides the possibility of simulating the listing of electricity consumption, similar to the Elektrokrajina system. The main actors in the model are `Potrosac`, `Elektricar`, `Distributer`, `Snabdjevac`, `Knjigovodja` and `Administrator`. Non-personalized objects, also of great importance, are `Predracun`, `Dokument`, `Opomena`, `Racun`, `Mjesto`. The application was developed using `MySQL (v8.0.36)` technology, with the implementation of business logic in the `Java (v22 JDK` programming language. The environment uses `Maven` *build-system*, for easy resolution of module dependencies. When expanding the project, it is necessary to resolve the visibility of the module with other packages in the `module-info.java` file. The graphic interface was developed using `JavaFX` technology, using the `SceneBuilder (v21.0.0)` application.

### About (RS)
Projekat iz Baza podataka (2261), '23/24. ePopis je aplikacija koja pruza mogucnost simulacije popisivanja potrosnje elektricne energije, slicno kao sistemu Elektrokrajine. Glavni akteri u modelu su `Potrosac`, `Elektricar`, `Distributer`, `Snabdjevac`, `Knjigovodja` i `Administrator`. Nepersonalizovani objekti, takodje od velike bitnosti su `Predracun`, `Dokument`, `Opomena`, `Racun`, `Mjesto`. Aplikacija je razvijena koristenjem `MySQL (v8.0.36)` tehnologije, sa implementacijom poslovne logike u `Java (v22 JDK)` programskom jeziku. Okruzenje koristi `Maven` *build-system*, zbog lakseg razrjesavanja zavisnosti modula. Prilikom prosirivanja projekta neophodno je razrjesiti vidljivost modula drugim paketima u `module-info.java` fajlu. Graficki interfejs je razvijen koristenjem `JavaFX` tehnologije, upotrebom `SceneBuilder (v21.0.0)` aplikacije.

## Project Structure

The project is organized into different modules, each representing a different part of the application:

- `AdminGUI`: The GUI for administrators.
- `DistributerGUI`: The GUI for distributors.
- `ElektricarGUI`: The GUI for electricians.
- `KnjigovodjaGUI`: The GUI for bookkeepers.
- `PotrosacGUI`: The GUI for consumers.
- `LoginGUI`: The GUI for login functionality.

Each module is located in its own directory under `src/main/java/org/unibl/etf/epopis/gui/views`.

## Building the Project

If you are using *intelliJ IDEA*, you can simply clone the repository and use pre-configured build tasks.

Eventhough, the project uses Maven for dependency management. To build the project, run the following command in the terminal:

```sh
./mvnw clean install
```

This will compile the project, run any tests, and package the compiled code into a JAR file.

## Running the Project

After building the project, you can run it with the following command:

```sh
./mvnw javafx:run
```

This will start the application.

## Dependencies

The project uses several dependencies, including:

- Lombok: For reducing boilerplate code.
- Protobuf: For protocol buffers.
- Apache Commons Lang: Provides extra functionality for classes in java.lang.
- JUnit: For unit testing.

For a full list of dependencies, see the `pom.xml` file.