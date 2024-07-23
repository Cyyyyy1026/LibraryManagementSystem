package User;

import Operation.*;

import java.util.Scanner;

public class Student extends User{
    public Student(String name){
        super(name);
        this.exitOperations = new ExitOperation[]{
                new Exit()
        };
        this.findOperations = new FindOperation[]{
                new Find()
        };
        this.borrowOperations = new BorrowOperation[]{
                new Borrow()
        };
        this.returnOperations = new ReturnOperation[]{
                new Return()
        };
    }
    public int menu()  {
        System.out.println("********用户菜单********");
        System.out.println("*****  2.查找图书  *****");
        System.out.println("*****  3.借阅图书  *****");
        System.out.println("*****  4.归还图书  *****");
        System.out.println("*****  0.退出系统  *****");
        System.out.println("**********************");
        System.out.println("请选择你的操作： ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }
}
