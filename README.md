# Travel to Georgia

Welcome to the Travel to Georgia project! This web application serves as a comprehensive guide to various sightseeing locations in Georgia, organized by season and region. It allows users to explore, search, and filter locations based on their preferences.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Application Structure](#application-structure)
- [Testing](#testing)
- [Contributing](#contributing)

## Features

- Browse a wide range of sightseeing locations in Georgia.
- Filter locations by season (Summer, Winter) or region (Imereti, Guria, Mtskheta-Mtianeti).
- Search for locations by name or description.
- View detailed information about each location, including similar locations by season and region.

## Technologies Used

- **Spring Boot**: Framework for building the web application.
- **Thymeleaf**: Templating engine for rendering HTML views.
- **H2 Database**: In-memory database for storing location data.
- **JUnit & Mockito**: Libraries for unit testing the application.

## Getting Started

To run this application locally, follow these steps:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/travel-to-georgia.git
   ```
2. **Navigate to the project directory**:
   ```bash
   cd travel-to-georgia
   ```
3. **Build the project** (if using Maven):
   ```bash
   mvn clean install
   ```
4. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```
5. **Access the application**: Open your web browser and go to [URL](https://safe-honeybee-indirectly.ngrok-free.app/locations) (accessible only when localhost is running)

## Usage

- **Browse Locations**: Visit `/locations` to see all available locations.
- **View Location Details**: Click on a location name to view detailed information and similar locations.
- **Search**: Use the search bar to find locations by name or description. Access it via `/locations/by_search_param?param={searchTerm}`.
- **Filter by Season**: Use the endpoint `/locations/by_season/{season}` to filter locations by season.
- **Filter by Region**: Use the endpoint `/locations/by_region/{region}` to filter locations by region.

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