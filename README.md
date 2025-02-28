CRM Lite - Customer Relationship Management API


📌 Project Description

CRM Lite is a Spring Boot-based RESTful API designed to simplify and optimize customer relationship management (CRM) processes. The project is developed to efficiently handle core CRM operations such as customer, order, and communication management.


🚀 Technologies

Java 17

Spring Boot 3.x

Spring Data JPA (Hibernate)

Spring Web (REST API)

Spring Validation

Lombok

PostgreSQL/MySQL (database support)

Maven (dependency management)


📂 Project Structure

![image](https://github.com/user-attachments/assets/1be3a64c-70ed-4fc2-853b-0c2922f2d544)


📢 Features

✅ Customer Management: Add, update, and delete customers.
✅ Communication Management: Manage customer contact information.
✅ Service Management: APIs for managing user roles, orders, and customer groups.
✅ DTO Implementation: Manage data flow with Data Transfer Objects.
✅ Layered Architecture: Separation of Controller, Service, and Repository for a flexible and scalable structure.
✅ Validation & Exception Handling: Robust structure against user errors.


⚡ Installation & Running

1️⃣ Clone the Project

git clone https://github.com/username/crm-lite.git
cd crm-lite

2️⃣ Install Dependencies

mvn clean install

3️⃣ Configure Database (application.properties)

spring.datasource.url=jdbc:postgresql://localhost:5432/crm-lite
spring.datasource.username=your_username
spring.datasource.password=your_password

4️⃣ Run the Application

mvn spring-boot:run


👥 Contributing

If you want to contribute to the project, feel free to submit a pull request or open an issue.


📜 License

Distributed under the MIT License. See the LICENSE file for more details.
 
