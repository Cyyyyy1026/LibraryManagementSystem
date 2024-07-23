import Book.BookList;
import User.Manager;
import User.Student;
import User.User;

import java.util.Scanner;

public class Main {
    public static User login() {
        System.out.println("请输入你的姓名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("请选择您的身份：1.管理员  2.学生");
        int role = scanner.nextInt();
        if(role == 1) {
            return new Manager(name);
        }else {
            return new Student(name);
        }
    }
    public static void main(String[] args) {
        BookList bookList = new BookList();
        User user = login();//此时不确定使用者是谁
        while (true) {
            int choice = user.menu();//根据菜单返回的choice来执行对应操作
            user.doOperation(choice, bookList);
        }
    }
}