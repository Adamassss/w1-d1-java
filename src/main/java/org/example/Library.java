package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private Map<String, Book> titleToBook = new HashMap<>();
    private Map<String, List<Book>> authorToBooks = new HashMap<>();


    public void addBook(Book book) {
        titleToBook.put (book.getTitle().toLowerCase(), book);
        authorToBooks.computeIfAbsent(book.getAuthor().toLowerCase(), l-> new ArrayList<>()).add(book);
    }

    public boolean removeBook(String title) {
        Book book = titleToBook.remove(title.toLowerCase());
        if (book == null) return false;

        authorToBooks.get(book.getAuthor().toLowerCase()).removeIf(b -> b.getTitle().equalsIgnoreCase(title));

        if(authorToBooks.get(book.getAuthor().toLowerCase()).isEmpty()) authorToBooks.remove(book.getAuthor().toLowerCase());

        return true;
    }

    public boolean removeAuthor(String author) {
        List<Book> list = authorToBooks.remove(author.toLowerCase());
        if(list == null) return false;
        for (Book b: list) titleToBook.remove(b.getTitle().toLowerCase());
        return true;
    }

    public void listBooks() {
        if (titleToBook.isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }

        for (String name: authorToBooks.keySet()){
            listBooksByAuthor(name);
        }

    }

    public void listBooksByAuthor(String author) {
        List<Book> list = authorToBooks.get(author.toLowerCase());

        if (list == null ) {
            System.out.println("No books by this author.");
            return;
        }

        System.out.println("Author: " + list.getFirst().getAuthor());
        list.forEach(System.out::println);
    }

    public void listBooksByGenre(Genre genre) {
        for (Book b: titleToBook.values()){
            if (b.getGenre().equals(genre)) System.out.println(b);
        }
    }


}
