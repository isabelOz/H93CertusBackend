FROM openjdk:11.0-oracle
Copy "./target/BackendH93P1-0.0.1-SNAPSHOT.jar" "BackendH93P1-0.0.1-SNAPSHOT.jar"

Expose 8080
EntryPoint ["java","-jar", "BackendH93P1-0.0.1-SNAPSHOT.jar"]