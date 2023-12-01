package licaicai.lesson1;

import java.awt.*;

public class TestFrame2 {
    public static void main(String[] args) {
        // 展示多个窗口, new
        MyFrame myframe1 = new MyFrame(100, 100, 200, 200, Color.pink);
        MyFrame myframe2 = new MyFrame(300, 100, 200, 200, Color.red);
        MyFrame myframe3 = new MyFrame(100, 300, 200, 200, Color.yellow);
        MyFrame myframe4 = new MyFrame(300, 300, 200, 200, Color.darkGray);
    }
}

class MyFrame extends Frame {
    static int id = 0; // 可能存在多个窗口, 我们需要一个计数器

    public MyFrame(int x, int y, int w, int h, Color color) {
        super("MyFrame + " + ( ++ id));
        setVisible(true); // 可见性
        setBounds(x, y, w, h); // 位置以及大小设置
        setBackground(color); // 背景颜色
    }
}
