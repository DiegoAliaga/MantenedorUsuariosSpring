# MantenedorUsuariosSpring
Evaluacion JAVA

Mantenedor de usuarios que tiene como objetivo exponer una API que permita gestionar usuarios

Tecnologias Utilizdas 🚀

    Spring Boot
    Java 17
    JPA
    Lombok
    Gradle
    Base de datos en memoria H2
    Swagger
    Groovy
    Mockito

Pre-requisitos 📋

Para ejecutar el proyecto, se requiere ir al repositorio y descargarlo en ZIP o clonarlo a un repositorio local como se muestra en el ejemplo a continuación:

git clone https://github.com/DiegoAliaga/MantenedorUsuariosSpring.git

Instalación 🔧

Dentro del proyecto se subio la coleccion de Postman, a fin de poder realizar pruebas del proyecto.

La base de datos utilizada es en memoria H2 la cual al dejar de correr el proyecto, los usuarios se borran. Se recomienda un MySql o Postgres para guardar datos y persistirlos

Para ingresar a la bd iniciar el proyecto, ingresar al enlace http://localhost:9095/h2-console y reemplazar contenido de JDBC URL: por jdbc:h2:mem:test

