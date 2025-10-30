# Grading System (Hibernate + Maven)

A simple console-based Java application to manage students using Hibernate ORM and MySQL. It demonstrates basic CRUD operations on a `Student` entity.

## Requirements
- Java 17+ (tested with Hibernate 7.x which targets modern Java)
- Maven 3.8+
- MySQL 8+

## Project Structure
```
D:\Grading_System
├─ src
│  ├─ main
│  │  ├─ java
│  │  │  └─ com.bootspring
│  │  │     ├─ App.java
│  │  │     ├─ MenuHandler.java
│  │  │     ├─ entity\Student.java
│  │  │     └─ hibernateUtil\HibernateUtil.java
│  │  └─ resources
│  │     └─ hibernate.cfg.xml
└─ pom.xml
```

## Database Configuration
This project uses MySQL. Update connection settings in `src/main/resources/hibernate.cfg.xml`:
- URL: `jdbc:mysql://localhost:3306/gradeSystem`

Notes:
- Create the database first: `CREATE DATABASE gradeSystem;`
- `hibernate.hbm2ddl.auto` is set to `update`, so Hibernate will create/update tables automatically.
- Mapping included: `com.bootspring.entity.Student`.

## Build
```bash
mvn clean package -DskipTests
```

## Run
There are two common ways to run the app:

1) From an IDE
- Open the project as a Maven project
- Run the `main` method in `com.bootspring.App`

2) Using Maven Exec Plugin
If you prefer running from the terminal, add the `exec-maven-plugin` to your `pom.xml` (inside `<build><plugins>`):
```xml
<plugin>
  <groupId>org.codehaus.mojo</groupId>
  <artifactId>exec-maven-plugin</artifactId>
  <version>3.5.0</version>
  <configuration>
    <mainClass>com.bootspring.App</mainClass>
  </configuration>
</plugin>
```
Then run:
```bash
mvn -DskipTests exec:java
```

## Usage
On start, the program prints "Hello World!", initializes Hibernate, and prompts:
```
How many students you want to enter:
```
Enter a number, then for each student you will be asked:
- Enter first name
- Enter last name
- Enter department

Each entry is persisted via Hibernate.

## Dependencies (from pom.xml)
- Hibernate Core: 7.1.5.Final (`org.hibernate.orm:hibernate-core`)
- MySQL Connector/J: 9.4.0 (`com.mysql:mysql-connector-j`)
- JUnit 3.8.1 for tests

## Troubleshooting
- Ensure MySQL is running and the `gradeSystem` database exists.
- If authentication fails, update credentials in `hibernate.cfg.xml`.
- If you see driver errors, verify dependency `mysql-connector-j` is downloaded and `com.mysql.cj.jdbc.Driver` is correct.
- If using Java below 17, upgrade Java to 17+ to match Hibernate/Jakarta dependencies.

## License
This project is for educational purposes. Use freely.
