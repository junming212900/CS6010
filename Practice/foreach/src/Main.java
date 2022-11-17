import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> hard = new ArrayList<String>();
        hard.add(" adb");
        hard.add("wht");
        hard.add("whadad");
        for (String a : hard) {// foreach loop 帮我我们省去写 int i = 0, i< name.length(),i++的繁琐 也可以过array 里的每一个element。
            System.out.println(a);
        }
    }
}