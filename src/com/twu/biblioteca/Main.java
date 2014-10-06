package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        PrintStream printStream = new PrintStream(System.out);
        MessagePrinter messagePrinter = new MessagePrinter(printStream);

        List<Book> books = books();
        Library library = new Library(printStream, books);
        QuitCommand quitCommand = new QuitCommand();
        Map<String, Command> commands = new HashMap<String, Command>();
        commands.put("1", new ListBooksCommand(library));
        commands.put("2", new CheckoutBookCommand(library, printStream, bufferedReader));
        commands.put("3", quitCommand);


        Menu menu = new Menu(printStream, bufferedReader, commands, quitCommand);

        BibliotecaApp bibApp = new BibliotecaApp(messagePrinter, menu, library);

        bibApp.run();
    }

    private static List<Book> books() {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Agile Samurai", "author1","1000"));
        books.add(new Book("Clean Code", "author2","2525"));
        books.add(new Book("Cookbook", "camp","1234"));
        return books;
    }

}
