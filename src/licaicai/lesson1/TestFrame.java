package licaicai.lesson1;

import java.awt.*;

// GUI的第一个界面
public class TestFrame {
    public static void main(String[] args) {

        // Frame, JDK, 学会看源码 !
        Frame frame = new Frame("我的第一个Java窗口 !");

        // 设置可见性
        frame.setVisible(true);

        // 设置窗口大小
        frame.setSize(300, 300);

        // 设置背景颜色Color
        frame.setBackground(new Color(255, 199, 199));

        // 弹出的初始位置 x 向右, y 向下
        frame.setLocation(200, 200);

        // 设置大小固定
        frame.setResizable(false);
    }
}
