# Blog API

This is a simple RESTful API for a blog application built with Spring Boot.

## Requirements

- Java 8
- Maven or Gradle

## Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/chndranndr/blog-api.git
   cd blog-api

Build the project:


# If using Maven
    mvn clean install

Run the application:


    # If using Maven
    mvn spring-boot:run

    The API will be accessible at http://localhost:8080/api/posts.

API Endpoints
Create a Blog Post

    URL: POST /api/posts
    Payload: JSON

    json

    {
      "title": "Sample Blog Post",
      "body": "This is the content of the blog post.",
      "author": "John Doe"
    }

Retrieve a Blog Post

    URL: GET /api/posts/{id}
    Parameters:
        {id}: ID of the blog post

Retrieve All Blog Posts

    URL: GET /api/posts
    Parameters:
        page (optional): Page number (0-indexed)
        size (optional): Page size
        sort (optional): Sort order and field(s) to sort by

Update a Blog Post

    URL: PUT /api/posts/{id}
    Parameters:
        {id}: ID of the blog post
    Payload: JSON

    json

    {
      "title": "Updated Blog Post",
      "body": "This is the updated content of the blog post.",
      "author": "Jane Doe"
    }

Delete a Blog Post

    URL: DELETE /api/posts/{id}
    Parameters:
        {id}: ID of the blog post


Technologies Used

    Java 8
    Spring Boot
    Spring Data JPA
    H2 Database
    Maven/Gradle
    Docker
