package licaicai.lesson1;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// panel 可以看成是一个空间, 但是不能单独存在
public class TestPanel {
    public static void main(String[] args) {
        Frame frame = new Frame();
        Panel panel = new Panel();

        // 设置布局
        frame.setLayout(null);

        // 坐标
        frame.setBounds(300, 300, 500, 500);
        frame.setBackground(Color.green);

        // panel 设置坐标, 相对于frame
        panel.setBounds(50, 50, 400, 400);
        panel.setBackground(Color.pink);

        // frame.add(panel);
        frame.add(panel);

        frame.setVisible(true);

        // 设置监听事件, 监听窗口关闭事件 System.exit(0)
        // 回忆适配器设计模式
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
