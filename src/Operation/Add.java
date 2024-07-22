package Operation;

import Book.Book;
import Book.BookList;
import java.util.Scanner;


public class Add implements AddOperation{
    @Override
    public void work(BookList bookList){
        System.out.println("新增图书！");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您要新增的书名：");
        String name = scanner.nextLine();
        System.out.println("请输入您要新增图书的作者：");
        String author = scanner.nextLine();
        System.out.println("请输入您要新增的书籍编号：");
        int  id = scanner.nextInt();
        System.out.println("请输入您要新增书籍数量：");
        int qty = scanner.nextInt();

        Book existingBook = bookList.findBook(name);
        Book book = new Book(id,name,author,qty);

        if (existingBook != null) {
            // 如果书籍已存在，增加现有数量
            existingBook.setQty(existingBook.getQty() + qty);
            bookList.setBookQty(existingBook); // 更新数量到图书管理系统
            System.out.println("图书已存在，数量已更新！");

        }else {
            //新增图书
            bookList.addBook(book);
            System.out.println("图书添加成功！");
        }
    }
}
