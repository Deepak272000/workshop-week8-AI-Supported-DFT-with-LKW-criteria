# Workshop: LKW Structural Testing of AI-Generated Code

## Overview
This project demonstrates the application of Laski-Korel-Weyuker (LKW) structural testing criteria to AI-generated code for an Autonomous Driving System. The focus is on verifying data flow integrity and adequacy using All-Definitions, All-Uses, and All-DU-Paths strategies.

## Structure
- `src/main/java/AdaptiveCruiseController.java`: Main safety-critical module.
- `src/main/java/SensorParser.java`: Utility component for sensor data parsing.
- `src/test/java/ADSTestSuite.java`: JUnit 5 test suite covering integration and component-level tests.
- `pom.xml`: Maven configuration with JUnit 5 dependencies.

## Workshop Phases
1. **Agentic Generation:** AI-generated AdaptiveCruiseController with safety logic.
2. **All-Definitions & All-Uses:** Definition-use mapping and coverage analysis.
3. **Antidecomposition:** Isolated boundary tests for SensorParser.
4. **All-DU-Paths:** Expanded test suite to cover all unique data flow paths and combinatorial logic interactions.

## How to Run
1. Ensure you have Maven installed.
2. In the project root, run:
   ```
   mvn test
   ```
3. All tests should pass, demonstrating full coverage of logic and data flow paths.

## Submission Bundle
- AI prompts used for code and test generation
- Source code and test files
- Test matrix and definition-use mapping
- Screenshots of test results
- Explanations and adequacy assessment

## Summary
This project ensures that all critical data flow paths are exercised, logic leaks are exposed, and both integration and component-level adequacy are achieved, meeting the highest standards for safety-critical software verification.
