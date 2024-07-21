package Operation;

import Book.Book;
import Book.BookList;
import java.util.Scanner;

public class Find implements FindOperation{
    @Override
    public void work(BookList bookList){
        System.out.println("查找图书！");
        System.out.println("请输入要查找的书名： ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        Book book = bookList.findBook(name);
        if (book != null) {
            System.out.println("这本书存在，信息如下：");
            System.out.println(book);
        } else {
            System.out.println("没有找到您所需的书籍，书名为: " + name);
        }
    }
}
