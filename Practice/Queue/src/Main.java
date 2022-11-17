import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        Queue<String > hard = new LinkedList<String>();//Queue是一个正序排列，第一个录入的就是第一个在这个list的, 他和stack 基本相反

        hard.add("h");
        hard.add("d");
        hard.add("wu");
       // hard.poll();// 拿掉这个list里的第一个

System.out.println(hard.peek());// show出里面的第一个element
        System.out.println(hard);
    }
}