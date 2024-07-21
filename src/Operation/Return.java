package Operation;


import Book.Book;
import Book.BookList;
import java.util.Scanner;

public class Return implements ReturnOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("归还图书！");
        System.out.println("请输入要归还的图书书名： ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        Book book = bookList.findBook(name);
        if (book != null) {
            System.out.println("归还成功！！！");
            book.setQty(book.getQty()+1);

            bookList.setBookQty(book);
        }else {
            System.out.println("您暂时还没有归还图书哦！！！" + name);
        }
    }
}