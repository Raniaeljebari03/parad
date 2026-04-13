
# LLM-powered RESTful Web Service
Author: Rania El Jebari 

## Project Overview
This project implements an LLM-powered RESTful web service for translating text from English to Moroccan Arabic Dialect (Darija). The backend is developed in Java using Jakarta RESTful Web Services API. The project also includes multiple clients, including a React Native web client, a Chrome extension, a Python client, and a PHP client.

## Features
- Java RESTful API for translation
- Integration with Google Gemini API
- Basic Authentication for securing the endpoint
- React Native web client interface
- Chrome extension with side panel translation
- Python client
- PHP client
- UML diagrams for software architecture

## Technologies Used
- Java
- Jakarta RESTful Web Services API
- Maven
- Google Gemini API
- React Native with TypeScript
- Expo / React Native Web
- JavaScript
- Python
- PHP
- Chrome Extension Manifest V3
- PlantUML

## Project Structure
- `src/main/java/com/project2` → Java backend source code
- `chrome-extension` → Chrome extension client
- `python-client` → Python client
- `php-client` → PHP client
- `mobile-react-native` → React Native client (used on web through Expo)
- `pom.xml` → Maven configuration file

## How to Run the Backend
Make sure Java and Maven are installed before running the backend.
```bash
mvn clean compile exec:java
```

Backend runs at:
http://localhost:8080/api/

How to Run the Web Client:
cd mobile-react-native
```bash
npx expo start --clear
```

Open in browser:
http://localhost:8081

## Authentication
	•	Username: rania
	•	Password: project2

## Chrome Extension
The Chrome extension uses the REST API to translate selected text directly from the browser side panel.

## Python and PHP Clients
The project includes Python and PHP clients that communicate with the same REST API endpoint.

## UML Diagrams
The UML diagrams illustrate the system architecture, request flow, and deployment structure.

	•	Class Diagram
	•	Deployment Diagram
	•	Sequence Diagram
	•	Use Case Diagram

## Known Limitation
The Google Gemini API may return:
503 Service Unavailable
due to high demand.







