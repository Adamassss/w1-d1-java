package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        int option;
        int removeOption;

        while(running){
            System.out.println("""
                \nChoose an option:
                1. Add a book
                2. Remove a book
                3. List all books
                0. Exit
                """);

            try {
                option = scanner.nextInt();
            } catch (InputMismatchException exception){
                option = -1;
            }

            scanner.nextLine(); // Consume newline

               switch (option){
                   case 1 ->{
                       System.out.print("Title: ");
                       String title = scanner.nextLine();
                       System.out.print("Author: ");
                       String author = scanner.nextLine();
                       int year = -1 ;

                       while (year < 0) {
                           System.out.print("Year: ");
                           try {
                               year = scanner.nextInt();
                           } catch (InputMismatchException e) {
                               System.out.println("Please enter valid year");
                                year = -1;

                           }
                           scanner.nextLine();  // Consume newline
                       }


                       System.out.print("Genre (FICTION, NON_FICTION, etc): ");
                       Genre genre = Genre.safeValueOf(scanner.nextLine().toUpperCase());

                       library.addBook(new Book(title, author, year, genre));
                       System.out.println("Book added.");
                   }
                   case 2 ->{
                       System.out.println("""
                            \nChoose an option:
                            1. Remove by title
                            2. Remove by author
                            0. Exit
                            """);
                       try {
                           removeOption = scanner.nextInt();
                           scanner.nextLine();// Consume newline
                       } catch (InputMismatchException e){
                           removeOption = -1;
                       }

                       boolean removed;

                       switch (removeOption){
                           case 1->{
                               System.out.print("Title to remove: ");

                               String toRemove = scanner.nextLine();
                               removed = library.removeBook(toRemove);
                           }
                           case 2->{
                               System.out.print("Author to remove: ");
                               String toRemove = scanner.nextLine();
                               removed = library.removeAuthor(toRemove);
                           }
                           case 0->{
                                continue;
                           }
                           default -> {
                               System.out.println("Invalid option");
                               continue;
                           }
                       }
                       System.out.println(removed ? "Removed." : "Not found.");

                   }
                   case 3 -> library.listBooks();
                   case 0 -> running = false;
                   default -> System.out.println("Invalid option");
               }


        }
    }
}