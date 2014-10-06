package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class CheckoutBookCommand implements Command {

    private Library library;
    private PrintStream printStream;
    private BufferedReader bufferedReader;

    public CheckoutBookCommand(Library library, PrintStream printStream, BufferedReader bufferedReader){
        this.library = library;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }
    @Override
    public void execute() {
        printStream.println("Enter the name of the book you want to remove");
        String bookToRemove = readChoice();

        library.checkout(bookToRemove);
    }

    private String readChoice() {
        String choice = "";
        try {
            choice = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return choice;
    }
}
