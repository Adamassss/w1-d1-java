package org.example;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private int year;
    private Genre genre;

    public Book(String title, String author, int year, Genre genre) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }


    @Override
    public String toString() {
        return "Book" +
                "title: '" + title + '\'' +
                ", author:'" + author + '\'' +
                ", genre:" + genre + '\''+
                ", year:" + year;
    }

    @Override
    public boolean equals(Object o){
        if(o == null || getClass() !=  o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && title.equalsIgnoreCase(book.title) && author.equalsIgnoreCase(book.author) && genre == book.genre;
    }

    //SALAM

    @Override
    public int hashCode() {
        return Objects.hash(title.toLowerCase(), author.toLowerCase(), year, genre);
    }
}
