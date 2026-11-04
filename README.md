# Serenity BDD with Cucumber and Java Framework

Serenity BDD (formerly known as Thucydides) is an open-source test automation framework that helps you write well-structured, maintainable acceptance criteria and automated tests. When combined with Cucumber (a BDD tool) and Java, it provides a powerful solution for behavior-driven development.

## Key Features

- **BDD Support**: Integrates with Cucumber to write tests in Gherkin syntax
- **Rich Reporting**: Generates detailed, narrative reports with screenshots
- **Web Testing**: Built-in support for Selenium WebDriver
- **Rest API Testing**: Includes support for REST-assured
- **Parallel Execution**: Supports running tests in parallel
- **Step Libraries**: Provides reusable step definitions for common actions

## Table of Contents
- [Project Overview](#project-overview)
- [Technology Stack](#technology-stack)
- [Setup Instructions](#setup-instructions)
- [Running Tests](#running-tests)
- [Reporting](#reporting)

## Project Overview
Automation framework for testing [Swag Labs](https://www.saucedemo.com/) demo e-commerce site using:
- Behavior-Driven Development (BDD) approach
- Page Object Model pattern
- Serenity's enhanced reporting capabilities

## Technology Stack
| Component       | Version |
|----------------|---------|
| Serenity BDD   | 4.2.22  |
| Cucumber       | 7.17.0  |
| JUnit          | 4.13.2  |
| Java           | 23      |
| Maven          | 3.9+    |

## Setup Instructions

### Prerequisites
1. Install JDK 23
2. Install Maven 3.9+
3. Install Git

### Installation
```bash
git clone <repository-url>
cd SwageDemo
mvn clean install
```

Running Tests
Run all tests

mvn clean verify

Run with specific browser
mvn clean verify -Dwebdriver.driver=firefox

Run specific feature
mvn clean verify -Dcucumber.filter.tags="@login"

Reporting
Serenity generates rich interactive reports located at:
target/site/serenity/index.html

Sample report includes:

-Test results dashboard
-Step-by-step screenshots
-Timing metrics
-Requirement coverage


## Suite validada

La ejecucion incluye 9 casos: acceso valido e invalido, usuario o clave vacios,
usuario bloqueado, agregar productos, carrito vacio, eliminar un producto y compra completa.
Se verifican nombres, cantidades, subtotal y confirmacion de compra.
El caso de carrito vacio valida su contenido; no afirma que el sitio bloquee el checkout.

```powershell
mvn clean verify -Dheadless.mode=true
mvn clean verify -Dheadless.mode=true "-Dcucumber.filter.tags=@Login"
mvn clean verify -Dheadless.mode=true "-Dcucumber.filter.tags=@Products"
```

Se utiliza Firefox por defecto y Selenium Manager descarga el navegador/driver si es necesario.
Se necesita acceso a Internet y JDK 23. El reporte queda en `target/site/serenity/index.html`.
En este equipo Maven tambien esta disponible en:
`C:\Program Files\NetBeans-15\netbeans\java\maven\bin\mvn.cmd`.
