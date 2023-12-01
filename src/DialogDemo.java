import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogDemo extends JFrame {
    public DialogDemo() {
        this.setVisible(true);
        this.setSize(700 ,500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // JFrame放东西, 容器
        Container container = this.getContentPane();
        // 绝对布局
        container.setLayout(null);

        // 按钮
        JButton button = new JButton("点击弹出一个对话框"); // 创建
        button.setBounds(30, 30, 200, 50);

        container.add(button);

        // 点击这个按钮的时候, 弹出一个对话框
        button.addActionListener(new ActionListener() { // 监听器
            @Override
            public void actionPerformed(ActionEvent e) {
                // 弹窗
                new MyDialogDemo();
            }
        });
    }
    public static void main(String[] args) {
        new DialogDemo();
    }
}

// 弹窗的窗口
class MyDialogDemo extends JDialog {
    public MyDialogDemo() {
        this.setVisible(true);
        this.setBounds(100, 100, 500, 500);
//        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // JDialog自带的有关闭了, 这里再写会导致重复然后报错

        Container container = this.getContentPane();
        container.setLayout(null);

        Label lab = new Label("hello world");
        lab.setBounds(30, 30, 300, 300);

        container.add(lab);
    }
}
