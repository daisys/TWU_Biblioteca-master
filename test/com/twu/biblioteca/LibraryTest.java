package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;


public class LibraryTest {
    PrintStream printStream;
    Library library;
    List<Book> books;
    private Book book1;
    private Book book2;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        books = new ArrayList<Book>();
        book1 = mock(Book.class);
        book2 = mock(Book.class);
    }

    @Test
    public void shouldListOneBookWhenLibraryContainsOneBook() {
        when(book1.getFormattedDetails()).thenReturn("aaa");
        books.add(book1);
        library = new Library(printStream, books);

        library.listBooks();

        verify(printStream).println("aaa");
    }

    @Test
    public void shouldListTwoBooksWhenLibraryContainsTwoBooks() {
        books.add(book1);
        when(book1.getFormattedDetails()).thenReturn("aaa");
        books.add(book2);
        when(book2.getFormattedDetails()).thenReturn("bbb");

        library = new Library(printStream, books);

        library.listBooks();

        verify(printStream).println("aaa");
        verify(printStream).println("bbb");
    }


    @Test
    public void shouldNotListCheckedOutBook(){
        books.add(book1);
        when(book1.getFormattedDetails()).thenReturn("aaa");

        books.add(book2);
        when(book2.getFormattedDetails()).thenReturn("bbb");

        library = new Library(printStream, books);
        library.checkout("aaa");

        assertThat(books.contains(book1), is(false));
    }

    @Test
    public void shouldDisplaySuccessfulCheckoutMessageWhenCheckoutSuccessfully(){
        books.add(book1);
        when(book1.getFormattedDetails()).thenReturn("aaa");

        library = new Library(printStream, books);
        library.checkout("aaa");

        verify(printStream).println("Thank you! Enjoy the book");
    }


}
