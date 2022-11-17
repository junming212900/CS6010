public class Main {
    public static void main(String[] args) {
        int []a = {1,2,3,4,5,6,7};
        for (int i = 0; i<a.length;i++){
            if (a[i] == 5){
                break;
            }
            System.out.println(a[i]);
        }
        for(int k=0; k<9;k++){
            for (int h=0 ; h<9;h++ )
                System.out.println(k+","+h);
            break;// Break 就是停止一部分运行
        }
    }
}