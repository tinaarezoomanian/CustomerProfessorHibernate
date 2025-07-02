CustomerProfessorHibernate

A simple Hibernate demo that creates and deletes a Customer and its one-to-one Professor.

Prerequisites

* Java 17 or newer
* Maven
* PostgreSQL running on localhost:5432
* PostgreSQL user postgres with password 123
* A database named university\_db

Database setup
psql -U postgres
CREATE DATABASE university\_db;
ALTER USER postgres WITH PASSWORD '123';
\q

Build and run

1. Clone the repo: git clone [https://github.com/tinaarezoomanian/CustomerProfessorHibernate.git](https://github.com/your-username/CustomerProfessorHibernate.git) cd CustomerProfessorHibernate
2. Compile:
   mvn clean compile
3. Create a Customer and Professor:
   mvn exec\:java -Dexec.mainClass="com.example.MainCreate"
4. Delete by Customer ID:
   mvn exec\:java -Dexec.mainClass="com.example.MainDelete"
   (enter the ID printed in step 3)
