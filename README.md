# Travel to Georgia

Welcome to the Travel to Georgia project! This web application serves as a comprehensive guide to various sightseeing locations in Georgia, organized by season and region. It allows users to explore, search, and filter locations based on their preferences. The application also features an admin interface for managing users.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Application Structure](#application-structure)
- [Authentication & Roles](#authentication--roles)
- [Testing](#testing)
- [Contributing](#contributing)

## Features

- Browse a wide range of sightseeing locations in Georgia.
- Filter locations by season (Summer, Winter) or region (Imereti, Guria, Mtskheta-Mtianeti).
- Search for locations by name or description.
- View detailed information about each location, including similar locations by season and region.
- **User Authentication**: Secure login and registration.
- **Role-Based Access**:
  - Users can view their profile.
  - Admins can access a dashboard listing all registered users.
- **Access the application**: Open your web browser and go to [URL](https://safe-honeybee-indirectly.ngrok-free.app/locations) (accessible only when localhost is running) 

## Technologies Used

- **Spring Boot**: Framework for building the web application.
- **Thymeleaf**: Templating engine for rendering HTML views.
- **PostgreSQL**: Database used to persist location and user data.
- **Spring Security**: Used for user authentication and role-based authorization.
- **Docker**: To simplify running the application with PostgreSQL.
- **JUnit & Mockito**: Libraries for unit testing the application.

## Getting Started

To run this application locally, follow these steps:

### Prerequisites

- **Docker**: Ensure Docker is installed on your system.
- **Java 17** or above.
- **Maven**: To build the project.

### Steps

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/travel-to-georgia.git
   ```
2. **Navigate to the project directory**:
   ```bash
   cd travel-to-georgia
   ```
3. **Run PostgreSQL with Docker**:
   If you're using Docker for PostgreSQL, you can run the following command to set up the database:
   ```bash
   docker run --name pg-docker -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=yourpassword -e POSTGRES_DB=georgia_db -p 5432:5432 -d postgres
   ```

4. **Set Up Database Schema**:
   Run the following commands to copy the schema and data SQL files into the Docker container and execute them:
   ```bash
   docker cp ./schema.sql pg-docker:/tmp/schema.sql
   docker exec -u postgres pg-docker psql -d georgia_db -f /tmp/schema.sql
   ```

   ```bash
   docker cp ./data.sql pg-docker:/tmp/data.sql
   docker exec -u postgres pg-docker psql -d georgia_db -f /tmp/data.sql
   ```

5. **Configure Database**:
   Update the `application.properties` or `application.yml` with your PostgreSQL settings:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/georgia_db
   spring.datasource.username=postgres
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
   ```

6. **Build the project**:
   ```bash
   mvn clean install
   ```

7. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

8. **Access the application**:
   Open your web browser and go to [http://localhost:8080/locations](http://localhost:8080/locations).

## Usage

- **Browse Locations**: Visit `/locations` to see all available locations.
- **View Location Details**: Click on a location name to view detailed information and similar locations.
- **Search**: Use the search bar to find locations by name or description. Access it via `/locations/by_search_param?param={searchTerm}`.
- **Filter by Season**: Use the endpoint `/locations/by_season/{season}` to filter locations by season.
- **Filter by Region**: Use the endpoint `/locations/by_region/{region}` to filter locations by region.
- **User Profile**: Visit `/profile` to view your user profile.
- **Admin Dashboard**: Admins can visit `/admin` to view a list of all users.

## Application Structure

The project consists of the following key components:

- **Domain Models**: Contains the business logic and data structures, including `Location`, `Region`, and `Season` enums.
- **Data Layer**: Includes the `LocationsRepository` for database interactions and the `LocationEntity` class for representing locations in the database.
- **Service Layer**: Implements the `LocationsService` class to handle business logic and data retrieval.
- **Controller Layer**: The `LocationsController` manages HTTP requests and responses, returning the appropriate views and data to the user.

### Important Classes

- `LocationsService`: Contains methods for retrieving and filtering locations based on various criteria.
- `LocationsController`: Handles incoming requests and renders the corresponding views.

## Testing

Unit tests are included for the service layer to ensure the correctness of the business logic. The `LocationsServiceTest` class covers the following scenarios:

- Retrieving all locations.
- Getting a location by its ID.
- Searching for locations by name.
- Filtering locations by region.

### Running Tests

To run the tests, execute the following command:
```bash
mvn test
```

## Contributing

Contributions are welcome! If you have suggestions for improvements or features, please feel free to submit a pull request or open an issue.