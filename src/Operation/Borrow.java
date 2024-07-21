package Operation;

import Book.Book;
import Book.BookList;
import java.util.Scanner;

public class Borrow implements BorrowOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("借阅图书！");
        System.out.println("请输入要借阅的书名： ");
        Scanner scanner = new Scanner(System.in);
        String  name = scanner.nextLine();

        Book book = bookList.findBook(name);
        if ((book != null) && book.getQty() > 0) {
            System.out.println("借阅成功！！！");
            book.setQty(book.getQty() - 1); // 减少库存

            bookList.setBookQty(book);
        }else {
            System.out.println("暂时没有您要借阅的书籍！" + name);
        }
    }
}