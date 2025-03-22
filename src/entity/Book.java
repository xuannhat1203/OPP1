package entity;

import validate.validateBook;
import java.util.Scanner;

public class Book {
    public static Scanner sc = new Scanner(System.in);

    private String bookId;
    private String bookName;
    private float importPrice;
    private float exportPrice;
    private String author;
    private int year;

    public Book(float importPrice, String bookId, String bookName, float exportPrice, String author, int year) {
        this.importPrice = importPrice;
        this.bookId = bookId;
        this.bookName = bookName;
        this.exportPrice = exportPrice;
        this.author = author;
        this.year = year;
    }

    public Book() {
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public float getInterest() {
        return exportPrice - importPrice;
    }

    public float getPrice() {
        return exportPrice;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishYear() {
        return year;
    }

    public void inputData() {
        this.bookId = validateBook.validateBookId(sc, "Nhập mã sách: ");
        this.bookName = validateBook.validateBookName(sc, "Nhập tên sách: ");
        this.importPrice = validateBook.validateImportPrice(sc, "Nhập giá nhập: ");
        this.exportPrice = validateBook.validateExportPrice(sc, "Nhập giá bán: ", importPrice);
        this.author = validateBook.validateAuthor(sc, "Nhập tên tác giả: ");
        this.year = validateBook.validateYear(sc, "Nhập năm xuất bản: ");
    }

    public void display() {
        System.out.println("Book Id: " + bookId);
        System.out.println("Book Name: " + bookName);
        System.out.println("Import Price: " + importPrice);
        System.out.println("Export Price: " + exportPrice);
        System.out.println("Author: " + author);
        System.out.println("Interest: " + getInterest());
        System.out.println("Year: " + year);
    }
}
