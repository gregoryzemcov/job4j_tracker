package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book kortik = new Book("Kortik", 325);
        Book belka = new Book("Belka i Strelka", 211);
        Book code = new Book("Clean code", 537);
        Book auto = new Book("Remont auto", 474);
        Book[] books = new Book[4];
        books[0] = kortik;
        books[1] = belka;
        books[2] = code;
        books[3] = auto;

        for (Book book : books) {
            System.out.println(book.getName() + " - " + book.getList());
        }

        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;

        for (Book book : books) {
            System.out.println(book.getName() + " - " + book.getList());
        }

        for (Book book : books) {
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + " - " + book.getList());
            }
        }
    }
}
