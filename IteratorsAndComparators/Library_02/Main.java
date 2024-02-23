package IteratorsAndComparators.Library_02;

import IteratorsAndComparators.ComparableBook_03.Book;

public class Main {
    public static void main(String[] args) {


        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");

        Library library = new Library(bookOne, bookTwo);

        for (Book book: library) {
            System.out.println(book.getTitle());
        }

    }
}
