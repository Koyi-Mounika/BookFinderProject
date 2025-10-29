# 📚 BookFinder Project

BookFinder is a simple Spring Boot application that allows users to search for books by title using the **Open Library API**.  
It fetches book details such as the title, author, publication year, and cover image.

---

## 🚀 Features

- Search books by title
- Fetch book details from the Open Library API
- Display author name, publish year, and cover image
- No database required — uses live API data

---

## 🛠️ Technologies Used

- Java 17
- Spring Boot
- Maven
- RestTemplate (for API calls)
- JSON (org.json library)

---

## 📦 API Used

**Open Library Search API:**  
https://openlibrary.org/search.json?title={bookTitle}

Example:  
https://openlibrary.org/search.json?title=harry+potter

## 🧩 How to Run the Project

1. Clone the repository:
   git clone https://github.com/<your-username>/BookFinder.git


Open the project in IntelliJ IDEA or any IDE.

Run the main application:
BookfinderprojectApplication.java

Access the API in browser or Postman:
http://localhost:8080/books/search/harry potter
