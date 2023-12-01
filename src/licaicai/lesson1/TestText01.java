package licaicai.lesson1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestText01 {
    public static void main(String[] args) {
        // 启动 !
        MyFrameNow myn = new MyFrameNow();
    }
}

class MyFrameNow extends Frame {
    public MyFrameNow() {
        TextField tf = new TextField();
        add(tf);

        // 监听这个文本框输入的文字
        MyActionListener myActionListener = new MyActionListener();
        // 按下enter就会触发这个输入框的事件
        tf.addActionListener(myActionListener);

        // 设置替换编码
        // 这样子用户前台输入看起来是*, 但是实际到后台还是原来的, 保障了一些安全性
        tf.setEchoChar('*');

        setVisible(true);
        pack();
        // 关闭事件
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class MyActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        TextField tf = (TextField) e.getSource(); // 获得一些资源, 返回的一个对象, 查看对象发现返回的Object, 可以随意向下转型
        System.out.println(tf.getText()); // 获得输入框中的文本
        tf.setText(""); // 模拟输入完回车以后内容清空
    }
}