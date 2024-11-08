# Transaction Application

This repository contains two Dockerized projects:

- **Transaction**: A Java Spring Boot backend application.
- **TransactionFrontend**: A Blazor WebAssembly frontend application using Radzen components.

Both applications are containerized and orchestrated using Docker Compose for seamless deployment and development.

## Development Environment

### Java Version
- **JDK**: 17

### C# Version
- **.NET**: 8.0 SDK

### Build Tools
- **Gradle**: Version 7.6 (for Java Spring Boot backend)
- **Docker**: Docker Engine for containerization
- **Docker Compose**: Version 3.8 for multi-container orchestration

### Frameworks
- **Frontend**: Blazor WebAssembly
- **Backend**: Spring Boot

### Development Tools
- **IDE**: Visual Studio, IntelliJ IDEA
- **Version Control**: Git
- **Container Registry**: Docker Hub
- **Logging**: SLF4J for backend logging
- **Frontend Libraries**: Radzen


## Table of Contents
- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
  - [Cloning the Repository](#cloning-the-repository)
  - [Building the Docker Images](#building-the-docker-images)
  - [Running the Application](#running-the-application)
  - [Accessing the Application](#accessing-the-application)
  - [Stopping the Application](#stopping-the-application)

## Prerequisites
Before you begin, ensure you have the following installed on your system:

- Git
- Docker
- Docker Compose

## Project Structure
```
├── docker-compose.yml         # Docker Compose configuration
├── Transaction                # Backend Java Spring Boot application
│   ├── application.yaml
│   ├── build.gradle
│   ├── Dockerfile
│   └── src/
├── TransactionFrontend        # Frontend Blazor WebAssembly application
│   ├── Dockerfile
│   ├── TransactionFrontend
│   │   ├── App.razor
│   │   ├── Models/
│   │   ├── Pages/
│   │   ├── Program.cs
│   │   ├── Services/
│   │   ├── TransactionFrontend.csproj
│   │   └── wwwroot/
└── README.md                  # Project documentation
```

## Getting Started

### Cloning the Repository
Clone the repository to your local machine using Git:

```bash
git clone https://github.com/jiachengqi/transactionApp.git
cd transactionApp
```

### Building the Docker Images
Build the Docker images for both the backend and frontend applications:

```bash
docker-compose build
```

### Running the Application
Start the applications using Docker Compose:

```bash
docker-compose up
```

### Accessing the Application
Once the containers are running, you can access the applications via your web browser:

- **Frontend**: [http://localhost:5100](http://localhost:5100)
- **Backend API**: [http://localhost:8080](http://localhost:8080)
- **Swagger for Backend**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

#### Testing the Backend API
You can test the backend API endpoints using tools like Postman or `curl`. For example:

```bash
curl http://localhost:8080/api/transactions
```

### Stopping the Application
To stop the running containers, press `Ctrl+C` in the terminal where `docker-compose up` is running, or execute:

```bash
docker-compose down
```

