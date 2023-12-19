# Cocktail API Test Suite :cocktail: :tropical_drink:

This repository contains a set of API tests for the CocktailDB API using RestAssured and JUnit.

## Overview

This test suite focuses on validating the functionality of the CocktailDB API by performing various tests related to ingredient searches, empty searches, stress testing for high-load scenarios, performance testing, and searching cocktails by name.

## Prerequisites

- Java Development Kit (JDK) Version 21.0.1 installed
- Maven Version 3.9.6 installed 

## Getting Started

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/Rezzaernest/CocktailAPI.git
2. **Install Dependencies:**

   ```bash
   cd cocktail-api-tests
   mvn clean install

2. **Run Tests**
Execute tests using Maven:
   ```bash
   mvn test

## Project Structure
The project structure is as follows:

- src/test/java/packageName/: Contains the test classes.
- pom.xml: Maven configuration file with dependencies and build settings.
- README.md: Project information and instructions.

## Test Structure

**SearchIngredientsByNameTests**
- setup(): Configures the base URI for the CocktailDB API.
- testSearchIngredientsByName(): Tests the API endpoint for searching ingredients by name.
- testEmptySearch(): Tests the API behavior for an empty search.

**StressTests**
- setup(): Configures the base URI for the CocktailDB API.
- testSearchIngredientsStress(): Simulates high load by sending a large number of requests for ingredient searches and sets a threshold for response time.
- testSearchCocktailsStress(): Simulates high load by sending a large number of requests for cocktail searches and sets a threshold for response time.

**PerformanceTests**
- setup(): Configures the base URI for the CocktailDB API.
- testSearchIngredientsPerformance(): Measures the performance by sending a single request for ingredient search and checks the response time.
- testSearchCocktailsPerformance(): Measures the performance by sending a single request for cocktail search and checks the response time.

**SearchCocktailsByNameTests**
- setup(): Configures the base URI for the CocktailDB API.
- CocktailsByName(): Tests the API endpoint for searching cocktails by name.
- testAlphaNumericSearch(): Tests the API behavior for an alphanumeric search.

