CustomerProfessorHibernate

A simple Hibernate demo with two parts:

1) customerprofessor: create/delete Customer ↔ Professor (1–1 cascade)
2) orderproduct: create/delete Order ↔ Product (M–N via order_detail)

Prerequisites
- Java 17+
- Maven
- PostgreSQL on localhost:5432
- DB user postgres/123, DB university_db
  (edit hibernate.cfg.xml if different)

DB setup (psql -U postgres):
CREATE DATABASE university_db;
ALTER USER postgres WITH PASSWORD '123';
\q

Build & run (from project root):
mvn clean compile

# Part A – Customer/Professor
mvn exec:java -Dexec.mainClass="com.example.customerprofessor.MainCreateCustomer"
mvn exec:java -Dexec.mainClass="com.example.customerprofessor.MainDeleteCustomer"

# Part B – Order/Product
mvn exec:java -Dexec.mainClass="com.example.orderproduct.MainCreateProduct"
mvn exec:java -Dexec.mainClass="com.example.orderproduct.MainCreateOrder"
mvn exec:java -Dexec.mainClass="com.example.orderproduct.MainDeleteOrder"
mvn exec:java -Dexec.mainClass="com.example.orderproduct.MainDeleteProduct"
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
