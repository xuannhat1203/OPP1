package run;

import entity.Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BookImp {
    public static ArrayList<Book> books = new ArrayList<Book>();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("******************MENU******************");
            System.out.println("1. Nhập thông tin n sách (n nhập từ bàn phím)");
            System.out.println("2. Tính lợi nhuận các sách");
            System.out.println("3. Hiển thị thông tin sách");
            System.out.println("4. Sắp xếp sách theo giá bán tăng dần");
            System.out.println("5. Sắp xếp sách theo lợi nhuận giảm dần");
            System.out.println("6. Tìm sách theo tên sách");
            System.out.println("7. Thống kê số lượng sách theo năm xuất bản");
            System.out.println("8. Thống kê số lượng sách theo tác giả");
            System.out.println("9. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    nhapThongTinSach();
                    break;
                case 2:
                    tinhLoiNhuan();
                    break;
                case 3:
                    hienThiThongTinSach();
                    break;
                case 4:
                    sapXepGiaTangDan();
                    break;
                case 5:
                    sapXepLoiNhuanGiamDan();
                    break;
                case 6:
                    timSachTheoTen();
                    break;
                case 7:
                    thongKeTheoNam();
                    break;
                case 8:
                    thongKeTheoTacGia();
                    break;
                case 9:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 9);
        sc.close();
    }
    public static void nhapThongTinSach() {
        System.out.print("Nhập số sách muốn thêm: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Book newBook = new Book();
            newBook.inputData();
            books.add(newBook);
        }
    }
    public static void tinhLoiNhuan() {
        books.forEach(book -> System.out.println(book.getBookName() + " - Lợi nhuận: " + book.getInterest()));
    }
    public static void hienThiThongTinSach() {
        for (Book book : books) {
            book.display();
            System.out.println("---------------------------------");
        }
    }
    public static void sapXepGiaTangDan() {
        books.sort(Comparator.comparingDouble(book -> book.getPrice()));
    }

    public static void sapXepLoiNhuanGiamDan() {
        books.sort(Comparator.comparingDouble(Book::getInterest).reversed());
    }

    public static void timSachTheoTen() {
        sc.nextLine();
        System.out.print("Nhập tên sách cần tìm: ");
        String name = sc.nextLine();
        books.stream().filter(book -> book.getBookName().equalsIgnoreCase(name)).forEach(book -> book.display());
    }

    public static void thongKeTheoNam() {
        books.stream().collect(Collectors.groupingBy(Book::getPublishYear, Collectors.counting()))
                .forEach((year, count) -> System.out.println("Năm " + year + ": " + count + " sách"));
    }
    public static void thongKeTheoTacGia() {
        ArrayList<String> countedAuthors = new ArrayList<>();
        for (Book book : books) {
            String author = book.getAuthor();
            if (!countedAuthors.contains(author)) {
                int count = 0;
                for (Book b : books) {
                    if (b.getAuthor().equals(author)) {
                        count++;
                    }
                }
                System.out.println("Tác giả " + author + ": " + count + " sách");
                countedAuthors.add(author);
            }
        }
    }

}
