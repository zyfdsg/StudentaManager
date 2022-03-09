package ityf;
//学生登入界面
import java.util.ArrayList;
import java.util.Scanner;
public class StudentManager {
    public static void main(String[] args) {
        //创建学生对象，用于存储学生数据
        ArrayList<Student> array = new ArrayList<>();
        //用循环完成每次回到界面
        while (true) {
            //用输出语句完成主界面的编写
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看所有学生");
            System.out.println("5 退出");
            System.out.println("请输入你的选择");
            //用Scanner实现键盘录入数据
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            //用switch语句完成操作的选择
            switch (line) {
                case "1":
                    //添加学生
                    addStudent(array);
                    break;
                case "2":
                    //删除学生
                    deleteStudent(array);
                    break;
                case "3":
                    //修改学生
                    updateStudent(array);
                    break;
                case "4":
                    //查看所有学生
                    findAllStudent(array);
                    break;
                case "5":
                    System.out.println("谢谢使用");
                    System.exit(0);//JVM退出

            }
        }
    }
    //定义一个方法，用于添加学生信息
    public static void addStudent(ArrayList<Student> array) {
        //键盘录入学生对象所需要的数据，显示提示信息，提示要输入何种信息
        Scanner sc = new Scanner(System.in);
        //为了sid在while循环外面能被访问到，我们把sid定义到了循环外
        String sid;
        while (true) {
            System.out.println("请输入学生学号");
            sid = sc.nextLine();
            boolean flag = isUsed(array,sid);
            if (flag) {
                System.out.println("你输入的学号已经被使用，请重新输入");
            }else{
                break;
            }
        }
        System.out.println("请输入学生姓名");
        String name = sc.nextLine();
        System.out.println("请输入学生年龄");
        String age = sc.nextLine();
        System.out.println("请输入学生地址");
        String address = sc.nextLine();
        //创建学生对象，把键盘录入的数据赋值给学生对象的成员变量
        Student s = new Student();
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);
        s.setSid(sid);
        //把对象添加的集合中
        array.add(s);
        //给出添加成功提示
        System.out.println("添加学生成功");
    }
    //定义一个方法，判断学生学号是否被使用
    public static boolean isUsed(ArrayList<Student>array,String sid){
        //如果与集合中某一学号相同，返回ture，不相同返回false
        boolean flag=false;
        for (int i = 0; i < array.size(); i++) {
            Student s=array.get(i);
            if(s.getSid().equals(sid)){
                flag=true;
                break;
            }
        }return  flag;
    }
    //定义一个方法，用于查看所有学生信息
    public static void findAllStudent(ArrayList<Student> array) {
        //显示表头信息
        //\t就是一个tab键的位置
        //判断集合中是否有信息
        if (array.size() == 0) {
            System.out.println("无信息，请先添加信息再查询");
            //为了让程序不再往下执行，给出return
            return;
        }
        System.out.println("学号\t\t\t姓名\t\t年龄\t\t居住地");
        //将集合数据取出按照对应格式显示学生信息，年龄显示补充"岁“
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            System.out.println(s.getSid() + "\t" + s.getName() + "\t" + s.getAge() + "岁\t" + s.getAddress() + "\t");
        }
    }
    //定义一个方法，用于删除学生信息
    public static void deleteStudent(ArrayList<Student> array) {
        //键盘录入要删除的学生学号，显示提示信息
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要删除学生的学号");
        String sid = sc.nextLine();
       /* 删除操作前，对学号是否存在进行判断
       如果不存在则显示提示信息
       如果存在则执行删除操作
       */
        int index=-1;
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getSid().equals(sid)) {
                index=i;
                break;
            }
        }if(index==-1){
            System.out.println("该信息不存在，请重新输入");
        }else {
            array.remove(index);
            //给出删除成功提示
            System.out.println("删除成功");
        }
    }
    //定义一个方法，用于修改学生信息
    public static void updateStudent(ArrayList<Student> array) {
        //键盘录入要修改的学生学号，显示提示信息
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改的学生学号");
        String sid = sc.nextLine();
        /* 修改操作前，对学号是否存在进行判断
       如果不存在则显示提示信息
       如果存在则执行修改操作
       */
        int index=-1;
        for (int i = 0; i < array.size(); i++) {
            Student student = array.get(i);
            if (student.getSid().equals(sid)) {
                index=i;
                break;
            }
        }if(index==-1){
            System.out.println("给信息不存在,请重新输入");
            return;
        }
        //键盘录入要修改的学生信息
        System.out.println("请输入学生新姓名");
        String name = sc.nextLine();
        System.out.println("请输入学生新年龄");
        String age = sc.nextLine();
        System.out.println("请输入学生新地址");
        String address = sc.nextLine();
        //创建学生对象
        Student s = new Student();
        s.setSid(sid);
        s.setAge(age);
        s.setName(name);
        s.setAddress(address);
        //修改学生信息
        array.set(index,s);
        //给出修改成功的提示
        System.out.println("修改学生信息成功");
    }
}

