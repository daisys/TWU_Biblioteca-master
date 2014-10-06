package com.twu.biblioteca;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckoutBookCommandTest {
    @Test
    public void shouldCheckoutBookWhenExecute() throws IOException {
        Library library = mock(Library.class);
        String bookTitle = "book title";

        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn(bookTitle);
        PrintStream printStream = mock(PrintStream.class);
        CheckoutBookCommand checkoutBookCommand = new CheckoutBookCommand(library, printStream, bufferedReader);

        checkoutBookCommand.execute();

        verify(library).checkout(bookTitle);
    }



}