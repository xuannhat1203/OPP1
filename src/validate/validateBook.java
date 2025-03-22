package validate;

import entity.Book;
import run.BookImp;
import java.util.Scanner;

public class validateBook {
    public static Scanner sc = new Scanner(System.in);

    public static String validateBookId(Scanner sc, String message) {
        System.out.println(message);
        while (true) {
            String bookId = sc.nextLine();
            if (!bookId.isEmpty()) {
                boolean exists = BookImp.books.stream().anyMatch(b -> b.getBookId().equals(bookId));
                if (!exists) {
                    return bookId;
                }
                System.out.println("Mã sách đã tồn tại, vui lòng nhập lại.");
            }
        }
    }

    public static String validateBookName(Scanner sc, String message) {
        System.out.println(message);
        while (true) {
            String bookName = sc.nextLine();
            if (!bookName.isEmpty() && bookName.matches("^B.{3,}$")) {
                return bookName;
            }
            System.out.println("Tên sách phải bắt đầu bằng 'B' và có ít nhất 4 ký tự.");
        }
    }

    public static float validateImportPrice(Scanner sc, String message) {
        System.out.println(message);
        while (true) {
            try {
                float importPrice = Float.parseFloat(sc.nextLine());
                if (importPrice > 0) {
                    return importPrice;
                }
                System.out.println("Giá nhập phải lớn hơn 0.");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số hợp lệ.");
            }
        }
    }

    public static float validateExportPrice(Scanner sc, String message, float importPrice) {
        System.out.println(message);
        while (true) {
            try {
                float exportPrice = Float.parseFloat(sc.nextLine());
                if (exportPrice > importPrice * 1.3) {
                    return exportPrice;
                }
                System.out.println("Giá xuất phải lớn hơn ít nhất 30% so với giá nhập.");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số hợp lệ.");
            }
        }
    }

    public static int validateYear(Scanner sc, String message) {
        System.out.println(message);
        while (true) {
            try {
                int year = Integer.parseInt(sc.nextLine());
                if (year >= 2000) {
                    return year;
                }
                System.out.println("Năm xuất bản phải từ năm 2000 trở đi.");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số hợp lệ.");
            }
        }
    }

    public static String validateAuthor(Scanner sc, String message) {
        System.out.println(message);
        while (true) {
            String author = sc.nextLine();
            if (author.length() >= 6 && author.length() <= 50) {
                return author;
            }
            System.out.println("Tên tác giả phải có từ 6 đến 50 ký tự.");
        }
    }
}
