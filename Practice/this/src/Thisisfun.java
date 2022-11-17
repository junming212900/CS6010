public class Thisisfun {// this 是区分在同一个class 中相同的variable。但是不可以和static 在一起用
    int a;
    int b;

    public void setData(int a, int b ) {
        this.a = a;
        this.b = b;
    }


    public static void main(String[] args) {
Thisisfun t = new Thisisfun();
t.setData(4,3);
System.out.println(t.a);
System.out.println(t.b);

        System.out.println("Hello world!");
    }
}