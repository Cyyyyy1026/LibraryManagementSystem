package User;

import  Operation.*;

import java.util.Scanner;

public class Manager extends User{
    public Manager(String name){
        super(name);
        this.exitOperations = new ExitOperation[]{
                new Exit()
        };
        this.findOperations = new FindOperation[]{
                new Find()
        };
        this.addOperations = new AddOperation[]{
                new Add()
        };
    }

    public int menu()  {
        System.out.println("*******管理员菜单*******");
        System.out.println("*****  1.新增图书  *****");
        System.out.println("*****  2.查找图书  *****");
        System.out.println("*****  3.修改库存  *****");
        System.out.println("*****  0.退出系统  *****");
        System.out.println("**********************");
        System.out.println("请选择你的操作： ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }
}//
