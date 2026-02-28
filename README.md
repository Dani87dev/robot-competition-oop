# 🤖 Robot Competition – Domain Modeling with Value Objects

## 📌 Overview

Java project that models an autonomous robot competition system using Object-Oriented Programming and a simple layered architecture.

The system manages different robot types (ground, aerial, aquatic) and evaluates resistance competition eligibility based on explicit business rules.

This project was intentionally built to move beyond basic OOP exercises and start practicing **real domain modeling decisions**.

---

## 🎯 What I Wanted to Practice

This repository focuses on improving:

- Designing a clean and expressive domain model  
- Separating responsibilities into clear layers  
- Encapsulating business rules inside the domain  
- Introducing simple but meaningful Value Objects  
- Enforcing domain validation at construction time  
- Writing unit tests that verify business logic  

The goal was not complexity, but correctness and clarity.

---

## 🏗️ Architecture

The project follows a layered structure:

```
src/main/java
├── app
│   └── Application
├── domain
│   ├── Robot
│   ├── GroundRobot
│   ├── AerialRobot
│   ├── AquaticRobot
│   ├── ResistanceEvaluable
│   ├── exception
│   │   └── InvalidRobotSpecificationException
│   └── value
│       └── FlightAutonomy
├── service
│   └── RobotService
└── report
    └── ResistanceReportPrinter
```

Each layer has a clear responsibility:

- **domain** → Core business model and rules  
- **value** → Domain Value Objects  
- **exception** → Domain-specific exceptions  
- **service** → Business logic and filtering operations  
- **report** → Output formatting  
- **app** → Entry point  

This structure represents a first step toward more structured backend architecture patterns.

---

## 🧠 Key Design Decisions

### Value Object: `FlightAutonomy`

Instead of using a raw `int`, flight autonomy is modeled as a Value Object.

This allows:

- Centralized validation  
- Encapsulation of the eligibility rule (≥ 60 minutes)  
- Prevention of invalid states  
- More expressive domain language  

Business rules live inside the domain, not in the application layer.

---

## 🔒 Domain Validation

Robots cannot be created in an invalid state.

Examples of enforced rules:

- Manufacturing year must be valid  
- Max speed must be greater than zero  
- Max altitude must be greater than zero  
- Flight autonomy must be positive  

Invalid data triggers a domain-specific exception.

This guarantees consistency from the moment an object is created.

---

## 🧪 Testing

The project includes unit tests covering:

- Value Object validation and eligibility logic  
- Resistance competition rules  
- Service layer filtering logic  

Testing ensures that business rules behave correctly and remain stable during refactoring.

---

## 📈 Evolution

This project represents a deliberate step forward from simple class-based exercises toward:

- Stronger domain modeling  
- Better responsibility separation  
- Cleaner validation strategies  
- More intentional architectural thinking  

It is intentionally simple in scope, but structured with scalability and maintainability in mind.
