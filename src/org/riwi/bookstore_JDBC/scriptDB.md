# Commands to create our database.
CREATE DATABASE bookstore;

USE bookstore;

CREATE TABLE author (       
    id VARCHAR(100) PRIMARY KEY,    
    name VARCHAR(100),  
    nationality VARCHAR(100)    
);

CREATE TABLE book (  
    id VARCHAR(100) PRIMARY KEY,    
    title VARCHAR(100),     
    yearOfPublished INT,        
    price DECIMAL(10, 2),       
    authorId VARCHAR(100),      
    FOREIGN KEY (authorId) REFERENCES author(id) ON DELETE CASCADE ON UPDATE CASCADE
);