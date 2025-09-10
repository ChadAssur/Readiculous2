package domain;

import domain.Book;

import java.util.ArrayList;
import java.util.Scanner;

public class BookRecommendation {

    private ArrayList<Book> books;

    public BookRecommendation() {
        books = new ArrayList<>();
        // Sample books
        books.add(new Book("Atomic Habits", "James Clear", "selfhelp", "audio", "selfgrowth"));
        books.add(new Book("Sapiens", "Yuval Noah Harari", "nonfiction", "ebook", "education"));
        books.add(new Book("To All the Boys I’ve Loved Before", "Jenny Han", "romance", "print", "entertainment"));
        books.add(new Book("The Hunger Games", "Suzanne Collins", "fiction", "print", "entertainment"));
    }

    public void startRecommendation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();

        System.out.print("Enter format: ");
        String format = scanner.nextLine();

        System.out.print("Enter purpose: ");
        String purpose = scanner.nextLine();

        System.out.println("\nRecommended Books:");
        boolean found = false;
        for (Book book : books) {
            if (book.matches(genre, format, purpose)) {
                System.out.println("- " + book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books matched your preferences.");
        }
    }
}
