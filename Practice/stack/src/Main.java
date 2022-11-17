import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        //stack 是一个纵向的储蓄结构。 每一个variable 都是重叠在另一个的上面，比如如果希望移动最下面的 就要最上面的先移移开
        Stack<Character> tower = new Stack<Character>();
        tower.add('a');
        tower.add('b');
        tower.add('c');

        System.out.println(tower.peek());
        System.out.println(tower.pop());// 拿掉了最上面一个element
        System.out.println(tower.get(1));// 现在这个stack 只有两个elment a和b。

        // 当然stack 也可以用 其他容器的功能，像是clear，empty，contain.
    }
}