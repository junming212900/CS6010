enum size { SMALL,MEDIUM,LARGE;}//将多个标记class 做出一个新的array

public class Main {
    public static void main(String[] args) {
        size s = size.LARGE;
        switch(s){
            case LARGE :
                System.out.println("Size Large");
                break;
            case MEDIUM :
                System.out.println("Size Medium");
                break;
            case SMALL:
                System.out.println("Size small");
                break;


        }

        System.out.println("Hello world!");

    }
}