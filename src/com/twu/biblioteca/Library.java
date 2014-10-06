package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class Library {

    private PrintStream printStream;
    private List<Book> books;

    public Library(PrintStream printStream, List<Book> books) {
        this.printStream = printStream;
        this.books = books;

    }

    public void listBooks() {
        for (Book book : books) {
            printStream.println(book.getFormattedDetails());
        }
    }

    public void checkout(String title) {

        for (Book book : books) {
            String bookDetails = book.getFormattedDetails();
            if(bookDetails.contains(title)) {
                books.remove(book);
                break;
            }
        }


    }
}
