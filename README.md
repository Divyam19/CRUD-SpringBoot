# CRUD-WEB-API using SpringBoot
This is a simple CRUD (Create, Read, Update, Delete) application built using Spring Boot. It provides a RESTful API to perform CRUD operations on a database.

Getting Started
Prerequisites
Java Development Kit (JDK) 8 or higher
Apache Maven
MySQL or any other database of your choice
Installation
Clone the repository:

bash
Copy code
git clone https://github.com/your_username/your_crud_app.git
Navigate to the project directory:

bash
Copy code
cd your_crud_app
Build the project using Maven:

bash
Copy code
mvn clean install
Run the application:

bash
Copy code
java -jar target/your_crud_app.jar
The application will start running on http://localhost:8080.

Usage
You can interact with the application using any RESTful API client such as Postman. Below are the endpoints available:

Create: POST /api/resource - Create a new resource.
Read:
GET /api/resource/{id} - Get a resource by its ID.
GET /api/resource - Get all resources.
Update: PUT /api/resource/{id} - Update a resource by its ID.
Delete: DELETE /api/resource/{id} - Delete a resource by its ID.
Replace resource with the actual resource name in your application (e.g., user, product).

Example
Create a new resource:
Method: POST
URL: http://localhost:8080/api/user
Body:
json
Copy code
{
    "name": "John Doe",
    "email": "john@example.com"
}
Get all resources:
Method: GET
URL: http://localhost:8080/api/user
Get a resource by ID:
Method: GET
URL: http://localhost:8080/api/user/1
Update a resource:
Method: PUT
URL: http://localhost:8080/api/user/1
Body:
json
Copy code
{
    "name": "John Doe",
    "email": "john.doe@example.com"
}
Delete a resource:
Method: DELETE
URL: http://localhost:8080/api/user/1
