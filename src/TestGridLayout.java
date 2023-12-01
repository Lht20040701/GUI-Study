import java.awt.*;

public class TestGridLayout {
    public static void main(String[] args) {
        Frame frame = new Frame("TestGridLayout");

        Button btn1 = new Button("btn1");
        Button btn2 = new Button("btn1");
        Button btn3 = new Button("btn1");
        Button btn4 = new Button("btn1");
        Button btn5 = new Button("btn1");
        Button btn6 = new Button("btn1");

        frame.setLayout(new GridLayout(3, 2));

        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        frame.add(btn4);
        frame.add(btn5);
        frame.add(btn6);

        frame.pack(); // Java函数, 自动将上面add的东西按最优的布局排列
        frame.setVisible(true);
    }
}
