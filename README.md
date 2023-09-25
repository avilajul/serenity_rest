# Serenity Rest
For the Spanish version, click [here](README-es.md).

Test automation with the Serenity framework implementing the Screenplay pattern in Java,
Gradle, Cucumber and Junit to test RESTful API.

Public RESTful API used for automation
[https://reqres.in/api/](https://reqres.in/api/)

### Tests built 📋
- Search for an existing user
- Create a user successfully
- Update partial data of a user.
- Update complete information of a user

## Prerequisites 🛠️ ##
- Java JDK 11
- Gradle 8.1.1 or higher
- GIT

## Project structure 🗼

    .
    ├──📂 src
    │  └──🗃️ main
    │  │    └──📂️ java                              # SourceFiles
    │  │            └──📦 com.co.empresa.certificacion.api
    │  │                ├──📦 exceptions            # Custom exceptions
    │  │                ├──📦 models                # Package where the models are located - Object
    │  │                │    
    │  │                │
    │  │                ├──📦 questions             # Package where classes are stored to get service data, service response, etc.
    │  │                │   
    │  │                │
    │  │                ├──📦 tasks                 # Package where the tasks that consume the service are stored.       
    │  │                │   
    │  │                │
    │  │                └──📦 utils                 # Developed utilities
    │  │                    └──📦 constants         # Constants used in the project
    │  │     
    │  │      
    │  ├──🗃️ test                                   # Files for testing execution
    │  │   ├──📂️ java
    │  │   │   ├──📦 com.co.empresa.certificacion.api
    │  │   │   ├──📦 runners                        # Test execution classes
    │  │   │   │   
    │  │   │   │
    │  │   │   └──📦 stepdefinitions                # Classes with the Java method with an expression that links it to one or more Gherkin steps
    │  │   │       └──📦 settings
    │  │   │
    │  │   └──🗂️ resources
    │  │       ├──📂️ features                       # Package where the Gherkin language scenarios are stored
    │  │       │   
    │  │       │
    │  │       └──📂️ files                          # Paquete donde se almacena el archivo xml con la solicitud de servicio
    │  │           
    │  └── ···
    │
    └── ···

## Installation ⚙️

- Clone this repository using `git clone https://github.com/avilajul/serenity_rest.git`
- Open or import the project from your preferred IDE
- Go to the `build.gradle` file to download and build the project dependencies
- Another option is to execute the following command to run through the console
```
gradle -x clean build test
gradleJava compilation
```
## Execution 🚀

Address some of the brokers like `CheckSingleUser`, `CreateUser`, `DeleteAnUser`,
`UpdateUserData`, `UpdateUserInfo` to run the test

**NOTE:** The generated test report is located in the path `/target/site/serenity/index.html`

## Contribution 🤝
If you would like to make a contribution, follow these steps:

1. Clone or Fork the project
2. Create the feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit the changes (`git commit -m 'comments of changes added'`)
4. Push to the working branch (`git push origin feature/AmazingFeature`)
5. Open a pull request