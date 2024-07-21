package Operation;

import Book.BookList;

public class Exit implements ExitOperation{
    @Override
    public void work(BookList bookList){
        System.out.println("退出系统！");
        System.exit(0);
    }
}
