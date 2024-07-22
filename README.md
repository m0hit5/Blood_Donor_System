# Blood Donor Management System

A comprehensive Blood Donor Management System built using Java, JSP, MySQL, HTML, and CSS. This application allows administrators to manage blood donor records, ensuring that all required health and contact information is validated before being added to the database.

## Features

- **CRUD Operations**: Create, Read, Update, and Delete blood donor records.
- **Validation**: Ensures data integrity through SQL triggers and form validation.
- **Responsive Design**: Basic CSS styling for a clean interface.

## Project Structure

- `.settings/`: Eclipse project settings
- `bin/`: Compiled class files
- `jdbc-mysqljava.jar`: MySQL JDBC driver
- `src/`: Source Java files
- `.classpath`: Eclipse classpath configuration
- `.project`: Eclipse project configuration
- `blood_donors.sql`: SQL script for database schema and triggers

## Technologies Used

- **Backend**: Java, JSP
- **Frontend**: HTML, CSS
- **Database**: MySQL
- **Server**: Apache Tomcat

## Database Schema

The `blood_donors.sql` file contains the schema for the donors table along with various SQL triggers to ensure data integrity.

## Setup Instructions

### Prerequisites

- JDK (Java Development Kit)
- Apache Tomcat
- MySQL
- Eclipse IDE (or any other Java IDE)
- Launch4j (for creating Windows executables)

### Steps to Install and Run

1. **Clone the Repository**:
    ```sh
    git clone <repository-url>
    ```

2. **Import the Project into Eclipse**:
    - Open Eclipse.
    - Select `File > Import > Existing Projects into Workspace`.
    - Browse to the project directory and import it.

3. **Configure MySQL Database**:
    - Create a new database and import the `blood_donors.sql` file.
    ```sh
    mysql -u root -p
    CREATE DATABASE blood_donors;
    USE blood_donors;
    SOURCE path/to/blood_donors.sql;
    ```

4. **Compile Java Files**:
    ```sh
    javac -cp "C:\Users\User1\Desktop\bds\jdbc\mysqljava.jar;." *.java
    ```

5. **Run the Application**:
    ```sh
    java -cp "C:\Users\User1\Desktop\bds\jdbc\mysqljava.jar;." WelcomeFrame
    ```

6. **Package with Launch4j**:
    - Use Launch4j to create a Windows executable from your Java application. Configure the path to the JAR file and set up the necessary options in Launch4j.

7. **Deploy the Application**:
    - Deploy the application on Apache Tomcat by copying your WAR file to the Tomcat `webapps` directory or by using the Tomcat Manager.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request.

## License

This project is licensed under the MIT License.
