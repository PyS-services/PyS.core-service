# PyS Core Service

[![PyS.core-service CI](https://github.com/PyS-services/PyS.core-service/actions/workflows/maven.yml/badge.svg?branch=main)](https://github.com/PyS-services/PyS.core-service/actions/workflows/maven.yml)

## Overview

PyS Core Service is a Spring Boot-based REST API service that serves as a core component of the PyS ecosystem. It provides essential functionality for the platform, including data persistence, PDF generation, and integration with other services.

## Features

- RESTful API endpoints with standardized naming conventions
- Spring Boot 3.5.3
- Spring Cloud 2025.0.0
- Java 21
- Kotlin 2.1.21
- MySQL 9.3.0 database integration
- PDF generation using OpenPDF 2.2.3
- OpenAPI 3.0 documentation (SpringDoc 2.8.9)
- Eureka client for service discovery
- Feign client for service-to-service communication
- Log4j2 logging
- QR code generation with ZXing 3.5.3

## Prerequisites

- Java 21
- Maven 3.8.8 or higher
- MySQL database
- Docker (optional, for containerized deployment)

## Getting Started

### Local Development

1. Clone the repository:
   ```bash
   git clone https://github.com/PyS-services/PyS.core-service.git
   ```

2. Navigate to the project directory:
   ```bash
   cd PyS.core-service
   ```

3. Build the project:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

### Docker Deployment

1. Build the Docker image:
   ```bash
   docker build -t pys-core-service .
   ```

2. Run the container:
   ```bash
   docker run -p 8080:8080 pys-core-service
   ```

## API Documentation

Once the application is running, you can access the API documentation at:
```
http://localhost:8080/swagger-ui.html
```

## Configuration

The application uses Spring Cloud Config for configuration management. Key configuration files are located in the `src/main/resources` directory.

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Support

For support, please open an issue in the GitHub repository or contact the development team.
