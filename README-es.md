# SOAP API Testing
For the English version, click [here](README.md).

Automatización de pruebas con el framework Serenity implementando el patrón Screenplay en Java,
Gradle, Cucumber y Junit para probar API RESTful.

API RESTful pública utilizada para la automatización 
[https://reqres.in/api/](https://reqres.in/api/)

### Pruebas construidas 📋
 - Buscar un usuario existente
 - Crear un usuario exitosamente
 - Actualizar los datos parciales de un usuario
 - Actualizar información completa de un usuario

## Prerequisitos 🛠️ ##
- Java JDK 11
- Gradle 8.1.1 o superior
- GIT

## Estructura del proyecto 🗼

    .
    ├──📂 src
    │  └──🗃️ main
    │  │    └──📂️ java                              # Archivos fuente
    │  │            └──📦 com.co.empresa.certificacion.api
    │  │                ├──📦 exceptions            # Excepciones personalizadas
    │  │                ├──📦 models                # Paquete donde se ubican los modelos - Objeto
    │  │                │    
    │  │                │
    │  │                ├──📦 questions             # Paquete donde se almacenan las clases para obtener datos del servicio, respuesta del servicio, etc.
    │  │                │   
    │  │                │
    │  │                ├──📦 tasks                 # Paquete donde se almacenan las tareas que realizan el consumo del servicio, etc.       
    │  │                │   
    │  │                │
    │  │                └──📦 utils                 # Utilidades desarrolladas
    │  │                    └──📦 constants         # Constantes que se utilizan en el proyecto
    │  │     
    │  │      
    │  ├──🗃️ test                                   # Archivos para la ejecución de las pruebas
    │  │   ├──📂️ java
    │  │   │   ├──📦 com.co.empresa.certificacion.api
    │  │   │   ├──📦 runners                        # Clases de ejecución de pruebas
    │  │   │   │   
    │  │   │   │
    │  │   │   └──📦 stepdefinitions                # Clases con el método Java con una expresión que lo vincula a uno o más pasos de Gherkin
    │  │   │       └──📦 settings
    │  │   │
    │  │   └──🗂️ resources
    │  │       ├──📂️ features                       # Paquete donde se almacenan los escenarios en lenguaje Gherkin
    │  │       │   
    │  │       │
    │  │       └──📂️ files                          # Paquete donde se almacena el archivo xml con la solicitud de servicio
    │  │           
    │  └── ···
    │
    └── ···

## Instalación ⚙️

- Clona este repositorio usando `git clone https://github.com/avilajul/serenity_rest.git`
- Abra o importa el proyecto desde su IDE de preferencia
- Dirijase al archivo `build.gradle` para descargar y construir las dependencias del proyecto
- Otra opción es ejecutar el siguiente comando para correr por consola
```
gradle clean build -x test
gradle compileJava
```
## Ejecución 🚀

Dirijase a algunos de los runners como `CheckSingleUser`, `CreateUser`, `DeleteAnUser`,
`UpdateUserData`, `UpdateUserInfo` para correr la prueba

**NOTA:** El reporte generado de la prueba se encuentra en la ruta `/target/site/serenity/index.html`

## Contribución 🤝
Si desea hacer una contribución, siga los siguientes pasos:

1. Clona o crea un Fork del proyecto
2. Crea el Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit a los cambios (`git commit -m 'comentarios de los cambios adicionados'`)
4. Push a la rama de trabajo (`git push origin feature/AmazingFeature`)
5. Abra un Pull Request