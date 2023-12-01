package licaicai.lesson1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestActionTwo {
    public static void main(String[] args) {
        // 两个按钮, 实现同一个监听
        // 开始 - 停止
        Frame frame  = new Frame("开始-停止");
        Button button1 = new Button("start");
        Button button2 = new Button("end");

        // 可以显示的定义触发会返回的命令, 如果不显示定义, 则会走默认的值 !
        // 可以多个按钮只写一个监听类
        button2.setActionCommand("stop"); // 这里写的stop就是触发后返回的命令

        MyMonitor mymonitor = new MyMonitor();

        button1.addActionListener(mymonitor);
        button2.addActionListener(mymonitor);

        frame.add(button1, BorderLayout.NORTH);
        frame.add(button2, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }
}

class MyMonitor implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        // e.getActionCommand() 获取按钮的信息
        System.out.println("被点击按钮返还回来的命令是 => " + e.getActionCommand());
        if ("start".equals(e.getActionCommand())) System.out.println("hello world");
        else System.out.println("no hello world");
    }
}
