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

CocktailAPI
├── src
│   ├── main
│   │   └──java
│   │      └── org
|   |          └── cocktailAPI
│   │              └── Main.java
│   └── test
│       └── java
│           └── cocktailTest
│               ├── SearchIngredientsByNameTests.java
│               ├── StressTests.java
│               ├── PerformanceTests.java
│               └── SearchCocktailsByNameTests.java
├── .gitignore
├── README.md
└── pom.xml

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

## Test Cases 

| Test Case ID                    | Test Type            | Test Case            | Input      | Expected Output                                                                                                   |
|---------------------------------|----------------------|----------------------|------------|-------------------------------------------------------------------------------------------------------------------|
| Test1_SearchIngredientsByName   | Search Ingredients By Name | Positive Test Case | vodka      | Ingredient ID, Ingredient, Description, Type, Alcohol, ABV should be present and correct. If non-alcoholic, Alcohol and ABV should be null. If alcoholic, Alcohol should be 'yes,' and ABV should not be null. |
|                                 |                        | Negative Test Case   | ""         | The API should not return results                                                                                 |
| Test2_SearchCocktailsByName     | Search Cocktails By Name   | Positive Test Case | margarita  | Ensure case-insensitivity of the search. Validate the presence and correctness of properties in the response based on the provided schema. |
|                                 |                        | Negative Test Case   | AbC12345   | The API should return drinks as null, as the cocktail does not exist in the cocktail DB.                         |
| Test3_Performance               | Non-Functional Tests | Performance Testing  |            | Evaluate the system's response time under high load. Simulate concurrent requests to the API and measure the response time. |
| Test4_Stress                    | Non-Functional Tests | Stress Testing       |            | Ensure that the system performance remains stable under extensive stress test and API response times remains under threshold |

