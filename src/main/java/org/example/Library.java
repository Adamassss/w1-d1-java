package org.example;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean removeBook(String title) {
        return books.removeIf(b -> b.getTitle().equalsIgnoreCase(title));
    }

    public boolean removeAuthor(String author) {
        return books.removeIf(book -> book.getAuthor().equalsIgnoreCase(author));
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }
        books.forEach(System.out::println);
    }

    public List<Book> getBooks() {
        return books;
    }
}
