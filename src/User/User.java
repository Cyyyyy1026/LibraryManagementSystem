package User;

import Book.BookList;
import Operation.*;

abstract public class User {
    protected  String name;
    protected AddOperation[] addOperations;
    protected BorrowOperation[] borrowOperations;
    protected ReturnOperation[] returnOperations;
    protected ExitOperation[] exitOperations;
    protected FindOperation[] findOperations;

    public  User(String name) {
        this.name = name;
    }
    public  abstract  int menu();

    public void doOperation(int choice, BookList bookList) {
        switch (choice) {
            case 0:
                this.exitOperations[choice].work(bookList);
                break;
            case 1:
                if (this.addOperations != null) {
                    this.addOperations[0].work(bookList);
                } else {
                    this.findOperations[0].work(bookList);
                }
                break;
            case 2:
                if (this.findOperations != null) {
                    this.findOperations[0].work(bookList);
                } else {
                    this.findOperations[0].work(bookList);
                }
                break;
            case 3:
                if (this.borrowOperations != null) {
                    this.borrowOperations[0].work(bookList);
                } else {
                    this.findOperations[0].work(bookList);
                }
                break;
            case 4:
                if (this.returnOperations != null) {
                    this.returnOperations[0].work(bookList);
                } else {
                    this.findOperations[0].work(bookList);
                }
                break;


            default:
                System.out.println("无效的选择，请重试。");
                break;
        }
    }
}