package com.example.BookFinderProject.service;

import com.example.BookFinderProject.DTO.BookDTO;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    public List<BookDTO> searchBooks(String title) {
        List<BookDTO> books = new ArrayList<>();

        try {
            // ✅ OpenLibrary API endpoint
            String apiUrl = "https://openlibrary.org/search.json?title=" + title.replace(" ", "+");

            // ✅ Make a GET request
            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(apiUrl, String.class);

            // ✅ Parse JSON response
            JSONObject json = new JSONObject(response);

            if (!json.has("docs")) {
                System.out.println("No 'docs' found in API response.");
                return books;
            }

            JSONArray docs = json.getJSONArray("docs");

            // ✅ Limit results to first 10 books
            for (int i = 0; i < Math.min(docs.length(), 10); i++) {
                JSONObject bookObj = docs.getJSONObject(i);

                long id = i + 1;
                String bookTitle = bookObj.optString("title", "Unknown Title");
                String author = bookObj.has("author_name")
                        ? bookObj.getJSONArray("author_name").optString(0, "Unknown Author")
                        : "Unknown Author";
                int publishYear = bookObj.optInt("first_publish_year", 0);
                String coverUrl = bookObj.has("cover_i")
                        ? "https://covers.openlibrary.org/b/id/" + bookObj.getInt("cover_i") + "-M.jpg"
                        : null;

                books.add(new BookDTO((int) id, bookTitle, author, publishYear, coverUrl));
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("❌ Error while fetching book data: " + e.getMessage());
        }

        return books;
    }
}
