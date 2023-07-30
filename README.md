## About The Project


This is API server for the frontend application (https://github.com/RyRyRyRy321/Inventory-management-app), it is responsible for communicating with the database and adheres to standard HTTP methods (GET, POST, PUT, DELETE) for managing data entities.

### Built With

The frontend application is built using the following frameworks:

* Spring
* Hibernate ORM

### Features

* Read Product - Enables users to retrieve data from the server using GET requests. users can request specific resources or collections of resources.

* Add Product - Allows users to create new products by sending POST requests with the necessary data.

* Update Product - Supports updating existing product using PUT or PATCH requests, allowing users to modify specific properties or the entire product.

* Delete Product - Allows users to delete products using DELETE requests, removing them permanently from the database.

* Server-side Form Validation - Ensures incoming product data is thoroughly examined and validated on the server before processing.


!!! warning "Caution"

The application will not launch if the values of database is not supplied the following environment variables are ${JAVA_DATABASE_URL}, ${JAVA_DATABASE_USERNAME}, and ${JAVA_DATABASE_PASSWORD} (Assuming the user uses a password).

## Installation

1. Clone the repository:

```

git clone <repository-url>

```


2. Navigate to the project directory:

```

cd <project-directory>

```


3. Install the dependencies:

```
./mvnw install

```


4. Start the application:

```
./mvnw spring-boot:run

```


5. Open your web browser and visit http://localhost:5000/client/product it should return a JSON file.