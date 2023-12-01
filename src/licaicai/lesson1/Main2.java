package licaicai.lesson1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main2 {
    public static void main(String[] args) {
        Frame frame = new Frame();
        Button button = new Button("hello world");

        // 给按钮绑定事件 因为addActionListener需要一个 ActionListener , 所以我们需要构造一个ActionListener
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // e是事件对象 ! 要学会看源码, 要学会动脑子, 要会计算机英语
                System.out.println("hello world");
            }
        });

        // 把按钮放到frame中
        frame.add(button, BorderLayout.CENTER);
        frame.pack();

        // 设置关闭功能
        windowClose(frame);
        frame.setVisible(true);

        // 网络编程 : 按下 !
    }

    // 封装关闭功能
    private static void windowClose(Frame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
